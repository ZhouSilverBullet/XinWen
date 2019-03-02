package com.zhousaito.news.presenter.contract;

import com.zhousaito.news.base.BasePresenter;
import com.zhousaito.news.base.BaseView;

public interface NewsListFragmentContract {
    interface IView extends BaseView {
        void showData(String value);
    }

    interface IPresenter extends BasePresenter<IView> {
        void loadData(String value);
    }


}
