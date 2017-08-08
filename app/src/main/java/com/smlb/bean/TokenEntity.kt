package com.smlb.bean

import com.google.gson.annotations.SerializedName


/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class TokenEntity {

    @SerializedName("access_token")
    val mAccessToken: String? = null
    @SerializedName("token_type")
    val mTokenType: String? = null
    @SerializedName("scope")
    val mScope: String? = null
    @SerializedName("created_at")
    val mCreatedAt: Int = 0

}