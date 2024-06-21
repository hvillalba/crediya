package py.hvillalba.microsol_app.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CobrosDTO;
import py.hvillalba.microsol_app.data.CuotaAtrasadaDTO;
import py.hvillalba.microsol_app.data.CuotaDTO;
import py.hvillalba.microsol_app.data.NotificacionDto;
import py.hvillalba.microsol_app.http.RestAdapter;
import py.hvillalba.microsol_app.http.service.UserInterface;
import py.hvillalba.microsol_app.util.CustomPreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SincronizacionActivity extends AppCompatActivity {
    Button btnSincro;
    /* access modifiers changed from: private */
    public CustomPreferenceManager customPreferenceManager;
    private RealmResults<CobrosDTO> listaCobrosRealm;
    ProgressBar progressBar;
    /* access modifiers changed from: private */
    public Realm realm;
    TextView tvFecha;
    private UserInterface userInterface;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sincronizacion);
        this.realm = Realm.getDefaultInstance();
        this.userInterface = (UserInterface) RestAdapter.getClient("").create(UserInterface.class);
        this.tvFecha = (TextView) findViewById(R.id.tvFecha);
        this.btnSincro = (Button) findViewById(R.id.btnSincro);
        CustomPreferenceManager customPreferenceManager2 = new CustomPreferenceManager(this);
        this.customPreferenceManager = customPreferenceManager2;
        this.tvFecha.setText(customPreferenceManager2.getString("fecha"));
        this.progressBar = (ProgressBar) findViewById(R.id.loading);
        this.btnSincro.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SincronizacionActivity.this.lambda$onCreate$0$SincronizacionActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$SincronizacionActivity(View view) {
        this.progressBar.setVisibility(View.VISIBLE);
        clearDB();
        cargarCuotasAtrasadas();
        cobrosDelDia();
        llamarServicio();
        login();
    }

    public void clearDB() {
        this.realm.executeTransaction(new Realm.Transaction() {
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });
    }

    private void cargarCuotasAtrasadas() {
        this.userInterface.getCuotaAtrasadas().enqueue(new Callback<List<CuotaAtrasadaDTO>>() {
            public void onResponse(Call<List<CuotaAtrasadaDTO>> call, Response<List<CuotaAtrasadaDTO>> response) {
                if (response.body() == null) {
                    Log.e("Error", response.message());
                    Toast.makeText(SincronizacionActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                } else if (response.body() != null) {
                    SincronizacionActivity.this.realm.beginTransaction();
                    int i = 1;
                    for (CuotaAtrasadaDTO cuotaAtrasadaDTO : response.body()) {
                        cuotaAtrasadaDTO.setId(Long.valueOf((long) i));
                        cuotaAtrasadaDTO.getCliente();
                        cuotaAtrasadaDTO.setTipocredito(cuotaAtrasadaDTO.getTipocredito());
                        cuotaAtrasadaDTO.setFormacobrocredito(cuotaAtrasadaDTO.getFormacobrocredito());
                        SincronizacionActivity.this.realm.copyToRealmOrUpdate(cuotaAtrasadaDTO);
                        i++;
                    }
                    SincronizacionActivity.this.realm.commitTransaction();
                    SincronizacionActivity.this.customPreferenceManager.setValue("fecha", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.US).format(new Date()));
                } else {
                    Toast.makeText(SincronizacionActivity.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                }
            }

            public void onFailure(Call<List<CuotaAtrasadaDTO>> call, Throwable th) {
                Toast.makeText(SincronizacionActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                th.printStackTrace();
            }
        });
    }

    private void llamarServicio() {
        UserInterface userInterface2 = (UserInterface) RestAdapter.getClient((String) null).create(UserInterface.class);
        this.userInterface = userInterface2;
        userInterface2.getNotificacion().enqueue(new Callback<NotificacionDto>() {
            public void onResponse(Call<NotificacionDto> call, Response<NotificacionDto> response) {
                if (response.body() != null) {
                    SincronizacionActivity.this.realm.beginTransaction();
                    NotificacionDto notificacionDto = new NotificacionDto();
                    notificacionDto.setNrocuota(response.body().getNrocuota());
                    notificacionDto.setFecvencimiento(response.body().getFecvencimiento());
                    notificacionDto.setCapital(response.body().getCapital());
                    notificacionDto.setInteres(response.body().getInteres());
                    SincronizacionActivity.this.realm.copyToRealmOrUpdate(notificacionDto);
                    SincronizacionActivity.this.realm.commitTransaction();
                }
            }

            public void onFailure(Call<NotificacionDto> call, Throwable th) {
                Toast.makeText(SincronizacionActivity.this, "Ocurrio un error, intente de nuevo por favor", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void cobrosDelDia() {
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).sort("fechavencimiento", Sort.ASCENDING).findAll();
        this.listaCobrosRealm = findAll;
        if (findAll.isEmpty()) {
            this.userInterface.getCobros().enqueue(new Callback<List<CobrosDTO>>() {
                public void onResponse(Call<List<CobrosDTO>> call, Response<List<CobrosDTO>> response) {
                    if (response.body() == null) {
                        Log.e("Error", response.message());
                        Toast.makeText(SincronizacionActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                    } else if (response.body() != null) {
                        SincronizacionActivity.this.realm.beginTransaction();
                        int i = 1;
                        for (CobrosDTO cobrosDTO : response.body()) {
                            cobrosDTO.setId(Long.valueOf((long) i));
                            cobrosDTO.getCliente();
                            cobrosDTO.setTipocredito(cobrosDTO.getTipocredito());
                            cobrosDTO.setFormacobrocredito(cobrosDTO.getFormacobrocredito());
                            SincronizacionActivity.this.realm.copyToRealmOrUpdate(cobrosDTO);
                            i++;
                        }
                        SincronizacionActivity.this.realm.commitTransaction();
                        SincronizacionActivity.this.customPreferenceManager.setValue("fecha", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.US).format(new Date()));
                    } else {
                        Toast.makeText(SincronizacionActivity.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                    }
                }

                public void onFailure(Call<List<CobrosDTO>> call, Throwable th) {
                    Toast.makeText(SincronizacionActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                    th.printStackTrace();
                }
            });
        }
    }

    private void login() {
        this.userInterface.getCuota().enqueue(new Callback<List<CuotaDTO>>() {
            public void onResponse(Call<List<CuotaDTO>> call, Response<List<CuotaDTO>> response) {
                if (response.body() == null) {
                    Log.e("Error", response.message());
                    Snackbar.make((View) SincronizacionActivity.this.btnSincro, (CharSequence) "No se pudo Sincronizar", Snackbar.LENGTH_LONG).show();
                    SincronizacionActivity.this.progressBar.setVisibility(View.GONE);
                } else if (response.body() != null) {
                    SincronizacionActivity.this.realm.beginTransaction();
                    int i = 1;
                    for (CuotaDTO cuotaDTO : response.body()) {
                        cuotaDTO.setId(Long.valueOf((long) i));
                        cuotaDTO.setTipocredito(cuotaDTO.getTipocredito());
                        cuotaDTO.setFormacobrocredito(cuotaDTO.getFormacobrocredito());
                        cuotaDTO.setAtraso(Integer.valueOf(SincronizacionActivity.numeroDiasEntreDosFechas(cuotaDTO.getFecvencimiento(), new Date())));
                        SincronizacionActivity.this.realm.copyToRealmOrUpdate(cuotaDTO);
                        i++;
                    }
                    SincronizacionActivity.this.realm.commitTransaction();
                    String format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.US).format(new Date());
                    SincronizacionActivity.this.customPreferenceManager.setValue("fecha", format);
                    SincronizacionActivity.this.tvFecha.setText(format);
                    Snackbar.make((View) SincronizacionActivity.this.btnSincro, (CharSequence) "Proceso satisfactorio", Snackbar.LENGTH_LONG).show();
                    SincronizacionActivity.this.progressBar.setVisibility(View.GONE);
                } else {
                    Snackbar.make((View) SincronizacionActivity.this.btnSincro, (CharSequence) "No se pudo Sincronizar", Snackbar.LENGTH_LONG).show();
                    SincronizacionActivity.this.progressBar.setVisibility(View.GONE);
                }
            }

            public void onFailure(Call<List<CuotaDTO>> call, Throwable th) {
                Snackbar.make((View) SincronizacionActivity.this.btnSincro, (CharSequence) "No se pudo Sincronizar", Snackbar.LENGTH_LONG).show();
                SincronizacionActivity.this.progressBar.setVisibility(View.GONE);
                th.printStackTrace();
            }
        });
    }

    public static int numeroDiasEntreDosFechas(Date date, Date date2) {
        return (int) ((date2.getTime() - date.getTime()) / 86400000);
    }
}
