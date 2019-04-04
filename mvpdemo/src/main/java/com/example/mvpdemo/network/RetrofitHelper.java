package com.example.mvpdemo.network;

import android.content.Context;

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
    private final Context mContext;
    OkHttpClient client = new OkHttpClient();
    private Retrofit mRetrofit;
    private GsonConverterFactory factory=GsonConverterFactory.create(new GsonBuilder().create());

    public static synchronized RetrofitHelper getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitHelper(context);
        }
        return instance;
    }

    private RetrofitHelper(Context context){
        mContext =context;
        init();
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
