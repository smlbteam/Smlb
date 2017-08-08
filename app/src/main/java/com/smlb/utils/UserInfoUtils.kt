package com.smlb.utils

import android.content.Context
import android.text.TextUtils

import com.google.gson.Gson
import com.smlb.app.AppConstants
import com.smlb.bean.UserEntity

import java.util.HashMap

object UserInfoUtils {

    val KEY_CURRENT_USER = "user"

    private val sUserEntity = HashMap<String, UserEntity>()

    fun getCurrentUser(context: Context): UserEntity? {
        val currentUser = sUserEntity[KEY_CURRENT_USER]
        if (currentUser != null) return currentUser

        val userStr = SPUtils.get(context, AppConstants.SP_CURRENT_USER, "") as String
        if (TextUtils.isEmpty(userStr)) return null

        val user = Gson().fromJson(userStr, UserEntity::class.java)
        sUserEntity.put(AppConstants.SP_CURRENT_USER, user)
        return user
    }

    fun clearUserInfo(context: Context) {
        sUserEntity.clear()
        SPUtils.put(context, AppConstants.SP_CURRENT_USER, "")
    }

    fun setUserInfo(context: Context, entity: UserEntity) {
        sUserEntity.put(KEY_CURRENT_USER, entity)
        SPUtils.put(context, AppConstants.SP_CURRENT_USER, Gson().toJson(entity))
    }
}
