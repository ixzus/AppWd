package com.yltx.modulewd.borrow.lsit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.allen.library.SuperButton;
import com.yltx.modulebase.base.BaseFragment;
import com.yltx.modulewd.R;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends BaseFragment {
    private RecyclerView recyclerview;
    private CheckBox checkbox;
    private TextView tv_count;
    private TextView tv_total_count;
    private TextView tv_money;
    private SuperButton btn_do;
    private RelativeLayout rl_bottom;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private List<MySection> listData = new ArrayList<>();

    public ListFragment() {
    }

    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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
        return R.layout.fragment_list;
    }

    @Override
    protected void initView() {
        recyclerview = rootView.findViewById(R.id.recyclerview);
        checkbox = rootView.findViewById(R.id.checkbox);
        tv_count = rootView.findViewById(R.id.tv_count);
        tv_total_count = rootView.findViewById(R.id.tv_total_count);
        tv_money = rootView.findViewById(R.id.tv_money);
        btn_do = rootView.findViewById(R.id.btn_do);
        rl_bottom = rootView.findViewById(R.id.rl_bottom);
        if ("借款".equals(mParam1)) {
            rl_bottom.setVisibility(View.VISIBLE);
        } else {
            rl_bottom.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {
        recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        listData = getSampleData();
        SectionAdapter adapter = new SectionAdapter(R.layout.rv_list_item, R.layout.rv_list_head, listData);
        recyclerview.setAdapter(adapter);
    }

    public static List<MySection> getSampleData() {
        List<MySection> list = new ArrayList<>();
        list.add(new MySection(true, "2017年八月"));
        list.add(new MySection(new Record("借款2000")));
        list.add(new MySection(new Record("借款2000")));
        list.add(new MySection(new Record("借款2000")));
        list.add(new MySection(true, "2017年九月"));
        list.add(new MySection(new Record("借款3000")));
        list.add(new MySection(new Record("借款4000")));
        list.add(new MySection(new Record("借款5000")));
        list.add(new MySection(true, "2017年十月月"));
        list.add(new MySection(new Record("借款1000")));
        list.add(new MySection(new Record("借款2000")));
        list.add(new MySection(new Record("借款6000")));

        return list;
    }

    public void onButtonPressed(String status) {
        if (mListener != null) {
            mListener.onFragmentInteraction(status);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String status);
    }

}
