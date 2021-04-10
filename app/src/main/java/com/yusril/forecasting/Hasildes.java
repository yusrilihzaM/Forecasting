package com.yusril.forecasting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.yusril.forecasting.adapter.ViewPagerAdapter;
import com.yusril.forecasting.fragment.DES.FragmentChartDes;
import com.yusril.forecasting.fragment.DES.FragmentHasilDes;
import com.yusril.forecasting.fragment.DES.FragmentMapeDes;
import com.yusril.forecasting.fragment.DES.FragmentRamal;
import com.yusril.forecasting.fragment.SES.FragmentChart;
import com.yusril.forecasting.fragment.SES.FragmentHasilSes;
import com.yusril.forecasting.fragment.SES.FragmentMapeSes;
import com.yusril.forecasting.fragment.SES.FragmentRamalSes;

public class Hasildes extends AppCompatActivity {
    ImageView back, tambah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasildes);
        getSupportActionBar().hide();
        back=findViewById(R.id.btnBack2);
        tambah=findViewById(R.id.btnTambahRamal);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent =  new Intent(Hasildes.this,TambahRamal.class);
                startActivity(intent);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent =  new Intent(Hasildes.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TabLayout tabLayout= findViewById(R.id.tablayoutdes);
        ViewPager viewPager= findViewById(R.id.viewpagerdes);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentMapeDes(),"MAPE");
        adapter.AddFragment(new FragmentHasilDes(),"Perhitungan");
        adapter.AddFragment(new FragmentRamal(),"Ramal");
        adapter.AddFragment(new FragmentChartDes(),"Chart");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}