package py.hvillalba.microsol_app.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
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
import py.hvillalba.microsol_app.data.CobrosDTO;
import py.hvillalba.microsol_app.data.CuotaAtrasadaDTO;
import py.hvillalba.microsol_app.http.service.UserInterface;
import py.hvillalba.microsol_app.util.Constant;
import py.hvillalba.microsol_app.util.CustomPreferenceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CobrosDelDiaActivity extends AppCompatActivity {
    private String TAG = "CobrosDelDiaActivity";
    private Button btnCreditoDetalle;
    private Button btnDebitoDetalle;
    private Button btnEfectivoDetalle;
    private Button btnVerDetalle;
    private int cantClientes;
    private int cantCuotas;
    private Context context;
    /* access modifiers changed from: private */
    public CustomPreferenceManager customPreferenceManager;
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    private ImageView imgCredito;
    private ImageView imgDebito;
    private ImageView imgEfectivo;
    private RealmResults<CobrosDTO> listaRealm;
    /* access modifiers changed from: private */
    public Realm realm;
    private double total;
    private double totalCapitales;
    private int totalCredito;
    private int totalDebito;
    private int totalEfectivo;
    private double totalIntereses;
    private int totalMetodoCobro;
    private double totalMora;
    private TextView tvCantCuotas;
    private TextView tvCapital;
    private TextView tvClientes;
    private TextView tvCredito;
    private TextView tvDebito;
    private TextView tvEfectivo;
    private TextView tvEfectivoLabel;
    private TextView tvFecha;
    private TextView tvInteres;
    private TextView tvMetodoCobro;
    private TextView tvMora;
    private TextView tvTarjetaCreditoLabel;
    private TextView tvTarjetaDebitoLabel;
    private TextView tvTotal;
    private TextView tvTotalValores;
    private UserInterface userInterface;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cobros_del_dia);
        setTitle("Vencimientos del Día");
        this.btnEfectivoDetalle = (Button) findViewById(R.id.btnDetalleEfectivo);
        this.btnDebitoDetalle = (Button) findViewById(R.id.btnDetalleDebito);
        this.btnCreditoDetalle = (Button) findViewById(R.id.btnDetalleCredito);
        this.tvEfectivoLabel = (TextView) findViewById(R.id.tvEfectivoLabel);
        this.tvTarjetaDebitoLabel = (TextView) findViewById(R.id.tvDebitoLabel);
        this.tvTarjetaCreditoLabel = (TextView) findViewById(R.id.tvCreditoLabel);
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
        this.tvMetodoCobro = (TextView) findViewById(R.id.tvTotalMetodoCobro);
        this.btnVerDetalle = (Button) findViewById(R.id.btnVerDetalle);
        this.tvFecha = (TextView) findViewById(R.id.tvFecha);
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
        this.tvFecha.setText("Fecha: " + format);
        this.btnVerDetalle.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CobrosDelDiaActivity.this.lambda$onCreate$0$CobrosDelDiaActivity(view);
            }
        });
        this.imgEfectivo.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CobrosDelDiaActivity.this.lambda$onCreate$1$CobrosDelDiaActivity(view);
            }
        });
        this.tvEfectivoLabel.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CobrosDelDiaActivity.this.lambda$onCreate$2$CobrosDelDiaActivity(view);
            }
        });
        this.btnEfectivoDetalle.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CobrosDelDiaActivity.this.lambda$onCreate$3$CobrosDelDiaActivity(view);
            }
        });
        this.imgDebito.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CobrosDelDiaActivity.this.lambda$onCreate$4$CobrosDelDiaActivity(view);
            }
        });
        this.btnDebitoDetalle.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CobrosDelDiaActivity.this.lambda$onCreate$5$CobrosDelDiaActivity(view);
            }
        });
        this.tvTarjetaDebitoLabel.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CobrosDelDiaActivity.this.lambda$onCreate$6$CobrosDelDiaActivity(view);
            }
        });
        this.tvTarjetaCreditoLabel.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CobrosDelDiaActivity.this.lambda$onCreate$7$CobrosDelDiaActivity(view);
            }
        });
        this.btnCreditoDetalle.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CobrosDelDiaActivity.this.lambda$onCreate$8$CobrosDelDiaActivity(view);
            }
        });
        this.imgCredito.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CobrosDelDiaActivity.this.lambda$onCreate$9$CobrosDelDiaActivity(view);
            }
        });
        this.realm = Realm.getDefaultInstance();
        this.context = this;
        this.customPreferenceManager = new CustomPreferenceManager(this);
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            ClienteDTO cliente = ((CobrosDTO) this.listaRealm.get(0)).getCliente();
            if (cliente != null) {
                this.cantClientes++;
            }
            Iterator it = this.listaRealm.iterator();
            while (it.hasNext()) {
                CobrosDTO cobrosDTO = (CobrosDTO) it.next();
                this.cantCuotas++;
                this.total += cobrosDTO.getMonto().doubleValue();
                this.totalMora += cobrosDTO.getMora().doubleValue();
                this.totalCapitales += cobrosDTO.getCapital().doubleValue();
                this.totalIntereses += cobrosDTO.getInteres().doubleValue();
                if (cobrosDTO.getFormacobrocredito().getDescripcion().equalsIgnoreCase("efectivo")) {
                    this.totalEfectivo++;
                }
                if (cobrosDTO.getFormacobrocredito().getDescripcion().contains("CREDITO")) {
                    this.totalCredito++;
                }
                if (cobrosDTO.getFormacobrocredito().getDescripcion().contains("DEBITO")) {
                    this.totalDebito++;
                }
                if (!cobrosDTO.getCliente().getIdcliente().equals(cliente.getIdcliente())) {
                    this.cantClientes++;
                    cliente = cobrosDTO.getCliente();
                }
            }
        } else {
            Toast.makeText(this, "No se encontraron datos", Toast.LENGTH_LONG).show();
        }
        this.tvTotal.setText("Gs. " + this.decimalFormat.format(this.total));
        this.tvCapital.setText("Gs. " + this.decimalFormat.format(this.totalCapitales));
        this.tvInteres.setText("Gs. " + this.decimalFormat.format(this.totalIntereses));
        this.tvClientes.setText("" + this.cantClientes);
        this.tvCantCuotas.setText("" + this.cantCuotas);
        this.tvEfectivo.setText("" + this.totalEfectivo);
        this.tvDebito.setText("" + this.totalDebito);
        this.tvCredito.setText("" + this.totalCredito);
        this.tvMetodoCobro.setText("" + this.totalMetodoCobro);
        this.tvTotalValores.setText("Total: " + (this.totalDebito + this.totalEfectivo + this.totalCredito));
    }

    public /* synthetic */ void lambda$onCreate$0$CobrosDelDiaActivity(View view) {
        Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
        intent.putExtra("cobros", true);
        startActivity(intent);
    }

    public /* synthetic */ void lambda$onCreate$1$CobrosDelDiaActivity(View view) {
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).equalTo("formacobrocredito.descripcion", "EFECTIVO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CobrosDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            intent.putExtra("cobros", true);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$2$CobrosDelDiaActivity(View view) {
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).equalTo("formacobrocredito.descripcion", "EFECTIVO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CobrosDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            intent.putExtra("cobros", true);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$3$CobrosDelDiaActivity(View view) {
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).equalTo("formacobrocredito.descripcion", "EFECTIVO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CobrosDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            intent.putExtra("cobros", true);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$4$CobrosDelDiaActivity(View view) {
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.DEBITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        List<CobrosDTO> copyFromRealm = this.realm.copyFromRealm(findAll);
        Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
        intent.putExtra("lista", (Serializable) copyFromRealm);
        intent.putExtra("cobros", true);
        startActivity(intent);
    }

    public /* synthetic */ void lambda$onCreate$5$CobrosDelDiaActivity(View view) {
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.DEBITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CobrosDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            intent.putExtra("cobros", true);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$6$CobrosDelDiaActivity(View view) {
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.DEBITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CobrosDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            intent.putExtra("cobros", true);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$7$CobrosDelDiaActivity(View view) {
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.CREDITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CobrosDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            intent.putExtra("cobros", true);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$8$CobrosDelDiaActivity(View view) {
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.CREDITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CobrosDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            intent.putExtra("cobros", true);
            startActivity(intent);
        }
    }

    public /* synthetic */ void lambda$onCreate$9$CobrosDelDiaActivity(View view) {
        RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).equalTo("formacobrocredito.descripcion", "TARJ.CREDITO").sort(Constant.KEY_DEVICE, Sort.ASCENDING).findAll();
        this.listaRealm = findAll;
        if (!findAll.isEmpty()) {
            List<CobrosDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            Intent intent = new Intent(this, CuotasAtrasadasDetalleActivity.class);
            intent.putExtra("lista", (Serializable) copyFromRealm);
            intent.putExtra("cobros", true);
            startActivity(intent);
        }
    }

    private void cobroDelDia() {
        this.userInterface.getCuotaAtrasadas().enqueue(new Callback<List<CuotaAtrasadaDTO>>() {
            public void onResponse(Call<List<CuotaAtrasadaDTO>> call, Response<List<CuotaAtrasadaDTO>> response) {
                if (response.body() == null) {
                    Log.e("Error", response.message());
                    Toast.makeText(CobrosDelDiaActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                } else if (response.body() != null) {
                    CobrosDelDiaActivity.this.realm.beginTransaction();
                    for (CuotaAtrasadaDTO cuotaAtrasadaDTO : response.body()) {
                        cuotaAtrasadaDTO.getCliente();
                        cuotaAtrasadaDTO.setTipocredito(cuotaAtrasadaDTO.getTipocredito());
                        cuotaAtrasadaDTO.setFormacobrocredito(cuotaAtrasadaDTO.getFormacobrocredito());
                        CobrosDelDiaActivity.this.realm.copyToRealmOrUpdate(cuotaAtrasadaDTO);
                    }
                    CobrosDelDiaActivity.this.realm.commitTransaction();
                    CobrosDelDiaActivity.this.customPreferenceManager.setValue("fecha", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.US).format(new Date()));
                } else {
                    Toast.makeText(CobrosDelDiaActivity.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                }
            }

            public void onFailure(Call<List<CuotaAtrasadaDTO>> call, Throwable th) {
                Toast.makeText(CobrosDelDiaActivity.this, "Ocurrio un error al intentar loguear, intente de nuevo por favor", Toast.LENGTH_LONG).show();
                th.printStackTrace();
            }
        });
    }
}
