package com.example.mvpdemo.view.view;

import com.example.mvpdemo.model.LoginBean;
import com.example.mvpdemo.view.view.IBaseView;

public interface ILoginView extends IBaseView {
    void onSuccess(LoginBean loginBean);
}
