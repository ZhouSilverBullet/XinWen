package com.zhousaito.news.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.zhousaito.news.app.App;


public class SystemUtil {
    public static boolean isNetworkConnect() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo() != null;
        }
        return false;
    }
}
