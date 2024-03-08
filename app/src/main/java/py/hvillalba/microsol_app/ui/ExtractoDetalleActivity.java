package py.hvillalba.microsol_app.ui;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CuotaDTO;
import py.hvillalba.microsol_app.ui.recyclerDetalleExtracto.RecyclerViewExtractoDetalle;

public class ExtractoDetalleActivity extends AppCompatActivity {
    RecyclerViewExtractoDetalle adapter;
    boolean conSaldo;
    List<CuotaDTO> listTemp;
    private List<CuotaDTO> listaFinal = new ArrayList();
    RealmResults<CuotaDTO> listaRealm;
    Realm realm;
    RecyclerView recyclerView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_extracto_detalle);
        setTitle("Extracto Detalle");
        String stringExtra = getIntent().getStringExtra("nrodoc");
        String stringExtra2 = getIntent().getStringExtra("estado");
        this.conSaldo = getIntent().getBooleanExtra("conSaldo", false);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        Integer valueOf = Integer.valueOf(getIntent().getIntExtra("idcredito", 0));
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.rvExtractoDetalle);
        this.recyclerView = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.realm = Realm.getDefaultInstance();
        String[] strArr = {"nombreapellido", "fecvencimiento"};
        Sort[] sortArr = {Sort.DESCENDING, Sort.ASCENDING};
        if (stringExtra2.equals("mora") || stringExtra2.equals("aldia")) {
            if (stringExtra2.equals("mora")) {
                this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("nrodoc", stringExtra).and().equalTo("idcredito", valueOf).and().equalTo("pagado", (Boolean) false).and().greaterThan("atraso", 0).sort(strArr, sortArr).findAll();
            } else {
                this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("nrodoc", stringExtra).and().equalTo("idcredito", valueOf).and().equalTo("pagado", (Boolean) false).and().lessThanOrEqualTo("atraso", 0).sort(strArr, sortArr).findAll();
            }
        } else if (stringExtra2.equals("")) {
            if (this.conSaldo) {
                this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("nrodoc", stringExtra).and().equalTo("idcredito", valueOf).and().equalTo("pagado", (Boolean) false).sort(strArr, sortArr).findAll();
            } else {
                this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("nrodoc", stringExtra).and().equalTo("idcredito", valueOf).sort(strArr, sortArr).findAll();
            }
            List<CuotaDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            this.listTemp = copyFromRealm;
            RecyclerViewExtractoDetalle recyclerViewExtractoDetalle = new RecyclerViewExtractoDetalle(this, copyFromRealm);
            this.adapter = recyclerViewExtractoDetalle;
            this.recyclerView.setAdapter(recyclerViewExtractoDetalle);
            this.recyclerView.setVisibility(View.VISIBLE);
            return;
        }
        List<CuotaDTO> copyFromRealm2 = this.realm.copyFromRealm(this.listaRealm);
        this.listTemp = copyFromRealm2;
        copyFromRealm2.get(0).getIdcredito();
        new ArrayList().add(this.listTemp.get(0));
        for (CuotaDTO add : this.listTemp) {
            this.listaFinal.add(add);
        }
        if (!this.listTemp.isEmpty()) {
            RecyclerViewExtractoDetalle recyclerViewExtractoDetalle2 = new RecyclerViewExtractoDetalle(this, this.listaFinal);
            this.adapter = recyclerViewExtractoDetalle2;
            this.recyclerView.setAdapter(recyclerViewExtractoDetalle2);
            this.recyclerView.setVisibility(View.VISIBLE);
            return;
        }
        Snackbar.make((View) this.recyclerView, (CharSequence) "No se encontraron datos", Snackbar.LENGTH_LONG).show();
    }

    public static int numeroDiasEntreDosFechas(Date date, Date date2) {
        return (int) ((date2.getTime() - date.getTime()) / 86400000);
    }
}
