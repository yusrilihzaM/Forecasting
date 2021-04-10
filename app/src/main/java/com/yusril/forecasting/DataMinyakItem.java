package com.yusril.forecasting;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DataMinyakItem implements Parcelable {

	@SerializedName("tahun")
	private String tahun;

	@SerializedName("t")
	private String T;

	@SerializedName("bulan")
	private String bulan;

	@SerializedName("id_data_minyak")
	private String idDataMinyak;

	@SerializedName("jumlah_minyak")
	private String jumlahMinyak;

	protected DataMinyakItem(Parcel in) {
		tahun = in.readString();
		T = in.readString();
		bulan = in.readString();
		idDataMinyak = in.readString();
		jumlahMinyak = in.readString();
	}

	public static final Creator<DataMinyakItem> CREATOR = new Creator<DataMinyakItem>() {
		@Override
		public DataMinyakItem createFromParcel(Parcel in) {
			return new DataMinyakItem(in);
		}

		@Override
		public DataMinyakItem[] newArray(int size) {
			return new DataMinyakItem[size];
		}
	};

	public void setTahun(String tahun){
		this.tahun = tahun;
	}

	public String getTahun(){
		return tahun;
	}

	public void setT(String T){
		this.T = T;
	}

	public String getT(){
		return T;
	}

	public void setBulan(String bulan){
		this.bulan = bulan;
	}

	public String getBulan(){
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
			"DataMinyakItem{" + 
			"tahun = '" + tahun + '\'' + 
			",t = '" + T + '\'' + 
			",bulan = '" + bulan + '\'' + 
			",id_data_minyak = '" + idDataMinyak + '\'' + 
			",jumlah_minyak = '" + jumlahMinyak + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(tahun);
		dest.writeString(T);
		dest.writeString(bulan);
		dest.writeString(idDataMinyak);
		dest.writeString(jumlahMinyak);
	}
}