package py.hvillalba.microsol_app.data;

public class Request<T> {
    private T data;
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }
}
