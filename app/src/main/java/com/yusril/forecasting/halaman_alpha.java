package com.yusril.forecasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class halaman_alpha extends AppCompatActivity {
    ImageView btn_back, btn_save;
    private List<DataAlphaItem> listItem;
    EditText edt_alpha;
    TextView textViewAlpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_alpha);
        getSupportActionBar().hide();
        textViewAlpha=findViewById(R.id.txt_alpha);
        btn_back=findViewById(R.id.ramalback);
        btn_save=findViewById(R.id.save_ramal);
        edt_alpha=findViewById(R.id.edtAlpha);

        btn_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int id=1;
                double getalpha=Double.parseDouble(edt_alpha.getText().toString());
                RestClient.getService().putAlpha(id,getalpha).enqueue(new Callback<PutAlphaResponse>() {
                    @Override
                    public void onResponse(Call<PutAlphaResponse> call, Response<PutAlphaResponse> response) {
                        Toast.makeText(halaman_alpha.this, "Alpha Berhasil Disimpan", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent();
                        intent =  new Intent(halaman_alpha.this,halaman_alpha.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PutAlphaResponse> call, Throwable t) {
                        Toast.makeText(halaman_alpha.this, "Alpha Gagal Disimpan", Toast.LENGTH_SHORT).show();
                        Log.d("Gagal Update", t.getMessage());
                    }
                });
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent =  new Intent(halaman_alpha.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        RestClient.getService().getAlpha().enqueue(new Callback<AlphaResponse>() {
            @Override
            public void onResponse(Call<AlphaResponse> call, Response<AlphaResponse> response) {
                Toast.makeText(halaman_alpha.this, "Ambil Alpha Berhasil", Toast.LENGTH_SHORT).show();
                listItem = response.body().getDataAlpha();
                Log.d("API Result", String.valueOf(response.body().getDataAlpha().get(0)));
                Log.d("API lisitem", String.valueOf(listItem.get(0)));
                textViewAlpha.setText(String.valueOf(listItem.get(0).getAlpha()));
            }

            @Override
            public void onFailure(Call<AlphaResponse> call, Throwable t) {
                Toast.makeText(halaman_alpha.this, "Ambil Alpha Gagal", Toast.LENGTH_SHORT).show();

                Log.d("API Result",  t.getMessage());
                t.getMessage();
            }
        });
//        RestClient.getService().getAlpha().enqueue(new Callback<AlphaResponse>() {
//            @Override
//            public void onResponse(Call<AlphaResponse> call, Response<AlphaResponse> response) {
//                Toast.makeText(halaman_alpha.this, "Ambil Alpha Berhasil", Toast.LENGTH_SHORT).show();
//                textViewAlpha.setText("0.4");
//            }
//
//            @Override
//            public void onFailure(Call<AlphaResponse> call, Throwable t) {
//                Toast.makeText(halaman_alpha.this, "Ambil Alpha Gagal", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}