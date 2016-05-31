package com.weizhi.arrow.cashierdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.weizhi.arrow.cashierdemo.R;
import com.weizhi.arrow.cashierdemo.base.BaseActivity;

public class ZxingPayActivity extends BaseActivity {

    private TextView tv_zxing_pay_barcode;
    private TextView tv_zxing_pay_receiver;
    private TextView tv_zxing_pay_back;

    private String money;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_zxing_pay;
    }

    @Override
    protected void initView() {
        tv_zxing_pay_barcode = (TextView) findViewById(R.id.tv_zxing_pay_barcode);
        tv_zxing_pay_receiver = (TextView) findViewById(R.id.tv_zxing_pay_receiver);
        tv_zxing_pay_back = (TextView) findViewById(R.id.tv_zxing_pay_back);
    }

    @Override
    protected void setListener() {
        tv_zxing_pay_barcode.setOnClickListener(this);
        tv_zxing_pay_receiver.setOnClickListener(this);
        tv_zxing_pay_back.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        money = intent.getStringExtra("money");
        Log.i(TAG, "------money------" + money);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_zxing_pay_barcode:

                break;
            case R.id.tv_zxing_pay_receiver:
                if (money != null) {
                    ZxingReceiverActivity.launch(ZxingPayActivity.this, money);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
                break;
            case R.id.tv_zxing_pay_back:
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
        }
    }

    public static void launch(Context context, String money) {
        Intent intent = new Intent(context, ZxingPayActivity.class);
        intent.putExtra("money", money);
        context.startActivity(intent);
    }
}
