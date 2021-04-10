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

public class HasildesAdapter  extends RecyclerView.Adapter<HasildesAdapter.MyViewHolder>{
    private List<DataDesItem> dataHitungdes;
    private Context mContext;
    public HasildesAdapter(List<DataDesItem> dataHitungdes, Context mContext) {
        this.dataHitungdes = dataHitungdes;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hasil_des, parent, false);
        return new HasildesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String dtno=String.valueOf(dataHitungdes.get(position).getT());
                String dttahun=String.valueOf(dataHitungdes.get(position).getTahun());
                String dtbulan=String.valueOf(dataHitungdes.get(position).getBulan());
                String dtat=dataHitungdes.get(position).getJumlahMinyak();
                String dtysen=String.valueOf(dataHitungdes.get(position).getYAksenDes());
                String dtysensen=String.valueOf(dataHitungdes.get(position).getYDblAksenDes());
                String dta=String.valueOf(dataHitungdes.get(position).getADes());
                String dtb=String.valueOf(dataHitungdes.get(position).getBDes());
                String dtft=String.valueOf(dataHitungdes.get(position).getHasilForecastDes());

        holder.no.setText(dtno);
        holder.tahun.setText(dttahun);
        holder.bulan.setText(dtbulan);
        holder.at.setText(dtat);
        holder.ysen.setText(dtysen);
        holder.ysensen.setText(dtysensen);
        holder.a.setText(dta);
        holder.b.setText(dtb);
        holder.ft.setText(dtft);
    }

    @Override
    public int getItemCount() {
        return dataHitungdes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView no,tahun,bulan,at,ysen,ysensen,a,b,ft;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            no=itemView.findViewById(R.id.tvNohdes);
            tahun=itemView.findViewById(R.id.tvTahundes);
            bulan=itemView.findViewById(R.id.tvBulanhdes);
            at=itemView.findViewById(R.id.athdes);
            ysen=itemView.findViewById(R.id.yseshdes);
            ysensen=itemView.findViewById(R.id.yseseshdes);
            a=itemView.findViewById(R.id.ahdes);
            b=itemView.findViewById(R.id.bhdes);
            ft=itemView.findViewById(R.id.fthdes);
        }
    }
}
