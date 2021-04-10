package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class PostRamalResponse{

	@SerializedName("status_tambahramaldes")
	private boolean statusTambahramaldes;

	@SerializedName("message_tambahramaldes")
	private String messageTambahramaldes;

	public void setStatusTambahramaldes(boolean statusTambahramaldes){
		this.statusTambahramaldes = statusTambahramaldes;
	}

	public boolean isStatusTambahramaldes(){
		return statusTambahramaldes;
	}

	public void setMessageTambahramaldes(String messageTambahramaldes){
		this.messageTambahramaldes = messageTambahramaldes;
	}

	public String getMessageTambahramaldes(){
		return messageTambahramaldes;
	}

	@Override
 	public String toString(){
		return 
			"PostRamalResponse{" + 
			"status_tambahramaldes = '" + statusTambahramaldes + '\'' + 
			",message_tambahramaldes = '" + messageTambahramaldes + '\'' + 
			"}";
		}
}