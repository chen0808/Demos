package com.example.mvpdemo.model;

import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.DatasBean;
import com.example.mvpdemo.bean.NavigationBean;
import com.example.mvpdemo.contract.NavigationContract;
import com.example.mvpdemo.network.RetrofitHelper;

import java.util.List;

import retrofit.Call;

/**
 * 作者：陈飞
 * 时间：2019/09/16 15:54
 */
public class NavigationModel implements NavigationContract.Model {
    @Override
    public Call<BaseBean<List<NavigationBean<DatasBean>>>> navitation() {
        return RetrofitHelper.getInstance().getServer().navitation();
    }
}
