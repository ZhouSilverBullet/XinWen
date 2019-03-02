package com.zhousaito.news.presenter;

import com.zhousaito.news.base.RxPresenter;
import com.zhousaito.news.presenter.contract.NewsListFragmentContract;

import javax.inject.Inject;

public class NewsListFragmentPresenter extends RxPresenter<NewsListFragmentContract.IView> implements NewsListFragmentContract.IPresenter {
    @Inject
    public NewsListFragmentPresenter() {
    }

    @Override
    public void loadData(String value) {
        mView.showData(value);
    }
}
