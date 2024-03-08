package py.hvillalba.microsol_app.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.RealmObjectProxy;
import java.io.Serializable;
import java.util.Date;

public class NotificacionDto extends RealmObject implements Serializable {
    private Double capital;
    private Date fecvencimiento;
    private Double interes;
    @PrimaryKey
    private Integer nrocuota;

    public Double realmGet$capital() {
        return this.capital;
    }

    public Date realmGet$fecvencimiento() {
        return this.fecvencimiento;
    }

    public Double realmGet$interes() {
        return this.interes;
    }

    public Integer realmGet$nrocuota() {
        return this.nrocuota;
    }

    public void realmSet$capital(Double d) {
        this.capital = d;
    }

    public void realmSet$fecvencimiento(Date date) {
        this.fecvencimiento = date;
    }

    public void realmSet$interes(Double d) {
        this.interes = d;
    }

    public void realmSet$nrocuota(Integer num) {
        this.nrocuota = num;
    }

    public NotificacionDto() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public Integer getNrocuota() {
        return realmGet$nrocuota();
    }

    public void setNrocuota(Integer num) {
        realmSet$nrocuota(num);
    }

    public Double getCapital() {
        return realmGet$capital();
    }

    public void setCapital(Double d) {
        realmSet$capital(d);
    }

    public Double getInteres() {
        return realmGet$interes();
    }

    public void setInteres(Double d) {
        realmSet$interes(d);
    }

    public Date getFecvencimiento() {
        return realmGet$fecvencimiento();
    }

    public void setFecvencimiento(Date date) {
        realmSet$fecvencimiento(date);
    }
}
