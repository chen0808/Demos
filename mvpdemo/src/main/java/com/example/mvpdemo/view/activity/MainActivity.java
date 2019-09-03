package com.example.mvpdemo.view.activity;

import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mvpdemo.R;
import com.example.mvpdemo.view.fragment.BaseFragment;
import com.example.mvpdemo.view.fragment.HierarchyFragment;
import com.example.mvpdemo.view.fragment.MainFragment;
import com.example.mvpdemo.view.fragment.NavigationFragment;
import com.example.mvpdemo.view.fragment.ProjectFragment;
import com.example.mvpdemo.view.fragment.PublicNumFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：陈飞
 * 时间：2019/08/26 16:42
 */
public class MainActivity extends BaseActivity {


    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.navigationView)
    NavigationView navigationView;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    private List<BaseFragment> fragments;
    private int mLastFgIndex;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initDrawlayout();
        initFragment();
        initBottomNavigationView();
    }


    @Override
    protected void inidData() {

    }

    private void initDrawlayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
                //获取抽屉的view
                View mContent = drawerLayout.getChildAt(0);
                float scale = 1 - slideOffset;
                float endScale = 0.8f + scale * 0.2f;
                float startScale = 1 - 0.3f * scale;

                //设置左边菜单滑动后的占据屏幕大小
                drawerView.setScaleX(startScale);
                drawerView.setScaleY(startScale);
                //设置菜单透明度
                drawerView.setAlpha(0.6f + 0.4f * (1 - scale));

                //设置内容界面水平和垂直方向偏转量
                //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
                mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
                //设置内容界面操作无效（比如有button就会点击无效）
                mContent.invalidate();
                //设置右边菜单滑动后的占据屏幕大小
                mContent.setScaleX(endScale);
                mContent.setScaleY(endScale);
            }
        };
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new HierarchyFragment());
        fragments.add(new PublicNumFragment());
        fragments.add(new NavigationFragment());
        fragments.add(new ProjectFragment());
        switchFragment(0);
    }

    private void initBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.tab_one:
                            switchFragment(0);
                            break;
                        case R.id.tab_two:
                            switchFragment(1);
                            break;
                        case R.id.tab_three:
                            switchFragment(2);
                            break;
                        case R.id.tab_four:
                            switchFragment(3);
                            break;
                        case R.id.tab_five:
                            switchFragment(4);
                            break;
                    }
                    return true;
                }
        );
    }

    private void switchFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment targetFg = fragments.get(index);
        Fragment lastFg = fragments.get(mLastFgIndex);
        mLastFgIndex = index;
        ft.hide(lastFg);
        if (!targetFg.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(targetFg).commitAllowingStateLoss();
            ft.add(R.id.fl_container, targetFg);
        }
        ft.show(targetFg);
        ft.commitAllowingStateLoss();
    }
}
