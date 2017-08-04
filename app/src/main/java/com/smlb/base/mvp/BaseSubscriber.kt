package com.smlb.base.mvp

import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * Created by Sunmeng on 8/4/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

abstract class BaseSubscriber<T> : Observer<T> {

    private var mView: BaseView? = null

    private var mDialogMsg: String? = null

    private var mIsShowLoading: Boolean = false

    constructor(view: BaseView) {
        mView = view
    }

    constructor(view: BaseView, isShowLoading: Boolean) {
        mView = view
        mIsShowLoading = isShowLoading
    }

    override fun onSubscribe(d: Disposable?) {
        if (mIsShowLoading && mView != null) mView!!.showLoading()
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onComplete() {
        if (mView != null) {
            mView!!.onComplete()
            if (mIsShowLoading) mView!!.showLoading()
        }
        mView = null
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        onFail(e.message!!)
        if (mView != null) {
            mView!!.onComplete()
            if (e.message!! in "404") return
            mView!!.showError()
        }
    }

    protected abstract fun onSuccess(t: T)

    protected fun onFail(msg: String) {}

}