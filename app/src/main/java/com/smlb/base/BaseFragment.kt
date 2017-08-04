package com.smlb.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.smlb.utils.SnackbarUtils


/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

abstract class BaseFragment : Fragment() {

    protected var mActivity: Activity? = null
    protected var mContext: Context? = null
    protected var mRootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater!!.inflate(getLayoutId(), container, false)
        ButterKnife.bind(this, mRootView as View)
        return mRootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view!!, savedInstanceState!!)
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun init(view: View, savedInstanceState: Bundle)

    fun showToast(msg: CharSequence) {
        SnackbarUtils.show(mActivity!!.window.decorView, msg, mContext)
    }

    fun showToastForStrong(normal: String, strong: String) {
        val msg = Html.fromHtml("$normal<strong>「$strong」</strong>")
        SnackbarUtils.show(mActivity!!.window.decorView, msg, mContext)
    }

    fun showToastForStrongWithAction(normal: String, strong: String, actionText: String,
                                     listener: View.OnClickListener) {
        val msg = Html.fromHtml("$normal<strong>「$strong」</strong>")
        SnackbarUtils.showWithAction(mActivity!!.window.decorView, msg, mContext, actionText, listener)
    }

    override fun onPause() {
        super.onPause()
        SnackbarUtils.releaseSnackBar()
    }

}