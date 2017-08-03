package com.smlb.app

import com.smlb.constant.ApiConstants

/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:分页
 */

class PagerMap(page: Int) : HashMap<String, String>() {

    init {
        put(ApiConstants.ParamKey.PAGE, page.toString())
        put(ApiConstants.ParamKey.PER_PAGE, ApiConstants.ParamValue.PAGE_SIZE.toString())
    }

}