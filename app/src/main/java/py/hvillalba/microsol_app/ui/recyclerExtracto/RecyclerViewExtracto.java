package py.hvillalba.microsol_app.ui.recyclerExtracto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CuotaDTO;
import py.hvillalba.microsol_app.ui.ExtractoDetalleActivity;

public class RecyclerViewExtracto extends RecyclerView.Adapter<CustomViewHolderExtracto> {
    private boolean conSaldo;
    Context context;
    private List<CuotaDTO> lista = new ArrayList();

    public RecyclerViewExtracto(Context context2, List<CuotaDTO> list, boolean z) {
        this.context = context2;
        this.lista = list;
        this.conSaldo = z;
    }

    public CustomViewHolderExtracto onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CustomViewHolderExtracto(LayoutInflater.from(this.context).inflate(R.layout.extracto_item, viewGroup, false));
    }

    public void onBindViewHolder(CustomViewHolderExtracto customViewHolderExtracto, int i) {
        try {
            CuotaDTO cuotaDTO = this.lista.get(customViewHolderExtracto.getAdapterPosition());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
            String format = simpleDateFormat.format(cuotaDTO.getFecvencimiento());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            double doubleValue = cuotaDTO.getTotal().doubleValue() - cuotaDTO.getImportepagado().doubleValue();
            if (cuotaDTO.getEstadocredito().equals("PEN")) {
                customViewHolderExtracto.tvEstado.setTextColor(this.context.getResources().getColor(R.color.estadoRojo));
            } else {
                customViewHolderExtracto.tvEstado.setTextColor(this.context.getResources().getColor(R.color.verde));
            }
            customViewHolderExtracto.tvEstado.setText(cuotaDTO.getEstadocredito());
            customViewHolderExtracto.tvCuota.setText(cuotaDTO.getNrocuota().toString());
            customViewHolderExtracto.tvImporte.setText(decimalFormat.format(cuotaDTO.getTotal()));
            customViewHolderExtracto.tvFechaOperacion.setText(simpleDateFormat.format(cuotaDTO.getFechadesembolso()));
            customViewHolderExtracto.tvFechaVenc.setText(format);
            customViewHolderExtracto.tvCuotasPagadas.setText(cuotaDTO.getCuotasPagadas() == null ? "0" : cuotaDTO.getCuotasPagadas().toString());
            customViewHolderExtracto.tvTipoCobro.setText(cuotaDTO.getTipocredito().getDescripcion());
            customViewHolderExtracto.tvTasa.setText(cuotaDTO.getTasamora().toString());
            customViewHolderExtracto.tvMontoInteres.setText(decimalFormat.format(cuotaDTO.getInteres()));
            customViewHolderExtracto.tvMontoCuota.setText(decimalFormat.format(cuotaDTO.getMonto()));
            customViewHolderExtracto.tvMontoPagado.setText(decimalFormat.format(cuotaDTO.getImportepagado()));
            customViewHolderExtracto.tvSaldo.setText(decimalFormat.format(doubleValue));
            customViewHolderExtracto.tvCapital.setText(decimalFormat.format(cuotaDTO.getSaldocapital()));
            customViewHolderExtracto.btnDetalle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, ExtractoDetalleActivity.class);
                            intent.putExtra("nrodoc", cuotaDTO.getNrodoc());
                            intent.putExtra("idcredito", cuotaDTO.getIdcredito());
                            intent.putExtra("conSaldo", conSaldo);
                            context.startActivity(intent);
                        }
                    });
            TextView textView = customViewHolderExtracto.tvSocio;
            textView.setText("Cliente:" + cuotaDTO.getNombreapellido());
            TextView textView2 = customViewHolderExtracto.tvTelefono;
            textView2.setText("Tel. :" + cuotaDTO.getTelefono());
            customViewHolderExtracto.tvNroCredito.setText(cuotaDTO.getIdcredito().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$RecyclerViewExtracto(CuotaDTO cuotaDTO, View view) {
        Intent intent = new Intent(this.context, ExtractoDetalleActivity.class);
        intent.putExtra("nrodoc", cuotaDTO.getNrodoc());
        intent.putExtra("idcredito", cuotaDTO.getIdcredito());
        intent.putExtra("conSaldo", this.conSaldo);
        this.context.startActivity(intent);
    }

    public int getItemCount() {
        return this.lista.size();
    }
}
