package com.yusril.forecasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahRamal extends AppCompatActivity {
    ImageView back, save;
    EditText bulan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_ramal);
        getSupportActionBar().hide();
        back=findViewById(R.id.ramalback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent =  new Intent(TambahRamal.this,Hasildes.class);
                startActivity(intent);
                finish();
            }
        });
        bulan=findViewById(R.id.edtbulan);
        save=findViewById(R.id.save_ramal);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=1;
                int bulan1= Integer.parseInt(bulan.getText().toString());
                RestClient.getService().postramal(bulan1).enqueue(new Callback<PostRamalResponse>() {
                    @Override
                    public void onResponse(Call<PostRamalResponse> call, Response<PostRamalResponse> response) {
                        Toast.makeText(TambahRamal.this, "Berhasil meramal", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent();
                        intent =  new Intent(TambahRamal.this,Hasildes.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostRamalResponse> call, Throwable t) {

                    }
                });

            }
        });

    }
}