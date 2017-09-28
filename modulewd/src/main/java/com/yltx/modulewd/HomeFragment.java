package com.yltx.modulewd;


import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.allen.library.SuperButton;
import com.yltx.modulebase.base.BaseFragment;
import com.yltx.modulewd.borrow.lsit.ListActivity;


public class HomeFragment extends BaseFragment {
    public TextView tv_add;
    public SuperButton btn_add;
    public TextView tv_open;
    public SuperButton btn_open;
    public ConstraintLayout cl_top;
    public TextView tv_limit;
    public TextView tv_subLimit;
    public Guideline guide;
    public SuperButton btn_do;
    public CheckBox checkbox;
    public TextView tv_protocol;
    public TextView tv_doc;
    public TextView tv_line;
    public TextView issus;
    public Guideline guideline;
    public TextView tv_effcient;
    public TextView tv_safety;
    public TextView tv_free;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void fetchData() {

    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        tv_add = mContext.findViewById(R.id.tv_add);
        btn_add = mContext.findViewById(R.id.btn_add);
        tv_open = mContext.findViewById(R.id.tv_open);
        btn_open = mContext.findViewById(R.id.btn_open);
        cl_top = mContext.findViewById(R.id.cl_top);
        tv_limit = mContext.findViewById(R.id.tv_limit);
        tv_subLimit = mContext.findViewById(R.id.tv_subLimit);
        guide = mContext.findViewById(R.id.guide);
        btn_do = mContext.findViewById(R.id.btn_do);
        checkbox = mContext.findViewById(R.id.checkbox);
        tv_protocol = mContext.findViewById(R.id.tv_protocol);
        tv_doc = mContext.findViewById(R.id.tv_doc);
        tv_line = mContext.findViewById(R.id.tv_line);
        issus = mContext.findViewById(R.id.issus);
        guideline = mContext.findViewById(R.id.guideline);
        tv_effcient = mContext.findViewById(R.id.tv_effcient);
        tv_safety = mContext.findViewById(R.id.tv_safety);
        tv_free = mContext.findViewById(R.id.tv_free);
        status(UserCaStatus.USER_CA);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    btn_do.setEnabled(true);
                } else {
                    btn_do.setEnabled(false);
                }
            }
        });
        btn_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, ListActivity.class));
            }
        });
    }

    @Override
    protected void initData() {

    }

    private void status(String status) {
        switch (status) {
            case UserCaStatus.USER_CA:
                cl_top.setVisibility(View.GONE);
                checkbox.setVisibility(View.GONE);
                tv_protocol.setVisibility(View.GONE);
                break;
            case UserCaStatus.USER_ALI:
                cl_top.setVisibility(View.GONE);
                checkbox.setVisibility(View.VISIBLE);
                tv_protocol.setVisibility(View.VISIBLE);
                break;
            case UserCaStatus.USER_BANK:
                checkbox.setVisibility(View.GONE);
                tv_protocol.setVisibility(View.GONE);
                cl_top.setVisibility(View.VISIBLE);
                tv_add.setVisibility(View.VISIBLE);
                btn_add.setVisibility(View.VISIBLE);
                tv_open.setVisibility(View.GONE);
                btn_open.setVisibility(View.GONE);
                break;
            case UserCaStatus.USER_VIP:
                checkbox.setVisibility(View.GONE);
                tv_protocol.setVisibility(View.GONE);
                cl_top.setVisibility(View.VISIBLE);
                tv_add.setVisibility(View.GONE);
                btn_add.setVisibility(View.GONE);
                tv_open.setVisibility(View.VISIBLE);
                btn_open.setVisibility(View.VISIBLE);
                break;
        }

    }


}
