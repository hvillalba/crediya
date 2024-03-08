package py.hvillalba.microsol_app.http;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import py.hvillalba.microsol_app.util.Constant;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAdapter {
    static JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
        public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            if (jsonElement.getAsString().contains("-")) {
                String[] split = jsonElement.getAsString().split("\\-");
                Calendar instance = Calendar.getInstance();
                instance.set(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                if (jsonElement == null) {
                    return null;
                }
                return instance.getTime();
            } else if (jsonElement == null) {
                return null;
            } else {
                return new Date(jsonElement.getAsLong());
            }
        }
    };
    private static Retrofit retrofit;
    static JsonSerializer<Date> ser = new JsonSerializer<Date>() {
        public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
            if (date == null) {
                return null;
            }
            return new JsonPrimitive((Number) Long.valueOf(date.getTime()));
        }
    };
    static String token;

    public static Retrofit getClient(String str) {
        Gson create = new GsonBuilder().setDateFormat("yyyy-MM-dd").registerTypeAdapter(Date.class, new DateTypeDeserializer()).create();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Constant.URL_PATH).client(getHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(create)).build();
        }
        return retrofit;
    }

    public static class DateTypeDeserializer implements JsonDeserializer<Date> {
        private final String[] DATE_FORMATS = {"yyyy-MM-dd", "dd-MM-yyyy hh:mm:ss", "dd-MM-yyyy"};

        public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            String[] strArr = this.DATE_FORMATS;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                Log.e("dateFormat", str);
                try {
                    if (jsonElement.getAsString().contains("-")) {
                        return new SimpleDateFormat(str, Locale.US).parse(jsonElement.getAsString());
                    }
                    if (jsonElement == null) {
                        return null;
                    }
                    return new Date(jsonElement.getAsLong());
                } catch (ParseException e) {
                    Log.e("ParseException", e.getMessage());
                    i++;
                }
            }
            throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString() + "\". Supported formats: \n" + Arrays.toString(this.DATE_FORMATS));
        }
    }

    private static OkHttpClient getHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request.Builder newBuilder = chain.request().newBuilder();
                return chain.proceed(newBuilder.addHeader(HttpRequest.HEADER_AUTHORIZATION, "Bearer " + RestAdapter.token).build());
            }
        });
        builder.connectTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS);
        return builder.build();
    }
}
