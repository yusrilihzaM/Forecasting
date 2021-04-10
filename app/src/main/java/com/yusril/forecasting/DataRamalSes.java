package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class DataRamalSes{

	@SerializedName("hasil_forecast")
	private double hasilForecast;

	@SerializedName("tahun")
	private int tahun;

	@SerializedName("bulan")
	private int bulan;

	public void setHasilForecast(double hasilForecast){
		this.hasilForecast = hasilForecast;
	}

	public double getHasilForecast(){
		return hasilForecast;
	}

	public void setTahun(int tahun){
		this.tahun = tahun;
	}

	public int getTahun(){
		return tahun;
	}

	public void setBulan(int bulan){
		this.bulan = bulan;
	}

	public int getBulan(){
		return bulan;
	}

	@Override
 	public String toString(){
		return 
			"DataRamalSes{" + 
			"hasil_forecast = '" + hasilForecast + '\'' + 
			",tahun = '" + tahun + '\'' + 
			",bulan = '" + bulan + '\'' + 
			"}";
		}
}