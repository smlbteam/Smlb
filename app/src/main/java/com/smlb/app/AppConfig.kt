package com.smlb.app

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import com.smlb.utils.SPUtils



/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class AppConfig(context: Context) {

    private var mToken: String? = null

    private var mViewMode: Int = 0

    private var mShowGIF: Boolean = false

    private var mIsUseWIFI: Boolean = false

    private var mPreferences: SharedPreferences? = null

    init {
        mPreferences = context.getSharedPreferences(SPUtils.FILE_NAME, Context.MODE_PRIVATE)
        mToken = SPUtils.get(AppConstants.SP_ACCESS_TOKEN, "", mPreferences) as String
        mViewMode = SPUtils.get(AppConstants.SP_VIEW_MODE, AppConstants.VIEW_MODE_SMALL_WITH_INFO, mPreferences) as Int
        mShowGIF = SPUtils.get(AppConstants.SP_SHOW_GIF, true, mPreferences) as Boolean
    }

    fun isLogin(): Boolean {
        return !TextUtils.isEmpty(mToken)
    }

    fun getToken(): String? {
        return mToken
    }

    fun setToken(token: String) {
        mToken = token
        SPUtils.put(AppConstants.SP_ACCESS_TOKEN, token, mPreferences)
    }

    fun getShowGIFValue(): Boolean {
        return mShowGIF
    }

    fun setShowGIF(showGIF: Boolean) {
        mShowGIF = showGIF
        SPUtils.put(AppConstants.SP_SHOW_GIF, showGIF, mPreferences)
    }

    fun isShowGIF(): Boolean {
        return mShowGIF && !mIsUseWIFI
    }

    fun getViewMode(): Int {
        return mViewMode
    }

    fun setViewMode(viewMode: Int) {
        mViewMode = viewMode
        SPUtils.put(AppConstants.SP_VIEW_MODE, viewMode, mPreferences)
    }

    fun setUseWIFI(useWIFI: Boolean) {
        mIsUseWIFI = useWIFI
    }

}