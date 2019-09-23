package com.example.mvpdemo.view.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.UserBean;
import com.example.mvpdemo.contract.LoginContract;
import com.example.mvpdemo.presenter.LoginPresenter;
import com.example.mvpdemo.utils.LoadingUtils;
import com.example.mvpdemo.utils.SPUtils;
import com.example.mvpdemo.utils.ToastUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.wang.avi.indicators.PacmanIndicator;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_username)
    TextInputEditText etUsername;
    @BindView(R.id.et_password)
    TextInputEditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    private LoginPresenter mPresenter;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);

    }

    @Override
    protected void inidData() {

    }

    @Override
    protected void destory() {
        mPresenter.detachView();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        mPresenter.login(getUsername(), getPassword());
    }

    @Override
    public String getUsername() {
        return Objects.requireNonNull(etUsername.getText()).toString();
    }

    @Override
    public String getPassword() {
        return Objects.requireNonNull(etPassword.getText()).toString();
    }

    @Override
    public void onSuccess(BaseBean<UserBean> userBean) {
        SPUtils.saveUsername(userBean.getData().getUsername());
        SPUtils.savePassword(userBean.getData().getPassword());

        final int width = ivBg.getMeasuredWidth();
        final int height = ivBg.getMeasuredHeight();
        final float radius = (float) Math.sqrt(width * width + height * height);
        Animator animator = ViewAnimationUtils.createCircularReveal(ivBg, width / 2, height / 2, radius, 0);
        animator.setDuration(3000);
        animator.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

    }

    @Override
    public void showLoading() {
        LoadingUtils.show(this, new PacmanIndicator());
    }

    @Override
    public void hideLoading() {
        LoadingUtils.hide();
    }

    @Override
    public void onError(String error) {
        ToastUtils.show(this, error);
    }
}
