package com.yusril.forecasting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.yusril.forecasting.adapter.ViewPagerAdapter;
import com.yusril.forecasting.fragment.SES.FragmentChart;
import com.yusril.forecasting.fragment.SES.FragmentHasilSes;
import com.yusril.forecasting.fragment.SES.FragmentMapeSes;
import com.yusril.forecasting.fragment.SES.FragmentRamalSes;

public class Hasilses extends AppCompatActivity {
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasilses);
        getSupportActionBar().hide();
        back=findViewById(R.id.btnBack2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent =  new Intent(Hasilses.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TabLayout tabLayout= findViewById(R.id.tablayoutses);
        ViewPager viewPager= findViewById(R.id.viewpager);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentMapeSes(),"MAPE");
        adapter.AddFragment(new FragmentHasilSes(),"Perhitungan");
        adapter.AddFragment(new FragmentRamalSes(),"Ramal");
        adapter.AddFragment(new FragmentChart(),"Chart");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}