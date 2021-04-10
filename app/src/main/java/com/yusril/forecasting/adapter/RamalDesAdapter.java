package com.yusril.forecasting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yusril.forecasting.DataDesItem;
import com.yusril.forecasting.DataRamalDesItem;
import com.yusril.forecasting.R;

import java.util.List;

public class RamalDesAdapter extends RecyclerView.Adapter<RamalDesAdapter.MyViewHolder>{
    private List<DataRamalDesItem> dataRamaldes;
    private Context mContext;
    public RamalDesAdapter(List<DataRamalDesItem> dataRamaldes, Context mContext) {
        this.dataRamaldes = dataRamaldes;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ramal_des, parent, false);
        return new RamalDesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String dtno=String.valueOf(dataRamaldes.get(position).getBulanDes());

        String dtbulan=String.valueOf(dataRamaldes.get(position).getBulanDes());
        String dtft=String.valueOf(dataRamaldes.get(position).getJumlahMinyakDes());
        holder.nora.setText(dtno);

        holder.bulan.setText(dtbulan);
        holder.ramal.setText(dtft);
    }

    @Override
    public int getItemCount() {
        return dataRamaldes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nora,tahun,bulan,ramal;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nora=itemView.findViewById(R.id.NoRamalDes);

            bulan=itemView.findViewById(R.id.BulanRamalDes);
            ramal=itemView.findViewById(R.id.FtRamalDes);
        }
    }
}
