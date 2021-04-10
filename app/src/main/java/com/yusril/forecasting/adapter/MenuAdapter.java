package com.yusril.forecasting.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yusril.forecasting.HargaMinyak;
import com.yusril.forecasting.Hasildes;
import com.yusril.forecasting.Hasilses;
import com.yusril.forecasting.MenuModel;
import com.yusril.forecasting.R;
import com.yusril.forecasting.halaman_alpha;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private Context context;
    private ArrayList<MenuModel> listmenu;
    private ArrayList<MenuModel> getListmenu() {
        return listmenu;
    }
    public void setListMenu(ArrayList<MenuModel> Listmenu) {
        this.listmenu = Listmenu;
    }
    public MenuAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuModel item = getListmenu().get(position);


        Glide.with(context)
                .load(item.getIc_menu())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.ic_menu);
        holder.cardView.setCardBackgroundColor(Color.parseColor(item.getBg_menu()));
        holder.tvmenu1.setText(item.getNama1());
        holder.tvmenu2.setText(item.getNama2());
        holder.tvsubmenu.setText(item.getSubnama());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (holder.getAdapterPosition()){
                    case 0:
                        intent =  new Intent(context, halaman_alpha.class);
                        context.startActivity(intent);
                        ((Activity)context).finish();
                        break;
                    case 1:
                        intent =  new Intent(context, HargaMinyak.class);
                        context.startActivity(intent);
                        ((Activity)context).finish();
                        break;
                    case 2:
                        intent =  new Intent(context, Hasilses.class);
                        context.startActivity(intent);
                        ((Activity)context).finish();
                        break;
                    case 3:

                        intent =  new Intent(context, Hasildes.class);
                        context.startActivity(intent);
                        ((Activity)context).finish();
                        break;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return getListmenu().size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView  ic_menu;
        CardView cardView;
        TextView tvmenu1, tvmenu2, tvsubmenu;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.card_view);
            ic_menu=itemView.findViewById(R.id.logoitem);
            tvmenu1 = itemView.findViewById(R.id.judul1);
            tvmenu2 = itemView.findViewById(R.id.judul2);
            tvsubmenu = itemView.findViewById(R.id.subjudul2);
        }
    }
}
