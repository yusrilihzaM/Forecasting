package com.yusril.forecasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailDataMinyak extends AppCompatActivity {
    public static final String EXTRA_DATA_MINYAK = "extra_data_minyak";
    EditText tahun, bulan,harga;
    ImageView btn_save,back, del;
    DataMinyakItem dataMinyak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data_minyak);
        getSupportActionBar().hide();
        tahun=findViewById(R.id.editTextTahun);
        bulan=findViewById(R.id.editTextBulan);
        harga=findViewById(R.id.editTextHarga);
        btn_save=findViewById(R.id.btn_save_minyak);
        del=findViewById(R.id.btnHapus);
        dataMinyak=getIntent().getParcelableExtra(EXTRA_DATA_MINYAK);
        int id= Integer.parseInt(dataMinyak.getIdDataMinyak());
        tahun.setText(dataMinyak.getTahun());
        bulan.setText(dataMinyak.getBulan());
        harga.setText(dataMinyak.getJumlahMinyak());
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idt= String.valueOf(id);
                RestClient.getService().DeleteMinyakResponse(idt).enqueue(new Callback<DeleteMinyakResponse>() {
                    @Override
                    public void onResponse(Call<DeleteMinyakResponse> call, Response<DeleteMinyakResponse> response) {
                        Toast.makeText(DetailDataMinyak.this, "Data Minyak Berhasil Di Hapus", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent();
                        intent =  new Intent(DetailDataMinyak.this,HargaMinyak.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<DeleteMinyakResponse> call, Throwable t) {
                        Toast.makeText(DetailDataMinyak.this, "Data Minyak Gagal Di Update", Toast.LENGTH_SHORT).show();
                        Log.d("Gagal", t.getMessage());
                    }
                });
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dtTahun= Integer.parseInt(tahun.getText().toString());
                int dtBulan= Integer.parseInt(bulan.getText().toString());
                double dtHarga= Double.parseDouble(harga.getText().toString());
                RestClient.getService().putDataMinyak(id,dtTahun,dtBulan,dtHarga).enqueue(new Callback<PostMinyakResponse>() {
                    @Override
                    public void onResponse(Call<PostMinyakResponse> call, Response<PostMinyakResponse> response) {
                        Toast.makeText(DetailDataMinyak.this, "Data Minyak Berhasil Di Update", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent();
                        intent =  new Intent(DetailDataMinyak.this,HargaMinyak.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostMinyakResponse> call, Throwable t) {
                        Toast.makeText(DetailDataMinyak.this, "Data Minyak Gagal Di Update", Toast.LENGTH_SHORT).show();
                        Log.d("Gagal", t.getMessage());
                    }
                });
            }
        });
        back=findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent =  new Intent(DetailDataMinyak.this,HargaMinyak.class);
                startActivity(intent);
                finish();
            }
        });

    }
}