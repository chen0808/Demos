package com.example.mvpdemo.presenter;

import com.example.mvpdemo.view.view.IBaseView;

/**
 * 作者：陈飞
 * 时间：2019/09/16 09:25
 */
public class BasePresenter<V extends IBaseView> {

    V mView;

    public void attachView(V view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
    }

    boolean isViewAttached() {
        return mView != null;
    }
}
