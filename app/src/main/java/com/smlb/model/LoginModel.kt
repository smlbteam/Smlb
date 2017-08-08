package com.smlb.model

import com.smlb.app.ApiClient
import com.smlb.bean.TokenEntity
import com.smlb.bean.UserEntity
import com.smlb.constant.ApiConstants
import com.smlb.contract.LoginContract
import io.reactivex.Observable


/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class LoginModel : LoginContract.Model {

    override val userInfo: Observable<UserEntity>
        get() = ApiClient.getForRest().getUserInfo()

    override fun getToken(code: String): Observable<TokenEntity> {
        val params = HashMap<String, String>()
        params.put(ApiConstants.ParamKey.CLIENT_ID, ApiConstants.ParamValue.CLIENT_ID)
        params.put(ApiConstants.ParamKey.CLIENT_SECRET, ApiConstants.ParamValue.CLIENT_SECRET)
        params.put(ApiConstants.ParamKey.REDIRECT_URI, ApiConstants.ParamValue.REDIRECT_URI)
        params.put(ApiConstants.ParamKey.CODE, code)
        return ApiClient.getForOAuth().getToken(params)
    }
}