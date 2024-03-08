package py.hvillalba.microsol_app.data;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.RealmObjectProxy;
import java.io.Serializable;
import java.util.Date;

public class CuotaDTO extends RealmObject implements Serializable {
    Integer atraso;
    Integer cantidadcuota;
    Double capital;
    Double capitalriesgo;
    @Ignore
    Integer cuotasPagadas;
    String estadocredito;
    Date fechadesembolso;
    Date fecvencimiento;
    FormacobrocreditoDTO formacobrocredito;
    @PrimaryKey
    Long id;
    Integer idcliente;
    Integer idcredito;
    Integer idcuota;
    Double importepagado;
    Double interes;
    Double monto;
    String nombreapellido;
    Integer nrocuota;
    String nrodoc;
    Boolean pagado;
    Double saldocapital;
    Double saldocuota;
    Double saldointeres;
    @Ignore
    Double salo;
    Double tasamora;
    String telefono;
    TipocreditoDTO tipocredito;
    @Ignore
    Double total;

    public Integer realmGet$atraso() {
        return this.atraso;
    }

    public Integer realmGet$cantidadcuota() {
        return this.cantidadcuota;
    }

    public Double realmGet$capital() {
        return this.capital;
    }

    public Double realmGet$capitalriesgo() {
        return this.capitalriesgo;
    }

    public String realmGet$estadocredito() {
        return this.estadocredito;
    }

    public Date realmGet$fechadesembolso() {
        return this.fechadesembolso;
    }

    public Date realmGet$fecvencimiento() {
        return this.fecvencimiento;
    }

    public FormacobrocreditoDTO realmGet$formacobrocredito() {
        return this.formacobrocredito;
    }

    public Long realmGet$id() {
        return this.id;
    }

    public Integer realmGet$idcliente() {
        return this.idcliente;
    }

    public Integer realmGet$idcredito() {
        return this.idcredito;
    }

    public Integer realmGet$idcuota() {
        return this.idcuota;
    }

    public Double realmGet$importepagado() {
        return this.importepagado;
    }

    public Double realmGet$interes() {
        return this.interes;
    }

    public Double realmGet$monto() {
        return this.monto;
    }

    public String realmGet$nombreapellido() {
        return this.nombreapellido;
    }

    public Integer realmGet$nrocuota() {
        return this.nrocuota;
    }

    public String realmGet$nrodoc() {
        return this.nrodoc;
    }

    public Boolean realmGet$pagado() {
        return this.pagado;
    }

    public Double realmGet$saldocapital() {
        return this.saldocapital;
    }

    public Double realmGet$saldocuota() {
        return this.saldocuota;
    }

    public Double realmGet$saldointeres() {
        return this.saldointeres;
    }

    public Double realmGet$tasamora() {
        return this.tasamora;
    }

    public String realmGet$telefono() {
        return this.telefono;
    }

    public TipocreditoDTO realmGet$tipocredito() {
        return this.tipocredito;
    }

    public void realmSet$atraso(Integer num) {
        this.atraso = num;
    }

    public void realmSet$cantidadcuota(Integer num) {
        this.cantidadcuota = num;
    }

    public void realmSet$capital(Double d) {
        this.capital = d;
    }

    public void realmSet$capitalriesgo(Double d) {
        this.capitalriesgo = d;
    }

    public void realmSet$estadocredito(String str) {
        this.estadocredito = str;
    }

    public void realmSet$fechadesembolso(Date date) {
        this.fechadesembolso = date;
    }

    public void realmSet$fecvencimiento(Date date) {
        this.fecvencimiento = date;
    }

    public void realmSet$formacobrocredito(FormacobrocreditoDTO formacobrocreditoDTO) {
        this.formacobrocredito = formacobrocreditoDTO;
    }

    public void realmSet$id(Long l) {
        this.id = l;
    }

    public void realmSet$idcliente(Integer num) {
        this.idcliente = num;
    }

    public void realmSet$idcredito(Integer num) {
        this.idcredito = num;
    }

    public void realmSet$idcuota(Integer num) {
        this.idcuota = num;
    }

    public void realmSet$importepagado(Double d) {
        this.importepagado = d;
    }

    public void realmSet$interes(Double d) {
        this.interes = d;
    }

    public void realmSet$monto(Double d) {
        this.monto = d;
    }

    public void realmSet$nombreapellido(String str) {
        this.nombreapellido = str;
    }

    public void realmSet$nrocuota(Integer num) {
        this.nrocuota = num;
    }

    public void realmSet$nrodoc(String str) {
        this.nrodoc = str;
    }

    public void realmSet$pagado(Boolean bool) {
        this.pagado = bool;
    }

    public void realmSet$saldocapital(Double d) {
        this.saldocapital = d;
    }

