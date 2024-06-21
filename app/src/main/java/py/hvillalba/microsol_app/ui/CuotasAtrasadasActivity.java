package py.hvillalba.microsol_app.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.ClienteDTO;
import py.hvillalba.microsol_app.data.CuotaAtrasadaDTO;
import py.hvillalba.microsol_app.http.service.UserInterface;
import py.hvillalba.microsol_app.util.Constant;
import py.hvillalba.microsol_app.util.CustomPreferenceManager;

public class CuotasAtrasadasActivity extends AppCompatActivity {
    private String TAG = "CuotasAtrasadasActivity";
    private Button btnCreditoDetalle;
    private Button btnDebitoDetalle;
    private Button btnEfectivoDetalle;
    Button btnVerDetalle;
    private int cantClientes;
    private int cantCuotas;
    private Context context;
    private CustomPreferenceManager customPreferenceManager;
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    private ImageView imgCredito;
    private ImageView imgDebito;
    private ImageView imgEfectivo;
    private RealmResults<CuotaAtrasadaDTO> listaRealm;
    private Realm realm;
    private double total;
    private double totalCapitales;
    private int totalCredito;
    private int totalDebito;
    private int totalEfectivo;
    private double totalIntereses;
    private double totalMora;
    private TextView tvCantCuotas;
    private TextView tvCapital;
    private TextView tvClientes;
    private TextView tvCredito;
    private TextView tvDebito;
    private TextView tvEfectivo;
    private TextView tvEfectivoLabel;
    TextView tvFecha;
    private TextView tvFechaConsulta;
    private TextView tvInteres;
    //private TextView tvMora;
    private TextView tvTarjetaCreditoLabel;
    private TextView tvTarjetaDebitoLabel;
    private TextView tvTotal;
    private TextView tvTotalValores;
    private UserInterface userInterface;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_cuotas_atrasadas);
        setTitle("Cuotas Atrasadas");
        this.btnEfectivoDetalle = (Button) findViewById(R.id.btnDetalleEfectivo);
        this.btnDebitoDetalle = (Button) findViewById(R.id.btnDetalleDebito);
        this.btnCreditoDetalle = (Button) findViewById(R.id.btnDetalleCredito);
        this.tvEfectivoLabel = (TextView) findViewById(R.id.tvEfectivoLabel);
        this.tvTarjetaDebitoLabel = (TextView) findViewById(R.id.tvDebitoLabel);
        this.tvTarjetaCreditoLabel = (TextView) findViewById(R.id.tvCreditoLabel);
        this.btnVerDetalle = (Button) findViewById(R.id.btnVerDetalle);
        this.tvFechaConsulta = (TextView) findViewById(R.id.tvFecha);
        this.tvTotal = (TextView) findViewById(R.id.tvTotal);
        //this.tvMora = (TextView) findViewById(R.id.tvMora);
        this.tvInteres = (TextView) findViewById(R.id.tvInteres);
        this.tvCapital = (TextView) findViewById(R.id.tvCapital);
        this.tvCantCuotas = (TextView) findViewById(R.id.tvCanCuotas);
        this.tvClientes = (TextView) findViewById(R.id.tvCanClientes);
        this.tvCredito = (TextView) findViewById(R.id.cantCredito);
        this.tvDebito = (TextView) findViewById(R.id.cantDebito);
        this.tvEfectivo = (TextView) findViewById(R.id.cantEfectivo);
        this.tvTotalValores = (TextView) findViewById(R.id.tvTotalValores);
        this.imgCredito = (ImageView) findViewById(R.id.imgCredito);
        this.imgDebito = (ImageView) findViewById(R.id.imgDebito);
        this.imgEfectivo = (ImageView) findViewById(R.id.imgEfectivo);
        this.tvFecha = (TextView) findViewById(R.id.tvFecha);
        this.imgEfectivo.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CuotasAtrasadasActivity.this.lambda$onCreate$0$CuotasAtrasadasActivity(view);
            }
        });
        this.btnEfectivoDetalle.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CuotasAtrasadasActivity.this.lambda$onCreate$1$CuotasAtrasadasActivity(view);
            }
        });
        this.tvEfectivoLabel.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CuotasAtrasadasActivity.this.lambda$onCreate$2$CuotasAtrasadasActivity(view);
            }
        });
        this.imgDebito.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CuotasAtrasadasActivity.this.lambda$onCreate$3$CuotasAtrasadasActivity(view);
            }
        });
        this.btnDebitoDetalle.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CuotasAtrasadasActivity.this.lambda$onCreate$4$CuotasAtrasadasActivity(view);
            }
        });
        this.tvTarjetaDebitoLabel.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CuotasAtrasadasActivity.this.lambda$onCreate$5$CuotasAtrasadasActivity(view);
            }
        });
        this.tvTarjetaCreditoLabel.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CuotasAtrasadasActivity.this.lambda$onCreate$6$CuotasAtrasadasActivity(view);
            }
        });
        this.imgCredito.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CuotasAtrasadasActivity.this.lambda$onCreate$7$CuotasAtrasadasActivity(view);
            }
        });
        this.btnCreditoDetalle.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CuotasAtrasadasActivity.this.lambda$onCreate$8$CuotasAtrasadasActivity(view);
            }
        });
        this.realm = Realm.getDefaultInstance();
        this.context = this;
        this.btnVerDetalle.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CuotasAtrasadasActivity.this.lambda$onCreate$9$CuotasAtrasadasActivity(view);
            }
        });
        this.customPreferenceManager = new CustomPreferenceManager(this.context);
        this.listaRealm = this.realm.where(CuotaAtrasadaDTO.class).findAll();
        Date minimumDate = this.realm.where(CuotaAtrasadaDTO.class).minimumDate("fechavencimiento");
        Date maximumDate = this.realm.where(CuotaAtrasadaDTO.class).maximumDate("fechavencimiento");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String format = simpleDateFormat.format(minimumDate);
        String format2 = simpleDateFormat.format(maximumDate);
        this.tvFecha.setText("Fecha Desde.: " + format + "\nFecha Hasta: " + format2);
        TextView textView = this.tvFechaConsulta;
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha Consulta.: ");
        sb.append(simpleDateFormat.format(new Date()));
        textView.setText(sb.toString());
        ClienteDTO cliente = ((CuotaAtrasadaDTO) this.listaRealm.get(0)).getCliente();
        if (cliente != null) {
            this.cantClientes++;
        }
        Iterator it = this.listaRealm.iterator();
        while (it.hasNext()) {
            CuotaAtrasadaDTO cuotaAtrasadaDTO = (CuotaAtrasadaDTO) it.next();
            this.cantCuotas++;
            this.total += cuotaAtrasadaDTO.getMonto().doubleValue();
            this.totalMora += cuotaAtrasadaDTO.getMora().doubleValue();
            this.totalCapitales += cuotaAtrasadaDTO.getCapital().doubleValue();
            this.totalIntereses += cuotaAtrasadaDTO.getInteres().doubleValue();
            if (cuotaAtrasadaDTO.getFormacobrocredito().getDescripcion().equalsIgnoreCase("efectivo")) {
                this.totalEfectivo++;
            }
            if (cuotaAtrasadaDTO.getFormacobrocredito().getDescripcion().contains("CREDITO")) {
                this.totalCredito++;
            }
            if (cuotaAtrasadaDTO.getFormacobrocredito().getDescripcion().contains("DEBITO")) {
                this.totalDebito++;
            }
            if (!cuotaAtrasadaDTO.getCliente().getIdcliente().equals(cliente.getIdcliente())) {
                this.cantClientes++;
                cliente = cuotaAtrasadaDTO.getCliente();
            }
        }
        this.tvTotal.setText("Gs. " + this.decimalFormat.format( this.totalCapitales + this.totalIntereses));
        //this.tvTotal.setText("Gs. " + this.decimalFormat.format(this.totalMora + this.totalCapitales + this.totalIntereses));
        //this.tvMora.setText("Gs. " + this.decimalFormat.format(this.totalMora));
        this.tvCapital.setText("Gs. " + this.decimalFormat.format(this.totalCapitales));
        this.tvInteres.setText("Gs. " + this.decimalFormat.format(this.totalIntereses));
        this.tvClientes.setText("" + this.cantClientes);
        this.tvCantCuotas.setText("" + this.cantCuotas);
        this.tvEfectivo.setText("" + this.totalEfectivo);
        this.tvDebito.setText("" + this.totalDebito);
        this.tvCredito.setText("" + this.totalCredito);
        this.tvTotalValores.setText("Total: " + (this.totalDebito + this.totalEfectivo + this.totalCredito));
    }

    public /* synthetic */ void lambda$onCreate$0$CuotasAtrasadasActivity(View view) {
        RealmResults<CuotaAtrasadaDTO> findAll = this.realm.where(CuotaAtrasadaDTO.class).equalTo("formacobrocredito.descripcion", "EFECTIVO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        List<CuotaAtrasadaDTO> copyFromRealm = this.realm.copyFromRealm(findAll);
        Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
        intent.putExtra("lista", (Serializable) copyFromRealm);
        startActivity(intent);
    }

    public /* synthetic */ void lambda$onCreate$1$CuotasAtrasadasActivity(View view) {
        RealmResults<CuotaAtrasadaDTO> findAll = this.realm.where(CuotaAtrasadaDTO.class).equalTo("formacobrocredito.descripcion", "EFECTIVO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CuotaAtrasadaDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$2$CuotasAtrasadasActivity(View view) {
        RealmResults<CuotaAtrasadaDTO> findAll = this.realm.where(CuotaAtrasadaDTO.class).equalTo("formacobrocredito.descripcion", "EFECTIVO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        List<CuotaAtrasadaDTO> copyFromRealm = this.realm.copyFromRealm(findAll);
        Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
        intent.putExtra("lista", (Serializable) copyFromRealm);
        startActivity(intent);
    }

    public /* synthetic */ void lambda$onCreate$3$CuotasAtrasadasActivity(View view) {
        RealmResults<CuotaAtrasadaDTO> findAll = this.realm.where(CuotaAtrasadaDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.DEBITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        List<CuotaAtrasadaDTO> copyFromRealm = this.realm.copyFromRealm(findAll);
        Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
        intent.putExtra("lista", (Serializable) copyFromRealm);
        startActivity(intent);
    }

    public /* synthetic */ void lambda$onCreate$4$CuotasAtrasadasActivity(View view) {
        RealmResults<CuotaAtrasadaDTO> findAll = this.realm.where(CuotaAtrasadaDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.DEBITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CuotaAtrasadaDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$5$CuotasAtrasadasActivity(View view) {
        RealmResults<CuotaAtrasadaDTO> findAll = this.realm.where(CuotaAtrasadaDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.DEBITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (findAll.isEmpty()) {
            List<CuotaAtrasadaDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$6$CuotasAtrasadasActivity(View view) {
        RealmResults<CuotaAtrasadaDTO> findAll = this.realm.where(CuotaAtrasadaDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.CREDITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CuotaAtrasadaDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$7$CuotasAtrasadasActivity(View view) {
        RealmResults<CuotaAtrasadaDTO> findAll = this.realm.where(CuotaAtrasadaDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.CREDITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CuotaAtrasadaDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$8$CuotasAtrasadasActivity(View view) {
        RealmResults<CuotaAtrasadaDTO> findAll = this.realm.where(CuotaAtrasadaDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.CREDITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CuotaAtrasadaDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$9$CuotasAtrasadasActivity(View view) {
        startActivity(new Intent(this, CuotasAtrasadasDetalleActivity.class));
    }
}
