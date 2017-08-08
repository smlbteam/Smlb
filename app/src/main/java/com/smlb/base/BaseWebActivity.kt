package com.smlb.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.smlb.R
import com.smlb.constant.WebConstants
import kotlinx.android.synthetic.main.activity_base_web.*


/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

open class BaseWebActivity : BaseActivity() {
    protected var mWebTitle: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_web)
        initToolbar()
        initWebView()
    }

    private fun initToolbar() {
        mWebTitle = intent.getStringExtra(WebConstants.EXTRA_WEB_TITLE)
        setSupportActionBar(toolbar_web)
        if (!TextUtils.isEmpty(mWebTitle)) toolbar_web.title = mWebTitle
        toolbar_web.setNavigationIcon(R.drawable.iv_close_white_24dp)
        toolbar_web.setNavigationOnClickListener { finish() }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        val settings = web_view.settings
        settings.javaScriptEnabled = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        settings.javaScriptEnabled = true
        web_view.setWebChromeClient(getWebChromeClient())
        web_view.setWebViewClient(getWebViewClient())
        web_view.loadUrl(intent.getStringExtra(WebConstants.EXTRA_WEB_LOAD_URL))
    }

    protected open fun getWebChromeClient(): WebChromeClient {
        return MyWebChromeClient()
    }

    protected fun getWebViewClient(): WebViewClient {
        return MyWebViewClient()
    }

    protected open inner class MyWebChromeClient : WebChromeClient() {

        override fun onProgressChanged(view: WebView, newProgress: Int) {
            if (newProgress == 100) {
                progress_web.visibility = View.GONE
            } else {
                if (progress_web.visibility == View.GONE) {
                    progress_web.visibility = View.VISIBLE
                }
                progress_web.progress = newProgress
            }
        }

        override fun onReceivedTitle(view: WebView, title: String) {
            if (TextUtils.isEmpty(mWebTitle)) {
                toolbar_web.title = title
            }
        }
    }

    protected open inner class MyWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            toolbar_web.title = view.title
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && web_view.canGoBack()) {
            web_view.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
