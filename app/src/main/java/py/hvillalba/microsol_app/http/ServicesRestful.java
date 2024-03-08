package py.hvillalba.microsol_app.http;

import android.content.Context;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import py.hvillalba.microsol_app.util.Constant;
import py.hvillalba.microsol_app.util.CustomPreferenceManager;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public interface ServicesRestful {
    public static final JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
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
    public static final JsonDeserializer<String> deserString = new JsonDeserializer<String>() {
        public String deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            if (jsonElement.getAsString() != null) {
                return jsonElement.getAsString();
            }
            if (jsonElement == null) {
                return "";
            }
            return jsonElement.getAsString();
        }
    };
    public static final JsonSerializer<Date> ser = new JsonSerializer<Date>() {
        public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
            if (date == null) {
                return null;
            }
            return new JsonPrimitive((Number) Long.valueOf(date.getTime()));
        }
    };
    public static final JsonSerializer<String> serString = new JsonSerializer<String>() {
        public JsonElement serialize(String str, Type type, JsonSerializationContext jsonSerializationContext) {
            if (str == null) {
                return null;
            }
            return new JsonPrimitive(str);
        }
    };

    public static class Creator {
        public static Retrofit newApisService(Context context) {
            new CustomPreferenceManager(context);
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            return new Retrofit.Builder().baseUrl(Constant.URL_PATH).client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").registerTypeAdapter(Date.class, ServicesRestful.ser).registerTypeAdapter(Date.class, ServicesRestful.deser).create())).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        }
    }

    /* renamed from: py.hvillalba.microsol_app.http.ServicesRestful$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static OkHttpClient getHttpClient() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(new Interceptor() {
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    return chain.proceed(chain.request().newBuilder().build());
                }
            });
            builder.connectTimeout(120, TimeUnit.SECONDS).writeTimeout(120, TimeUnit.SECONDS).readTimeout(120, TimeUnit.SECONDS);
            return builder.build();
        }
    }

    public static final class UnixEpochDateTypeAdapter extends TypeAdapter<Date> {
        private static final TypeAdapter<Date> unixEpochDateTypeAdapter = new UnixEpochDateTypeAdapter();

        private UnixEpochDateTypeAdapter() {
        }

        static TypeAdapter<Date> getUnixEpochDateTypeAdapter() {
            return unixEpochDateTypeAdapter;
        }

        public Date read(JsonReader jsonReader) {
            try {
                return new Date(jsonReader.nextLong());
            } catch (Exception unused) {
                return new Date();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|2|3|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0008 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void write(com.google.gson.stream.JsonWriter r3, java.util.Date r4) {
            /*
                r2 = this;
                long r0 = r4.getTime()     // Catch:{ Exception -> 0x0008 }
                r3.value((long) r0)     // Catch:{ Exception -> 0x0008 }
                goto L_0x0014
            L_0x0008:
                java.util.Date r4 = new java.util.Date     // Catch:{ IOException -> 0x0014 }
                r4.<init>()     // Catch:{ IOException -> 0x0014 }
                long r0 = r4.getTime()     // Catch:{ IOException -> 0x0014 }
                r3.value((long) r0)     // Catch:{ IOException -> 0x0014 }
            L_0x0014:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: py.hvillalba.microsol_app.http.ServicesRestful.UnixEpochDateTypeAdapter.write(com.google.gson.stream.JsonWriter, java.util.Date):void");
        }
    }
}
