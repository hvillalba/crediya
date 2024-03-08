package py.hvillalba.microsol_app.data;

public class Response<T> {
    private Integer codigo;
    private T data;
    private String mensaje;

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer num) {
        this.codigo = num;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String str) {
        this.mensaje = str;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }
}
