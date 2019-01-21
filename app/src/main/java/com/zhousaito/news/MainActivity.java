package com.zhousaito.news;

import android.util.Log;

import com.zhousaito.news.base.BaseMvpActivity;
import com.zhousaito.news.presenter.MainPresenter;
import com.zhousaito.news.presenter.contract.MainContract;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.IView {
    public static final String TAG = "MainActivity";

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.refreshData();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showDataList(String value) {
        Log.e(TAG, "showDataList: " + value);
    }

    @Override
    public void showError(String error) {

    }
}
