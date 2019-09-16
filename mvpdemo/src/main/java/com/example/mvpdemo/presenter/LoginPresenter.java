package com.example.mvpdemo.presenter;

import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.UserBean;
import com.example.mvpdemo.contract.LoginContract;
import com.example.mvpdemo.model.LoginModel;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    private final LoginModel mModel;

    public LoginPresenter() {
        mModel = new LoginModel();
    }

    @Override
    public void login(String username, String password) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mModel.login(username, password).enqueue(new Callback<BaseBean<UserBean>>() {
            @Override
            public void onResponse(Response<BaseBean<UserBean>> response, Retrofit retrofit) {
                mView.hideLoading();
                mView.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                mView.hideLoading();
                mView.onError(t.getMessage());
            }
        });
    }
}
