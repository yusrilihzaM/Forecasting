package com.yusril.forecasting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yusril.forecasting.DataSesItem;
import com.yusril.forecasting.R;

import java.util.List;

public class MapesesAdapter extends RecyclerView.Adapter<MapesesAdapter.MyViewHolder>{
    private List<DataSesItem> dataHitungses;
    private Context mContext;

    public MapesesAdapter(List<DataSesItem> dataHitungses, Context mContext) {
        this.dataHitungses = dataHitungses;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mapeses, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String ft= String.valueOf(dataHitungses.get(position).getYAksenSes());
        String atft= String.valueOf(dataHitungses.get(position).getAtFtSes());
                String absft= String.valueOf(dataHitungses.get(position).getAbsAtFtSes());
      holder.txtNo.setText(dataHitungses.get(position).getT());
        holder.txtAt.setText(dataHitungses.get(position).getJumlahMinyak());
        holder.txtFt.setText(ft);
        holder.txtAtFT.setText(atft);
        holder.txtAtFTabs.setText(absft);
//
    }

    @Override
    public int getItemCount() {
        return dataHitungses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNo,txtAt,txtFt,txtAtFT,txtAtFTabs;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNo=itemView.findViewById(R.id.tvNoses);
            txtAt=itemView.findViewById(R.id.tvAtses);
            txtFt=itemView.findViewById(R.id.tvFtses);
            txtAtFT=itemView.findViewById(R.id.tvat_ftses);
            txtAtFTabs=itemView.findViewById(R.id.tvaabset_ftses);
        }
    }
}
