package py.hvillalba.microsol_app.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.internal.RealmObjectProxy;
import java.io.Serializable;
import java.util.Date;

public class ClienteDTO extends RealmObject implements Serializable {
    private String correo;
    private String direccion;
    private String estado;
    private String estadocivil;
    private Date fechaalta;
    private Date fecnacimiento;
    @PrimaryKey
    private Long idcliente;
    private double lineacredito;
    private String lugarnacimiento;
    private String nacionalidad;
    private String nombreapellido;
    private String nrodoc;
    private String sexo;
    private String telefono;
    private String telefono1;
    private String telefono2;
    private String web;

    public String realmGet$correo() {
        return this.correo;
    }

    public String realmGet$direccion() {
        return this.direccion;
    }

    public String realmGet$estado() {
        return this.estado;
    }

    public String realmGet$estadocivil() {
        return this.estadocivil;
    }

    public Date realmGet$fechaalta() {
        return this.fechaalta;
    }

    public Date realmGet$fecnacimiento() {
        return this.fecnacimiento;
    }

    public Long realmGet$idcliente() {
        return this.idcliente;
    }

    public double realmGet$lineacredito() {
        return this.lineacredito;
    }

    public String realmGet$lugarnacimiento() {
        return this.lugarnacimiento;
    }

    public String realmGet$nacionalidad() {
        return this.nacionalidad;
    }

    public String realmGet$nombreapellido() {
        return this.nombreapellido;
    }

    public String realmGet$nrodoc() {
        return this.nrodoc;
    }

    public String realmGet$sexo() {
        return this.sexo;
    }

    public String realmGet$telefono() {
        return this.telefono;
    }

    public String realmGet$telefono1() {
        return this.telefono1;
    }

    public String realmGet$telefono2() {
        return this.telefono2;
    }

    public String realmGet$web() {
        return this.web;
    }

    public void realmSet$correo(String str) {
        this.correo = str;
    }

    public void realmSet$direccion(String str) {
        this.direccion = str;
    }

    public void realmSet$estado(String str) {
        this.estado = str;
    }

    public void realmSet$estadocivil(String str) {
        this.estadocivil = str;
    }

    public void realmSet$fechaalta(Date date) {
        this.fechaalta = date;
    }

    public void realmSet$fecnacimiento(Date date) {
        this.fecnacimiento = date;
    }

    public void realmSet$idcliente(Long l) {
        this.idcliente = l;
    }

    public void realmSet$lineacredito(double d) {
        this.lineacredito = d;
    }

    public void realmSet$lugarnacimiento(String str) {
        this.lugarnacimiento = str;
    }

    public void realmSet$nacionalidad(String str) {
        this.nacionalidad = str;
    }

    public void realmSet$nombreapellido(String str) {
        this.nombreapellido = str;
    }

    public void realmSet$nrodoc(String str) {
        this.nrodoc = str;
    }

    public void realmSet$sexo(String str) {
        this.sexo = str;
    }

    public void realmSet$telefono(String str) {
        this.telefono = str;
    }

    public void realmSet$telefono1(String str) {
        this.telefono1 = str;
    }

    public void realmSet$telefono2(String str) {
        this.telefono2 = str;
    }

    public void realmSet$web(String str) {
        this.web = str;
    }

    public ClienteDTO() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy) this).realm$injectObjectContext();
        }
    }

    public Long getIdcliente() {
        return realmGet$idcliente();
    }

    public void setIdcliente(Long l) {
        realmSet$idcliente(l);
    }

    public String getNombreapellido() {
        return realmGet$nombreapellido();
    }

    public void setNombreapellido(String str) {
        realmSet$nombreapellido(str);
    }

    public String getNrodoc() {
        return realmGet$nrodoc();
    }

    public void setNrodoc(String str) {
        realmSet$nrodoc(str);
    }

    public String getSexo() {
        return realmGet$sexo();
    }

    public void setSexo(String str) {
        realmSet$sexo(str);
    }

    public Date getFecnacimiento() {
        return realmGet$fecnacimiento();
    }

    public void setFecnacimiento(Date date) {
        realmSet$fecnacimiento(date);
    }

    public String getLugarnacimiento() {
        return realmGet$lugarnacimiento();
    }

    public void setLugarnacimiento(String str) {
        realmSet$lugarnacimiento(str);
    }

    public String getNacionalidad() {
        return realmGet$nacionalidad();
    }

    public void setNacionalidad(String str) {
        realmSet$nacionalidad(str);
    }

    public String getDireccion() {
        return realmGet$direccion();
    }

    public void setDireccion(String str) {
        realmSet$direccion(str);
    }

    public String getTelefono() {
        return realmGet$telefono();
    }

    public void setTelefono(String str) {
        realmSet$telefono(str);
    }

    public String getTelefono1() {
        return realmGet$telefono1();
    }

    public void setTelefono1(String str) {
        realmSet$telefono1(str);
    }

    public String getTelefono2() {
        return realmGet$telefono2();
    }

    public void setTelefono2(String str) {
        realmSet$telefono2(str);
    }

    public double getLineacredito() {
        return realmGet$lineacredito();
    }

    public void setLineacredito(double d) {
        realmSet$lineacredito(d);
    }

    public String getEstado() {
        return realmGet$estado();
    }

    public void setEstado(String str) {
        realmSet$estado(str);
    }

    public String getEstadocivil() {
        return realmGet$estadocivil();
    }

    public void setEstadocivil(String str) {
        realmSet$estadocivil(str);
    }

    public Date getFechaalta() {
        return realmGet$fechaalta();
    }

    public void setFechaalta(Date date) {
        realmSet$fechaalta(date);
    }

    public String getCorreo() {
        return realmGet$correo();
    }

    public void setCorreo(String str) {
        realmSet$correo(str);
    }

    public String getWeb() {
        return realmGet$web();
    }

    public void setWeb(String str) {
        realmSet$web(str);
    }
}
