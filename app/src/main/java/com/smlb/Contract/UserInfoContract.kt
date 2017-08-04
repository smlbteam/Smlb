package com.smlb.Contract

import com.smlb.base.mvp.BaseModel
import com.smlb.base.mvp.BasePresenter
import com.smlb.base.mvp.BaseView
import com.smlb.bean.UserEntity
import io.reactivex.Observable


/**
 * Created by Sunmeng on 8/4/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

interface UserInfoContract {

    interface Model : BaseModel {
        fun getUserInfo(): Observable<UserEntity>
    }

    interface View : BaseView {
        fun getUserInfoOnSuccess(entity: UserEntity)
    }

    abstract class Presenter : BasePresenter<Model, View>() {
        internal abstract fun getUserInfo()
    }

}