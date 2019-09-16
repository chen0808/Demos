package com.example.mvpdemo.contract;

import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.UserBean;
import com.example.mvpdemo.view.view.IBaseView;

import retrofit.Call;

/**
 * 作者：陈飞
 * 时间：2019/09/16 09:11
 */
public interface LoginContract {
    interface Model {
        Call<BaseBean<UserBean>> login(String username, String password);
    }

    interface View extends IBaseView {
        String getUsername();

        String getPassword();

        void onSuccess(BaseBean<UserBean> userBean);
    }

    interface Presenter {
        void login(String username, String password);
    }
}
