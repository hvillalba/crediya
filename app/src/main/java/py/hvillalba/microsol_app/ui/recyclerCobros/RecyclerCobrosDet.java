package py.hvillalba.microsol_app.ui.recyclerCobros;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CobrosDTO;
import py.hvillalba.microsol_app.data.CuotaDTO;
import py.hvillalba.microsol_app.ui.ExtractoDetalleActivity;

public class RecyclerCobrosDet extends RecyclerView.Adapter<CustomViewHolderCuotasDetalle> implements Filterable {
    Context context;
    /* access modifiers changed from: private */
    public List<CobrosDTO> listFiltered = new ArrayList();
    /* access modifiers changed from: private */
    public List<CobrosDTO> lista = new ArrayList();

    public RecyclerCobrosDet(Context context2, List<CobrosDTO> list) {
        this.context = context2;
        this.lista = list;
        this.listFiltered = list;
    }

    public CustomViewHolderCuotasDetalle onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CustomViewHolderCuotasDetalle(LayoutInflater.from(this.context).inflate(R.layout.detalle_cuotas_atrasadas, viewGroup, false));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:1|2|3|4|5|6|7|8|9|10|(1:12)(1:13)|14|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|(1:12)(1:13)|14|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0098 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x00a5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x00b2 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00bd A[Catch:{ Exception -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00d8 A[Catch:{ Exception -> 0x0151 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(CustomViewHolderCuotasDetalle customViewHolderCuotasDetalle, int i) {
        try {
            SimpleDateFormat fechaFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            CobrosDTO cuotaDTO = this.lista.get(customViewHolderCuotasDetalle.getAdapterPosition());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            customViewHolderCuotasDetalle.tvCliente.setText(cuotaDTO.getCliente().getNombreapellido());
            customViewHolderCuotasDetalle.tvNroCi.setText(cuotaDTO.getCliente().getNrodoc());
            customViewHolderCuotasDetalle.tvCreditoNro.setText(cuotaDTO.getIdcredito().toString());
            customViewHolderCuotasDetalle.tvCuota.setText(cuotaDTO.getNrocuota() +"/"+ cuotaDTO.getCantidadCuotas());
            customViewHolderCuotasDetalle.tvFrecuencia.setText(cuotaDTO.getFormacobrocredito().getDescripcion());
            customViewHolderCuotasDetalle.tvFCobro.setText(cuotaDTO.getTipocredito().getDescripcion());
            customViewHolderCuotasDetalle.tvDesembolso.setText(cuotaDTO.getFechacobro() == null ? "" : fechaFormat.format(cuotaDTO.getFechacobro()));
            customViewHolderCuotasDetalle.tvVencimiento.setText(cuotaDTO.getFechavencimiento() == null ? "" : fechaFormat.format(cuotaDTO.getFechavencimiento()));
            customViewHolderCuotasDetalle.tvFechaUltPago.setText(cuotaDTO.getFechacobro() == null ? "" : fechaFormat.format(cuotaDTO.getFechacobro()));
            if (cuotaDTO.getAtraso() == 1){
                customViewHolderCuotasDetalle.tvDiasAtraso.setText( cuotaDTO.getAtraso() + " dia");
            }else if(cuotaDTO.getAtraso() > 1) {
                customViewHolderCuotasDetalle.tvDiasAtraso.setText( cuotaDTO.getAtraso() + " dias");
            }
            customViewHolderCuotasDetalle.tvMora.setText(decimalFormat.format(cuotaDTO.getMora()));
            customViewHolderCuotasDetalle.tvCapital.setText(decimalFormat.format(cuotaDTO.getCapital()));
            customViewHolderCuotasDetalle.tvInteres.setText(decimalFormat.format(cuotaDTO.getInteres()));
            double interes = cuotaDTO.getInteres();
            double mora = cuotaDTO.getMora();
            double capital = cuotaDTO.getCapital();
            customViewHolderCuotasDetalle.tvTotal.setText(decimalFormat.format(interes+mora+capital));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                    RecyclerCobrosDet recyclerCobrosDet = RecyclerCobrosDet.this;
                    List unused = recyclerCobrosDet.listFiltered = recyclerCobrosDet.lista;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (CobrosDTO cobrosDTO : RecyclerCobrosDet.this.lista) {
                        if (cobrosDTO.getCliente().getNombreapellido().toLowerCase().contains(charSequence2.toLowerCase()) || cobrosDTO.getFormacobrocredito().getDescripcion().contains(charSequence.toString().toUpperCase())) {
                            arrayList.add(cobrosDTO);
                        }
                    }
                    List unused2 = RecyclerCobrosDet.this.listFiltered = arrayList;
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = RecyclerCobrosDet.this.listFiltered;
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                List unused = RecyclerCobrosDet.this.listFiltered = (ArrayList) filterResults.values;
                RecyclerCobrosDet.this.notifyDataSetChanged();
            }
        };
    }
}
