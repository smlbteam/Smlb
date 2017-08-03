package com.smlb.app

import android.text.TextUtils
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.smlb.constant.ApiConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class ApiClient {

    companion object {

        private val IS_DEBUG = false
        private val TIME_OUT_SECONDS = 15L
        private var sOAuthRetrofit: Retrofit? = null
        private var sRestRetrofit: Retrofit? = null
        private var sJsoupRetrofit: Retrofit? = null

        @Synchronized fun getForRest(): ApiStores {
            if (sRestRetrofit == null) {
                val builder = OkHttpClient.Builder()
                if (IS_DEBUG) {
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.level = HttpLoggingInterceptor.Level.BODY
                    builder.addInterceptor(interceptor)
                }
                val token = SmlbApplication.getAppConfig().getToken()
                val access_token = "Bearer " + if (TextUtils.isEmpty(token)) ApiConstants.ParamValue.TOKEN else token
                val tokenInterceptor = Interceptor { chain ->
                    val request = chain.request().newBuilder().header("Authorization", access_token).build()
                    chain.proceed(request)
                }
                builder.addNetworkInterceptor(tokenInterceptor)

                builder.retryOnConnectionFailure(true).connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                sRestRetrofit = Retrofit.Builder().baseUrl(ApiConstants.Url.BASE_URL)
                        .client(builder.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
            }
            return sRestRetrofit!!.create(ApiStores::class.java)
        }

        @Synchronized fun getForOAuth(): ApiStores {
            if (sOAuthRetrofit == null) {
                val builder = OkHttpClient.Builder()
                if (IS_DEBUG) {
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.level = HttpLoggingInterceptor.Level.BODY
                    builder.addInterceptor(interceptor)
                }
                builder.retryOnConnectionFailure(true).connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                sOAuthRetrofit = Retrofit.Builder().baseUrl(ApiConstants.Url.OAUTH_URL)
                        .client(builder.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
            }
            return sOAuthRetrofit!!.create(ApiStores::class.java)
        }

        @Synchronized fun getForJsoup(): ApiStores {
            if (sJsoupRetrofit == null) {
                val builder = OkHttpClient.Builder()
                if (IS_DEBUG) {
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.level = HttpLoggingInterceptor.Level.BODY
                    builder.addInterceptor(interceptor)
                }
                builder.retryOnConnectionFailure(true).connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                sJsoupRetrofit = Retrofit.Builder().baseUrl(ApiConstants.Url.BASE_JSOUP_URL)
                        .client(builder.build())
                        .addConverterFactory(SearchConverter.Factory())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
            }
            return sJsoupRetrofit!!.create(ApiStores::class.java)
        }

        @Synchronized fun resetApiClient() {
            if (sRestRetrofit != null) sRestRetrofit = null
        }

    }

}