package com.smlb.model

import com.smlb.contract.UserInfoContract
import com.smlb.app.ApiClient
import com.smlb.bean.UserEntity
import io.reactivex.Observable

/**
 * Created by Sunmeng on 8/4/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class UserInfoModel : UserInfoContract.Model{
    override fun getUserInfo(): Observable<UserEntity> {
        return ApiClient.getForRest().getUserInfo()
    }
}