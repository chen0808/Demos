package com.example.mvpdemo.model;

import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.UserBean;
import com.example.mvpdemo.contract.LoginContract;
import com.example.mvpdemo.network.RetrofitHelper;

import retrofit.Call;

/**
 * 作者：陈飞
 * 时间：2019/09/16 10:35
 */
public class LoginModel implements LoginContract.Model {

    @Override
    public Call<BaseBean<UserBean>> login(String username, String password) {
        return RetrofitHelper.getInstance().getServer().login(username, password);
    }
}
