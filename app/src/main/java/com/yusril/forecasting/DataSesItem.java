package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class DataSesItem{

	@SerializedName("error_ses")
	private Object errorSes;

	@SerializedName("tahun")
	private Object tahun;

	@SerializedName("t")
	private String T;

	@SerializedName("id_hitung_ses")
	private String idHitungSes;

	@SerializedName("abs_at_ft_ses")
	private Object absAtFtSes;

	@SerializedName("y_aksen_ses")
	private Object yAksenSes;

	@SerializedName("at_ft_ses")
	private Object atFtSes;

	@SerializedName("at_ft2_ses")
	private Object atFt2Ses;

	@SerializedName("bulan")
	private Object bulan;

	@SerializedName("id_data_minyak")
	private String idDataMinyak;

	@SerializedName("jumlah_minyak")
	private String jumlahMinyak;

	public void setErrorSes(Object errorSes){
		this.errorSes = errorSes;
	}

	public Object getErrorSes(){
		return errorSes;
	}

	public void setTahun(Object tahun){
		this.tahun = tahun;
	}

	public Object getTahun(){
		return tahun;
	}

	public void setT(String T){
		this.T = T;
	}

	public String getT(){
		return T;
	}

	public void setIdHitungSes(String idHitungSes){
		this.idHitungSes = idHitungSes;
	}

	public String getIdHitungSes(){
		return idHitungSes;
	}

	public void setAbsAtFtSes(Object absAtFtSes){
		this.absAtFtSes = absAtFtSes;
	}

	public Object getAbsAtFtSes(){
		return absAtFtSes;
	}

	public void setYAksenSes(Object yAksenSes){
		this.yAksenSes = yAksenSes;
	}

	public Object getYAksenSes(){
		return yAksenSes;
	}

	public void setAtFtSes(Object atFtSes){
		this.atFtSes = atFtSes;
	}

	public Object getAtFtSes(){
		return atFtSes;
	}

	public void setAtFt2Ses(Object atFt2Ses){
		this.atFt2Ses = atFt2Ses;
	}

	public Object getAtFt2Ses(){
		return atFt2Ses;
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
			"DataSesItem{" + 
			"error_ses = '" + errorSes + '\'' + 
			",tahun = '" + tahun + '\'' + 
			",t = '" + T + '\'' + 
			",id_hitung_ses = '" + idHitungSes + '\'' + 
			",abs_at_ft_ses = '" + absAtFtSes + '\'' + 
			",y_aksen_ses = '" + yAksenSes + '\'' + 
			",at_ft_ses = '" + atFtSes + '\'' + 
			",at_ft2_ses = '" + atFt2Ses + '\'' + 
			",bulan = '" + bulan + '\'' + 
			",id_data_minyak = '" + idDataMinyak + '\'' + 
			",jumlah_minyak = '" + jumlahMinyak + '\'' + 
			"}";
		}
}