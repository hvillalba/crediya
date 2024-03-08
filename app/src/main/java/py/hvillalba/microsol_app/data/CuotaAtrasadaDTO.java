package py.hvillalba.microsol_app.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.RealmObjectProxy;
import java.io.Serializable;
import java.util.Date;

public class CuotaAtrasadaDTO extends RealmObject implements Serializable{
    Integer atraso;
    Integer cantcuotas;
    Integer cantidadCuotas;
    Double capital;
    Double capitalCobro;
    ClienteDTO cliente;
    String comentarios;
    Double comision;
    Double cuotaCobro;
    Date fecDesembolso;
    Date fechaUltimoPago;
    Date fechaoperacion;
    Date fechavencimiento;
    FormacobrocreditoDTO formacobrocredito;
    @PrimaryKey
    Long id;
    Integer idcredito;
    Integer idcuota;
    Double interes;
    Double interesCobro;
    Integer item;
    Double monto;
    Double mora;
    Integer nrocuota;
    Double porcentaje;
    Double saldoCapital;
    Double saldoComision;
    Double saldoCuota;
    Double saldoInteres;
    TipocreditoDTO tipocredito;
    Double total;

    public Integer realmGet$atraso() {
        return this.atraso;
    }

    public Integer realmGet$cantcuotas() {
        return this.cantcuotas;
    }

    public Integer realmGet$cantidadCuotas() {
        return this.cantidadCuotas;
    }

    public Double realmGet$capital() {
        return this.capital;
    }

    public Double realmGet$capitalCobro() {
        return this.capitalCobro;
    }

    public ClienteDTO realmGet$cliente() {
        return this.cliente;
    }

    public String realmGet$comentarios() {
        return this.comentarios;
    }

    public Double realmGet$comision() {
        return this.comision;
    }

    public Double realmGet$cuotaCobro() {
        return this.cuotaCobro;
    }

    public Date realmGet$fecDesembolso() {
        return this.fecDesembolso;
    }

    public Date realmGet$fechaUltimoPago() {
        return this.fechaUltimoPago;
    }

    public Date realmGet$fechaoperacion() {
        return this.fechaoperacion;
    }

    public Date realmGet$fechavencimiento() {
        return this.fechavencimiento;
    }

    public FormacobrocreditoDTO realmGet$formacobrocredito() {
        return this.formacobrocredito;
    }

    public Long realmGet$id() {
        return this.id;
    }

    public Integer realmGet$idcredito() {
        return this.idcredito;
    }

    public Integer realmGet$idcuota() {
        return this.idcuota;
    }

    public Double realmGet$interes() {
        return this.interes;
    }

    public Double realmGet$interesCobro() {
        return this.interesCobro;
    }

    public Integer realmGet$item() {
        return this.item;
    }

    public Double realmGet$monto() {
        return this.monto;
    }

    public Double realmGet$mora() {
        return this.mora;
    }

    public Integer realmGet$nrocuota() {
        return this.nrocuota;
    }

    public Double realmGet$porcentaje() {
        return this.porcentaje;
    }

    public Double realmGet$saldoCapital() {
        return this.saldoCapital;
    }

    public Double realmGet$saldoComision() {
        return this.saldoComision;
    }

    public Double realmGet$saldoCuota() {
        return this.saldoCuota;
    }

    public Double realmGet$saldoInteres() {
        return this.saldoInteres;
    }

    public TipocreditoDTO realmGet$tipocredito() {
        return this.tipocredito;
    }

    public Double realmGet$total() {
        return this.total;
    }

    public void realmSet$atraso(Integer num) {
        this.atraso = num;
    }

    public void realmSet$cantcuotas(Integer num) {
        this.cantcuotas = num;
    }

    public void realmSet$cantidadCuotas(Integer num) {
        this.cantidadCuotas = num;
    }

    public void realmSet$capital(Double d) {
        this.capital = d;
    }

    public void realmSet$capitalCobro(Double d) {
        this.capitalCobro = d;
    }

    public void realmSet$cliente(ClienteDTO clienteDTO) {
        this.cliente = clienteDTO;
    }

    public void realmSet$comentarios(String str) {
        this.comentarios = str;
    }

    public void realmSet$comision(Double d) {
        this.comision = d;
    }

    public void realmSet$cuotaCobro(Double d) {
        this.cuotaCobro = d;
    }

    public void realmSet$fecDesembolso(Date date) {
        this.fecDesembolso = date;
    }

    public void realmSet$fechaUltimoPago(Date date) {
        this.fechaUltimoPago = date;
    }

    public void realmSet$fechaoperacion(Date date) {
        this.fechaoperacion = date;
    }

    public void realmSet$fechavencimiento(Date date) {
        this.fechavencimiento = date;
    }

    public void realmSet$formacobrocredito(FormacobrocreditoDTO formacobrocreditoDTO) {
        this.formacobrocredito = formacobrocreditoDTO;
    }

    public void realmSet$id(Long l) {
        this.id = l;
    }

    public void realmSet$idcredito(Integer num) {
        this.idcredito = num;
    }

    public void realmSet$idcuota(Integer num) {
        this.idcuota = num;
    }

    public void realmSet$interes(Double d) {
        this.interes = d;
    }

