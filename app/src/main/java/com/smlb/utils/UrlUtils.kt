package com.smlb.utils

import com.smlb.constant.ApiConstants


/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class UrlUtils {

    companion object {
        /**
         * 获取登录链接
         */
        fun getAuthorizeUrl(): String {
            val params = HashMap<String, String>()
            params.put(ApiConstants.ParamKey.CLIENT_ID, ApiConstants.ParamValue.CLIENT_ID)
            params.put(ApiConstants.ParamKey.REDIRECT_URI, ApiConstants.ParamValue.REDIRECT_URI)
            params.put(ApiConstants.ParamKey.SCOPE, ApiConstants.ParamValue.SCOPE)
            params.put(ApiConstants.ParamKey.STATE, ApiConstants.ParamValue.STATE)
            return formatToUrl(ApiConstants.Url.OAUTH_URL + ApiConstants.Path.AUTHORIZE, params)
        }

        fun formatToUrl(url: String, params: Map<String, String>): String {
            var sb: StringBuilder? = null

            for ((key, value) in params) {
                if (sb == null) {
                    sb = StringBuilder(url + "?")
                } else {
                    sb.append("&")
                }

                sb.append(key)
                sb.append("=")
                sb.append(value)
            }

            return sb!!.toString()
        }
    }


}