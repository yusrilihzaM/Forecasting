package com.yusril.forecasting;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AlphaResponse{

	@SerializedName("data_alpha")
	private List<DataAlphaItem> dataAlpha;

	@SerializedName("status")
	private boolean status;

	public void setDataAlpha(List<DataAlphaItem> dataAlpha){
		this.dataAlpha = dataAlpha;
	}

	public List<DataAlphaItem> getDataAlpha(){
		return dataAlpha;
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
			"AlphaResponse{" + 
			"data_alpha = '" + dataAlpha + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}