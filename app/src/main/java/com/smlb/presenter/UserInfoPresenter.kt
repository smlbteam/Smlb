package com.smlb.presenter

import com.smlb.base.mvp.BaseSubscriber
import com.smlb.bean.UserEntity
import com.smlb.contract.UserInfoContract


/**
 * Created by Sunmeng on 8/4/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class UserInfoPresenter : UserInfoContract.Presenter() {
    override fun getUserInfo() {
        subscribe(mModel!!.getUserInfo(), object : BaseSubscriber<UserEntity>(mView!!) {
            override fun onSuccess(t: UserEntity) {
                mView!!.getUserInfoOnSuccess(t)
            }
        })
    }
}