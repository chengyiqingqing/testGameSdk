package com.sww.testgamesdk;

import android.app.Application;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.ledong.lib.leto.Leto;


public class LetoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //
        MultiDex.install(this);

        //SDK 初始化
        //LetoManager.init(this);

        //SDK 初始化
        long start = System.currentTimeMillis();

        //关闭日志输出
        Leto.setDebugMode(false);

        //初始化启动
        Leto.init(this);

        long end =  System.currentTimeMillis();

        long duration = (end - start);

        Log.i("init_end", "时长：" + duration);
    }

}
