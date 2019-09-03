package com.example.mvpdemo.network;

import android.content.Context;

import com.example.mvpdemo.model.ArticleBean;
import com.example.mvpdemo.model.BaseBean;
import com.example.mvpdemo.model.DatasBean;
import com.example.mvpdemo.model.UserBean;

import retrofit.Call;

public class DataManager {

    /**
     * 接口都写在这里
     */
    private RetrofitService mRetrofitService;

    public DataManager(Context context) {
        mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    public Call<BaseBean<UserBean>> login(String username, String password) {
        return mRetrofitService.login(username, password);
    }

    public Call<BaseBean<ArticleBean<DatasBean>>> mainList(int page) {
        return mRetrofitService.mainList(page);
    }
}
