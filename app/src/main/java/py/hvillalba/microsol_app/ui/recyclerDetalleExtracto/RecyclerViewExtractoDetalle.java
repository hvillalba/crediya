package py.hvillalba.microsol_app.ui.recyclerDetalleExtracto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CuotaDTO;

public class RecyclerViewExtractoDetalle extends RecyclerView.Adapter<CustomViewHolderExtractoDetalle> {
    Context context;
    private List<CuotaDTO> lista = new ArrayList();

    public RecyclerViewExtractoDetalle(Context context2, List<CuotaDTO> list) {
        this.context = context2;
        this.lista = list;
    }

    public CustomViewHolderExtractoDetalle onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CustomViewHolderExtractoDetalle(LayoutInflater.from(this.context).inflate(R.layout.detalle_extracto, viewGroup, false));
    }

    public void onBindViewHolder(CustomViewHolderExtractoDetalle customViewHolderExtractoDetalle, int i) {
        try {
            CuotaDTO cuotaDTO = this.lista.get(customViewHolderExtractoDetalle.getAdapterPosition());
            customViewHolderExtractoDetalle.tvCi.setText(cuotaDTO.getNrodoc());
            customViewHolderExtractoDetalle.tvCliente.setText(cuotaDTO.getNombreapellido());
            int numeroDiasEntreDosFechas = numeroDiasEntreDosFechas(cuotaDTO.getFecvencimiento(), new Date());
            int i2 = 0;
            if (numeroDiasEntreDosFechas >= 1) {
                cuotaDTO.setAtraso(Integer.valueOf(numeroDiasEntreDosFechas));
            } else if (numeroDiasEntreDosFechas <= 0) {
                numeroDiasEntreDosFechas = 0;
            }
            cuotaDTO.setAtraso(0);
            String format = new SimpleDateFormat("dd-MM-yyyy", Locale.US).format(cuotaDTO.getFecvencimiento());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            if (cuotaDTO.getImportepagado().doubleValue() >= cuotaDTO.getMonto().doubleValue()) {
                customViewHolderExtractoDetalle.tvEstado.setText("PAG");
                customViewHolderExtractoDetalle.tvEstado.setTextColor(this.context.getResources().getColor(R.color.verdeOscuro));
                customViewHolderExtractoDetalle.tvPagado.setTextColor(this.context.getResources().getColor(R.color.verdeOscuro));
            } else {
                customViewHolderExtractoDetalle.tvEstado.setText("PEN");
                customViewHolderExtractoDetalle.tvEstado.setTextColor(this.context.getResources().getColor(R.color.estadoRojo));
                customViewHolderExtractoDetalle.tvPagado.setTextColor(this.context.getResources().getColor(R.color.estadoRojo));
                i2 = numeroDiasEntreDosFechas;
            }
            customViewHolderExtractoDetalle.tvPagado.setText(decimalFormat.format(cuotaDTO.getImportepagado()));
            customViewHolderExtractoDetalle.tvCuota.setText(cuotaDTO.getNrocuota().toString());
            customViewHolderExtractoDetalle.tvImporte.setText(decimalFormat.format(cuotaDTO.getMonto()));
            customViewHolderExtractoDetalle.tvFechaOperacion.setText(format);
            customViewHolderExtractoDetalle.tvDiasAtraso.setText(String.valueOf(i2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int numeroDiasEntreDosFechas(Date date, Date date2) {
        return (int) ((date2.getTime() - date.getTime()) / 86400000);
    }

    public int getItemCount() {
        return this.lista.size();
    }
}
