package com.yltx.modulewd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.yltx.modulebase.base.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity {
    private HomeFragment homeFragment;
    private MyFragment myFragment;
    private TextView main_home;
    private TextView main_my;
    private TextView toolbar_title;
    private TextView toolbar_subtitle;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        initToolBar(true, "小白卡", "借还记录");
        main_home = (TextView) findViewById(R.id.main_home);
        main_my = (TextView) findViewById(R.id.main_my);
        main_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectIndex(0);
            }
        });
        main_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectIndex(1);
            }
        });
        if (savedInstanceState != null) {
            List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
            for (Fragment fragment : fragmentList) {
                if (fragment instanceof HomeFragment) {
                    homeFragment = (HomeFragment) fragment;
                }
                if (fragment instanceof MyFragment) {
                    myFragment = (MyFragment) fragment;
                }
            }
        } else {
            homeFragment = HomeFragment.newInstance("", "");
            myFragment = MyFragment.newInstance("", "");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_frame, homeFragment);
            fragmentTransaction.add(R.id.main_frame, myFragment);
            fragmentTransaction.commit();
        }
        getSupportFragmentManager().beginTransaction()
                .show(homeFragment)
                .hide(myFragment)
                .commit();

    }

    @Override
    protected void initData() {

    }

    private void selectIndex(int index){
        switch(index){
            case 0:
                initToolBar(true, "小白卡", "借还记录");
                getSupportFragmentManager().beginTransaction()
                        .show(homeFragment)
                        .hide(myFragment)
                        .commit();
                break;
            case 1:
                initToolBar(false, "账户", null);
                getSupportFragmentManager().beginTransaction()
                        .show(myFragment)
                        .hide(homeFragment)
                        .commit();
                break;
        }
    }

}
