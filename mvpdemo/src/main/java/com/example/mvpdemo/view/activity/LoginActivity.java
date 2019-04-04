package com.example.mvpdemo.view.activity;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.LoginBean;
import com.example.mvpdemo.presenter.LoginPresenter;
import com.example.mvpdemo.view.view.ILoginView;

public class LoginActivity extends BaseActivity {

    private LoginPresenter mPresenter = new LoginPresenter(this);

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mPresenter.onAttachView(mLoginView);
    }

    @Override
    protected void inidData() {
        mPresenter.login("aaa", "bbb");
    }

    private ILoginView mLoginView = new ILoginView() {
        @Override
        public void onSuccess(LoginBean loginBean) {

        }

        @Override
        public void onError(String result) {

        }
    };
}
