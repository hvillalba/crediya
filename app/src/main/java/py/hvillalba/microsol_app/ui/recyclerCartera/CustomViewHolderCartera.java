package py.hvillalba.microsol_app.ui.recyclerCartera;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import py.hvillalba.microsol_app.R;

public class CustomViewHolderCartera extends RecyclerView.ViewHolder {
    Button btnDetalle;
    TextView tvAtraso;
    TextView tvCapital;
    TextView tvCi;
    TextView tvCliente;
    TextView tvCredito;
    TextView tvEstado;
    TextView tvSaldoCapital;
    TextView tvTelefono;

    public CustomViewHolderCartera(View view) {
        super(view);
        this.tvCliente = (TextView) view.findViewById(R.id.tvCliente);
        this.tvTelefono = (TextView) view.findViewById(R.id.tvTelefono);
        this.tvAtraso = (TextView) view.findViewById(R.id.tvAtraso);
        this.tvCi = (TextView) view.findViewById(R.id.tvCi);
        this.tvCapital = (TextView) view.findViewById(R.id.tvCapital);
        this.tvEstado = (TextView) view.findViewById(R.id.tvEstado);
        this.btnDetalle = (Button) view.findViewById(R.id.btnDetalle);
        this.tvCredito = (TextView) view.findViewById(R.id.tvCredito);
        this.tvSaldoCapital = (TextView) view.findViewById(R.id.tvSaldoCapital);
    }
}
