package com.zhousaito.news.base;

import android.os.Bundle;

import com.zhousaito.news.app.App;
import com.zhousaito.news.di.component.ActivityComponent;
import com.zhousaito.news.di.component.DaggerActivityComponent;
import com.zhousaito.news.di.module.ActivityModule;

import javax.inject.Inject;

import androidx.annotation.Nullable;

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {
    @Inject
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initInject();
        if (presenter != null) {
            presenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent
                .builder()
                .appComponent(App.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    protected abstract void initInject();
}
