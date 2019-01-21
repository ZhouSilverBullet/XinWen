package com.zhousaito.news.base;

public interface BasePresenter<T> {
    void attachView(T t);

    void detachView();
}
