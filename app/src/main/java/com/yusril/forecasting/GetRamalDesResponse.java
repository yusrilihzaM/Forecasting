package com.yusril.forecasting;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetRamalDesResponse{

	@SerializedName("data_ramal_des")
	private List<DataRamalDesItem> dataRamalDes;

	@SerializedName("status")
	private boolean status;

	public void setDataRamalDes(List<DataRamalDesItem> dataRamalDes){
		this.dataRamalDes = dataRamalDes;
	}

	public List<DataRamalDesItem> getDataRamalDes(){
		return dataRamalDes;
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
			"GetRamalDesResponse{" + 
			"data_ramal_des = '" + dataRamalDes + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}