package py.hvillalba.microsol_app.ui.recyclerExtractoPorSocio;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import py.hvillalba.microsol_app.R;

public class CustomViewHolderExtractoPorSocio extends RecyclerView.ViewHolder {
    Button btnDetalle;
    TextView tvCedula;
    TextView tvSocio;
    TextView tvTelefono;

    public CustomViewHolderExtractoPorSocio(View view) {
        super(view);
        this.tvCedula = (TextView) view.findViewById(R.id.tvCedula);
        this.btnDetalle = (Button) view.findViewById(R.id.btnDetalle);
        this.tvTelefono = (TextView) view.findViewById(R.id.tvTelefono);
        this.tvSocio = (TextView) view.findViewById(R.id.tvSocio);
    }
}
