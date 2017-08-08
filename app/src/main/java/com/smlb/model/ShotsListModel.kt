package com.smlb.model

import com.smlb.app.ApiClient
import com.smlb.bean.ShotsEntity
import com.smlb.constant.ApiConstants
import com.smlb.contract.ShotsListContract
import io.reactivex.Observable


/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class ShotsListModel : ShotsListContract.Model {
    override fun getShots(type: Int, sort: Int, timeFrame: Int, page: Int): Observable<List<ShotsEntity>> {
        val params = HashMap<String, String>()
        params.put(ApiConstants.ParamKey.LIST, ApiConstants.ParamValue.LIST_VALUES[type])
        params.put(ApiConstants.ParamKey.SORT, ApiConstants.ParamValue.SORT_VALUES[sort])
        params.put(ApiConstants.ParamKey.TIME_FRAME, ApiConstants.ParamValue.TIME_VALUES[timeFrame])
        params.put(ApiConstants.ParamKey.PAGE, page.toString() + "")
        params.put(ApiConstants.ParamKey.PER_PAGE, ApiConstants.ParamValue.PAGE_SIZE.toString() + "")
        return ApiClient.getForRest().getShotsList(params)
    }
}