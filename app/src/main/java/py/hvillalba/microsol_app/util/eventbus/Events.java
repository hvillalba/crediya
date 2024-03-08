package py.hvillalba.microsol_app.util.eventbus;

public class Events {

    public static class FinalizarOrden {
        public String message;
        public boolean success;

        public FinalizarOrden(boolean z, String str) {
            this.success = z;
            this.message = str;
        }
    }

    public static class showAnimationVale {
        public int status;

        public showAnimationVale(int i) {
            this.status = i;
        }
    }

    public static class Login {
        public boolean habilitar;
        public String message;

        public Login(boolean z, String str) {
            this.habilitar = z;
            this.message = str;
        }
    }

    public static class Ciudad {
        public String ciudad;

        public Ciudad(String str) {
            this.ciudad = str;
        }
    }

    public static class Barrio {
        public String barrio;

        public Barrio(String str) {
            this.barrio = str;
        }
    }

    public static class Profesion {
        public String profesion;

        public Profesion(String str) {
            this.profesion = str;
        }
    }

    public static class Institucion {
        public String institucion;

        public Institucion(String str) {
            this.institucion = str;
        }
    }

    public static class Registro {
        public String registro;

        public Registro(String str) {
            this.registro = str;
        }
    }

    public static class Maps {
        public double lat;
        public double lon;

        public Maps(double d, double d2) {
            this.lat = d;
            this.lon = d2;
        }
    }

    public static class Parentesco {
        public String parentesco;

        public Parentesco(String str) {
            this.parentesco = str;
        }
    }

    public static class Cargo {
        public String cargo;

        public Cargo(String str) {
            this.cargo = str;
        }
    }

    public static class InformacionLegal {
        public boolean acepto;

        public InformacionLegal(boolean z) {
            this.acepto = z;
        }
    }

    public static class Solicitud {
        public boolean acepto;

        public Solicitud(boolean z) {
            this.acepto = z;
        }
    }

    public static class Error {
        public boolean acepto;

        public Error(boolean z) {
            this.acepto = z;
        }
    }
}
