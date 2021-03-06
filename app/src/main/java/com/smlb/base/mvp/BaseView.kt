package com.smlb.base.mvp

/**
 * Created by Sunmeng on 8/4/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

interface BaseView {
    fun showLoading()

    fun onComplete()

    fun showToast(msg: CharSequence)

    fun showError()
}