package com.zhousaito.news.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

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
