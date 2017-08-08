package com.smlb.contract

import com.smlb.base.mvp.BaseModel
import com.smlb.base.mvp.BasePresenter
import com.smlb.base.mvp.BaseView
import com.smlb.bean.ShotsEntity
import io.reactivex.Observable


/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

interface ShotsListContract {

    interface Model : BaseModel {

        fun getShots(type: Int, sort: Int, timeFrame: Int, page: Int): Observable<List<ShotsEntity>>
    }

    interface View : BaseView {

        fun getShotsOnSuccess(data: List<ShotsEntity>)
    }

    abstract class Presenter : BasePresenter<Model, View>() {
        abstract fun getShots(type: Int, sort: Int, timeFrame: Int, page: Int)
    }

}