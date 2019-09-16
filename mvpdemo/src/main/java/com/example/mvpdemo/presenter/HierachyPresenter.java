package com.example.mvpdemo.presenter;

import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.TreeBean;
import com.example.mvpdemo.contract.HierachyContract;
import com.example.mvpdemo.model.HierachyModel;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 作者：陈飞
 * 时间：2019/09/16 14:26
 */
public class HierachyPresenter extends BasePresenter<HierachyContract.View> implements HierachyContract.Presenter {

    private final HierachyModel model;

    public HierachyPresenter() {
        model = new HierachyModel();
    }

    @Override
    public void tree() {
        mView.showLoading();
        model.tree().enqueue(new Callback<BaseBean<List<TreeBean>>>() {
            @Override
            public void onResponse(Response<BaseBean<List<TreeBean>>> response, Retrofit retrofit) {
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
