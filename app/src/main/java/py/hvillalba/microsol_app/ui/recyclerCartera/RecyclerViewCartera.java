package py.hvillalba.microsol_app.ui.recyclerCartera;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CuotaDTO;
import py.hvillalba.microsol_app.ui.ExtractoDetalleActivity;

public class RecyclerViewCartera extends RecyclerView.Adapter<CustomViewHolderCartera> {
    Context context;
    private List<CuotaDTO> lista = new ArrayList();

    public RecyclerViewCartera(Context context2, List<CuotaDTO> list) {
        this.context = context2;
        this.lista = list;
    }

    public CustomViewHolderCartera onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CustomViewHolderCartera(LayoutInflater.from(this.context).inflate(R.layout.cartera_item, viewGroup, false));
    }

    public void onBindViewHolder(CustomViewHolderCartera customViewHolderCartera, int i) {
        try {
            CuotaDTO cuotaDTO = this.lista.get(customViewHolderCartera.getAdapterPosition());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            TextView textView = customViewHolderCartera.tvCapital;
            textView.setText(decimalFormat.format(cuotaDTO.getCapitalriesgo()) + " Gs.");
            TextView textView2 = customViewHolderCartera.tvSaldoCapital;
            textView2.setText(decimalFormat.format(cuotaDTO.getSaldocapital()) + " Gs.");
            customViewHolderCartera.tvCi.setText(cuotaDTO.getNrodoc());
            customViewHolderCartera.tvTelefono.setText(cuotaDTO.getTelefono() == null ? "" : cuotaDTO.getTelefono());
            customViewHolderCartera.tvCliente.setText(cuotaDTO.getNombreapellido());
            if (cuotaDTO.getEstadocredito().equals("PEN")) {
                customViewHolderCartera.tvEstado.setTextColor(this.context.getResources().getColor(R.color.rojoOscuro));
            } else {
                customViewHolderCartera.tvEstado.setTextColor(this.context.getResources().getColor(R.color.verde));
            }
            customViewHolderCartera.tvEstado.setText(cuotaDTO.getEstadocredito());
            customViewHolderCartera.tvCredito.setText(cuotaDTO.getIdcredito().toString());
            customViewHolderCartera.btnDetalle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, ExtractoDetalleActivity.class);
                            intent.putExtra("nrodoc", cuotaDTO.getNrodoc());
                            intent.putExtra("estado", cuotaDTO.getAtraso().intValue() > 0 ? "mora" : "aldia");
                            intent.putExtra("idcredito", cuotaDTO.getIdcredito());
                            context.startActivity(intent);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$RecyclerViewCartera(CuotaDTO cuotaDTO, View view) {
        Intent intent = new Intent(this.context, ExtractoDetalleActivity.class);
        intent.putExtra("nrodoc", cuotaDTO.getNrodoc());
        intent.putExtra("estado", cuotaDTO.getAtraso().intValue() > 0 ? "mora" : "aldia");
        intent.putExtra("idcredito", cuotaDTO.getIdcredito());
        this.context.startActivity(intent);
    }

    public int getItemCount() {
        return this.lista.size();
    }
}
