package com.example.mvpdemo.view.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mvpdemo.R;
import com.example.mvpdemo.model.DatasBean;

import java.util.List;

/**
 * 作者：陈飞
 * 时间：2019/08/28 16:04
 */
public class MainAdapter extends BaseQuickAdapter<DatasBean, BaseViewHolder> {

    public MainAdapter(int layoutResId, @Nullable List<DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DatasBean item) {
        helper.setText(R.id.tv_author, item.getAuthor())
                .setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_type, item.getSuperChapterName() + "/" + item.getChapterName())
                .setText(R.id.tv_date, item.getNiceDate());
    }
}
