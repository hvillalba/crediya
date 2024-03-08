package py.hvillalba.microsol_app.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.RealmObjectProxy;
import java.io.Serializable;

public class MetodoCobroDTO extends RealmObject implements Serializable {
    String descripcion;
    @PrimaryKey
    Long idmetodocobro;

    public String realmGet$descripcion() {
        return this.descripcion;
    }

    public Long realmGet$idmetodocobro() {
        return this.idmetodocobro;
    }

    public void realmSet$descripcion(String str) {
        this.descripcion = str;
    }

    public void realmSet$idmetodocobro(Long l) {
        this.idmetodocobro = l;
    }

    public MetodoCobroDTO() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public Long getIdmetodocobro() {
        return realmGet$idmetodocobro();
    }

    public void setIdmetodocobro(Long l) {
        realmSet$idmetodocobro(l);
    }

    public String getDescripcion() {
        return realmGet$descripcion();
    }

    public void setDescripcion(String str) {
        realmSet$descripcion(str);
    }
}
