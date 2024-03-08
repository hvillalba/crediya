package py.hvillalba.microsol_app.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CobrosDTO;
import py.hvillalba.microsol_app.data.CuotaAtrasadaDTO;
import py.hvillalba.microsol_app.data.CuotaDTO;
import py.hvillalba.microsol_app.data.FormacobrocreditoDTO;
import py.hvillalba.microsol_app.data.NotificacionDto;
import py.hvillalba.microsol_app.http.HttpRequest;
import py.hvillalba.microsol_app.http.RestAdapter;
import py.hvillalba.microsol_app.http.service.UserInterface;
import py.hvillalba.microsol_app.util.Constant;
import py.hvillalba.microsol_app.util.CustomPreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private String TAG = "LoginActivity";
    private Context context;
    /* access modifiers changed from: private */
    public CustomPreferenceManager customPreferenceManager;
    private RealmResults<CobrosDTO> listaCobrosRealm;
    private RealmResults<CuotaAtrasadaDTO> listaCuotaAtrasadaRealm;
    private RealmResults<CuotaDTO> listaRealm;
    EditText passwordEditText;
    /* access modifiers changed from: private */
    public Realm realm;
    private UserInterface userInterface;
    EditText usernameEditText;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_login);
        setTitle("Acceso CrediYa");
        this.realm = Realm.getDefaultInstance();
        this.context = this;
        this.customPreferenceManager = new CustomPreferenceManager(this);
        this.userInterface = (UserInterface) RestAdapter.getClient((String) null).create(UserInterface.class);
        this.usernameEditText = (EditText) findViewById(R.id.username);
        this.passwordEditText = (EditText) findViewById(R.id.password);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.loading);
        ((Button) findViewById(R.id.login)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                progressBar.setVisibility(View.GONE);
                if (!LoginActivity.this.usernameEditText.getText().toString().equals("admin")
                        || !LoginActivity.this.passwordEditText.getText().toString().equals("admin")) {
                    Snackbar.make(view, (CharSequence) "Parametros incorrectos", Snackbar.LENGTH_LONG).show();
                    return;
                }
                LoginActivity.this.cargarCuotasAtrasadas();
                LoginActivity.this.cobrosDelDia();
                LoginActivity.this.llamarServicio();
                LoginActivity.this.login();
            }
        });
    }

    /* access modifiers changed from: private */
    public void login() {
        RealmResults<CuotaDTO> findAll = this.realm.where(CuotaDTO.class).sort("fecvencimiento", Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            startActivity(new Intent(this, HomeActivity.class));
            this.customPreferenceManager.setValue(Constant.LOGUEADO, true);
            finish();
            return;
        }
        this.userInterface.getCuota().enqueue(new Callback<List<CuotaDTO>>() {
            public void onResponse(Call<List<CuotaDTO>> call, Response<List<CuotaDTO>> response) {
                if (response.body() == null) {
                    Log.e("Error", response.message());
                    Toast.makeText(LoginActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                } else if (response.body() != null) {
                    LoginActivity.this.realm.beginTransaction();
                    int i = 1;
                    for (CuotaDTO cuotaDTO : response.body()) {
                        cuotaDTO.setId(Long.valueOf((long) i));
                        cuotaDTO.setTipocredito(cuotaDTO.getTipocredito());
                        cuotaDTO.setFormacobrocredito(cuotaDTO.getFormacobrocredito());
                        cuotaDTO.setAtraso(Integer.valueOf(LoginActivity.numeroDiasEntreDosFechas(cuotaDTO.getFecvencimiento(), new Date())));
                        LoginActivity.this.realm.copyToRealmOrUpdate(cuotaDTO);
                        i++;
                    }
                    LoginActivity.this.realm.commitTransaction();
                    LoginActivity.this.startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    LoginActivity.this.finish();
                    LoginActivity.this.customPreferenceManager.setValue(Constant.LOGUEADO, true);
                    LoginActivity.this.customPreferenceManager.setValue("fecha", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.US).format(new Date()));
                } else {
                    Toast.makeText(LoginActivity.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                }
            }

            public void onFailure(Call<List<CuotaDTO>> call, Throwable th) {
                Toast.makeText(LoginActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                th.printStackTrace();
            }
        });
    }

    /* access modifiers changed from: private */
    public void llamarServicio() {
        UserInterface userInterface2 = (UserInterface) RestAdapter.getClient((String) null).create(UserInterface.class);
        this.userInterface = userInterface2;
        userInterface2.getNotificacion().enqueue(new Callback<NotificacionDto>() {
            public void onResponse(Call<NotificacionDto> call, Response<NotificacionDto> response) {
                if (response.body() != null) {
                    LoginActivity.this.realm.beginTransaction();
                    NotificacionDto notificacionDto = new NotificacionDto();
                    notificacionDto.setNrocuota(response.body().getNrocuota());
                    notificacionDto.setFecvencimiento(response.body().getFecvencimiento());
                    notificacionDto.setCapital(response.body().getCapital());
                    notificacionDto.setInteres(response.body().getInteres());
                    LoginActivity.this.realm.copyToRealmOrUpdate(notificacionDto);
                    LoginActivity.this.realm.commitTransaction();
                }
            }

            public void onFailure(Call<NotificacionDto> call, Throwable th) {
                Toast.makeText(LoginActivity.this, "Ocurrio un error, intente de nuevo por favor", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadFileAndInsert() {
       /* String assetJsonData = getAssetJsonData(getApplicationContext());
        Type type = new TypeToken<List<CuotaDTO>>() {
        }.getType();
        this.realm.beginTransaction();
        int i = 1;
        Gson gson = new Gson();
        for (CuotaDTO cuotaDTO : gson.fromJson(assetJsonData, type)) {
            cuotaDTO.setId(Long.valueOf((long) i));
            cuotaDTO.setTipocredito(cuotaDTO.getTipocredito());
            cuotaDTO.setFormacobrocredito(cuotaDTO.getFormacobrocredito());
            this.realm.copyToRealmOrUpdate(cuotaDTO);
            i++;
        }
        this.realm.commitTransaction();
        startActivity(new Intent(this, HomeActivity.class));
        finish();
        this.customPreferenceManager.setValue(Constant.LOGUEADO, true);
        this.customPreferenceManager.setValue("fecha", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.US).format(new Date()));*/
    }

    public static String getAssetJsonData(Context context2) {
        try {
            InputStream open = context2.getAssets().open("bd.json");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            String str = new String(bArr, HttpRequest.CHARSET_UTF8);
            Log.e("data", str);
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void cobrosDelDia() {
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).sort("fechavencimiento", Sort.ASCENDING).findAll();
        this.listaCobrosRealm = findAll;
        if (findAll.isEmpty()) {
            this.userInterface.getCobros().enqueue(new Callback<List<CobrosDTO>>() {
                public void onResponse(Call<List<CobrosDTO>> call, Response<List<CobrosDTO>> response) {
                    if (response.body() == null) {
                        Log.e("Error", response.message());
                        Toast.makeText(LoginActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                    } else if (response.body() != null) {
                        LoginActivity.this.realm.beginTransaction();
                        int i = 1;
                        for (CobrosDTO cobrosDTO : response.body()) {
                            cobrosDTO.setId(Long.valueOf((long) i));
                            cobrosDTO.getCliente();
                            cobrosDTO.setTipocredito(cobrosDTO.getTipocredito());
                            cobrosDTO.setFormacobrocredito(cobrosDTO.getFormacobrocredito());
                            LoginActivity.this.realm.copyToRealmOrUpdate(cobrosDTO);
                            i++;
                        }
                        LoginActivity.this.realm.commitTransaction();
                        LoginActivity.this.customPreferenceManager.setValue("fecha", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.US).format(new Date()));
                    } else {
                        Toast.makeText(LoginActivity.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                    }
                }

                public void onFailure(Call<List<CobrosDTO>> call, Throwable th) {
                    Toast.makeText(LoginActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                    th.printStackTrace();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void cargarCuotasAtrasadas() {
        RealmResults<CuotaAtrasadaDTO> findAll = this.realm.where(CuotaAtrasadaDTO.class).sort("fechavencimiento", Sort.ASCENDING).findAll();
        this.listaCuotaAtrasadaRealm = findAll;
        if (findAll.isEmpty()) {
            this.userInterface.getCuotaAtrasadas().enqueue(new Callback<List<CuotaAtrasadaDTO>>() {
                public void onResponse(Call<List<CuotaAtrasadaDTO>> call, Response<List<CuotaAtrasadaDTO>> response) {
                    if (response.body() == null) {
                        Log.e("Error", response.message());
                        Toast.makeText(LoginActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                    } else if (response.body() != null) {
                        LoginActivity.this.realm.beginTransaction();
                        int i = 1;
                        for (CuotaAtrasadaDTO cuotaAtrasadaDTO : response.body()) {
                            cuotaAtrasadaDTO.setId(Long.valueOf((long) i));
                            cuotaAtrasadaDTO.getCliente();
                            cuotaAtrasadaDTO.setTipocredito(cuotaAtrasadaDTO.getTipocredito());
                            FormacobrocreditoDTO formacobrocredito = cuotaAtrasadaDTO.getFormacobrocredito();
                            cuotaAtrasadaDTO.setAtraso(Integer.valueOf(LoginActivity.numeroDiasEntreDosFechas(cuotaAtrasadaDTO.getFechavencimiento(), new Date())));
                            cuotaAtrasadaDTO.setFormacobrocredito(formacobrocredito);
                            LoginActivity.this.realm.copyToRealmOrUpdate(cuotaAtrasadaDTO);
                            i++;
                        }
                        LoginActivity.this.realm.commitTransaction();
                        LoginActivity.this.customPreferenceManager.setValue("fecha", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.US).format(new Date()));
                    } else {
                        Toast.makeText(LoginActivity.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                    }
                }

                public void onFailure(Call<List<CuotaAtrasadaDTO>> call, Throwable th) {
                    Toast.makeText(LoginActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                    th.printStackTrace();
                }
            });
        }
    }

    public static int numeroDiasEntreDosFechas(Date date, Date date2) {
        return (int) ((date2.getTime() - date.getTime()) / 86400000);
    }
}
