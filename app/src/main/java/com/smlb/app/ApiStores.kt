package com.smlb.app

import com.smlb.bean.*
import com.smlb.constant.ApiConstants
import io.reactivex.Observable
import retrofit2.http.*


/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:ApiStores
 */

interface ApiStores {
    @POST(ApiConstants.Path.TOKEN)
    fun getToken(@QueryMap params: Map<String, String>): Observable<TokenEntity>

    @GET(ApiConstants.Path.SHOTS)
    fun getShotsList(@QueryMap params: Map<String, String>): Observable<List<ShotsEntity>>

    @GET(ApiConstants.Path.SHOTS_DETAIL)
    fun getShotsDetail(@Path("id") id: String): Observable<ShotsEntity>

    @GET(ApiConstants.Path.SHOTS_COMMENTS)
    fun getComments(@Path("id") id: String, @QueryMap params: Map<String, String>): Observable<List<CommentEntity>>

    @POST(ApiConstants.Path.SHOTS_PUT_COMMENTS)
    fun putComments(@Path("shots") shots: String, @Path("id") id: String, @QueryMap params: Map<String, String>): Observable<ShotsEntity>

    @DELETE(ApiConstants.Path.SHOTS_PUT_COMMENTS)
    fun deleteComments(@Path("shots") shots: String, @Path("id") id: String): Observable<String>

    @GET(ApiConstants.Path.SHOTS_LIKE)
    fun checkShotsLike(@Path("id") id: String): Observable<CheckLikeEntity>

    @POST(ApiConstants.Path.SHOTS_LIKE)
    fun likeShots(@Path("id") id: String): Observable<CheckLikeEntity>

    @DELETE(ApiConstants.Path.SHOTS_LIKE)
    fun unlikeShots(@Path("id") id: String): Observable<CheckLikeEntity>

    @GET(ApiConstants.Path.USER_FOLLOWERS)
    fun getFollowers(@Path("id") id: String, @QueryMap params: Map<String, String>): Observable<List<FollowerEntity>>

    @GET(ApiConstants.Path.SEARCH)
    fun search(@QueryMap params: Map<String, String>): Observable<List<ShotsEntity>>

    @GET(ApiConstants.Path.USER)
    fun getUserInfo(): Observable<UserEntity>

    @GET(ApiConstants.Path.USER_SHOTS)
    fun getUserShots(@Path("id") id: String, @QueryMap params: Map<String, String>): Observable<List<ShotsEntity>>

    @GET(ApiConstants.Path.USER_BUCKETS)
    fun getBucketsList(): Observable<List<BucketsEntity>>

    @GET(ApiConstants.Path.BUCKETS_DETAIL)
    fun getBucketsDetail(@Path("id") id: String, @QueryMap params: Map<String, String>): Observable<List<ShotsEntity>>

    @PUT(ApiConstants.Path.ADD_SHOTS_TO_BUCKETS)
    fun addShotsToBuckets(@Path("id") id: String, @QueryMap params: Map<String, String>): Observable<String>
}
