package com.zhousaito.news.di.component;

import android.app.Activity;


import com.zhousaito.news.di.module.ActivityModule;
import com.zhousaito.news.di.qualifier.ActivityScope;
import com.zhousaito.news.ui.activity.HomeActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(HomeActivity homeActivity);
}
