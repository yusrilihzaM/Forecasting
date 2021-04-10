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

public class TambahDataMinyak extends AppCompatActivity {
    EditText tahun, bulan,harga;
    ImageView btn_save,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data_minyak);
        getSupportActionBar().hide();
        tahun=findViewById(R.id.editTextTahun);
        bulan=findViewById(R.id.editTextBulan);
        harga=findViewById(R.id.editTextHarga);
        btn_save=findViewById(R.id.btn_save_minyak);
        back=findViewById(R.id.btnBack);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dtTahun= Integer.parseInt(tahun.getText().toString());
                int dtBulan= Integer.parseInt(bulan.getText().toString());
                Double dtHarga= Double.parseDouble(harga.getText().toString());
                RestClient.getService().postdataminyak(dtTahun,dtBulan,dtHarga).enqueue(new Callback<PostMinyakResponse>() {
                    @Override
                    public void onResponse(Call<PostMinyakResponse> call, Response<PostMinyakResponse> response) {
                        Toast.makeText(TambahDataMinyak.this, "Data Minyak Berhasil Disimpan", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent();
                        intent =  new Intent(TambahDataMinyak.this,HargaMinyak.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostMinyakResponse> call, Throwable t) {
                        Toast.makeText(TambahDataMinyak.this, "Data Minyak  Gagal Disimpan", Toast.LENGTH_SHORT).show();
                        Log.d("Gagal", t.getMessage());
                    }
                });
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent =  new Intent(TambahDataMinyak.this,HargaMinyak.class);
                startActivity(intent);
                finish();
            }
        });
    }
}