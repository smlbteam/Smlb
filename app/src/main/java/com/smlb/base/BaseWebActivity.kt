package com.smlb.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.text.TextUtils
import android.view.KeyEvent
import android.webkit.WebView
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import com.smlb.R
import com.smlb.constant.WebConstants
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import android.view.KeyEvent.KEYCODE_BACK
import android.view.View


/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

open class BaseWebActivity : BaseActivity() {
    @BindView(R.id.toolbar_web)
    protected var mToolbar: Toolbar? = null
    protected var mProgressWeb: ProgressBar? = null
    protected var mWebView: WebView? = null
    protected var mWebTitle: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_web)
        ButterKnife.bind(this)
        initToolbar()
        initWebView()
    }

    private fun initToolbar() {
        mWebTitle = intent.getStringExtra(WebConstants.EXTRA_WEB_TITLE)
        setSupportActionBar(mToolbar)
        if (!TextUtils.isEmpty(mWebTitle)) mToolbar!!.title = mWebTitle
        mToolbar!!.setNavigationIcon(R.drawable.iv_close_white_24dp)
        mToolbar!!.setNavigationOnClickListener { finish() }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        mProgressWeb = findViewById(R.id.progress_web) as ProgressBar
        mWebView = findViewById(R.id.web_view) as WebView
        val settings = mWebView!!.settings
        settings.javaScriptEnabled = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        settings.javaScriptEnabled = true
        mWebView!!.setWebChromeClient(getWebChromeClient())
        mWebView!!.setWebViewClient(getWebViewClient())
        mWebView!!.loadUrl(intent.getStringExtra(WebConstants.EXTRA_WEB_LOAD_URL))
    }

    protected fun getWebChromeClient(): WebChromeClient {
        return MyWebChromeClient()
    }

    protected fun getWebViewClient(): WebViewClient {
        return MyWebViewClient()
    }

    protected inner class MyWebChromeClient : WebChromeClient() {

        override fun onProgressChanged(view: WebView, newProgress: Int) {
            if (newProgress == 100) {
                mProgressWeb!!.visibility = View.GONE
            } else {
                if (mProgressWeb!!.visibility === View.GONE) {
                    mProgressWeb!!.visibility = View.VISIBLE
                }
                mProgressWeb!!.progress = newProgress
            }
        }

        override fun onReceivedTitle(view: WebView, title: String) {
            if (TextUtils.isEmpty(mWebTitle)) {
                mToolbar!!.title = title
            }
        }
    }

    protected inner class MyWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            mToolbar!!.title = view.title
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView!!.canGoBack()) {
            mWebView!!.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
