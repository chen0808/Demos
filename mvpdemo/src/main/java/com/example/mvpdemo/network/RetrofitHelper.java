package com.example.mvpdemo.network;

import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * 初始化
 */
public class RetrofitHelper {
    private static RetrofitHelper instance;
    private OkHttpClient client = new OkHttpClient();
    private Retrofit mRetrofit;
    private GsonConverterFactory factory=GsonConverterFactory.create(new GsonBuilder().create());

    private RetrofitHelper() {
        init();
    }

    public static synchronized RetrofitHelper getInstance() {
        if (instance == null) {
            instance = new RetrofitHelper();
        }
        return instance;
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
       mRetrofit=new Retrofit.Builder()
               .baseUrl(ApiService.BASE_URL)
               .client(client)
               .addConverterFactory(factory)
               .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
               .build();
    }

    public RetrofitService getServer(){
        return mRetrofit.create(RetrofitService.class);
    }
}
