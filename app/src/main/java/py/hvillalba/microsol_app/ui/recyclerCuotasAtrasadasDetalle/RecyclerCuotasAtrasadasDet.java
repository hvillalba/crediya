package py.hvillalba.microsol_app.ui.recyclerCuotasAtrasadasDetalle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
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
    public void onBindViewHolder(py.hvillalba.microsol_app.ui.recyclerCuotasAtrasadasDetalle.CustomViewHolderCuotasDetalle r7, int r8) {
        /*
            r6 = this;
            java.lang.String r8 = "###,###,###"
            java.lang.String r0 = ""
            java.util.List<py.hvillalba.microsol_app.data.CuotaAtrasadaDTO> r1 = r6.listFiltered     // Catch:{ Exception -> 0x0173 }
            int r2 = r7.getAdapterPosition()     // Catch:{ Exception -> 0x0173 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0173 }
            py.hvillalba.microsol_app.data.CuotaAtrasadaDTO r1 = (py.hvillalba.microsol_app.data.CuotaAtrasadaDTO) r1     // Catch:{ Exception -> 0x0173 }
            android.widget.TextView r2 = r7.tvCliente     // Catch:{ Exception -> 0x0173 }
            py.hvillalba.microsol_app.data.ClienteDTO r3 = r1.getCliente()     // Catch:{ Exception -> 0x0173 }
            java.lang.String r3 = r3.getNombreapellido()     // Catch:{ Exception -> 0x0173 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0173 }
            android.widget.TextView r2 = r7.tvNroCi     // Catch:{ Exception -> 0x0173 }
            py.hvillalba.microsol_app.data.ClienteDTO r3 = r1.getCliente()     // Catch:{ Exception -> 0x0173 }
            java.lang.String r3 = r3.getNrodoc()     // Catch:{ Exception -> 0x0173 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0173 }
            android.widget.TextView r2 = r7.tvCreditoNro     // Catch:{ Exception -> 0x0173 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0173 }
            r3.<init>()     // Catch:{ Exception -> 0x0173 }
            r3.append(r0)     // Catch:{ Exception -> 0x0173 }
            java.lang.Integer r4 = r1.getIdcredito()     // Catch:{ Exception -> 0x0173 }
            r3.append(r4)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0173 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0173 }
            android.widget.TextView r2 = r7.tvCuota     // Catch:{ Exception -> 0x0173 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0173 }
            r3.<init>()     // Catch:{ Exception -> 0x0173 }
            r3.append(r0)     // Catch:{ Exception -> 0x0173 }
            java.lang.Integer r4 = r1.getNrocuota()     // Catch:{ Exception -> 0x0173 }
            r3.append(r4)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ Exception -> 0x0173 }
            java.lang.Integer r4 = r1.getCantidadCuotas()     // Catch:{ Exception -> 0x0173 }
            r3.append(r4)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0173 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0173 }
            android.widget.TextView r2 = r7.tvFrecuencia     // Catch:{ Exception -> 0x0173 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0173 }
            r3.<init>()     // Catch:{ Exception -> 0x0173 }
            r3.append(r0)     // Catch:{ Exception -> 0x0173 }
            py.hvillalba.microsol_app.data.TipocreditoDTO r4 = r1.getTipocredito()     // Catch:{ Exception -> 0x0173 }
            java.lang.String r4 = r4.getDescripcion()     // Catch:{ Exception -> 0x0173 }
            r3.append(r4)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0173 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0173 }
            android.widget.TextView r2 = r7.tvFCobro     // Catch:{ Exception -> 0x0173 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0173 }
            r3.<init>()     // Catch:{ Exception -> 0x0173 }
            r3.append(r0)     // Catch:{ Exception -> 0x0173 }
            py.hvillalba.microsol_app.data.FormacobrocreditoDTO r4 = r1.getFormacobrocredito()     // Catch:{ Exception -> 0x0173 }
            java.lang.String r4 = r4.getDescripcion()     // Catch:{ Exception -> 0x0173 }
            r3.append(r4)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0173 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0173 }
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0173 }
            java.lang.String r3 = "yyyy-MM-dd"
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ Exception -> 0x0173 }
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0173 }
            java.util.Date r3 = r1.getFecDesembolso()     // Catch:{ Exception -> 0x0173 }
            java.lang.String r3 = r2.format(r3)     // Catch:{ Exception -> 0x0173 }
            android.widget.TextView r4 = r7.tvDesembolso     // Catch:{ Exception -> 0x0173 }
            r4.setText(r3)     // Catch:{ Exception -> 0x0173 }
            java.util.Date r3 = r1.getFechavencimiento()     // Catch:{ Exception -> 0x0173 }
            java.lang.String r3 = r2.format(r3)     // Catch:{ Exception -> 0x0173 }
            android.widget.TextView r4 = r7.tvVencimiento     // Catch:{ Exception -> 0x0173 }
            r4.setText(r3)     // Catch:{ Exception -> 0x0173 }
            java.util.Date r3 = r1.getFechaUltimoPago()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r2 = r2.format(r3)     // Catch:{ Exception -> 0x00cf }
            android.widget.TextView r3 = r7.tvFechaUltPago     // Catch:{ Exception -> 0x00cf }
            r3.setText(r2)     // Catch:{ Exception -> 0x00cf }
            goto L_0x00d4
        L_0x00cf:
            android.widget.TextView r2 = r7.tvFechaUltPago     // Catch:{ Exception -> 0x0173 }
            r2.setText(r0)     // Catch:{ Exception -> 0x0173 }
        L_0x00d4:
            java.lang.Integer r0 = r1.getAtraso()     // Catch:{ Exception -> 0x0173 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0173 }
            r2 = 1
            if (r0 != r2) goto L_0x00fa
            android.widget.TextView r0 = r7.tvDiasAtraso     // Catch:{ Exception -> 0x0173 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0173 }
            r2.<init>()     // Catch:{ Exception -> 0x0173 }
            java.lang.Integer r3 = r1.getAtraso()     // Catch:{ Exception -> 0x0173 }
            r2.append(r3)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r3 = " día"
            r2.append(r3)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0173 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0173 }
            goto L_0x0114
        L_0x00fa:
            android.widget.TextView r0 = r7.tvDiasAtraso     // Catch:{ Exception -> 0x0173 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0173 }
            r2.<init>()     // Catch:{ Exception -> 0x0173 }
            java.lang.Integer r3 = r1.getAtraso()     // Catch:{ Exception -> 0x0173 }
            r2.append(r3)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r3 = " días"
            r2.append(r3)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0173 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0173 }
        L_0x0114:
            android.widget.TextView r0 = r7.tvMora     // Catch:{ Exception -> 0x0173 }
            java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0173 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0173 }
            java.lang.Double r3 = r1.getMora()     // Catch:{ Exception -> 0x0173 }
            java.lang.String r2 = r2.format(r3)     // Catch:{ Exception -> 0x0173 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0173 }
            android.widget.TextView r0 = r7.tvCapital     // Catch:{ Exception -> 0x0173 }
            java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0173 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0173 }
            java.lang.Double r3 = r1.getCapital()     // Catch:{ Exception -> 0x0173 }
            java.lang.String r2 = r2.format(r3)     // Catch:{ Exception -> 0x0173 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0173 }
            android.widget.TextView r0 = r7.tvInteres     // Catch:{ Exception -> 0x0173 }
            java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0173 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0173 }
            java.lang.Double r3 = r1.getInteres()     // Catch:{ Exception -> 0x0173 }
            java.lang.String r2 = r2.format(r3)     // Catch:{ Exception -> 0x0173 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0173 }
            java.lang.Double r0 = r1.getInteres()     // Catch:{ Exception -> 0x0173 }
            double r2 = r0.doubleValue()     // Catch:{ Exception -> 0x0173 }
            java.lang.Double r0 = r1.getMora()     // Catch:{ Exception -> 0x0173 }
            double r4 = r0.doubleValue()     // Catch:{ Exception -> 0x0173 }
            double r2 = r2 + r4
            java.lang.Double r0 = r1.getCapital()     // Catch:{ Exception -> 0x0173 }
            double r0 = r0.doubleValue()     // Catch:{ Exception -> 0x0173 }
            double r2 = r2 + r0
            android.widget.TextView r7 = r7.tvTotal     // Catch:{ Exception -> 0x0173 }
            java.text.DecimalFormat r0 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0173 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r8 = r0.format(r2)     // Catch:{ Exception -> 0x0173 }
            r7.setText(r8)     // Catch:{ Exception -> 0x0173 }
            goto L_0x0177
        L_0x0173:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: py.hvillalba.microsol_app.ui.recyclerCuotasAtrasadasDetalle.RecyclerCuotasAtrasadasDet.onBindViewHolder(py.hvillalba.microsol_app.ui.recyclerCuotasAtrasadasDetalle.CustomViewHolderCuotasDetalle, int):void");
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
