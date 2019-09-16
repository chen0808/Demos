package com.example.mvpdemo.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.bean.TreeBean;
import com.example.mvpdemo.contract.HierachyContract;
import com.example.mvpdemo.presenter.HierachyPresenter;
import com.example.mvpdemo.utils.LoadingUtils;
import com.example.mvpdemo.utils.ToastUtils;
import com.example.mvpdemo.view.adapter.HierarchyAdapter;
import com.wang.avi.indicators.PacmanIndicator;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * 作者：陈飞
 * 时间：2019/08/28 14:39
 */
public class HierarchyFragment extends BaseFragment implements HierachyContract.View {


    @BindView(R.id.rv_hierarchy)
    RecyclerView rvHierarchy;
    private HierachyPresenter presenter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_hierarchy;
    }

    @Override
    protected void initView(View view) {
        presenter = new HierachyPresenter();
        presenter.attachView(this);

        rvHierarchy = view.findViewById(R.id.rv_hierarchy);
    }

    @Override
    protected void inidData() {
        presenter.tree();
    }

    @Override
    protected void destory() {
        presenter.detachView();
    }

    @Override
    public void onSuccess(List<TreeBean> data) {
        rvHierarchy.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvHierarchy.setAdapter(new HierarchyAdapter(R.layout.item_hierarchy, data));
    }

    @Override
    public void showLoading() {
        LoadingUtils.show(Objects.requireNonNull(getActivity()), new PacmanIndicator());
    }

    @Override
    public void hideLoading() {
        LoadingUtils.hide();
    }

    @Override
    public void onError(String error) {
        ToastUtils.show(getActivity(), error);
    }
}
