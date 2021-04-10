package com.yusril.forecasting;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface MainInterface {
    @GET("api/alpha")
    Call<AlphaResponse> getAlpha();
    @GET("api/dataminyak")
    Call<GetMinyakResponse> getMinyak();
    @FormUrlEncoded
    @PUT("api/alpha")
    Call<PutAlphaResponse> putAlpha(@Field("id") int id,
                                     @Field("alpha") Double alpha);
    @FormUrlEncoded
    @POST("api/dataminyak")
    Call<PostMinyakResponse> postdataminyak(
            @Field("tahun") int tahun,
            @Field("bulan") int bulan,
            @Field("jumlah_minyak") Double jumlah_minyak
    );
    @FormUrlEncoded
    @PUT("api/dataminyak")
    Call<PostMinyakResponse> putDataMinyak(
            @Field("id") int id_data_minyak,
            @Field("tahun") int tahun,
            @Field("bulan") int bulan,
            @Field("jumlah_minyak") Double jumlah_minyak
    );
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "api/dataminyak", hasBody = true)
    Call<DeleteMinyakResponse> DeleteMinyakResponse(@Field("id") String id);
    @GET("api/mapeses")
    Call<GetMapeResponse> getMAPESES();

    @GET("api/hasilhitungses")
    Call<HasilHitungSesResponse> getHasilHitungSes();
    @GET("api/ramalses")
    Call<GetRamalSesResponse> getHasilRamalSes();
    @GET("api/mapedes")
    Call<GetMapeDesResponse> getMAPEDES();
    @GET("api/hasilhitungdes")
    Call<GetHasilDesResponse> getHasilHitungDes();
    @GET("api/ramaldes")
    Call<GetRamalDesResponse> getHasilRamalDes();

    @FormUrlEncoded
    @POST("api/ramaldes")
    Call<PostRamalResponse> postramal(
            @Field("bulan") int bulan
    );
}
