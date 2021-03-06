package com.yltx.modulebase.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/18.
 */

public abstract class BaseMVPFragment<P extends BasePresenter> extends LazyFragment implements BaseContract.IBaseView {
    protected P presenter;
    protected String TAG;
    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (0 != initLayout()) {
            return inflater.inflate(initLayout(), container, false);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TAG = getActivity().getPackageName() + "." + getClass().getSimpleName();
        presenter = initPresenter();
        if (null != presenter) {
            presenter.attatch(initModule(), this);
        }
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected abstract P initPresenter();

    protected abstract BaseModel initModule();

    protected abstract
    @LayoutRes
    int initLayout();

    protected abstract void initView();

    protected abstract void initData();

}
