package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class DataRamalDesItem{

	@SerializedName("id_ramal_des")
	private String idRamalDes;

	@SerializedName("bulan_des")
	private String bulanDes;

	@SerializedName("tahun_des")
	private String tahunDes;

	@SerializedName("jumlah_minyak_des")
	private String jumlahMinyakDes;

	public void setIdRamalDes(String idRamalDes){
		this.idRamalDes = idRamalDes;
	}

	public String getIdRamalDes(){
		return idRamalDes;
	}

	public void setBulanDes(String bulanDes){
		this.bulanDes = bulanDes;
	}

	public String getBulanDes(){
		return bulanDes;
	}

	public void setTahunDes(String tahunDes){
		this.tahunDes = tahunDes;
	}

	public String getTahunDes(){
		return tahunDes;
	}

	public void setJumlahMinyakDes(String jumlahMinyakDes){
		this.jumlahMinyakDes = jumlahMinyakDes;
	}

	public String getJumlahMinyakDes(){
		return jumlahMinyakDes;
	}

	@Override
 	public String toString(){
		return 
			"DataRamalDesItem{" + 
			"id_ramal_des = '" + idRamalDes + '\'' + 
			",bulan_des = '" + bulanDes + '\'' + 
			",tahun_des = '" + tahunDes + '\'' + 
			",jumlah_minyak_des = '" + jumlahMinyakDes + '\'' + 
			"}";
		}
}