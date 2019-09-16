package com.example.mvpdemo.model;

import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.TreeBean;
import com.example.mvpdemo.contract.HierachyContract;
import com.example.mvpdemo.network.RetrofitHelper;

import java.util.List;

import retrofit.Call;

/**
 * 作者：陈飞
 * 时间：2019/09/16 14:26
 */
public class HierachyModel implements HierachyContract.Model {

    @Override
    public Call<BaseBean<List<TreeBean>>> tree() {
        return RetrofitHelper.getInstance().getServer().tree();
    }
}
