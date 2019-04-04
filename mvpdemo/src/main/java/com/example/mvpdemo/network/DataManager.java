package com.example.mvpdemo.network;

import android.content.Context;
import android.database.Observable;

import com.example.mvpdemo.model.LoginBean;

import retrofit.Call;

public class DataManager {

    /**
     * 接口都写在这里
     */
    private RetrofitService mRetrofitService;

    public DataManager(Context context) {
        mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    public Call<LoginBean> login(String username, String password) {
        return mRetrofitService.login("365EBFC20C6C42C6AA5F4F8BE89B6E12");
    }
}