    public void realmSet$saldocuota(Double d) {
        this.saldocuota = d;
    }

    public void realmSet$saldointeres(Double d) {
        this.saldointeres = d;
    }

    public void realmSet$tasamora(Double d) {
        this.tasamora = d;
    }

    public void realmSet$telefono(String str) {
        this.telefono = str;
    }

    public void realmSet$tipocredito(TipocreditoDTO tipocreditoDTO) {
        this.tipocredito = tipocreditoDTO;
    }

    public CuotaDTO() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public Double getSaldocapital() {
        return realmGet$saldocapital();
    }

    public void setSaldocapital(Double d) {
        realmSet$saldocapital(d);
    }

    public Double getSaldointeres() {
        return realmGet$saldointeres();
    }

    public void setSaldointeres(Double d) {
        realmSet$saldointeres(d);
    }

    public Double getSaldocuota() {
        return realmGet$saldocuota();
    }

    public void setSaldocuota(Double d) {
        realmSet$saldocuota(d);
    }

    public Long getId() {
        return realmGet$id();
    }

    public void setId(Long l) {
        realmSet$id(l);
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double d) {
        this.total = d;
    }

    public Double getImportepagado() {
        return realmGet$importepagado();
    }

    public void setImportepagado(Double d) {
        realmSet$importepagado(d);
    }

    public Double getSalo() {
        return this.salo;
    }

    public void setSalo(Double d) {
        this.salo = d;
    }

    public Integer getCuotasPagadas() {
        return this.cuotasPagadas;
    }

    public void setCuotasPagadas(Integer num) {
        this.cuotasPagadas = num;
    }

    public Integer getAtraso() {
        return realmGet$atraso();
    }

    public void setAtraso(Integer num) {
        realmSet$atraso(num);
    }

    public Integer getNrocuota() {
        return realmGet$nrocuota();
    }

    public void setNrocuota(Integer num) {
        realmSet$nrocuota(num);
    }

    public Integer getIdcredito() {
        return realmGet$idcredito();
    }

    public void setIdcredito(Integer num) {
        realmSet$idcredito(num);
    }

    public Integer getIdcuota() {
        return realmGet$idcuota();
    }

    public void setIdcuota(Integer num) {
        realmSet$idcuota(num);
    }

    public Date getFecvencimiento() {
        return realmGet$fecvencimiento();
    }

    public void setFecvencimiento(Date date) {
        realmSet$fecvencimiento(date);
    }

    public Integer getIdcliente() {
        return realmGet$idcliente();
    }

    public void setIdcliente(Integer num) {
        realmSet$idcliente(num);
    }

    public String getNrodoc() {
        return realmGet$nrodoc();
    }

    public void setNrodoc(String str) {
        realmSet$nrodoc(str);
    }

    public String getNombreapellido() {
        return realmGet$nombreapellido();
    }

    public void setNombreapellido(String str) {
        realmSet$nombreapellido(str);
    }

    public String getTelefono() {
        return realmGet$telefono();
    }

    public void setTelefono(String str) {
        realmSet$telefono(str);
    }

    public Integer getCantidadcuota() {
        return realmGet$cantidadcuota();
    }

    public void setCantidadcuota(Integer num) {
        realmSet$cantidadcuota(num);
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

    public Double getMonto() {
        return realmGet$monto();
    }

    public void setMonto(Double d) {
        realmSet$monto(d);
    }

    public TipocreditoDTO getTipocredito() {
        return realmGet$tipocredito();
    }

    public void setTipocredito(TipocreditoDTO tipocreditoDTO) {
        realmSet$tipocredito(tipocreditoDTO);
    }

    public FormacobrocreditoDTO getFormacobrocredito() {
        return realmGet$formacobrocredito();
    }

    public void setFormacobrocredito(FormacobrocreditoDTO formacobrocreditoDTO) {
        realmSet$formacobrocredito(formacobrocreditoDTO);
    }

    public Double getTasamora() {
        return realmGet$tasamora();
    }

    public void setTasamora(Double d) {
        realmSet$tasamora(d);
    }

    public Double getCapitalriesgo() {
        return realmGet$capitalriesgo();
    }

    public void setCapitalriesgo(Double d) {
        realmSet$capitalriesgo(d);
    }

    public Date getFechadesembolso() {
        return realmGet$fechadesembolso();
    }

    public void setFechadesembolso(Date date) {
        realmSet$fechadesembolso(date);
    }

    public Boolean getPagado() {
        return realmGet$pagado();
    }

    public void setPagado(Boolean bool) {
        realmSet$pagado(bool);
    }

    public String getEstadocredito() {
        return realmGet$estadocredito();
    }

    public void setEstadocredito(String str) {
        realmSet$estadocredito(str);
    }
}
