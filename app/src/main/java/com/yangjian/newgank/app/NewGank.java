package com.yangjian.newgank.app;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;


/**
 * Created by Yang on 2018/6/22.
 * Function：App初始化类
 */

public class NewGank extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        Logger.init("NewGank")
                .methodOffset(2)
                .methodCount(2)
                .hideThreadInfo()
                .logLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE);
    }

    public static Context getContext() {
        return context;
    }
}
