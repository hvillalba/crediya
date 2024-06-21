package py.hvillalba.microsol_app.ui.recyclerCuotasAtrasadasDetalle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CuotaAtrasadaDTO;

public class RecyclerCuotasAtrasadasDet extends RecyclerView.Adapter<CustomViewHolderCuotasDetalle> implements Filterable {
    Context context;
    /* access modifiers changed from: private */
    public List<CuotaAtrasadaDTO> listFiltered = new ArrayList();
    /* access modifiers changed from: private */
    public List<CuotaAtrasadaDTO> lista = new ArrayList();

    public RecyclerCuotasAtrasadasDet(Context context2, List<CuotaAtrasadaDTO> list) {
        this.context = context2;
        this.lista = list;
        this.listFiltered = list;
    }

    public CustomViewHolderCuotasDetalle onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CustomViewHolderCuotasDetalle(LayoutInflater.from(this.context).inflate(R.layout.detalle_cuotas_atrasadas, viewGroup, false));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:1|2|3|4|5|6|7|(1:9)(1:10)|11|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x00cf */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(CustomViewHolderCuotasDetalle customViewHolderCuotasDetalle, int id) {
        SimpleDateFormat fechaFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        CuotaAtrasadaDTO cuotaAtrasadaDTO = lista.get(customViewHolderCuotasDetalle.getAdapterPosition());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        customViewHolderCuotasDetalle.tvCliente.setText(cuotaAtrasadaDTO.getCliente().getNombreapellido());
        customViewHolderCuotasDetalle.tvNroCi.setText(cuotaAtrasadaDTO.getCliente().getNrodoc());
        customViewHolderCuotasDetalle.tvCreditoNro.setText(cuotaAtrasadaDTO.getIdcredito().toString());
        customViewHolderCuotasDetalle.tvCuota.setText(cuotaAtrasadaDTO.getNrocuota() +"/"+ cuotaAtrasadaDTO.getCantidadCuotas());
        customViewHolderCuotasDetalle.tvFrecuencia.setText(cuotaAtrasadaDTO.getTipocredito().getDescripcion());
        customViewHolderCuotasDetalle.tvFCobro.setText(cuotaAtrasadaDTO.getFormacobrocredito().getDescripcion());
        customViewHolderCuotasDetalle.tvDesembolso.setText(fechaFormat.format(cuotaAtrasadaDTO.getFecDesembolso()));
        customViewHolderCuotasDetalle.tvVencimiento.setText(fechaFormat.format(cuotaAtrasadaDTO.getFechavencimiento()));
        customViewHolderCuotasDetalle.tvFechaUltPago.setText(fechaFormat.format(cuotaAtrasadaDTO.getFechaUltimoPago()));
        if (cuotaAtrasadaDTO.getAtraso() == 1){
            customViewHolderCuotasDetalle.tvDiasAtraso.setText( cuotaAtrasadaDTO.getAtraso() + " dia");
        }else if(cuotaAtrasadaDTO.getAtraso() > 1) {
            customViewHolderCuotasDetalle.tvDiasAtraso.setText( cuotaAtrasadaDTO.getAtraso() + " dias");
        }
        customViewHolderCuotasDetalle.tvMora.setText(decimalFormat.format(cuotaAtrasadaDTO.getMora()));
        customViewHolderCuotasDetalle.tvCapital.setText(decimalFormat.format(cuotaAtrasadaDTO.getCapital()));
        customViewHolderCuotasDetalle.tvInteres.setText(decimalFormat.format(cuotaAtrasadaDTO.getInteres()));
        double interes = cuotaAtrasadaDTO.getInteres();
        double mora = cuotaAtrasadaDTO.getMora();
        double capital = cuotaAtrasadaDTO.getCapital();
        customViewHolderCuotasDetalle.tvTotal.setText(decimalFormat.format(interes+mora+capital));
      }

    public int getItemCount() {
        return this.listFiltered.size();
    }

    public Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                if (charSequence2.isEmpty()) {
                    RecyclerCuotasAtrasadasDet recyclerCuotasAtrasadasDet = RecyclerCuotasAtrasadasDet.this;
                    List unused = recyclerCuotasAtrasadasDet.listFiltered = recyclerCuotasAtrasadasDet.lista;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (CuotaAtrasadaDTO cuotaAtrasadaDTO : RecyclerCuotasAtrasadasDet.this.lista) {
                        if (cuotaAtrasadaDTO.getCliente().getNombreapellido().toLowerCase().contains(charSequence2.toLowerCase()) || cuotaAtrasadaDTO.getCliente().getNrodoc().contains(charSequence) || cuotaAtrasadaDTO.getTipocredito().getDescripcion().contains(charSequence.toString().toUpperCase()) || cuotaAtrasadaDTO.getFormacobrocredito().getDescripcion().contains(charSequence.toString().toUpperCase())) {
                            arrayList.add(cuotaAtrasadaDTO);
                        }
                    }
                    List unused2 = RecyclerCuotasAtrasadasDet.this.listFiltered = arrayList;
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = RecyclerCuotasAtrasadasDet.this.listFiltered;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                List unused = RecyclerCuotasAtrasadasDet.this.listFiltered = (ArrayList) filterResults.values;
                RecyclerCuotasAtrasadasDet.this.notifyDataSetChanged();
            }
        };
    }
}
