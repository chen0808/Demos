package com.example.mvpdemo.presenter;

import android.content.Context;

import com.example.mvpdemo.model.LoginBean;
import com.example.mvpdemo.network.DataManager;
import com.example.mvpdemo.view.view.IBaseView;
import com.example.mvpdemo.view.view.ILoginView;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginPresenter implements IBasePresenter {
    private Context mContext;
    private DataManager manager;
    private ILoginView mLoginView;

    public LoginPresenter(Context context) {
        mContext = context;
        manager = new DataManager(mContext);
    }


    @Override
    public void onAttachView(IBaseView view) {
        mLoginView = (ILoginView) view;
    }

    @Override
    public void onCreate() {

    }

    public void login(String username, String password) {
        manager.login(username, password).enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Response<LoginBean> response, Retrofit retrofit) {
                mLoginView.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                mLoginView.onError(t.getMessage());
            }
        });
    }
}
