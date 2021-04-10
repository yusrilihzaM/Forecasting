package com.yusril.forecasting.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yusril.forecasting.DataMinyakItem;
import com.yusril.forecasting.DetailDataMinyak;
import com.yusril.forecasting.MenuModel;
import com.yusril.forecasting.R;
import com.yusril.forecasting.RestClient;

import java.util.List;

public class MinyakAdapter extends RecyclerView.Adapter<MinyakAdapter.MinyakViewHolder>{
    private List<DataMinyakItem> dataMinyak;
    private Context mContext;
    public MinyakAdapter(List<DataMinyakItem> dataMinyak, Context mContext) {
        this.dataMinyak = dataMinyak;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MinyakAdapter.MinyakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_minyak, parent, false);
        return new MinyakAdapter.MinyakViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MinyakAdapter.MinyakViewHolder holder, int position) {
       holder.txtNo.setText(dataMinyak.get(position).getT());
        holder.txtTahun.setText(dataMinyak.get(position).getTahun());
        holder.txtBulan.setText(dataMinyak.get(position).getBulan());
        holder.txtHarg.setText(dataMinyak.get(position).getJumlahMinyak());
        holder.item_data_minyak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveWithDataIntent = new Intent(mContext, DetailDataMinyak.class);
                moveWithDataIntent.putExtra(DetailDataMinyak.EXTRA_DATA_MINYAK, dataMinyak.get(position));
                mContext.startActivity(moveWithDataIntent);
                ((Activity)mContext).finish();

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataMinyak.size();
    }

    public class MinyakViewHolder extends RecyclerView.ViewHolder {
        TextView txtNo,txtTahun,txtBulan,txtHarg;
        LinearLayout item_data_minyak;
        public MinyakViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNo=itemView.findViewById(R.id.tvNo);
            txtTahun=itemView.findViewById(R.id.tvTahun);
            txtBulan=itemView.findViewById(R.id.tvBulan);
            txtHarg=itemView.findViewById(R.id.tvHarga);
            item_data_minyak=itemView.findViewById(R.id.item_data_minyak);
        }
    }
}
