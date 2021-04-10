package com.yusril.forecasting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import com.yusril.forecasting.adapter.MenuAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMenu;
    private ArrayList<MenuModel> list;
    private String[] dataNama1;
    private String[] dataNama2;
    private String[] dataSubnama;
    private String[] databg;
    private TypedArray icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        rvMenu = findViewById(R.id.rv_menu);
        rvMenu.setHasFixedSize(true);
        prepare();
        addItem();
        showRecyclerCardView();
    }
    private void prepare() {
        dataNama1 = getResources().getStringArray(R.array.data_nama1);
        dataNama2 = getResources().getStringArray(R.array.data_nama2);
        dataSubnama = getResources().getStringArray(R.array.data_sub_nama);
        databg = getResources().getStringArray(R.array.data_bg);
        icon = getResources().obtainTypedArray(R.array.data_ic);
    }
    private void showRecyclerCardView(){
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        MenuAdapter menuAdapter = new MenuAdapter(this);
        menuAdapter.setListMenu(list);
        rvMenu.setAdapter(menuAdapter);

    }
    private void addItem() {
        list = new ArrayList<>();
        for (int i = 0; i < dataNama1.length; i++) {
           MenuModel item= new MenuModel();
            item.setNama1(dataNama1[i]);
            item.setNama2(dataNama2[i]);
            item.setSubnama(dataSubnama[i]);
            item.setBg_menu(databg[i]);
            item.setIc_menu(icon.getResourceId(i, -1));

            list.add(item);
        }
    }
}