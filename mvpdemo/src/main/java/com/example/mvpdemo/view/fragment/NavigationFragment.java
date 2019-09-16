package com.example.mvpdemo.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.bean.DatasBean;
import com.example.mvpdemo.bean.NavigationBean;
import com.example.mvpdemo.contract.NavigationContract;
import com.example.mvpdemo.presenter.NavigationPresenter;
import com.example.mvpdemo.utils.LoadingUtils;
import com.example.mvpdemo.utils.ToastUtils;
import com.wang.avi.indicators.PacmanIndicator;

import java.util.List;
import java.util.Objects;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * 作者：陈飞
 * 时间：2019/08/28 14:50
 */
public class NavigationFragment extends BaseFragment implements NavigationContract.View {

    private VerticalTabLayout tabLayout;
    private RecyclerView rvNavigation;
    private NavigationPresenter presenter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_navigation;
    }

    @Override
    protected void initView(View view) {
        tabLayout = view.findViewById(R.id.tablayout);
        rvNavigation = view.findViewById(R.id.rv_navigation);

        presenter = new NavigationPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void inidData() {
        presenter.navitation();
    }

    @Override
    protected void destory() {
        presenter.detachView();
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

    @Override
    public void onSuccess(List<NavigationBean<DatasBean>> data) {
        tabLayout.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                return new TabView.TabTitle.Builder()
                        .setContent(data.get(position).getName())
//                        .setTextColor(ContextCompat.getColor(_mActivity, R.color.shallow_green),
//                                ContextCompat.getColor(_mActivity, R.color.shallow_grey))
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });
    }
}
