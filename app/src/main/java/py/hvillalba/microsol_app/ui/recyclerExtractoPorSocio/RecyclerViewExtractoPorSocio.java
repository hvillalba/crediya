package py.hvillalba.microsol_app.ui.recyclerExtractoPorSocio;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.data.CuotaDTO;
import py.hvillalba.microsol_app.ui.ConsultarExtractoCabActivity;

public class RecyclerViewExtractoPorSocio extends RecyclerView.Adapter<CustomViewHolderExtractoPorSocio> {
    Context context;
    boolean ischecked;
    private List<CuotaDTO> lista = new ArrayList();

    public RecyclerViewExtractoPorSocio(Context context2, List<CuotaDTO> list, boolean z) {
        this.context = context2;
        this.lista = list;
        this.ischecked = z;
    }

    public CustomViewHolderExtractoPorSocio onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CustomViewHolderExtractoPorSocio(LayoutInflater.from(this.context)
                .inflate(R.layout.extracto_socio, viewGroup, false));
    }

    public void onBindViewHolder(CustomViewHolderExtractoPorSocio customViewHolderExtractoPorSocio, int i) {
        try {
            CuotaDTO cuotaDTO = this.lista.get(customViewHolderExtractoPorSocio.getAdapterPosition());
            customViewHolderExtractoPorSocio.btnDetalle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, ConsultarExtractoCabActivity.class);
                            intent.putExtra("nrodoc", cuotaDTO.getNrodoc());
                            intent.putExtra("ischecked", ischecked);
                            context.startActivity(intent);
                        }
                    });
            customViewHolderExtractoPorSocio.tvSocio.setText(cuotaDTO.getNombreapellido());
            customViewHolderExtractoPorSocio.tvTelefono.setText(cuotaDTO.getTelefono());
            customViewHolderExtractoPorSocio.tvCedula.setText(cuotaDTO.getNrodoc());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$RecyclerViewExtractoPorSocio(CuotaDTO cuotaDTO, View view) {
        Intent intent = new Intent(this.context, ConsultarExtractoCabActivity.class);
        intent.putExtra("nrodoc", cuotaDTO.getNrodoc());
        intent.putExtra("ischecked", this.ischecked);
        this.context.startActivity(intent);
    }

    public int getItemCount() {
        return this.lista.size();
    }
}
