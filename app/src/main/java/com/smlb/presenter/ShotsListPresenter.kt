package com.smlb.presenter

import com.smlb.base.mvp.BaseSubscriber
import com.smlb.bean.ShotsEntity
import com.smlb.contract.ShotsListContract



/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class ShotsListPresenter : ShotsListContract.Presenter() {
    override fun getShots(type: Int, sort: Int, timeFrame: Int, page: Int) {
        subscribe(mModel!!.getShots(type, sort, timeFrame, page), object : BaseSubscriber<List<ShotsEntity>>(view = mView!!) {
            override fun onSuccess(t: List<ShotsEntity>) {
                mView!!.getShotsOnSuccess(t)
            }
        })
    }
}