package com.yusril.forecasting;

import com.google.gson.annotations.SerializedName;

public class DataAlphaItem{

	@SerializedName("alpha")
	private String alpha;

	@SerializedName("id_alpha")
	private String idAlpha;

	public void setAlpha(String alpha){
		this.alpha = alpha;
	}

	public String getAlpha(){
		return alpha;
	}

	public void setIdAlpha(String idAlpha){
		this.idAlpha = idAlpha;
	}

	public String getIdAlpha(){
		return idAlpha;
	}

	@Override
 	public String toString(){
		return 
			"DataAlphaItem{" + 
			"alpha = '" + alpha + '\'' + 
			",id_alpha = '" + idAlpha + '\'' + 
			"}";
		}
}