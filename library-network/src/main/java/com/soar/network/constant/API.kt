package com.soar.cloud.retrofit


import com.soar.cloud.bean.*
import com.soar.network.bean.BaseResultBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * YONG_
 */
interface API {
    //---------------------------------GankIo-API---------------------------------//
    /**
     * 每日推荐
     * eg:http://gank.io/api/day/2015/08/06
     */
    @GET("day/{year}/{month}/{day}")
    fun getGankIoDay(
        @Path("year") year: String?,
        @Path("month") month: String?,
        @Path("day") day: String?
    ): Observable<GankIoDayBean>


    /**
     * 导航数据
     */
    @GET("navi/json")
    fun getNaviJson(): Observable<BaseResultBean<List<NaviBean>>>
}