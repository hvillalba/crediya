package py.hvillalba.microsol_app.ui.recyclerCobros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CobrosDTO;

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
    public void onBindViewHolder(py.hvillalba.microsol_app.ui.recyclerCobros.CustomViewHolderCuotasDetalle r7, int r8) {
        /*
            r6 = this;
            java.lang.String r8 = ""
            java.lang.String r0 = "###,###,###"
            java.util.List<py.hvillalba.microsol_app.data.CobrosDTO> r1 = r6.listFiltered     // Catch:{ Exception -> 0x0151 }
            int r2 = r7.getAdapterPosition()     // Catch:{ Exception -> 0x0151 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0151 }
            py.hvillalba.microsol_app.data.CobrosDTO r1 = (py.hvillalba.microsol_app.data.CobrosDTO) r1     // Catch:{ Exception -> 0x0151 }
            android.widget.TextView r2 = r7.tvCliente     // Catch:{ Exception -> 0x0151 }
            py.hvillalba.microsol_app.data.ClienteDTO r3 = r1.getCliente()     // Catch:{ Exception -> 0x0151 }
            java.lang.String r3 = r3.getNombreapellido()     // Catch:{ Exception -> 0x0151 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0151 }
            android.widget.TextView r2 = r7.tvNroCi     // Catch:{ Exception -> 0x0151 }
            py.hvillalba.microsol_app.data.ClienteDTO r3 = r1.getCliente()     // Catch:{ Exception -> 0x0151 }
            java.lang.String r3 = r3.getNrodoc()     // Catch:{ Exception -> 0x0151 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0151 }
            android.widget.TextView r2 = r7.tvCreditoNro     // Catch:{ Exception -> 0x0151 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
            r3.<init>()     // Catch:{ Exception -> 0x0151 }
            r3.append(r8)     // Catch:{ Exception -> 0x0151 }
            java.lang.Integer r4 = r1.getIdcredito()     // Catch:{ Exception -> 0x0151 }
            r3.append(r4)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0151 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0151 }
            android.widget.TextView r2 = r7.tvCuota     // Catch:{ Exception -> 0x0151 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
            r3.<init>()     // Catch:{ Exception -> 0x0151 }
            r3.append(r8)     // Catch:{ Exception -> 0x0151 }
            java.lang.Integer r4 = r1.getNrocuota()     // Catch:{ Exception -> 0x0151 }
            r3.append(r4)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ Exception -> 0x0151 }
            java.lang.Integer r4 = r1.getCantidadCuotas()     // Catch:{ Exception -> 0x0151 }
            r3.append(r4)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0151 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0151 }
            android.widget.TextView r2 = r7.tvFCobro     // Catch:{ Exception -> 0x0151 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
            r3.<init>()     // Catch:{ Exception -> 0x0151 }
            r3.append(r8)     // Catch:{ Exception -> 0x0151 }
            py.hvillalba.microsol_app.data.FormacobrocreditoDTO r8 = r1.getFormacobrocredito()     // Catch:{ Exception -> 0x0151 }
            java.lang.String r8 = r8.getDescripcion()     // Catch:{ Exception -> 0x0151 }
            r3.append(r8)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r8 = r3.toString()     // Catch:{ Exception -> 0x0151 }
            r2.setText(r8)     // Catch:{ Exception -> 0x0151 }
            java.text.SimpleDateFormat r8 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0151 }
            java.lang.String r2 = "yyyy-MM-dd"
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ Exception -> 0x0151 }
            r8.<init>(r2, r3)     // Catch:{ Exception -> 0x0151 }
            java.util.Date r2 = r1.getFechacobro()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r2 = r8.format(r2)     // Catch:{ Exception -> 0x0098 }
            android.widget.TextView r3 = r7.tvDesembolso     // Catch:{ Exception -> 0x0098 }
            r3.setText(r2)     // Catch:{ Exception -> 0x0098 }
        L_0x0098:
            java.util.Date r2 = r1.getFechavencimiento()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r2 = r8.format(r2)     // Catch:{ Exception -> 0x00a5 }
            android.widget.TextView r3 = r7.tvVencimiento     // Catch:{ Exception -> 0x00a5 }
            r3.setText(r2)     // Catch:{ Exception -> 0x00a5 }
        L_0x00a5:
            java.util.Date r2 = r1.getFechacobro()     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r8 = r8.format(r2)     // Catch:{ Exception -> 0x00b2 }
            android.widget.TextView r2 = r7.tvFechaUltPago     // Catch:{ Exception -> 0x00b2 }
            r2.setText(r8)     // Catch:{ Exception -> 0x00b2 }
        L_0x00b2:
            java.lang.Integer r8 = r1.getAtraso()     // Catch:{ Exception -> 0x0151 }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x0151 }
            r2 = 1
            if (r8 != r2) goto L_0x00d8
            android.widget.TextView r8 = r7.tvDiasAtraso     // Catch:{ Exception -> 0x0151 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
            r2.<init>()     // Catch:{ Exception -> 0x0151 }
            java.lang.Integer r3 = r1.getAtraso()     // Catch:{ Exception -> 0x0151 }
            r2.append(r3)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r3 = " día"
            r2.append(r3)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0151 }
            r8.setText(r2)     // Catch:{ Exception -> 0x0151 }
            goto L_0x00f2
        L_0x00d8:
            android.widget.TextView r8 = r7.tvDiasAtraso     // Catch:{ Exception -> 0x0151 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
            r2.<init>()     // Catch:{ Exception -> 0x0151 }
            java.lang.Integer r3 = r1.getAtraso()     // Catch:{ Exception -> 0x0151 }
            r2.append(r3)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r3 = " días"
            r2.append(r3)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0151 }
            r8.setText(r2)     // Catch:{ Exception -> 0x0151 }
        L_0x00f2:
            android.widget.TextView r8 = r7.tvMora     // Catch:{ Exception -> 0x0151 }
            java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0151 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0151 }
            java.lang.Double r3 = r1.getMora()     // Catch:{ Exception -> 0x0151 }
            java.lang.String r2 = r2.format(r3)     // Catch:{ Exception -> 0x0151 }
            r8.setText(r2)     // Catch:{ Exception -> 0x0151 }
            android.widget.TextView r8 = r7.tvCapital     // Catch:{ Exception -> 0x0151 }
            java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0151 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0151 }
            java.lang.Double r3 = r1.getCapital()     // Catch:{ Exception -> 0x0151 }
            java.lang.String r2 = r2.format(r3)     // Catch:{ Exception -> 0x0151 }
            r8.setText(r2)     // Catch:{ Exception -> 0x0151 }
            android.widget.TextView r8 = r7.tvInteres     // Catch:{ Exception -> 0x0151 }
            java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0151 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0151 }
            java.lang.Double r3 = r1.getInteres()     // Catch:{ Exception -> 0x0151 }
            java.lang.String r2 = r2.format(r3)     // Catch:{ Exception -> 0x0151 }
            r8.setText(r2)     // Catch:{ Exception -> 0x0151 }
            java.lang.Double r8 = r1.getInteres()     // Catch:{ Exception -> 0x0151 }
            double r2 = r8.doubleValue()     // Catch:{ Exception -> 0x0151 }
            java.lang.Double r8 = r1.getMora()     // Catch:{ Exception -> 0x0151 }
            double r4 = r8.doubleValue()     // Catch:{ Exception -> 0x0151 }
            double r2 = r2 + r4
            java.lang.Double r8 = r1.getCapital()     // Catch:{ Exception -> 0x0151 }
            double r4 = r8.doubleValue()     // Catch:{ Exception -> 0x0151 }
            double r2 = r2 + r4
            android.widget.TextView r7 = r7.tvTotal     // Catch:{ Exception -> 0x0151 }
            java.text.DecimalFormat r8 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0151 }
            r8.<init>(r0)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r8 = r8.format(r2)     // Catch:{ Exception -> 0x0151 }
            r7.setText(r8)     // Catch:{ Exception -> 0x0151 }
            goto L_0x0155
        L_0x0151:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: py.hvillalba.microsol_app.ui.recyclerCobros.RecyclerCobrosDet.onBindViewHolder(py.hvillalba.microsol_app.ui.recyclerCobros.CustomViewHolderCuotasDetalle, int):void");
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
