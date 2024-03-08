package py.hvillalba.microsol_app.util;

import android.content.Context;
import android.content.SharedPreferences;

public class CustomPreferenceManager {
    Context context;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    public CustomPreferenceManager(Context context2) {
        SharedPreferences sharedPreferences2 = context2.getSharedPreferences(context2.getPackageName(), 0);
        this.sharedPreferences = sharedPreferences2;
        this.editor = sharedPreferences2.edit();
        this.context = context2;
    }

    public void setValue(String str, String str2) {
        this.editor.putString(str, str2);
        this.editor.apply();
    }

    public void setValue(String str, int i) {
        this.editor.putInt(str, i);
        this.editor.apply();
    }

    public void setValue(String str, boolean z) {
        this.editor.putBoolean(str, z);
        this.editor.apply();
    }

    public String getString(String str) {
        return this.sharedPreferences.getString(str, "");
    }

    public int getInt(String str) {
        return this.sharedPreferences.getInt(str, 0);
    }

    public Boolean getBoolean(String str) {
        return Boolean.valueOf(this.sharedPreferences.getBoolean(str, false));
    }

    public Boolean getBooleanTrue(String str) {
        return Boolean.valueOf(this.sharedPreferences.getBoolean(str, true));
    }
}
