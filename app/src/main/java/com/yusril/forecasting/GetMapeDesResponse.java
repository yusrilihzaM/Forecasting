package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class GetMapeDesResponse{

	@SerializedName("data_mape_des")
	private double dataMapeDes;

	@SerializedName("status")
	private boolean status;

	public void setDataMapeDes(double dataMapeDes){
		this.dataMapeDes = dataMapeDes;
	}

	public double getDataMapeDes(){
		return dataMapeDes;
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
			"GetMapeDesResponse{" + 
			"data_mape_des = '" + dataMapeDes + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}