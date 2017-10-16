package com.supengchao.github.jianzhioffer;

import android.app.Application;

/**
 * Created by supengchao on 17/9/15.
 */

public class MyApplication extends Application {

    private static MyApplication instance =null;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance(){
        return instance;
    }
}
