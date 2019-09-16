package com.example.mvpdemo.presenter;

import com.example.mvpdemo.bean.ArticleBean;
import com.example.mvpdemo.bean.BannerBean;
import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.DatasBean;
import com.example.mvpdemo.contract.MainPageContract;
import com.example.mvpdemo.model.MainPageModel;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 作者：陈飞
 * 时间：2019/09/16 13:49
 */
public class MainPagePresenter extends BasePresenter<MainPageContract.View> implements MainPageContract.Presenter {


    private final MainPageModel model;

    public MainPagePresenter() {
        model = new MainPageModel();
    }

    @Override
    public void banner() {
        mView.showLoading();
        model.banner().enqueue(new Callback<BaseBean<List<BannerBean>>>() {
            @Override
            public void onResponse(Response<BaseBean<List<BannerBean>>> response, Retrofit retrofit) {
                mView.hideLoading();
                mView.onBannerSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Throwable t) {
                mView.hideLoading();
                mView.onError(t.getMessage());
            }
        });
    }

    @Override
    public void mainList(int page) {
//        mView.showLoading();
        model.mainList(0).enqueue(new Callback<BaseBean<ArticleBean<DatasBean>>>() {
            @Override
            public void onResponse(Response<BaseBean<ArticleBean<DatasBean>>> response, Retrofit retrofit) {
                mView.hideLoading();
                mView.onMainSuccess(response.body().getData().getDatas());
            }

            @Override
            public void onFailure(Throwable t) {
                mView.hideLoading();
                mView.onError(t.getMessage());
            }
        });
    }
}
