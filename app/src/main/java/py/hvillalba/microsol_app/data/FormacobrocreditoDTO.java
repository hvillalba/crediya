package py.hvillalba.microsol_app.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.RealmObjectProxy;

import java.io.Serializable;

public class FormacobrocreditoDTO extends RealmObject implements Serializable{
    String descripcion;
    @PrimaryKey
    Integer idformacobrocredito;

    public String realmGet$descripcion() {
        return this.descripcion;
    }

    public Integer realmGet$idformacobrocredito() {
        return this.idformacobrocredito;
    }

    public void realmSet$descripcion(String str) {
        this.descripcion = str;
    }

    public void realmSet$idformacobrocredito(Integer num) {
        this.idformacobrocredito = num;
    }

    public FormacobrocreditoDTO() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public Integer getIdformacobrocredito() {
        return realmGet$idformacobrocredito();
    }

    public void setIdformacobrocredito(Integer num) {
        realmSet$idformacobrocredito(num);
    }

    public String getDescripcion() {
        return realmGet$descripcion();
    }

    public void setDescripcion(String str) {
        realmSet$descripcion(str);
    }
}
