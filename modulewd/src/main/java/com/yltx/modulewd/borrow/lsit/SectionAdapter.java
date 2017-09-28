package com.yltx.modulewd.borrow.lsit;

import android.view.View;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yltx.modulewd.R;

import java.util.List;

/**
 * 功能描述:
 * Created by ixzus on 2017/9/28.
 */

public class SectionAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder> {

    public SectionAdapter(int layoutResId, int sectionHeadResId, List<MySection> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MySection item) {
        helper.setText(R.id.rv_head_title, item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        helper.setText(R.id.tv_money, item.t.getInfo());
        helper.setText(R.id.tv_time, item.t.getInfo());
        helper.setText(R.id.tv_status, item.t.getInfo());
        helper.setChecked(R.id.cb_item, true);
        helper.getView(R.id.cb_item).setVisibility(View.GONE);
    }
}
