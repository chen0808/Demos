package com.example.mvpdemo.view.view;

public interface IBaseView {
    void showLoading();

    void hideLoading();

    void onError(String error);

//    /**
//     * 绑定Android生命周期 防止RxJava内存泄漏
//     *
//     * @param <T>
//     * @return
//     */
//    <T> AutoDisposeConverter<T> bindAutoDispose();
}
