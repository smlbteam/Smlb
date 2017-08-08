package com.smlb.presenter

import com.smlb.base.mvp.BaseSubscriber
import com.smlb.bean.TokenEntity
import com.smlb.bean.UserEntity
import com.smlb.contract.LoginContract


/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class LoginPresenter : LoginContract.Presenter() {

    override fun getToken(code: String) {
        subscribe(mModel!!.getToken(code), object : BaseSubscriber<TokenEntity>(mView!!) {
            public override fun onSuccess(t: TokenEntity) {
                mView!!.getTokenOnSuccess(t)
            }

            override fun onFail(msg: String) {
                mView!!.getTokenOnFail(msg)
                mView!!.showToast(msg)
            }
        })
    }

    override fun getUserInfo() {
        subscribe(mModel!!.userInfo, object : BaseSubscriber<UserEntity>(mView!!) {
            override fun onSuccess(t: UserEntity) {
                mView!!.getUserInfoOnSuccess(t)
            }
        })
    }

}