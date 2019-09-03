package com.example.mvpdemo.view.view;

import com.example.mvpdemo.model.BaseBean;
import com.example.mvpdemo.model.UserBean;

public interface ILoginView extends IBaseView {
    void onSuccess(BaseBean<UserBean> userBean);
}
