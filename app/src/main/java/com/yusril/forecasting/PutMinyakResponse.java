package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class PutMinyakResponse{

	@SerializedName("status_update_minyak")
	private boolean statusUpdateMinyak;

	@SerializedName("message_update_minyak")
	private String messageUpdateMinyak;

	public void setStatusUpdateMinyak(boolean statusUpdateMinyak){
		this.statusUpdateMinyak = statusUpdateMinyak;
	}

	public boolean isStatusUpdateMinyak(){
		return statusUpdateMinyak;
	}

	public void setMessageUpdateMinyak(String messageUpdateMinyak){
		this.messageUpdateMinyak = messageUpdateMinyak;
	}

	public String getMessageUpdateMinyak(){
		return messageUpdateMinyak;
	}

	@Override
 	public String toString(){
		return 
			"PutMinyakResponse{" + 
			"status_update_minyak = '" + statusUpdateMinyak + '\'' + 
			",message_update_minyak = '" + messageUpdateMinyak + '\'' + 
			"}";
		}
}