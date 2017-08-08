package com.smlb.contract

import com.smlb.base.mvp.BaseModel
import com.smlb.base.mvp.BasePresenter
import com.smlb.base.mvp.BaseView
import com.smlb.bean.TokenEntity
import com.smlb.bean.UserEntity
import io.reactivex.Observable


/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

interface LoginContract {

    interface Model : BaseModel {

        val userInfo: Observable<UserEntity>

        fun getToken(code: String): Observable<TokenEntity>
    }

    interface View : BaseView {

        fun getTokenOnSuccess(entity: TokenEntity)

        fun getTokenOnFail(msg: String)

        fun getUserInfoOnSuccess(entity: UserEntity)
    }

    abstract class Presenter : BasePresenter<Model, View>() {

        internal abstract fun getToken(code: String)

        internal abstract fun getUserInfo()
    }
}
