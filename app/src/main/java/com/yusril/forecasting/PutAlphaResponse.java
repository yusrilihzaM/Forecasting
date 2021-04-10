package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class PutAlphaResponse{

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"PutAlphaResponse{" + 
			"message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}