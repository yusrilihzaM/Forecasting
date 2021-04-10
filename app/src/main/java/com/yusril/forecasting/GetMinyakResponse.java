package com.yusril.forecasting;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetMinyakResponse{

	@SerializedName("status")
	private boolean status;

	@SerializedName("data_minyak")
	private List<DataMinyakItem> dataMinyak;

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setDataMinyak(List<DataMinyakItem> dataMinyak){
		this.dataMinyak = dataMinyak;
	}

	public List<DataMinyakItem> getDataMinyak(){
		return dataMinyak;
	}

	@Override
 	public String toString(){
		return 
			"GetMinyakResponse{" + 
			"status = '" + status + '\'' + 
			",data_minyak = '" + dataMinyak + '\'' + 
			"}";
		}
}