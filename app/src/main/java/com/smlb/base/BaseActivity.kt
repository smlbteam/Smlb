package com.smlb.base

import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.View
import com.smlb.utils.SnackbarUtils


/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

abstract class BaseActivity : AppCompatActivity() {
    fun showToast(msg: CharSequence) {
        SnackbarUtils.show(window.decorView, msg, this)
    }

    fun showToastForStrong(normal: String, strong: String) {
        val msg = Html.fromHtml("$normal <strong>「$strong」</strong>")
        SnackbarUtils.show(window.decorView, msg, this)
    }

    fun showToastForStrongWithAction(normal: String, strong: String, actionText: String,
                                     listener: View.OnClickListener) {
        val msg = Html.fromHtml("$normal<strong>「$strong」</strong>")
        SnackbarUtils.showWithAction(window.decorView, msg, this, actionText, listener)
    }

    fun showToastForStrongWithAction(normal: String, strong: String, listener: View.OnClickListener) {
        val msg = Html.fromHtml("$normal<strong>「$strong」</strong>")
        SnackbarUtils.showWithAction(window.decorView, msg, this, listener)
    }

    override fun onPause() {
        super.onPause()
        SnackbarUtils.releaseSnackBar()
    }
}