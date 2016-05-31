package com.weizhi.arrow.cashierdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.weizhi.arrow.cashierdemo.R;
import com.weizhi.arrow.cashierdemo.base.BaseActivity;

public class ZxingReceiverActivity extends BaseActivity {

    private TextView tv_zxing_receiver_back;
    private TextView tv_zxing_receiver_position;
    private TextView tv_zxing_receiver_gopay;
    private TextView tv_zxing_receiver_price;

    private String money_pay;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_zxing_receiver;
    }

    @Override
    protected void initView() {
        tv_zxing_receiver_back = (TextView) findViewById(R.id.tv_zxing_receiver_back);
        tv_zxing_receiver_position = (TextView) findViewById(R.id.tv_zxing_receiver_position);
        tv_zxing_receiver_gopay = (TextView) findViewById(R.id.tv_zxing_receiver_gopay);
        tv_zxing_receiver_price = (TextView) findViewById(R.id.tv_zxing_receiver_price);
    }

    @Override
    protected void setListener() {
        tv_zxing_receiver_back.setOnClickListener(this);
        tv_zxing_receiver_position.setOnClickListener(this);
        tv_zxing_receiver_gopay.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        money_pay = intent.getStringExtra("money_pay");
        Log.i(TAG, "------money_pay-----" + money_pay);
        tv_zxing_receiver_price.setText(money_pay);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_zxing_receiver_back:
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.tv_zxing_receiver_position:

                break;
            case R.id.tv_zxing_receiver_gopay:
                if (!TextUtils.isEmpty(money_pay)) {
                    ZxingPayActivity.launch(ZxingReceiverActivity.this, money_pay);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
                break;
        }
    }

    public static void launch(Context context, String money) {
        Intent intent = new Intent(context, ZxingReceiverActivity.class);
        intent.putExtra("money_pay", money);
        context.startActivity(intent);
    }
}
