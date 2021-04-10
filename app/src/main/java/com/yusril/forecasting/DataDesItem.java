package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class DataDesItem{

	@SerializedName("tahun")
	private Object tahun;

	@SerializedName("id_hitung_des")
	private String idHitungDes;

	@SerializedName("b_des")
	private Object bDes;

	@SerializedName("hasil_forecast_des")
	private Object hasilForecastDes;

	@SerializedName("at_ft_des")
	private Object atFtDes;

	@SerializedName("abs_at_ft_bagiat_des")
	private Object absAtFtBagiatDes;

	@SerializedName("t")
	private String T;

	@SerializedName("y_dbl_aksen_des")
	private String yDblAksenDes;

	@SerializedName("a_des")
	private String aDes;

	@SerializedName("y_aksen_des")
	private String yAksenDes;

	@SerializedName("bulan")
	private Object bulan;

	@SerializedName("id_data_minyak")
	private String idDataMinyak;

	@SerializedName("jumlah_minyak")
	private String jumlahMinyak;

	public void setTahun(Object tahun){
		this.tahun = tahun;
	}

	public Object getTahun(){
		return tahun;
	}

	public void setIdHitungDes(String idHitungDes){
		this.idHitungDes = idHitungDes;
	}

	public String getIdHitungDes(){
		return idHitungDes;
	}

	public void setBDes(Object bDes){
		this.bDes = bDes;
	}

	public Object getBDes(){
		return bDes;
	}

	public void setHasilForecastDes(Object hasilForecastDes){
		this.hasilForecastDes = hasilForecastDes;
	}

	public Object getHasilForecastDes(){
		return hasilForecastDes;
	}

	public void setAtFtDes(Object atFtDes){
		this.atFtDes = atFtDes;
	}

	public Object getAtFtDes(){
		return atFtDes;
	}

	public void setAbsAtFtBagiatDes(Object absAtFtBagiatDes){
		this.absAtFtBagiatDes = absAtFtBagiatDes;
	}

	public Object getAbsAtFtBagiatDes(){
		return absAtFtBagiatDes;
	}

	public void setT(String T){
		this.T = T;
	}

	public String getT(){
		return T;
	}

	public void setYDblAksenDes(String yDblAksenDes){
		this.yDblAksenDes = yDblAksenDes;
	}

	public String getYDblAksenDes(){
		return yDblAksenDes;
	}

	public void setADes(String aDes){
		this.aDes = aDes;
	}

	public String getADes(){
		return aDes;
	}

	public void setYAksenDes(String yAksenDes){
		this.yAksenDes = yAksenDes;
	}

	public String getYAksenDes(){
		return yAksenDes;
	}

	public void setBulan(Object bulan){
		this.bulan = bulan;
	}

	public Object getBulan(){
		return bulan;
	}

	public void setIdDataMinyak(String idDataMinyak){
		this.idDataMinyak = idDataMinyak;
	}

	public String getIdDataMinyak(){
		return idDataMinyak;
	}

	public void setJumlahMinyak(String jumlahMinyak){
		this.jumlahMinyak = jumlahMinyak;
	}

	public String getJumlahMinyak(){
		return jumlahMinyak;
	}

	@Override
 	public String toString(){
		return 
			"DataDesItem{" + 
			"tahun = '" + tahun + '\'' + 
			",id_hitung_des = '" + idHitungDes + '\'' + 
			",b_des = '" + bDes + '\'' + 
			",hasil_forecast_des = '" + hasilForecastDes + '\'' + 
			",at_ft_des = '" + atFtDes + '\'' + 
			",abs_at_ft_bagiat_des = '" + absAtFtBagiatDes + '\'' + 
			",t = '" + T + '\'' + 
			",y_dbl_aksen_des = '" + yDblAksenDes + '\'' + 
			",a_des = '" + aDes + '\'' + 
			",y_aksen_des = '" + yAksenDes + '\'' + 
			",bulan = '" + bulan + '\'' + 
			",id_data_minyak = '" + idDataMinyak + '\'' + 
			",jumlah_minyak = '" + jumlahMinyak + '\'' + 
			"}";
		}
}