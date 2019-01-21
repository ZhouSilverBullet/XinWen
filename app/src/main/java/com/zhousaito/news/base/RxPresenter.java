package com.zhousaito.news.base;

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;

    @Override
    public void attachView(T t) {
        this.mView = t;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}
