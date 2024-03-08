package py.hvillalba.microsol_app.http;

import java.io.IOException;

public class TimeoutError extends IOException {
    private static final long serialVersionUID = -6469766654369165864L;

    public TimeoutError() {
    }

    public TimeoutError(Throwable th) {
        super(th);
    }
}
