package py.hvillalba.microsol_app.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.RealmObjectProxy;
import java.io.Serializable;

public class Usuario extends RealmObject implements Serializable {
    @PrimaryKey
    private Integer idUsuario;
    private String password;
    private String user;

    public Integer realmGet$idUsuario() {
        return this.idUsuario;
    }

    public String realmGet$password() {
        return this.password;
    }

    public String realmGet$user() {
        return this.user;
    }

    public void realmSet$idUsuario(Integer num) {
        this.idUsuario = num;
    }

    public void realmSet$password(String str) {
        this.password = str;
    }

    public void realmSet$user(String str) {
        this.user = str;
    }

    public Usuario() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public Integer getIdUsuario() {
        return realmGet$idUsuario();
    }

    public void setIdUsuario(Integer num) {
        realmSet$idUsuario(num);
    }

    public String getUser() {
        return realmGet$user();
    }

    public void setUser(String str) {
        realmSet$user(str);
    }

    public String getPassword() {
        return realmGet$password();
    }

    public void setPassword(String str) {
        realmSet$password(str);
    }
}
