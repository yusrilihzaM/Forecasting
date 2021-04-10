package com.yusril.forecasting;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetHasilDesResponse extends DataDesItem {

	@SerializedName("data_des")
	private List<DataDesItem> dataDes;

	@SerializedName("status")
	private boolean status;

	public void setDataDes(List<DataDesItem> dataDes){
		this.dataDes = dataDes;
	}

	public List<DataDesItem> getDataDes(){
		return dataDes;
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
			"GetHasilDesResponse{" + 
			"data_des = '" + dataDes + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}