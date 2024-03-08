package py.hvillalba.microsol_app.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.NotificacionDto;
import py.hvillalba.microsol_app.http.RestAdapter;
import py.hvillalba.microsol_app.http.service.UserInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificacionActivity extends AppCompatActivity {
    NotificacionDto notificacionDto;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    Realm realm;
    TextView tvCapital;
    TextView tvCuotas;
    TextView tvFecha;
    private TextView tvFechaConsulta;
    TextView tvTotal;
    TextView tvTotalInteres;
    private UserInterface userInterface;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_notificacion);
        setTitle("Alertas de Notificación");
        this.realm = Realm.getDefaultInstance();
        ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.loading);
        this.progressBar = progressBar2;
        progressBar2.setVisibility(View.VISIBLE);
        this.tvTotal = (TextView) findViewById(R.id.tvTotal);
        this.tvTotalInteres = (TextView) findViewById(R.id.tvTotalInteres);
        this.tvCapital = (TextView) findViewById(R.id.tvTotalCapital);
        this.tvCuotas = (TextView) findViewById(R.id.tvCuotasVencidas);
        this.tvFecha = (TextView) findViewById(R.id.tvFecha);
        this.tvFechaConsulta = (TextView) findViewById(R.id.tvFechaConsulta);
        NotificacionDto notificacionDto2 = (NotificacionDto) this.realm.where(NotificacionDto.class).findFirst();
        this.notificacionDto = notificacionDto2;
        if (notificacionDto2 != null) {
            this.progressBar.setVisibility(View.GONE);
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            TextView textView = this.tvCapital;
            textView.setText("" + decimalFormat.format(this.notificacionDto.getCapital()));
            TextView textView2 = this.tvTotal;
            textView2.setText("" + decimalFormat.format(this.notificacionDto.getCapital().doubleValue() + this.notificacionDto.getInteres().doubleValue()));
            TextView textView3 = this.tvTotalInteres;
            textView3.setText("" + decimalFormat.format(this.notificacionDto.getInteres()));
            TextView textView4 = this.tvCuotas;
            textView4.setText("" + this.notificacionDto.getNrocuota());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            this.tvFecha.setText(simpleDateFormat.format(this.notificacionDto.getFecvencimiento()));
            TextView textView5 = this.tvFechaConsulta;
            textView5.setText("" + simpleDateFormat.format(new Date()));
            return;
        }
        llamarServicio();
    }

    private void llamarServicio() {
        UserInterface userInterface2 = (UserInterface) RestAdapter.getClient((String) null).create(UserInterface.class);
        this.userInterface = userInterface2;
        userInterface2.getNotificacion().enqueue(new Callback<NotificacionDto>() {
            public void onResponse(Call<NotificacionDto> call, Response<NotificacionDto> response) {
                if (response.body() != null) {
                    NotificacionActivity.this.progressBar.setVisibility(View.GONE);
                    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                    TextView textView = NotificacionActivity.this.tvCapital;
                    textView.setText("" + decimalFormat.format(response.body().getCapital()));
                    TextView textView2 = NotificacionActivity.this.tvTotal;
                    textView2.setText("" + decimalFormat.format(response.body().getCapital().doubleValue() + response.body().getInteres().doubleValue()));
                    TextView textView3 = NotificacionActivity.this.tvTotalInteres;
                    textView3.setText("" + decimalFormat.format(response.body().getInteres()));
                    TextView textView4 = NotificacionActivity.this.tvCuotas;
                    textView4.setText("" + response.body().getNrocuota());
                    NotificacionActivity.this.tvFecha.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(response.body().getFecvencimiento()));
                }
            }

            public void onFailure(Call<NotificacionDto> call, Throwable th) {
                Toast.makeText(NotificacionActivity.this, "Ocurrio un error, intente de nuevo por favor", Toast.LENGTH_LONG).show();
            }
        });
    }
}
