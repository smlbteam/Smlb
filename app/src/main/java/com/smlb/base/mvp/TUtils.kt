package com.smlb.base.mvp

import java.lang.reflect.ParameterizedType

/**
 * Created by Sunmeng on 8/4/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class TUtils {
    companion object {
        fun getT(o: Any, i: Int): Any? {
            try {
                val parameter = o.javaClass.genericSuperclass as ParameterizedType
                return (parameter.actualTypeArguments[i] as Class<*>).newInstance()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: ClassCastException) {
                e.printStackTrace()
            }
            return null
        }
    }
}