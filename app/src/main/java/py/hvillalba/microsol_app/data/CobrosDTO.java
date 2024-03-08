package py.hvillalba.microsol_app.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.RealmObjectProxy;
import java.io.Serializable;
import java.util.Date;

public class CobrosDTO extends RealmObject implements Serializable {
    Integer atraso;
    Integer cantcuotas;
    Integer cantidadCuotas;
    Double capital;
    ClienteDTO cliente;
    Double comision;
    Double cuotaCobro;
    String estado;
    Date fechacobro;
    Date fechaoperacion;
    Date fechavencimiento;
    FormacobrocreditoDTO formacobrocredito;
    @PrimaryKey
    Long id;
    Integer idcredito;
    Double interes;
    Double monto;
    Double mora;
    Integer nrocuota;
    Integer nrorecibo;
    Double otrosingresos;
    TipocreditoDTO tipocredito;

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

    public ClienteDTO realmGet$cliente() {
        return this.cliente;
    }

    public Double realmGet$comision() {
        return this.comision;
    }

    public Double realmGet$cuotaCobro() {
        return this.cuotaCobro;
    }

    public String realmGet$estado() {
        return this.estado;
    }

    public Date realmGet$fechacobro() {
        return this.fechacobro;
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

    public Double realmGet$interes() {
        return this.interes;
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

    public Integer realmGet$nrorecibo() {
        return this.nrorecibo;
    }

    public Double realmGet$otrosingresos() {
        return this.otrosingresos;
    }

    public TipocreditoDTO realmGet$tipocredito() {
        return this.tipocredito;
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

    public void realmSet$cliente(ClienteDTO clienteDTO) {
        this.cliente = clienteDTO;
    }

    public void realmSet$comision(Double d) {
        this.comision = d;
    }

    public void realmSet$cuotaCobro(Double d) {
        this.cuotaCobro = d;
    }

    public void realmSet$estado(String str) {
        this.estado = str;
    }

    public void realmSet$fechacobro(Date date) {
        this.fechacobro = date;
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

    public void realmSet$interes(Double d) {
        this.interes = d;
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

    public void realmSet$nrorecibo(Integer num) {
        this.nrorecibo = num;
    }

    public void realmSet$otrosingresos(Double d) {
        this.otrosingresos = d;
    }

    public void realmSet$tipocredito(TipocreditoDTO tipocreditoDTO) {
        this.tipocredito = tipocreditoDTO;
    }

    public CobrosDTO() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public Double getMonto() {
        return realmGet$monto();
    }

    public void setMonto(Double d) {
        realmSet$monto(d);
    }

    public Long getId() {
        return realmGet$id();
    }

    public void setId(Long l) {
        realmSet$id(l);
    }

    public Integer getIdcredito() {
        return realmGet$idcredito();
    }

    public void setIdcredito(Integer num) {
        realmSet$idcredito(num);
    }

    public Integer getCantcuotas() {
        return realmGet$cantcuotas();
    }

    public void setCantcuotas(Integer num) {
        realmSet$cantcuotas(num);
    }

    public Integer getNrocuota() {
        return realmGet$nrocuota();
    }

    public void setNrocuota(Integer num) {
        realmSet$nrocuota(num);
    }

    public ClienteDTO getCliente() {
        return realmGet$cliente();
    }

    public void setCliente(ClienteDTO clienteDTO) {
        realmSet$cliente(clienteDTO);
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

    public Double getMora() {
        return realmGet$mora();
    }

    public void setMora(Double d) {
        realmSet$mora(d);
    }

    public Double getOtrosingresos() {
        return realmGet$otrosingresos();
    }

    public void setOtrosingresos(Double d) {
        realmSet$otrosingresos(d);
    }

    public Double getComision() {
        return realmGet$comision();
    }

    public void setComision(Double d) {
        realmSet$comision(d);
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

    public Date getFechavencimiento() {
        return realmGet$fechavencimiento();
    }

    public void setFechavencimiento(Date date) {
        realmSet$fechavencimiento(date);
    }

    public Date getFechacobro() {
        return realmGet$fechacobro();
    }

    public void setFechacobro(Date date) {
        realmSet$fechacobro(date);
    }

    public Double getCuotaCobro() {
        return realmGet$cuotaCobro();
    }

    public void setCuotaCobro(Double d) {
        realmSet$cuotaCobro(d);
    }

    public Integer getNrorecibo() {
        return realmGet$nrorecibo();
    }

    public void setNrorecibo(Integer num) {
        realmSet$nrorecibo(num);
    }

    public String getEstado() {
        return realmGet$estado();
    }

    public void setEstado(String str) {
        realmSet$estado(str);
    }

    public Integer getAtraso() {
        return realmGet$atraso();
    }

    public void setAtraso(Integer num) {
        realmSet$atraso(num);
    }
}
