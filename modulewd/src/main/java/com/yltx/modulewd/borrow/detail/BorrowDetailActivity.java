package com.yltx.modulewd.borrow.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.allen.library.SuperButton;
import com.yltx.modulebase.base.BaseActivity;
import com.yltx.modulewd.R;

public class BorrowDetailActivity extends BaseActivity {
    public TextView toolbar_title;
    public TextView toolbar_subtitle;
    public TextView tv_title;
    public TextView tv_title_money;
    public ImageView iv_status;
    public TextView tv_title_status;
    public TextView tv_no_title;
    public TextView tv_no;
    public TextView tv_money_title;
    public TextView tv_money;
    public TextView tv_status_title;
    public TextView tv_status;
    public TextView tv_cycle_time_title;
    public TextView tv_cycle_time;
    public TextView tv_cycle_time_detail;
    public TextView tv_start_time_title;
    public TextView tv_start_time;
    public TextView tv_end_time_title;
    public TextView tv_end_time;
    public TextView tv_tip_title;
    public TextView tv_tip;
    public TextView tv_overdue_title;
    public TextView tv_overdue;
    public TextView tv_fine_title;
    public TextView tv_fine;
    public TextView tv_bank_title;
    public TextView tv_bank;
    public TextView tv_remark_title;
    public TextView tv_remark;
    public SuperButton btn_do;
    public TextView tv_doc;
    public TextView tv_line;
    public TextView issus;


    @Override
    protected int initLayout() {
        return R.layout.activity_borrow_detail;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        initToolBar(true, "借款详情", null);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_subtitle = (TextView) findViewById(R.id.toolbar_subtitle);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title_money = (TextView) findViewById(R.id.tv_title_money);
        iv_status = (ImageView) findViewById(R.id.iv_status);
        tv_title_status = (TextView) findViewById(R.id.tv_title_status);
        tv_no_title = (TextView) findViewById(R.id.tv_no_title);
        tv_no = (TextView) findViewById(R.id.tv_no);
        tv_money_title = (TextView) findViewById(R.id.tv_money_title);
        tv_money = (TextView) findViewById(R.id.tv_money);
        tv_status_title = (TextView) findViewById(R.id.tv_status_title);
        tv_status = (TextView) findViewById(R.id.tv_status);
        tv_cycle_time_title = (TextView) findViewById(R.id.tv_cycle_time_title);
        tv_cycle_time = (TextView) findViewById(R.id.tv_cycle_time);
        tv_cycle_time_detail = (TextView) findViewById(R.id.tv_cycle_time_detail);
        tv_start_time_title = (TextView) findViewById(R.id.tv_start_time_title);
        tv_start_time = (TextView) findViewById(R.id.tv_start_time);
        tv_end_time_title = (TextView) findViewById(R.id.tv_end_time_title);
        tv_end_time = (TextView) findViewById(R.id.tv_end_time);
        tv_tip_title = (TextView) findViewById(R.id.tv_tip_title);
        tv_tip = (TextView) findViewById(R.id.tv_tip);
        tv_overdue_title = (TextView) findViewById(R.id.tv_overdue_title);
        tv_overdue = (TextView) findViewById(R.id.tv_overdue);
        tv_fine_title = (TextView) findViewById(R.id.tv_fine_title);
        tv_fine = (TextView) findViewById(R.id.tv_fine);
        tv_bank_title = (TextView) findViewById(R.id.tv_bank_title);
        tv_bank = (TextView) findViewById(R.id.tv_bank);
        tv_remark_title = (TextView) findViewById(R.id.tv_remark_title);
        tv_remark = (TextView) findViewById(R.id.tv_remark);
        btn_do = (SuperButton) findViewById(R.id.btn_do);
        tv_doc = (TextView) findViewById(R.id.tv_doc);
        tv_line = (TextView) findViewById(R.id.tv_line);
        issus = (TextView) findViewById(R.id.issus);
        status(DetailStatus.BORROW_FAIL);
    }

    @Override
    protected void initData() {

    }

    private void status(String status) {
        switch (status) {
            case DetailStatus.FOR_LEND:
                iv_status.setVisibility(View.VISIBLE);
                iv_status.setImageResource(R.mipmap.ic_borrow_check);
                tv_title_status.setVisibility(View.VISIBLE);
                tv_title_status.setText(DetailStatus.FOR_LEND);
                tv_status.setText(DetailStatus.FOR_LEND);
                tv_status.setTextColor(ContextCompat.getColor(this, R.color.tvo));
                break;
            case DetailStatus.CHECK_PENDING:
                iv_status.setVisibility(View.VISIBLE);
                iv_status.setImageResource(R.mipmap.ic_borrow_check);
                tv_title_status.setVisibility(View.VISIBLE);
                tv_title_status.setText(DetailStatus.CHECK_PENDING);
                tv_status.setText(DetailStatus.CHECK_PENDING);
                tv_status.setTextColor(ContextCompat.getColor(this, R.color.tvo));
                break;
            case DetailStatus.LOAN:
                tv_title.setVisibility(View.VISIBLE);
                tv_title_money.setVisibility(View.VISIBLE);
                tv_title_money.setText("5000");
                tv_status.setText(DetailStatus.LOAN);
                tv_status.setTextColor(ContextCompat.getColor(this, R.color.base_color));
                btn_do.setVisibility(View.VISIBLE);
                btn_do.setText("提前还款");
                break;
            case DetailStatus.PAYOFF:
                iv_status.setVisibility(View.VISIBLE);
                iv_status.setImageResource(R.mipmap.ic_pay_off);
                tv_title_status.setVisibility(View.VISIBLE);
                tv_title_status.setText("本期借款已还清");
                tv_status.setText(DetailStatus.PAYOFF);
                tv_status.setTextColor(ContextCompat.getColor(this, R.color.tvo));
                break;
            case DetailStatus.OVERDUE:
                tv_title.setVisibility(View.VISIBLE);
                tv_title_money.setVisibility(View.VISIBLE);
                tv_title_money.setText("5000");
                tv_status.setText(DetailStatus.OVERDUE);
                tv_status.setTextColor(ContextCompat.getColor(this, R.color.tvred));
                btn_do.setVisibility(View.VISIBLE);
                btn_do.setText("立即还款");
                break;
            case DetailStatus.BORROW_FAIL:
                iv_status.setVisibility(View.VISIBLE);
                iv_status.setImageResource(R.mipmap.ic_borrow_fail);
                tv_title_status.setVisibility(View.VISIBLE);
                tv_title_status.setText(DetailStatus.BORROW_FAIL);
                tv_status.setText(DetailStatus.BORROW_FAIL);
                tv_status.setTextColor(ContextCompat.getColor(this, R.color.tvred));
                tv_remark_title.setVisibility(View.VISIBLE);
                tv_remark.setVisibility(View.VISIBLE);
                break;

        }
    }

}
