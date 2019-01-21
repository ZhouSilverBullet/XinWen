package com.zhousaito.news.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initVariables();
        initView();
        initEvent();
        initData();
    }

    protected void initEvent() {
    }

    protected void initData() {
    }

    protected void initView() {
    }

    protected void initVariables() {
    }

    protected abstract int getLayout();
}
