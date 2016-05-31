package com.weizhi.arrow.cashierdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by Arrow on 2016/5/31.
 */
public abstract class BaseActivity extends AutoLayoutActivity implements View.OnClickListener {

    protected final String TAG = this.getClass().getSimpleName();

    protected Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(getContentViewResId());
        initView();
        initData();
        setListener();
    }

    protected abstract int getContentViewResId();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 设置监听
     */
    protected abstract void setListener();

    /**
     * 从接口获取数据
     */
    protected abstract void initData();
}
