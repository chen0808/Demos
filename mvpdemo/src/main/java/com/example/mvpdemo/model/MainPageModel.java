package com.example.mvpdemo.model;

import com.example.mvpdemo.bean.ArticleBean;
import com.example.mvpdemo.bean.BannerBean;
import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.DatasBean;
import com.example.mvpdemo.contract.MainPageContract;
import com.example.mvpdemo.network.RetrofitHelper;

import java.util.List;

import retrofit.Call;

/**
 * 作者：陈飞
 * 时间：2019/09/16 13:49
 */
public class MainPageModel implements MainPageContract.Model {

    @Override
    public Call<BaseBean<List<BannerBean>>> banner() {
        return RetrofitHelper.getInstance().getServer().banner();
    }

    @Override
    public Call<BaseBean<ArticleBean<DatasBean>>> mainList(int page) {
        return RetrofitHelper.getInstance().getServer().mainList(page);
    }
}
