package com.yusril.forecasting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yusril.forecasting.DataDesItem;
import com.yusril.forecasting.DataSesItem;
import com.yusril.forecasting.R;

import java.util.List;

public class MapedesAdapter extends RecyclerView.Adapter<MapedesAdapter.MyViewHolder>{
    private List<DataDesItem> dataHitungdes;
    private Context mContext;

    public MapedesAdapter(List<DataDesItem> dataHitungdes, Context mContext) {
        this.dataHitungdes = dataHitungdes;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mape_des, parent, false);
        return new MapedesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String ft= String.valueOf(dataHitungdes.get(position).getHasilForecastDes());
        String atft= String.valueOf(dataHitungdes.get(position).getAtFtDes());
        String absft= String.valueOf(dataHitungdes.get(position).getAbsAtFtBagiatDes());
        holder.txtNo.setText(dataHitungdes.get(position).getT());
        holder.txtAt.setText(dataHitungdes.get(position).getJumlahMinyak());
        holder.txtFt.setText(ft);
        holder.txtAtFT.setText(atft);
        holder.txtAtFTabs.setText(absft);
    }

    @Override
    public int getItemCount() {
        return dataHitungdes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNo,txtAt,txtFt,txtAtFT,txtAtFTabs;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNo=itemView.findViewById(R.id.tvNodes);
            txtAt=itemView.findViewById(R.id.tvAtdes);
            txtFt=itemView.findViewById(R.id.tvFtdes);
            txtAtFT=itemView.findViewById(R.id.tvat_ftdes);
            txtAtFTabs=itemView.findViewById(R.id.tvaabset_ftdes);
        }
    }
}
