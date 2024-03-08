package py.hvillalba.microsol_app.ui.recyclerExtracto;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import py.hvillalba.microsol_app.R;

public class CustomViewHolderExtracto extends RecyclerView.ViewHolder {
    Button btnDetalle;
    TextView tvCapital;
    TextView tvCuota;
    TextView tvCuotasPagadas;
    TextView tvEstado;
    TextView tvFechaOperacion;
    TextView tvFechaVenc;
    TextView tvImporte;
    TextView tvMontoCuota;
    TextView tvMontoInteres;
    TextView tvMontoPagado;
    TextView tvNroCredito;
    TextView tvSaldo;
    TextView tvSocio;
    TextView tvTasa;
    TextView tvTelefono;
    TextView tvTipoCobro;

    public CustomViewHolderExtracto(View view) {
        super(view);
        this.tvImporte = (TextView) view.findViewById(R.id.tvImporte);
        this.tvCuota = (TextView) view.findViewById(R.id.tvCuota);
        this.tvFechaOperacion = (TextView) view.findViewById(R.id.tvFechaOperacion);
        this.tvEstado = (TextView) view.findViewById(R.id.tvEstado);
        this.btnDetalle = (Button) view.findViewById(R.id.btnDetalle);
        this.tvTipoCobro = (TextView) view.findViewById(R.id.tvTipoCobro);
        this.tvCuotasPagadas = (TextView) view.findViewById(R.id.tvCuotasPagadas);
        this.tvFechaVenc = (TextView) view.findViewById(R.id.tvFechaVenc);
        this.tvTasa = (TextView) view.findViewById(R.id.tvTasa);
        this.tvMontoInteres = (TextView) view.findViewById(R.id.tvInteres);
        this.tvSaldo = (TextView) view.findViewById(R.id.tvSaldo);
        this.tvSocio = (TextView) view.findViewById(R.id.tvSocio);
        this.tvTelefono = (TextView) view.findViewById(R.id.tvTelefono);
        this.tvMontoCuota = (TextView) view.findViewById(R.id.tvMontoCuota);
        this.tvMontoPagado = (TextView) view.findViewById(R.id.tvMontoPagado);
        this.tvNroCredito = (TextView) view.findViewById(R.id.tvNroCredito);
        this.tvCapital = (TextView) view.findViewById(R.id.tvCapital);
    }
}
