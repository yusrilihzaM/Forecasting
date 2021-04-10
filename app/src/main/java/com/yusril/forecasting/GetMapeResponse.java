package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class GetMapeResponse{

	@SerializedName("status_mape_ses")
	private boolean statusMapeSes;

	@SerializedName("data_mape_ses")
	private double dataMapeSes;

	public void setStatusMapeSes(boolean statusMapeSes){
		this.statusMapeSes = statusMapeSes;
	}

	public boolean isStatusMapeSes(){
		return statusMapeSes;
	}

	public void setDataMapeSes(double dataMapeSes){
		this.dataMapeSes = dataMapeSes;
	}

	public double getDataMapeSes(){
		return dataMapeSes;
	}

	@Override
 	public String toString(){
		return 
			"GetMapeResponse{" + 
			"status_mape_ses = '" + statusMapeSes + '\'' + 
			",data_mape_ses = '" + dataMapeSes + '\'' + 
			"}";
		}
}