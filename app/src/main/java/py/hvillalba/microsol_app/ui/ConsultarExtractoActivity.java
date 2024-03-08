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
import android.widget.ImageView;
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
import java.util.List;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CuotaDTO;
import py.hvillalba.microsol_app.ui.recyclerExtractoPorSocio.RecyclerViewExtractoPorSocio;

public class ConsultarExtractoActivity extends AppCompatActivity {
    RecyclerViewExtractoPorSocio adapter;
    /* access modifiers changed from: private */
    public Button btnConsultar;
    CheckBox checkBox;
    private EditText editText;
    ImageView imageView;
    RealmResults<CuotaDTO> listaRealm;
    ProgressBar progressBar;
    Realm realm;
    private RecyclerView recyclerView;
    TextView tvCliente;
    TextView tvTelefono;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_consultar_extracto);
        setTitle("Consultar Extracto");
        this.editText = (EditText) findViewById(R.id.edNroDocumento);
        this.checkBox = (CheckBox) findViewById(R.id.checkbox);
        this.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6) {
                    return false;
                }
                ConsultarExtractoActivity.this.btnConsultar.performClick();
                return true;
            }
        });
        this.btnConsultar = (Button) findViewById(R.id.btnConsultar);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.rvExtracto);
        this.recyclerView = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.progressBar = (ProgressBar) findViewById(R.id.loading);
        this.realm = Realm.getDefaultInstance();
        this.btnConsultar.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ConsultarExtractoActivity.this.lambda$onCreate$0$ConsultarExtractoActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$ConsultarExtractoActivity(View view) {
        this.progressBar.setVisibility(View.GONE);
        String[] strArr = {"nombreapellido", "idcredito", "nrocuota"};
        Sort[] sortArr = {Sort.ASCENDING, Sort.ASCENDING, Sort.ASCENDING};
        if (this.checkBox.isChecked()) {
            this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("nrodoc", this.editText.getText().toString()).or().contains("nombreapellido", this.editText.getText().toString(), Case.INSENSITIVE).and().equalTo("estadocredito", "PEN").and().equalTo("pagado", (Boolean) false).sort(strArr, sortArr).findAll();
        } else {
            this.listaRealm = this.realm.where(CuotaDTO.class).equalTo("nrodoc", this.editText.getText().toString()).or().contains("nombreapellido", this.editText.getText().toString(), Case.INSENSITIVE).sort(strArr, sortArr).findAll();
        }
        hideSoftKeyboard(this);
        List<CuotaDTO> copyFromRealm = this.realm.copyFromRealm(this.listaRealm);
        ArrayList arrayList = new ArrayList();
        if (!copyFromRealm.isEmpty()) {
            CuotaDTO cuotaDTO = null;
            String nombreapellido = copyFromRealm.get(0).getNombreapellido();
            boolean z = false;
            for (CuotaDTO next : copyFromRealm) {
                if (nombreapellido.equals(next.getNombreapellido())) {
                    nombreapellido = next.getNombreapellido();
                } else {
                    arrayList.add(cuotaDTO);
                    String nombreapellido2 = next.getNombreapellido();
                    arrayList.add(next);
                    nombreapellido = nombreapellido2;
                    z = true;
                }
                cuotaDTO = next;
            }
            if (!z) {
                arrayList.add(cuotaDTO);
            }
            RecyclerViewExtractoPorSocio recyclerViewExtractoPorSocio = new RecyclerViewExtractoPorSocio(this, arrayList, this.checkBox.isChecked());
            this.adapter = recyclerViewExtractoPorSocio;
            this.recyclerView.setAdapter(recyclerViewExtractoPorSocio);
            this.recyclerView.setVisibility(View.VISIBLE);
            this.progressBar.setVisibility(View.GONE);
            return;
        }
        Snackbar.make((View) this.recyclerView, (CharSequence) "No se encontraron datos", Snackbar.LENGTH_LONG).show();
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }
}
