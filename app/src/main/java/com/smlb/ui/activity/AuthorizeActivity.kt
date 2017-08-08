package com.smlb.ui.activity

import android.app.Activity
import android.content.Intent
import android.webkit.WebView
import com.smlb.base.BaseWebActivity
import com.smlb.constant.ApiConstants



/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class AuthorizeActivity : BaseWebActivity() {

    override fun getWebChromeClient(): MyWebChromeClient {
        return object : BaseWebActivity.MyWebChromeClient() {
            fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (url.contains("code")) {
                    val code = url.replace(ApiConstants.Url.REDIRECT_URL + "?code=", "")
                            .replace("&state=hunter", "")
                    val intent = Intent()
                    intent.putExtra(LoginActivity.EXTRA_AUTHORIZE_CODE, code)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                } else {
                    view.loadUrl(url)
                }
                return true
            }
        }
    }
}