package com.example.mvpdemo.network;

import com.example.mvpdemo.model.LoginBean;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * 接口的路径和参数
 */
public interface RetrofitService {
    @GET("plan/month/detail")
    Call<LoginBean> login(
//            @Field("username")String username,
            @Query("id") String id
    );
}
