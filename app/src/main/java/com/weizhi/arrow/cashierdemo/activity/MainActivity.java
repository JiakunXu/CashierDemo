package com.weizhi.arrow.cashierdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weizhi.arrow.cashierdemo.R;
import com.weizhi.arrow.cashierdemo.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnLongClickListener {

    private TextView tv_one;
    private TextView tv_two;
    private TextView tv_three;
    private TextView tv_four;
    private TextView tv_five;
    private TextView tv_six;
    private TextView tv_seven;
    private TextView tv_eight;
    private TextView tv_nine;
    private TextView tv_zero;
    private TextView tv_point;
    private TextView tv_input_num;
    private LinearLayout ll_input_del;

    private StringBuffer buffer = new StringBuffer(6);

    private LinearLayout ll_cashier;
    private LinearLayout ll_zxing_pay;
    private LinearLayout ll_member_consume;
    private LinearLayout ll_more;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ll_cashier = (LinearLayout) findViewById(R.id.include_bottom).findViewById(R.id.ll_cashier);
        ll_zxing_pay = (LinearLayout) findViewById(R.id.include_bottom).findViewById(R.id.ll_zxing_pay);
        ll_member_consume = (LinearLayout) findViewById(R.id.include_bottom).findViewById(R.id.ll_member_consume);
        ll_more = (LinearLayout) findViewById(R.id.include_bottom).findViewById(R.id.ll_more);
        tv_one = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_one);
        tv_two = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_two);
        tv_three = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_three);
        tv_four = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_four);
        tv_five = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_five);
        tv_six = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_six);
        tv_seven = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_seven);
        tv_eight = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_eight);
        tv_nine = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_nine);
        tv_zero = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_zero);
        tv_point = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_point);
        tv_input_num = (TextView) findViewById(R.id.fl_content).findViewById(R.id.tv_input_num);
        ll_input_del = (LinearLayout) findViewById(R.id.fl_content).findViewById(R.id.ll_input_del);
        tv_input_num.setText("");

    }

    @Override
    protected void setListener() {
        ll_cashier.setOnClickListener(this);
        ll_zxing_pay.setOnClickListener(this);
        ll_member_consume.setOnClickListener(this);
        ll_more.setOnClickListener(this);

        tv_one.setOnClickListener(this);
        tv_two.setOnClickListener(this);
        tv_three.setOnClickListener(this);
        tv_four.setOnClickListener(this);
        tv_five.setOnClickListener(this);
        tv_six.setOnClickListener(this);
        tv_seven.setOnClickListener(this);
        tv_eight.setOnClickListener(this);
        tv_nine.setOnClickListener(this);
        tv_zero.setOnClickListener(this);
        tv_point.setOnClickListener(this);
        tv_input_num.setOnClickListener(this);
        ll_input_del.setOnClickListener(this);
        ll_input_del.setOnLongClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_zxing_pay:
                if (!TextUtils.isEmpty(tv_input_num.getText().toString())) {
                    ZxingPayActivity.launch(MainActivity.this, tv_input_num.getText().toString());
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }else{
                    Toast.makeText(MainActivity.this, "请输入金额", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_member_consume:

                break;
            case R.id.ll_more:

                break;
            case R.id.tv_input_one:
                if (buffer.length() < 7) {
                    buffer.append("1");
                    setTextView(buffer.toString());
                }
                break;
            case R.id.tv_input_two:
                if (buffer.length() < 7) {
                    buffer.append("2");
                    setTextView(buffer.toString());
                }
                break;
            case R.id.tv_input_three:
                if (buffer.length() < 7) {
                    buffer.append("3");
                    setTextView(buffer.toString());
                }
                break;
            case R.id.tv_input_four:
                if (buffer.length() < 7) {
                    buffer.append("4");
                    setTextView(buffer.toString());
                }
                break;
            case R.id.tv_input_five:
                if (buffer.length() < 7) {
                    buffer.append("5");
                    setTextView(buffer.toString());
                }
                break;
            case R.id.tv_input_six:
                if (buffer.length() < 7) {
                    buffer.append("6");
                    setTextView(buffer.toString());
                }
                break;
            case R.id.tv_input_seven:
                if (buffer.length() < 7) {
                    buffer.append("7");
                    setTextView(buffer.toString());
                }
                break;
            case R.id.tv_input_eight:
                if (buffer.length() < 7) {
                    buffer.append("8");
                    setTextView(buffer.toString());
                }
                break;
            case R.id.tv_input_nine:
                if (buffer.length() < 7) {
                    buffer.append("9");
                    setTextView(buffer.toString());
                }
                break;
            case R.id.tv_input_zero:
                if (buffer.length() < 7) {
                    buffer.append("0");
                    setTextView(buffer.toString());
                }
                break;
            case R.id.tv_input_point:
                if (!buffer.toString().contains(".")) {
                    buffer.append(".");
                    setTextView(buffer.toString());
                }
                break;
            case R.id.ll_input_del:
                if (buffer.toString().length() != 0) {
                    setTextView(buffer.deleteCharAt(buffer.toString().length() - 1).toString() + "");
                } else {
                    setTextView(null);
                }
                break;
            default:
                break;
        }
    }

    public static void launch(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    private void setTextView(String buffer) {
        if (buffer != null) {
            if (buffer.length() <= 7) {
                tv_input_num.setText("￥" + buffer.toString());
                Spannable spannable = new SpannableString(tv_input_num.getText());
                spannable.setSpan(new AbsoluteSizeSpan(60), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                tv_input_num.setText(spannable);
            }
        } else {
            tv_input_num.setText("");
        }

    }


    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.ll_input_del:
                tv_input_num.setText("");
                break;
        }
        return true;
    }
}
