package py.hvillalba.microsol_app.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.RealmObjectProxy;
import java.io.Serializable;

public class TipocreditoDTO extends RealmObject implements Serializable {
    String descripcion;
    @PrimaryKey
    Integer idtipocredito;

    public String realmGet$descripcion() {
        return this.descripcion;
    }

    public Integer realmGet$idtipocredito() {
        return this.idtipocredito;
    }

    public void realmSet$descripcion(String str) {
        this.descripcion = str;
    }

    public void realmSet$idtipocredito(Integer num) {
        this.idtipocredito = num;
    }

    public TipocreditoDTO() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public Integer getIdtipocredito() {
        return realmGet$idtipocredito();
    }

    public void setIdtipocredito(Integer num) {
        realmSet$idtipocredito(num);
    }

    public String getDescripcion() {
        return realmGet$descripcion();
    }

    public void setDescripcion(String str) {
        realmSet$descripcion(str);
    }
}
