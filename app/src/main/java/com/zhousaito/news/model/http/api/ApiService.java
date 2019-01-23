package com.zhousaito.news.model.http.api;

import com.zhousaito.news.model.bean.NewsBean;
import com.zhousaito.news.model.bean.RequestBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    //https://blog.csdn.net/jiao_zg/article/details/77897748
    String BASE_URL = "http://zhousaito.com/mobile/";

    @GET("home")
    Observable<RequestBean<NewsBean>> getData();
}
