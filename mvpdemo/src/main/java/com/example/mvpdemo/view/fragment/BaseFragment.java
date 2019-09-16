package com.example.mvpdemo.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = initLayout();
        View view = inflater.inflate(layoutId, container, false);
//        ButterKnife.bind(getActivity());
        initView(view);
        inidData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        destory();
    }

    protected abstract int initLayout();

    protected abstract void initView(View view);

    protected abstract void inidData();

    protected abstract void destory();
}
