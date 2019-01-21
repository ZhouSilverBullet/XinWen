package com.zhousaito.news.presenter.contract;


import com.zhousaito.news.base.BasePresenter;
import com.zhousaito.news.base.BaseView;

public interface MainContract {
    interface IView extends BaseView {
        void showDataList(String value);
    }

    interface IPresenter extends BasePresenter<IView> {
        void refreshData();
    }
}
