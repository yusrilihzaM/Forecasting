package com.yusril.forecasting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yusril.forecasting.adapter.MinyakAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HargaMinyak extends AppCompatActivity {
    RecyclerView rvMinyak;
    ImageView btn_back, btn_add;
    private List<DataMinyakItem> listItem;
    private MinyakAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harga_minyak);
        getSupportActionBar().hide();
        btn_back=findViewById(R.id.btnBack);
        btn_add=findViewById(R.id.btnTambah);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent =  new Intent(HargaMinyak.this,TambahDataMinyak.class);
                startActivity(intent);
                finish();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent =  new Intent(HargaMinyak.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        rvMinyak=findViewById(R.id.rv_data_minyak);
        RestClient.getService().getMinyak().enqueue(new Callback<GetMinyakResponse>() {
            @Override
            public void onResponse(Call<GetMinyakResponse> call, Response<GetMinyakResponse> response) {
                Toast.makeText(HargaMinyak.this, "Ambil Data Berhasil", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()){

                    listItem = response.body().getDataMinyak();
                    Log.d("API lisitem", String.valueOf(listItem.get(0)));
                    adapter = new MinyakAdapter(listItem, HargaMinyak.this);
                    rvMinyak.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvMinyak.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<GetMinyakResponse> call, Throwable t) {
                Toast.makeText(HargaMinyak.this, "Ambil Data Gagal", Toast.LENGTH_SHORT).show();

                Log.d("API Result",  t.getMessage());
            }
        });
    }
}