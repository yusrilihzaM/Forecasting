package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class PostMinyakResponse{

	@SerializedName("status_tambah_minyak")
	private boolean statusTambahMinyak;

	@SerializedName("message_tambah_minyak")
	private String messageTambahMinyak;

	public void setStatusTambahMinyak(boolean statusTambahMinyak){
		this.statusTambahMinyak = statusTambahMinyak;
	}

	public boolean isStatusTambahMinyak(){
		return statusTambahMinyak;
	}

	public void setMessageTambahMinyak(String messageTambahMinyak){
		this.messageTambahMinyak = messageTambahMinyak;
	}

	public String getMessageTambahMinyak(){
		return messageTambahMinyak;
	}

	@Override
 	public String toString(){
		return 
			"PostMinyakResponse{" + 
			"status_tambah_minyak = '" + statusTambahMinyak + '\'' + 
			",message_tambah_minyak = '" + messageTambahMinyak + '\'' + 
			"}";
		}
}