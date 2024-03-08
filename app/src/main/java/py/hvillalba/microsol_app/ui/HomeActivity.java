package py.hvillalba.microsol_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import io.realm.Realm;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.util.Constant;
import py.hvillalba.microsol_app.util.CustomPreferenceManager;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button btnAlertas;
    private Button btnCobros;
    private Button btnConsultarCartera;
    private Button btnConsultarCuotasAtrasadas;
    private Button btnConsultarExtracto;
    private CustomPreferenceManager customPreferenceManager;
    private Realm realm;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home);
        setTitle("Credi Ya");
        this.realm = Realm.getDefaultInstance();
        this.customPreferenceManager = new CustomPreferenceManager(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.btnConsultarCartera = (Button) findViewById(R.id.btnConsultarCartera);
        this.btnConsultarCuotasAtrasadas = (Button) findViewById(R.id.btnCuotasAtrasadas);
        this.btnAlertas = (Button) findViewById(R.id.btnAlertas);
        Button button = (Button) findViewById(R.id.btnCuotasDelDia);
        this.btnCobros = button;
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeActivity.this.lambda$onCreate$0$HomeActivity(view);
            }
        });
        this.btnAlertas.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeActivity.this.lambda$onCreate$1$HomeActivity(view);
            }
        });
        this.btnConsultarCartera.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeActivity.this.lambda$onCreate$2$HomeActivity(view);
            }
        });
        this.btnConsultarCuotasAtrasadas.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeActivity.this.lambda$onCreate$3$HomeActivity(view);
            }
        });
        this.btnConsultarExtracto  = findViewById(R.id.btnConsultarExtracto);
        btnConsultarExtracto.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeActivity.this.lambda$onCreate$4$HomeActivity(view);
            }
        });
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
    }

    public /* synthetic */ void lambda$onCreate$0$HomeActivity(View view) {
        startActivity(new Intent(this, CobrosDelDiaActivity.class));
    }

    public /* synthetic */ void lambda$onCreate$1$HomeActivity(View view) {
        startActivity(new Intent(this, NotificacionActivity.class));
    }

    public /* synthetic */ void lambda$onCreate$2$HomeActivity(View view) {
        startActivity(new Intent(this, EstadoCarteraActivity.class));
    }

    public /* synthetic */ void lambda$onCreate$3$HomeActivity(View view) {
        startActivity(new Intent(this, CuotasAtrasadasActivity.class));
    }

    public /* synthetic */ void lambda$onCreate$4$HomeActivity(View view) {
        startActivity(new Intent(this, ConsultarExtractoActivity.class));
    }

    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            drawerLayout.closeDrawer((int) GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home_drawer, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.cerrarSesion) {
            return super.onOptionsItemSelected(menuItem);
        }
        cerrarSesion();
        return true;
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.extractoCuenta) {
            startActivity(new Intent(this, ConsultarExtractoActivity.class));
        } else if (itemId == R.id.extractoCartera) {
            startActivity(new Intent(this, EstadoCarteraActivity.class));
        } else if (itemId == R.id.sincro) {
            startActivity(new Intent(this, SincronizacionActivity.class));
        } else if (itemId == R.id.cerrarSesion) {
            cerrarSesion();
        }
        ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawer((int) GravityCompat.START);
        return true;
    }

    private void cerrarSesion() {
        this.customPreferenceManager.setValue(Constant.LOGUEADO, false);
        this.realm.executeTransaction(new Realm.Transaction() {
            public void execute(Realm realm) {
            }
        });
        finish();
        startActivity(new Intent(this, LoginActivity.class));
    }
}
