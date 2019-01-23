package com.zhousaito.news.presenter;

import com.orhanobut.logger.Logger;
import com.zhousaito.news.base.RxPresenter;
import com.zhousaito.news.model.bean.NewsBean;
import com.zhousaito.news.model.http.api.ApiService;
import com.zhousaito.news.model.http.net.RetrofitHelper;
import com.zhousaito.news.model.http.util.RxUtils;
import com.zhousaito.news.presenter.contract.HomeFragmentContract;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class HomeFragmentPresenter extends RxPresenter<HomeFragmentContract.IView> implements HomeFragmentContract.IPresenter {
    @Inject
    public HomeFragmentPresenter() {
    }

    @Override
    public void loadData() {
        ApiService xxApi = RetrofitHelper.getNewsApi();
        Disposable subscribe = xxApi.getData().compose(RxUtils.schedulers())
                .compose(RxUtils.handleResult())
                .subscribe(new Consumer<NewsBean>() {
                    @Override
                    public void accept(NewsBean newsBean) throws Exception {
                        mView.showData(newsBean.title);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(" Throwable " + throwable);
                        mView.showError("showError被调用");
                    }
                });

//        Disposable subscribe = xxApi.getData().compose(RxUtils.schedulers())
//                .subscribe(new Consumer<RequestBean>() {
//                    @Override
//                    public void accept(RequestBean requestBean) throws Exception {
//                        if (requestBean.getCode() == 200) {
//                            mView.showData(requestBean.getMsg());
//                        } else {
//                            mView.showError(requestBean.getMsg());
//                        }
//                    }
//                });
        addSubscribe(subscribe);
    }
}
