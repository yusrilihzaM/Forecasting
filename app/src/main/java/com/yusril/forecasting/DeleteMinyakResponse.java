package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class DeleteMinyakResponse{

	@SerializedName("status_hps_minyak")
	private boolean statusHpsMinyak;

	@SerializedName("message_hps_minyak")
	private String messageHpsMinyak;

	public void setStatusHpsMinyak(boolean statusHpsMinyak){
		this.statusHpsMinyak = statusHpsMinyak;
	}

	public boolean isStatusHpsMinyak(){
		return statusHpsMinyak;
	}

	public void setMessageHpsMinyak(String messageHpsMinyak){
		this.messageHpsMinyak = messageHpsMinyak;
	}

	public String getMessageHpsMinyak(){
		return messageHpsMinyak;
	}

	@Override
 	public String toString(){
		return 
			"DeleteMinyakResponse{" + 
			"status_hps_minyak = '" + statusHpsMinyak + '\'' + 
			",message_hps_minyak = '" + messageHpsMinyak + '\'' + 
			"}";
		}
}