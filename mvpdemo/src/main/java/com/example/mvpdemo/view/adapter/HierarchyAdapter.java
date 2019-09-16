package com.example.mvpdemo.view.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mvpdemo.R;
import com.example.mvpdemo.bean.TreeBean;

import java.util.List;

/**
 * 作者：陈飞
 * 时间：2019/09/09 15:47
 */
public class HierarchyAdapter extends BaseQuickAdapter<TreeBean, BaseViewHolder> {

    public HierarchyAdapter(int layoutResId, @Nullable List<TreeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, TreeBean item) {
        StringBuilder desc = new StringBuilder();
        for (TreeBean.ChildrenBean child : item.getChildren()) {
            desc.append(child.getName());
        }
        helper.setText(R.id.tv_title, item.getName())
                .setText(R.id.tv_content, desc.toString());
    }
}
