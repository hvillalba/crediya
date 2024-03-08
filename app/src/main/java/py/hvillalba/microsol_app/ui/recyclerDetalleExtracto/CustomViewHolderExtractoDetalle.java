package py.hvillalba.microsol_app.ui.recyclerDetalleExtracto;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import py.hvillalba.microsol_app.R;

public class CustomViewHolderExtractoDetalle extends RecyclerView.ViewHolder {
    Button btnDetalle;
    TextView tvCi;
    TextView tvCliente;
    TextView tvCuota;
    TextView tvDiasAtraso;
    TextView tvEstado;
    TextView tvFechaOperacion;
    TextView tvImporte;
    TextView tvPagado;
    TextView tvSaldoCuota;
    TextView tvSaldoInteres;

    public CustomViewHolderExtractoDetalle(View view) {
        super(view);
        this.tvImporte = (TextView) view.findViewById(R.id.tvImporte);
        this.tvCuota = (TextView) view.findViewById(R.id.tvCuota);
        this.tvFechaOperacion = (TextView) view.findViewById(R.id.tvFechaOperacion);
        this.tvEstado = (TextView) view.findViewById(R.id.tvEstado);
        this.btnDetalle = (Button) view.findViewById(R.id.btnDetalle);
        this.tvPagado = (TextView) view.findViewById(R.id.tvPagado);
        this.tvDiasAtraso = (TextView) view.findViewById(R.id.tvAtraso);
        this.tvCliente = (TextView) view.findViewById(R.id.tvCliente);
        this.tvCi = (TextView) view.findViewById(R.id.tvCi);
    }
}
