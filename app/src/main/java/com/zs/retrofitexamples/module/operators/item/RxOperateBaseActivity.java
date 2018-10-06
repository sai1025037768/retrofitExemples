package com.zs.retrofitexamples.module.operators.item;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.zs.retrofitexamples.R;
import com.zs.retrofitexamples.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Administrator
 * @name RetrofitExamples
 * @time 2018/9/28 14:59
 * @class describe
 */
public abstract class RxOperateBaseActivity extends ToolbarBaseActivity {

    @BindView(R.id.rx_operators_btn)
    protected Button mRxOperatorsBtn;

    @BindView(R.id.rx_operators_text)
    protected TextView mRxOperatorsText;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_rx_operator_base;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @OnClick(R.id.rx_operators_btn)
    public void onViewClick(){
        mRxOperatorsText.append("\n");
        doSomething();
    }

    protected abstract void doSomething();
}
