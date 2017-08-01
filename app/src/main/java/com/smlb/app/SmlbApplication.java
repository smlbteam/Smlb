package com.smlb.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by Sunmeng on 8/1/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */


public class SmlbApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(getApplicationContext());
        Logger.addLogAdapter(new AndroidLogAdapter());
        Hawk.init(getApplicationContext()).build();
    }
}
