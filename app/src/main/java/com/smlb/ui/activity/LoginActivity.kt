package com.smlb.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.smlb.R
import com.smlb.app.ApiClient
import com.smlb.app.SmlbApplication
import com.smlb.base.mvp.BaseMVPActivity
import com.smlb.bean.TokenEntity
import com.smlb.bean.UserEntity
import com.smlb.constant.WebConstants
import com.smlb.contract.LoginContract
import com.smlb.model.LoginModel
import com.smlb.presenter.LoginPresenter
import com.smlb.utils.UrlUtils
import com.smlb.utils.UserInfoUtils
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class LoginActivity : BaseMVPActivity<LoginPresenter, LoginModel>(), LoginContract.View {

    companion object{
        val EXTRA_AUTHORIZE_CODE = "extra_authorize_code"
        val REQUEST_CODE_AUTHORIZE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_to_authorize_web.setOnClickListener {
            val intent = Intent(this, AuthorizeActivity::class.java)
            intent.putExtra(WebConstants.EXTRA_WEB_LOAD_URL, UrlUtils.getAuthorizeUrl())
            startActivityForResult(intent, REQUEST_CODE_AUTHORIZE)
        }
        ibtn_login_close.setOnClickListener { finish() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_AUTHORIZE) {
            mPresenter!!.getToken(data!!.getStringExtra(EXTRA_AUTHORIZE_CODE))
            progress_login.visibility = View.VISIBLE
            progress_login.isIndeterminate = true
            btn_to_authorize_web.visibility = View.GONE
            tv_login_welcome.text = "欢迎回来"
        }
    }

    override fun getTokenOnSuccess(entity: TokenEntity) {
        SmlbApplication.getAppConfig().setToken(entity.mAccessToken!!)
        ApiClient.resetApiClient()
        mPresenter!!.getUserInfo()
    }

    override fun getTokenOnFail(msg: String) {
        btn_to_authorize_web.visibility = View.VISIBLE
    }

    override fun getUserInfoOnSuccess(entity: UserEntity) {
        UserInfoUtils.setUserInfo(this, entity)
        setResult(RESULT_OK)
        finish()
    }

    override fun showLoading() {
    }

    override fun onComplete() {
    }

    override fun showError() {
    }

}