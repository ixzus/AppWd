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
    private TextView tv_add;
    private SuperButton btn_add;
    private TextView tv_open;
    private SuperButton btn_open;
    private ConstraintLayout cl_top;
    private TextView tv_limit;
    private TextView tv_subLimit;
    private Guideline guide;
    private SuperButton btn_do;
    private CheckBox checkbox;
    private TextView tv_protocol;
    private TextView tv_doc;
    private TextView tv_line;
    private TextView issus;
    private Guideline guideline;
    private TextView tv_effcient;
    private TextView tv_safety;
    private TextView tv_free;
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
        tv_add = rootView.findViewById(R.id.tv_add);
        btn_add = rootView.findViewById(R.id.btn_add);
        tv_open = rootView.findViewById(R.id.tv_open);
        btn_open = rootView.findViewById(R.id.btn_open);
        cl_top = rootView.findViewById(R.id.cl_top);
        tv_limit = rootView.findViewById(R.id.tv_limit);
        tv_subLimit = rootView.findViewById(R.id.tv_subLimit);
        guide = rootView.findViewById(R.id.guide);
        btn_do = rootView.findViewById(R.id.btn_do);
        checkbox = rootView.findViewById(R.id.checkbox);
        tv_protocol = rootView.findViewById(R.id.tv_protocol);
        tv_doc = rootView.findViewById(R.id.tv_doc);
        tv_line = rootView.findViewById(R.id.tv_line);
        issus = rootView.findViewById(R.id.issus);
        guideline = rootView.findViewById(R.id.guideline);
        tv_effcient = rootView.findViewById(R.id.tv_effcient);
        tv_safety = rootView.findViewById(R.id.tv_safety);
        tv_free = rootView.findViewById(R.id.tv_free);
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
