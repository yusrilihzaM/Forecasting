package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class GetRamalSesResponse{

	@SerializedName("data_ramal_ses")
	private DataRamalSes dataRamalSes;

	@SerializedName("status")
	private boolean status;

	public void setDataRamalSes(DataRamalSes dataRamalSes){
		this.dataRamalSes = dataRamalSes;
	}

	public DataRamalSes getDataRamalSes(){
		return dataRamalSes;
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
			"GetRamalSesResponse{" + 
			"data_ramal_ses = '" + dataRamalSes + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}