package com.zhousaito.news.di.component;

import android.app.Activity;

import com.zhousaito.news.di.module.FragmentModule;
import com.zhousaito.news.di.qualifier.FragmentScope;
import com.zhousaito.news.ui.fragment.HomeFragment;
import com.zhousaito.news.ui.fragment.NewsListFragment;

import dagger.Component;

@FragmentScope
@Component(modules = {FragmentModule.class}, dependencies = AppComponent.class)
public interface FragmentComponent {
    Activity getActivity();

    void inject(HomeFragment homeFragment);

    void inject(NewsListFragment newsListFragment);
}
