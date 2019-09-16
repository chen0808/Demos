package com.example.mvpdemo.contract;

import com.example.mvpdemo.bean.ArticleBean;
import com.example.mvpdemo.bean.BannerBean;
import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.DatasBean;
import com.example.mvpdemo.view.view.IBaseView;

import java.util.List;

import retrofit.Call;
import retrofit.http.Path;

/**
 * 作者：陈飞
 * 时间：2019/09/16 13:49
 */
public interface MainPageContract {
    interface Model {
        Call<BaseBean<List<BannerBean>>> banner();

        Call<BaseBean<ArticleBean<DatasBean>>> mainList(
                @Path("page") int page);
    }

    interface View extends IBaseView {
        void onBannerSuccess(List<BannerBean> bean);

        void onMainSuccess(List<DatasBean> bean);
    }

    interface Presenter {
        void banner();

        void mainList(int page);
    }
}
