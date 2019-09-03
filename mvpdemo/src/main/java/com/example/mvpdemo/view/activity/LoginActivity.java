package com.example.mvpdemo.view.activity;

import android.content.Intent;
import android.widget.Button;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.BaseBean;
import com.example.mvpdemo.model.UserBean;
import com.example.mvpdemo.presenter.LoginPresenter;
import com.example.mvpdemo.utils.LoadingUtils;
import com.example.mvpdemo.utils.ToastUtils;
import com.example.mvpdemo.view.view.ILoginView;
import com.google.android.material.textfield.TextInputEditText;
import com.wang.avi.indicators.PacmanIndicator;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_username)
    TextInputEditText etUsername;
    @BindView(R.id.et_password)
    TextInputEditText etPassword;
    private LoginPresenter mPresenter = new LoginPresenter(this);
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mPresenter.onAttachView(mLoginView);
    }

    private ILoginView mLoginView = new ILoginView() {
        @Override
        public void onSuccess(BaseBean<UserBean> userBean) {
            LoadingUtils.hide();
            if (userBean.getErrorCode() == 0) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else {
                ToastUtils.show(LoginActivity.this, userBean.getErrorMsg());
            }
        }

        @Override
        public void onError(String error) {
            LoadingUtils.hide();
            ToastUtils.show(LoginActivity.this, error);
        }
    };

    @Override
    protected void inidData() {

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        LoadingUtils.show(this, new PacmanIndicator());
        mPresenter.login(etUsername.getText().toString(), etPassword.getText().toString());
    }
}
