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

public class HasilAdapter  extends RecyclerView.Adapter<HasilAdapter.MyViewHolder>{
    private List<DataSesItem> dataHitungses;
    private Context mContext;
    public HasilAdapter(List<DataSesItem> dataHitungses, Context mContext) {
        this.dataHitungses = dataHitungses;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public HasilAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hasilses, parent, false);
        return new HasilAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HasilAdapter.MyViewHolder holder, int position) {
        String dtbulan= String.valueOf(dataHitungses.get(position).getBulan());
        String dtTahun=String.valueOf(dataHitungses.get(position).getTahun());
        String dtFt=String.valueOf(dataHitungses.get(position).getYAksenSes());
        String at=String.valueOf(dataHitungses.get(position).getJumlahMinyak());
        holder.no.setText(dataHitungses.get(position).getT());
        holder.bulan.setText(dtbulan);
        holder.tahun.setText(dtTahun);
        holder.at.setText(dtFt);
        holder.ft.setText(dtFt);
    }

    @Override
    public int getItemCount() {
        return dataHitungses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView no,tahun,bulan,ft,at;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            no=itemView.findViewById(R.id.tvNohses);
            bulan=itemView.findViewById(R.id.tvBulanhses);
            tahun=itemView.findViewById(R.id.tvTahunses);
            at=itemView.findViewById(R.id.athses);
            ft=itemView.findViewById(R.id.hasil_ft);
        }
    }
}
