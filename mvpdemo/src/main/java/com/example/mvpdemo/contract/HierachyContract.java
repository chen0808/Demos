package com.example.mvpdemo.contract;

import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.TreeBean;
import com.example.mvpdemo.view.view.IBaseView;

import java.util.List;

import retrofit.Call;

/**
 * 作者：陈飞
 * 时间：2019/09/16 14:26
 */
public interface HierachyContract {
    interface Model {
        Call<BaseBean<List<TreeBean>>> tree();
    }

    interface View extends IBaseView {
        void onSuccess(List<TreeBean> data);
    }

    interface Presenter {
        void tree();
    }
}
