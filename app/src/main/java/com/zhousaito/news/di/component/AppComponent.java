package com.zhousaito.news.di.component;

import com.zhousaito.news.app.App;
import com.zhousaito.news.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    App getAppContext();
}
