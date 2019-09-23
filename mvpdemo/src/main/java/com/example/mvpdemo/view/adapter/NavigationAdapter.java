package com.example.mvpdemo.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mvpdemo.R;
import com.example.mvpdemo.bean.DatasBean;
import com.example.mvpdemo.bean.NavigationBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

/**
 * 作者：陈飞
 * 时间：2019/09/17 09:09
 */
public class NavigationAdapter extends BaseQuickAdapter<NavigationBean<DatasBean>, BaseViewHolder> {

    public NavigationAdapter(int layoutResId, @Nullable List<NavigationBean<DatasBean>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, NavigationBean<DatasBean> item) {
        helper.setText(R.id.tv, item.getName());
        TagFlowLayout flowLayout = helper.getView(R.id.flow_layout);
        flowLayout.setAdapter(new TagAdapter<DatasBean>(item.getArticles()) {
            @Override
            public View getView(FlowLayout parent, int position, DatasBean datasBean) {
                View view = LayoutInflater.from(mContext).inflate(R.layout.item_text, parent, false);
                TextView tv = view.findViewById(R.id.tv);
                tv.setText(datasBean.getTitle());
                return view;
            }
        });
    }
}
