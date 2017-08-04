package com.smlb.app

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.orhanobut.hawk.Hawk
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * Created by Sunmeng on 8/2/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class SmlbApplication : Application() {

    companion object {
        lateinit var sAppConfig: AppConfig
        lateinit var instance: SmlbApplication
        fun getAppConfig(): AppConfig {
            return sAppConfig
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        sAppConfig = AppConfig(applicationContext)
        Utils.init(applicationContext)
        Logger.addLogAdapter(AndroidLogAdapter())
        Hawk.init(applicationContext).build()
    }

}