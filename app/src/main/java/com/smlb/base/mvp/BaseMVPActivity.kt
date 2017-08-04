package com.smlb.base.mvp

import android.os.Bundle
import com.smlb.base.BaseActivity


/**
 * Created by Sunmeng on 8/4/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

open class BaseMVPActivity<P : BasePresenter<*, *>, M : BaseModel> : BaseActivity() {

    var mPresenter: P? = null
    var mModel: M? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = TUtils.getT(this, 0) as P?
        mModel = TUtils.getT(this, 1) as M?
        if (this is BaseView) mPresenter!!.setVM(this@BaseMVPActivity, mModel)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null) mPresenter!!.onDestroy()
    }

}