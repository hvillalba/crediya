package py.hvillalba.microsol_app.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CuotaDTO;
import py.hvillalba.microsol_app.ui.recyclerCartera.RecyclerViewCartera;

public class EstadoCarteraActivity extends AppCompatActivity {
    RecyclerViewCartera adapter;
    Button btnConsultar;
    CheckBox checkBoxAlDia;
    CheckBox checkBoxMora;
    EditText edNroDoc;
    RealmResults<CuotaDTO> listaRealm;
    ProgressBar loadingProgressBar;
    Realm realm;
    RecyclerView recyclerView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_estado_cartera);
        setTitle("Consultar Cartera");
        this.realm = Realm.getDefaultInstance();
        this.btnConsultar = (Button) findViewById(R.id.btnConsultar);
        EditText editText = (EditText) findViewById(R.id.edNroDocumento);
        this.edNroDoc = editText;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6) {
                    return false;
                }
                EstadoCarteraActivity.this.btnConsultar.performClick();
                return true;
            }
        });
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.rvCartera);
        this.recyclerView = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.checkBoxAlDia = (CheckBox) findViewById(R.id.checkboxDia);
        this.checkBoxMora = (CheckBox) findViewById(R.id.checkboxMora);
        this.loadingProgressBar = (ProgressBar) findViewById(R.id.progresBar);
        this.checkBoxMora.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EstadoCarteraActivity.this.lambda$onCreate$0$EstadoCarteraActivity(view);
            }
        });
        this.checkBoxAlDia.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EstadoCarteraActivity.this.lambda$onCreate$1$EstadoCarteraActivity(view);
            }
        });
        this.btnConsultar.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EstadoCarteraActivity.this.lambda$onCreate$2$EstadoCarteraActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$EstadoCarteraActivity(View view) {
        this.checkBoxAlDia.setChecked(false);
    }

    public /* synthetic */ void lambda$onCreate$1$EstadoCarteraActivity(View view) {
        this.checkBoxMora.setChecked(false);
    }

    public /* synthetic */ void lambda$onCreate$2$EstadoCarteraActivity(View view) {
        hideSoftKeyboard(this);
        if (this.checkBoxMora.isChecked() || this.checkBoxAlDia.isChecked()) {
            this.loadingProgressBar.setVisibility(View.GONE);
            new ArrayList();
            ArrayList<CuotaDTO> arrayList = new ArrayList<>();
            String[] strArr = {"nombreapellido", "idcredito", "fecvencimiento"};
            Sort[] sortArr = {Sort.ASCENDING, Sort.ASCENDING, Sort.ASCENDING};
            if (this.checkBoxMora.isChecked()) {
                if (this.edNroDoc.getText().toString().equals("")) {
                    this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("estadocredito", "PEN").and().equalTo("pagado", (Boolean) false).and().greaterThan("atraso", 0).sort(strArr, sortArr).findAll();
                } else {
                    RealmResults<CuotaDTO> findAll = this.realm.where(CuotaDTO.class).equalTo("estadocredito", "PEN").and().equalTo("nrodoc", this.edNroDoc.getText().toString()).and().greaterThan("atraso", 0).and().equalTo("pagado", (Boolean) false).sort(strArr, sortArr).findAll();
                    this.listaRealm = findAll;
                    if (findAll.isEmpty()) {
                        this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("estadocredito", "PEN").and().contains("nombreapellido", this.edNroDoc.getText().toString(), Case.INSENSITIVE).and().greaterThan("atraso", 0).and().equalTo("pagado", (Boolean) false).sort(strArr, sortArr).findAll();
                    }
                }
            } else if (this.checkBoxAlDia.isChecked()) {
                if (this.edNroDoc.getText().toString().equals("")) {
                    this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("estadocredito", "PEN").and().equalTo("pagado", (Boolean) false).and().lessThanOrEqualTo("atraso", 0).sort(strArr, sortArr).findAll();
                } else {
                    RealmResults<CuotaDTO> findAll2 = this.realm.where(CuotaDTO.class).equalTo("estadocredito", "PEN").and().equalTo("nrodoc", this.edNroDoc.getText().toString()).and().equalTo("pagado", (Boolean) false).and().lessThanOrEqualTo("atraso", 0).sort(strArr, sortArr).findAll();
                    this.listaRealm = findAll2;
                    if (findAll2.isEmpty()) {
                        this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("estadocredito", "PEN").and().equalTo("pagado", (Boolean) false).and().lessThanOrEqualTo("atraso", 0).and().contains("nombreapellido", this.edNroDoc.getText().toString(), Case.INSENSITIVE).sort(strArr, sortArr).findAll();
                    }
                }
            }
            List<CuotaDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
            if (copyFromRealm.isEmpty()) {
                Snackbar.make((View) this.btnConsultar, (CharSequence) "No se encontraron datos", Snackbar.LENGTH_LONG).show();
                this.loadingProgressBar.setVisibility(View.GONE);
                RecyclerViewCartera recyclerViewCartera = new RecyclerViewCartera(this, copyFromRealm);
                this.adapter = recyclerViewCartera;
                this.recyclerView.setAdapter(recyclerViewCartera);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (CuotaDTO next : copyFromRealm) {
                if (next.getEstadocredito().equals("PEN")) {
                    CuotaDTO cuotaDTO = (CuotaDTO) this.realm.where(CuotaDTO.class).equalTo("idcredito", next.getIdcredito()).and().greaterThan("atraso", 0).and().equalTo("pagado", (Boolean) false).sort(strArr, sortArr).findFirst();
                    if (!this.checkBoxAlDia.isChecked() || cuotaDTO == null) {
                        arrayList.add(next);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                Snackbar.make((View) this.btnConsultar, (CharSequence) "No se encontraron datos", Snackbar.LENGTH_LONG).show();
                this.loadingProgressBar.setVisibility(View.GONE);
                RecyclerViewCartera recyclerViewCartera2 = new RecyclerViewCartera(this, arrayList2);
                this.adapter = recyclerViewCartera2;
                this.recyclerView.setAdapter(recyclerViewCartera2);
                return;
            }
            int intValue = ((CuotaDTO) arrayList.get(0)).getIdcredito().intValue();
            arrayList2.add((CuotaDTO) arrayList.get(0));
            for (CuotaDTO cuotaDTO2 : arrayList) {
                if (intValue != cuotaDTO2.getIdcredito().intValue()) {
                    intValue = cuotaDTO2.getIdcredito().intValue();
                    arrayList2.add(cuotaDTO2);
                }
            }
            if (arrayList2.isEmpty()) {
                Snackbar.make((View) this.btnConsultar, (CharSequence) "No se encontraron datos", Snackbar.LENGTH_LONG).show();
                this.loadingProgressBar.setVisibility(View.GONE);
                return;
            }
            RecyclerViewCartera recyclerViewCartera3 = new RecyclerViewCartera(this, arrayList2);
            this.adapter = recyclerViewCartera3;
            this.recyclerView.setAdapter(recyclerViewCartera3);
            this.loadingProgressBar.setVisibility(View.GONE);
            return;
        }
        Snackbar.make((View) this.btnConsultar, (CharSequence) "Debe elegir un checkBox", Snackbar.LENGTH_LONG).show();
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static int numeroDiasEntreDosFechas(Date date, Date date2) {
        return (int) ((date2.getTime() - date.getTime()) / 86400000);
    }
}
