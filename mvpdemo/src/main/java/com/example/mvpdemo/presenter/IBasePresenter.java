package com.example.mvpdemo.presenter;

import com.example.mvpdemo.view.view.IBaseView;

public interface IBasePresenter {
    void onAttachView(IBaseView view);

    void onCreate();
}
