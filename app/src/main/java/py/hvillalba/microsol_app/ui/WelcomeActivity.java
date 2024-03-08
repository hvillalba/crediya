package py.hvillalba.microsol_app.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.util.Constant;
import py.hvillalba.microsol_app.util.CustomPreferenceManager;

public class WelcomeActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public CustomPreferenceManager customPreferenceManager;
    private Realm realm;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_welcome);
        this.customPreferenceManager = new CustomPreferenceManager(this);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                    if (WelcomeActivity.this.customPreferenceManager.getBoolean(Constant.LOGUEADO).booleanValue()) {
                        WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
                    } else {
                        WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                    }
                    WelcomeActivity.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
