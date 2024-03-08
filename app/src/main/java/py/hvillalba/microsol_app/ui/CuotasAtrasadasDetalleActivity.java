package py.hvillalba.microsol_app.ui;

import android.app.SearchManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import java.util.ArrayList;
import java.util.List;

import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CobrosDTO;
import py.hvillalba.microsol_app.data.CuotaAtrasadaDTO;
import py.hvillalba.microsol_app.ui.recyclerCobros.RecyclerCobrosDet;
import py.hvillalba.microsol_app.ui.recyclerCuotasAtrasadasDetalle.RecyclerCuotasAtrasadasDet;
import py.hvillalba.microsol_app.util.Constant;

public class CuotasAtrasadasDetalleActivity extends AppCompatActivity {
    RecyclerCuotasAtrasadasDet adapter;
    RecyclerCobrosDet adapterCobros;
    /* access modifiers changed from: private */
    public boolean cobros;
    List<CuotaAtrasadaDTO> lista = new ArrayList();
    List<CobrosDTO> listaCobros = new ArrayList();
    RealmResults<CuotaAtrasadaDTO> listaRealm;
    RealmResults<CobrosDTO> listaRealmCobros;
    Realm realm;
    RecyclerView recyclerView;
    private SearchView searchView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cuotas_atrasadas_detalle);
        boolean booleanExtra = getIntent().getBooleanExtra("cobros", false);
        this.cobros = booleanExtra;
        if (booleanExtra) {
            this.listaCobros = (List) getIntent().getSerializableExtra("lista");
            setTitle("Cobros del Día Detalle");
        } else {
            this.lista = (List) getIntent().getSerializableExtra("lista");
            setTitle("Cuotas Atrasadas Detalle");
        }
        this.realm = Realm.getDefaultInstance();
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle((int) R.string.toolbar_title);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.rvCuotaAtrasada);
        this.recyclerView = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (this.cobros) {
            String[] strArr = {Constant.KEY_DEVICE, "cliente.nombreapellido"};
            Sort[] sortArr = {Sort.ASCENDING, Sort.ASCENDING};
            List<CobrosDTO> list = this.listaCobros;
            if (list == null || list.isEmpty()) {
                RealmResults<CobrosDTO> findAll = this.realm.where(CobrosDTO.class).sort(strArr, sortArr).findAll();
                this.listaRealmCobros = findAll;
                RecyclerCobrosDet recyclerCobrosDet = new RecyclerCobrosDet(this, this.realm.copyFromRealm(findAll));
                this.adapterCobros = recyclerCobrosDet;
                this.recyclerView.setAdapter(recyclerCobrosDet);
                return;
            }
            RecyclerCobrosDet recyclerCobrosDet2 = new RecyclerCobrosDet(this, this.listaCobros);
            this.adapterCobros = recyclerCobrosDet2;
            this.recyclerView.setAdapter(recyclerCobrosDet2);
            return;
        }
        String[] strArr2 = {Constant.KEY_DEVICE, "cliente.nombreapellido"};
        Sort[] sortArr2 = {Sort.ASCENDING, Sort.ASCENDING};
        List<CuotaAtrasadaDTO> list2 = this.lista;
        if (list2 == null || list2.isEmpty()) {
            RealmResults<CuotaAtrasadaDTO> findAll2 = this.realm.where(CuotaAtrasadaDTO.class).sort(strArr2, sortArr2).findAll();
            this.listaRealm = findAll2;
            RecyclerCuotasAtrasadasDet recyclerCuotasAtrasadasDet = new RecyclerCuotasAtrasadasDet(this, this.realm.copyFromRealm(findAll2));
            this.adapter = recyclerCuotasAtrasadasDet;
            this.recyclerView.setAdapter(recyclerCuotasAtrasadasDet);
            return;
        }
        RecyclerCuotasAtrasadasDet recyclerCuotasAtrasadasDet2 = new RecyclerCuotasAtrasadasDet(this, this.lista);
        this.adapter = recyclerCuotasAtrasadasDet2;
        this.recyclerView.setAdapter(recyclerCuotasAtrasadasDet2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchView searchView2 = (SearchView) menu.findItem(R.id.action_search).getActionView();
        this.searchView = searchView2;
        searchView2.setSearchableInfo( ((SearchManager) getSystemService(Context.SEARCH_SERVICE)).getSearchableInfo(getComponentName()));
        this.searchView.setMaxWidth(Integer.MAX_VALUE);
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                if (CuotasAtrasadasDetalleActivity.this.cobros) {
                    CuotasAtrasadasDetalleActivity.this.adapterCobros.getFilter().filter(str);
                    return false;
                }
                CuotasAtrasadasDetalleActivity.this.adapter.getFilter().filter(str);
                return false;
            }

            public boolean onQueryTextChange(String str) {
                if (CuotasAtrasadasDetalleActivity.this.cobros) {
                    CuotasAtrasadasDetalleActivity.this.adapterCobros.getFilter().filter(str);
                    return false;
                }
                CuotasAtrasadasDetalleActivity.this.adapter.getFilter().filter(str);
                return false;
            }
        });
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onBackPressed() {
        if (!this.searchView.isIconified()) {
            this.searchView.setIconified(true);
        } else {
            super.onBackPressed();
        }
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setSystemUiVisibility(view.getSystemUiVisibility() | 8192);
            getWindow().setStatusBarColor(-1);
        }
    }
}
