package com.example.mvpdemo.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.ArticleBean;
import com.example.mvpdemo.model.BaseBean;
import com.example.mvpdemo.model.DatasBean;
import com.example.mvpdemo.network.DataManager;
import com.example.mvpdemo.utils.ToastUtils;
import com.example.mvpdemo.view.adapter.MainAdapter;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 作者：陈飞
 * 时间：2019/08/28 14:39
 */
public class MainFragment extends BaseFragment {
    //    @BindView(R.id.rv_main)
    RecyclerView rvMain;

    @Override
    protected int initLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view) {
        rvMain = view.findViewById(R.id.rv_main);
    }

    @Override
    protected void inidData() {
        DataManager manager = new DataManager(getActivity());
        manager.mainList(0).enqueue(new Callback<BaseBean<ArticleBean<DatasBean>>>() {
            @Override
            public void onResponse(Response<BaseBean<ArticleBean<DatasBean>>> response, Retrofit retrofit) {
                BaseBean<ArticleBean<DatasBean>> bean = response.body();
                if (bean.getErrorCode() == 0) {
                    initRecyclerView(bean.getData().getDatas());
                } else {
                    ToastUtils.show(getActivity(), bean.getErrorMsg());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                ToastUtils.show(getActivity(), t.getMessage());
            }
        });
    }

    private void initRecyclerView(List<DatasBean> data) {
        rvMain.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMain.setAdapter(new MainAdapter(R.layout.item_main, data));
    }
}
