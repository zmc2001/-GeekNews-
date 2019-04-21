package com.example.admin.day03_zuoye_one.base;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by admin on 2019/4/2.
 */

public class BaseApp extends Application {
    private static BaseApp app;

    public static int mMode = AppCompatDelegate.MODE_NIGHT_NO;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static BaseApp getInstance(){
        return app;
    }
}
