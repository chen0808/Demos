package com.example.mvpdemo.contract;

import com.example.mvpdemo.bean.BaseBean;
import com.example.mvpdemo.bean.DatasBean;
import com.example.mvpdemo.bean.NavigationBean;
import com.example.mvpdemo.view.view.IBaseView;

import java.util.List;

import retrofit.Call;

/**
 * 作者：陈飞
 * 时间：2019/09/16 15:54
 */
public interface NavigationContract {
    interface Model {
        Call<BaseBean<List<NavigationBean<DatasBean>>>> navitation();
    }

    interface View extends IBaseView {
        void onSuccess(List<NavigationBean<DatasBean>> data);
    }

    interface Presenter {
        void navitation();
    }
}
