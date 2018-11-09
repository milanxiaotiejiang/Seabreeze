package com.example.scout;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.scout.common.lifecycle.Foreground;
import com.robot.seabreeze.log.Log;
import com.robot.seabreeze.log.inner.ConsoleTree;
import com.robot.seabreeze.log.inner.FileTree;
import com.robot.seabreeze.log.inner.LogcatTree;

/**
 * Created by zhangyuanyuan on 2017/11/13.
 */

public class ScoutApp extends MultiDexApplication {

    private static ScoutApp instance;

    public static ScoutApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        Foreground.init(this);

        initPrint();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private void initPrint() {
        if(BuildConfig.DEBUG){
            Log.getLogConfig().configAllowLog(true)
                    .configShowBorders(false);
            Log.plant(new FileTree(this, "Log"));
            Log.plant(new ConsoleTree());
            Log.plant(new LogcatTree());
        }
    }
}
