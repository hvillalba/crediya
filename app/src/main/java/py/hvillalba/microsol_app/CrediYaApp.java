package py.hvillalba.microsol_app;

import android.util.Log;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class CrediYaApp extends MultiDexApplication {
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        Realm.init(getApplicationContext());
        RealmConfiguration build = new RealmConfiguration.Builder().name("crediya.realm").schemaVersion(1).build();
        Realm.setDefaultConfiguration(build);
        Realm.compactRealm(build);
        Log.e("CrediyaApp", "Seteando configuration Realm");
    }
}
