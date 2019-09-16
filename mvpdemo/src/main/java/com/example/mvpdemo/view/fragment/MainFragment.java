package com.example.mvpdemo.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvpdemo.R;
import com.example.mvpdemo.bean.BannerBean;
import com.example.mvpdemo.bean.DatasBean;
import com.example.mvpdemo.contract.MainPageContract;
import com.example.mvpdemo.presenter.MainPagePresenter;
import com.example.mvpdemo.utils.LoadingUtils;
import com.example.mvpdemo.utils.ToastUtils;
import com.example.mvpdemo.view.activity.WebActivity;
import com.example.mvpdemo.view.adapter.MainAdapter;
import com.wang.avi.indicators.PacmanIndicator;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/**
 * 作者：陈飞
 * 时间：2019/08/28 14:39
 */
public class MainFragment extends BaseFragment implements MainPageContract.View {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    private MainPagePresenter presenter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view) {
        presenter = new MainPagePresenter();
        presenter.attachView(this);

        banner = view.findViewById(R.id.banner);
        rvMain = view.findViewById(R.id.rv_main);
    }

    @Override
    protected void inidData() {
//        ButterKnife.bind(getActivity());
        presenter.banner();
        presenter.mainList(0);
    }

    @Override
    protected void destory() {
        presenter.detachView();
    }

    @Override
    public void onBannerSuccess(List<BannerBean> bean) {
        List<String> imageUrls = new ArrayList<>();
        for (int i = 0; i < bean.size(); i++) {
            imageUrls.add(bean.get(i).getImagePath());
        }
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        banner.setImages(imageUrls);
        banner.start();
    }

    @Override
    public void onMainSuccess(List<DatasBean> bean) {
        rvMain.setLayoutManager(new LinearLayoutManager(getActivity()));
        MainAdapter adapter = new MainAdapter(R.layout.item_main, bean);
        rvMain.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            Intent intent = new Intent(getActivity(), WebActivity.class);
            intent.putExtra("url", bean.get(position).getLink());
            startActivity(intent);
        });
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
