package com.zhousaito.news.app;

import android.app.Application;

import com.zhousaito.news.di.component.AppComponent;
import com.zhousaito.news.di.component.DaggerAppComponent;
import com.zhousaito.news.di.module.AppModule;


public class App extends Application {

    private static App instance;
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(instance)).build();
        }
        return appComponent;
    }
}
