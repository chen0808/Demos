package com.example.mvpdemo.presenter;

import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.DatasBean;
import com.example.mvpdemo.bean.NavigationBean;
import com.example.mvpdemo.contract.NavigationContract;
import com.example.mvpdemo.model.NavigationModel;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 作者：陈飞
 * 时间：2019/09/16 15:54
 */
public class NavigationPresenter extends BasePresenter<NavigationContract.View> implements NavigationContract.Presenter {

    private final NavigationModel model;

    public NavigationPresenter() {
        model = new NavigationModel();
    }

    @Override
    public void navitation() {
        mView.showLoading();
        model.navitation().enqueue(new Callback<BaseBean<List<NavigationBean<DatasBean>>>>() {
            @Override
            public void onResponse(Response<BaseBean<List<NavigationBean<DatasBean>>>> response, Retrofit retrofit) {
                mView.hideLoading();
                mView.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Throwable t) {
                mView.hideLoading();
                mView.onError(t.getMessage());
            }
        });
    }
}
