package py.hvillalba.microsol_app.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import java.util.ArrayList;
import java.util.List;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CuotaDTO;
import py.hvillalba.microsol_app.ui.recyclerExtracto.RecyclerViewExtracto;

public class ConsultarExtractoCabActivity extends AppCompatActivity {
    RecyclerViewExtracto adapter;
    RealmResults<CuotaDTO> listaRealm;
    ProgressBar progressBar;
    Realm realm;
    private RecyclerView recyclerView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_consultar_extracto_cab);
        String stringExtra = getIntent().getStringExtra("nrodoc");
        boolean booleanExtra = getIntent().getBooleanExtra("ischecked", false);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.rvExtractoCab);
        this.recyclerView = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.realm = Realm.getDefaultInstance();
        String[] strArr = {"idcredito", "nrocuota"};
        Sort[] sortArr = {Sort.ASCENDING, Sort.ASCENDING};
        if (booleanExtra) {
            this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("nrodoc", stringExtra).and().equalTo("estadocredito", "PEN").sort(strArr, sortArr).findAll();
        } else {
            this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("nrodoc", stringExtra).sort(strArr, sortArr).findAll();
        }
        List<CuotaDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
        ArrayList arrayList = new ArrayList();
        if (!copyFromRealm.isEmpty()) {
            CuotaDTO cuotaDTO = null;
            int intValue = copyFromRealm.get(0).getIdcredito().intValue();
            double d = 0.0d;
            double d2 = 0.0d;
            int i = 0;
            int i2 = 0;
            for (CuotaDTO next : copyFromRealm) {
                if (intValue == next.getIdcredito().intValue()) {
                    d += next.getMonto().doubleValue();
                    d2 += next.getImportepagado() == null ? 0.0d : next.getImportepagado().doubleValue();
                    if (next.getImportepagado().doubleValue() >= next.getMonto().doubleValue()) {
                        i2++;
                    } else {
                        i++;
                    }
                } else {
                    double d3 = (double) i;
                    double doubleValue = cuotaDTO.getMonto().doubleValue();
                    Double.isNaN(d3);
                    cuotaDTO.setSalo(Double.valueOf(d3 * doubleValue));
                    cuotaDTO.setTotal(Double.valueOf(d));
                    cuotaDTO.setImportepagado(Double.valueOf(d2));
                    cuotaDTO.setCuotasPagadas(Integer.valueOf(i2));
                    arrayList.add(cuotaDTO);
                    if (next.getImportepagado().doubleValue() >= next.getMonto().doubleValue()) {
                        i = 0;
                        i2 = 1;
                    } else {
                        i = 1;
                        i2 = 0;
                    }
                    int intValue2 = next.getIdcredito().intValue();
                    d2 = next.getImportepagado().doubleValue() + 0.0d;
                    d = next.getMonto().doubleValue() + 0.0d;
                    intValue = intValue2;
                }
                cuotaDTO = next;
            }
            double d4 = (double) i;
            double doubleValue2 = cuotaDTO.getMonto().doubleValue();
            Double.isNaN(d4);
            cuotaDTO.setSalo(Double.valueOf(d4 * doubleValue2));
            cuotaDTO.setTotal(Double.valueOf(d));
            cuotaDTO.setImportepagado(Double.valueOf(d2));
            cuotaDTO.setCuotasPagadas(Integer.valueOf(i2));
            arrayList.add(cuotaDTO);
            RecyclerViewExtracto recyclerViewExtracto = new RecyclerViewExtracto(this, arrayList, booleanExtra);
            this.adapter = recyclerViewExtracto;
            this.recyclerView.setAdapter(recyclerViewExtracto);
            this.recyclerView.setVisibility(View.VISIBLE);
            return;
        }
        Snackbar.make((View) this.recyclerView, (CharSequence) "No se encontraron datos", Snackbar.LENGTH_LONG).show();
    }
}
