package com.zhousaito.news.presenter;

import com.zhousaito.news.base.RxPresenter;
import com.zhousaito.news.presenter.contract.HomeContract;

import javax.inject.Inject;

public class HomePresenter extends RxPresenter<HomeContract.IView> implements HomeContract.IPresenter {
    @Inject
    public HomePresenter() {
    }


}
