package com.yusril.forecasting;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuModel  {
    private int ic_menu;
    private  String bg_menu;
    private  String nama1;
    private  String nama2;
    private  String subnama;

    public MenuModel() {
    }

    public MenuModel(int ic_menu, String bg_menu, String nama1, String nama2, String subnama) {
        this.ic_menu = ic_menu;
        this.bg_menu = bg_menu;
        this.nama1 = nama1;
        this.nama2 = nama2;
        this.subnama = subnama;
    }

    public int getIc_menu() {
        return ic_menu;
    }

    public void setIc_menu(int ic_menu) {
        this.ic_menu = ic_menu;
    }

    public String getBg_menu() {
        return bg_menu;
    }

    public void setBg_menu(String bg_menu) {
        this.bg_menu = bg_menu;
    }

    public String getNama1() {
        return nama1;
    }

    public void setNama1(String nama1) {
        this.nama1 = nama1;
    }

    public String getNama2() {
        return nama2;
    }

    public void setNama2(String nama2) {
        this.nama2 = nama2;
    }

    public String getSubnama() {
        return subnama;
    }

    public void setSubnama(String subnama) {
        this.subnama = subnama;
    }
}
