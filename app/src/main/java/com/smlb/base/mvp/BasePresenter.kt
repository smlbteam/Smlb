package com.smlb.base.mvp

import android.content.Context
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.ref.Reference
import java.lang.ref.WeakReference


/**
 * Created by Sunmeng on 8/4/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

abstract class BasePresenter<M, V> {

    var context: Context? = null
    private var mViewRef: Reference<BaseView>? = null
    var mModel: M? = null
    var mView: V? = null

    fun setVM(v: BaseView, m: BaseModel?) {
        mViewRef = WeakReference(v)
        mView = (mViewRef as WeakReference<V>).get()
        mModel = m as M
        onStart()
    }

    fun onStart() {}

    fun onDestroy() {
        if (mViewRef != null) {
            mViewRef!!.clear()
            mViewRef = null
        }
    }

    protected fun <T> subscribe(observable: Observable<T>, observer: Observer<T>) {
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer)
    }
}