    public void realmSet$interesCobro(Double d) {
        this.interesCobro = d;
    }

    public void realmSet$item(Integer num) {
        this.item = num;
    }

    public void realmSet$monto(Double d) {
        this.monto = d;
    }

    public void realmSet$mora(Double d) {
        this.mora = d;
    }

    public void realmSet$nrocuota(Integer num) {
        this.nrocuota = num;
    }

    public void realmSet$porcentaje(Double d) {
        this.porcentaje = d;
    }

    public void realmSet$saldoCapital(Double d) {
        this.saldoCapital = d;
    }

    public void realmSet$saldoComision(Double d) {
        this.saldoComision = d;
    }

    public void realmSet$saldoCuota(Double d) {
        this.saldoCuota = d;
    }

    public void realmSet$saldoInteres(Double d) {
        this.saldoInteres = d;
    }

    public void realmSet$tipocredito(TipocreditoDTO tipocreditoDTO) {
        this.tipocredito = tipocreditoDTO;
    }

    public void realmSet$total(Double d) {
        this.total = d;
    }

    public CuotaAtrasadaDTO() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public Integer getAtraso() {
        return realmGet$atraso();
    }

    public void setAtraso(Integer num) {
        realmSet$atraso(num);
    }

    public Double getCapital() {
        return realmGet$capital();
    }

    public void setCapital(Double d) {
        realmSet$capital(d);
    }

    public Double getMonto() {
        return realmGet$monto();
    }

    public void setMonto(Double d) {
        realmSet$monto(d);
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

    public Integer getNrocuota() {
        return realmGet$nrocuota();
    }

    public void setNrocuota(Integer num) {
        realmSet$nrocuota(num);
    }

    public Double getComision() {
        return realmGet$comision();
    }

    public void setComision(Double d) {
        realmSet$comision(d);
    }

    public Double getSaldoCapital() {
        return realmGet$saldoCapital();
    }

    public void setSaldoCapital(Double d) {
        realmSet$saldoCapital(d);
    }

    public Double getSaldoInteres() {
        return realmGet$saldoInteres();
    }

    public void setSaldoInteres(Double d) {
        realmSet$saldoInteres(d);
    }

    public Double getSaldoComision() {
        return realmGet$saldoComision();
    }

    public void setSaldoComision(Double d) {
        realmSet$saldoComision(d);
    }

    public Double getSaldoCuota() {
        return realmGet$saldoCuota();
    }

    public void setSaldoCuota(Double d) {
        realmSet$saldoCuota(d);
    }

    public Date getFechavencimiento() {
        return realmGet$fechavencimiento();
    }

    public void setFechavencimiento(Date date) {
        realmSet$fechavencimiento(date);
    }

    public Double getMora() {
        return realmGet$mora();
    }

    public void setMora(Double d) {
        realmSet$mora(d);
    }

    public ClienteDTO getCliente() {
        return realmGet$cliente();
    }

    public void setCliente(ClienteDTO clienteDTO) {
        realmSet$cliente(clienteDTO);
    }

    public Date getFechaoperacion() {
        return realmGet$fechaoperacion();
    }

    public void setFechaoperacion(Date date) {
        realmSet$fechaoperacion(date);
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

    public Integer getCantidadCuotas() {
        return realmGet$cantidadCuotas();
    }

    public void setCantidadCuotas(Integer num) {
        realmSet$cantidadCuotas(num);
    }

    public Integer getItem() {
        return realmGet$item();
    }

    public void setItem(Integer num) {
        realmSet$item(num);
    }

    public String getComentarios() {
        return realmGet$comentarios();
    }

    public void setComentarios(String str) {
        realmSet$comentarios(str);
    }

    public Double getPorcentaje() {
        return realmGet$porcentaje();
    }

    public void setPorcentaje(Double d) {
        realmSet$porcentaje(d);
    }

    public Integer getCantcuotas() {
        return realmGet$cantcuotas();
    }

    public void setCantcuotas(Integer num) {
        realmSet$cantcuotas(num);
    }

    public Date getFechaUltimoPago() {
        return realmGet$fechaUltimoPago();
    }

    public void setFechaUltimoPago(Date date) {
        realmSet$fechaUltimoPago(date);
    }

    public Double getTotal() {
        return realmGet$total();
    }

    public void setTotal(Double d) {
        realmSet$total(d);
    }

    public Date getFecDesembolso() {
        return realmGet$fecDesembolso();
    }

    public void setFecDesembolso(Date date) {
        realmSet$fecDesembolso(date);
    }

    public Double getCapitalCobro() {
        return realmGet$capitalCobro();
    }

    public void setCapitalCobro(Double d) {
        realmSet$capitalCobro(d);
    }

    public Double getCuotaCobro() {
        return realmGet$cuotaCobro();
    }

    public void setCuotaCobro(Double d) {
        realmSet$cuotaCobro(d);
    }

    public Long getId() {
        return realmGet$id();
    }

    public void setId(Long l) {
        realmSet$id(l);
    }

    public Double getInteres() {
        return realmGet$interes();
    }

    public void setInteres(Double d) {
        realmSet$interes(d);
    }

    public Double getInteresCobro() {
        return realmGet$interesCobro();
    }

    public void setInteresCobro(Double d) {
        realmSet$interesCobro(d);
    }
}
