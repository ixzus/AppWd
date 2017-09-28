package com.yltx.modulewd.borrow.lsit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.yltx.modulebase.base.BaseActivity;
import com.yltx.modulewd.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends BaseActivity implements ListFragment.OnFragmentInteractionListener{

    private TabLayout tablayout;
    private ViewPager viewpager;

    private ListFragment loanFragment;
    private ListFragment repaymentFragment;
    private List<Fragment> viewList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();


    @Override
    protected int initLayout() {
        return R.layout.activity_list;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        initToolBar(true, "借款记录", "筛选");
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        initFragment();
//        viewpager.setCurrentItem(0);
//        tablayout.getTabAt(0).select();
    }

    @Override
    protected void initData() {

    }

    private void initFragment() {
        viewList.clear();
        titleList.add("借款记录（0）");
        titleList.add("还款记录（0）");
        loanFragment = ListFragment.newInstance("借款", "");
        repaymentFragment = ListFragment.newInstance("还款", "");
        viewList.add(loanFragment);
        viewList.add(repaymentFragment);
        for (String str : titleList) {
            tablayout.addTab(tablayout.newTab().setText(str));
        }
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return viewList.get(position);
            }

            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        });

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                initToolBar(true, titleList.get(position), "筛选");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewpager.setOffscreenPageLimit(1);
        tablayout.setupWithViewPager(viewpager);
    }


    @Override
    public void onFragmentInteraction(String status) {

    }
}
