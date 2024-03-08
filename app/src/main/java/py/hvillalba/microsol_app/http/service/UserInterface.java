package py.hvillalba.microsol_app.http.service;

import java.util.List;
import py.hvillalba.microsol_app.data.CobrosDTO;
import py.hvillalba.microsol_app.data.CuotaAtrasadaDTO;
import py.hvillalba.microsol_app.data.CuotaDTO;
import py.hvillalba.microsol_app.data.NotificacionDto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserInterface {
    @GET("cuotas/cobros-del-dia")
    Call<List<CobrosDTO>> getCobros();

    @GET("cuotas")
    Call<List<CuotaDTO>> getCuota();

    @GET("cuotas/cuotas-atrasadas")
    Call<List<CuotaAtrasadaDTO>> getCuotaAtrasadas();

    @GET("cuotas/notificacion")
    Call<NotificacionDto> getNotificacion();
}
