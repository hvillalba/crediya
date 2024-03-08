package py.hvillalba.microsol_app.ui.recyclerCuotasAtrasadasDetalle;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import py.hvillalba.microsol_app.R;

public class CustomViewHolderCuotasDetalle extends RecyclerView.ViewHolder {
    TextView tvCapital;
    TextView tvCliente;
    TextView tvCreditoNro;
    TextView tvCuota;
    TextView tvDesembolso;
    TextView tvDiasAtraso;
    TextView tvFCobro;
    TextView tvFechaUltPago;
    TextView tvFrecuencia;
    TextView tvInteres;
    TextView tvMora;
    TextView tvNroCi;
    TextView tvTotal;
    TextView tvVencimiento;

    public CustomViewHolderCuotasDetalle(View view) {
        super(view);
        this.tvCliente = (TextView) view.findViewById(R.id.tvCliente);
        this.tvNroCi = (TextView) view.findViewById(R.id.tvCi);
        this.tvCreditoNro = (TextView) view.findViewById(R.id.tvIdCredito);
        this.tvCuota = (TextView) view.findViewById(R.id.tvCuota);
        this.tvFrecuencia = (TextView) view.findViewById(R.id.tvFrequencia);
        this.tvFCobro = (TextView) view.findViewById(R.id.tvFCobro);
        this.tvDesembolso = (TextView) view.findViewById(R.id.tvDesembolso);
        this.tvVencimiento = (TextView) view.findViewById(R.id.tvVencimiento);
        this.tvFechaUltPago = (TextView) view.findViewById(R.id.tvFecUltPago);
        this.tvMora = (TextView) view.findViewById(R.id.tvMora);
        this.tvCapital = (TextView) view.findViewById(R.id.tvCapital);
        this.tvInteres = (TextView) view.findViewById(R.id.tvInteres);
        this.tvTotal = (TextView) view.findViewById(R.id.tvTotal);
        this.tvDiasAtraso = (TextView) view.findViewById(R.id.tvDiasAtraso);
    }
}
