package com.zhousaito.news.presenter;


import com.zhousaito.news.base.RxPresenter;
import com.zhousaito.news.presenter.contract.MainContract;

import javax.inject.Inject;

public class MainPresenter extends RxPresenter<MainContract.IView> implements MainContract.IPresenter {

    @Inject
    public MainPresenter() {
    }

    @Override
    public void refreshData() {
        if (mView != null) {
            mView.showDataList("我是生成的数据");
        }
    }
}
