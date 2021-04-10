package com.yusril.forecasting;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HasilHitungSesResponse{

	@SerializedName("data_ses")
	private List<DataSesItem> dataSes;

	@SerializedName("status")
	private boolean status;

	public void setDataSes(List<DataSesItem> dataSes){
		this.dataSes = dataSes;
	}

	public List<DataSesItem> getDataSes(){
		return dataSes;
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
			"HasilHitungSesResponse{" + 
			"data_ses = '" + dataSes + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}