package com.example.tz.business.data

import com.example.tz.business.data.model.BonusResponse
import com.example.tz.business.data.model.GradeResponse
import com.example.tz.business.data.model.ProfitResponse
import com.example.tz.business.data.model.RefillResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header


interface BalanceService {

    @GET("/dashboards/grade")
    fun getGrade(@Header("Authorization") token: String): Deferred<GradeResponse>

    @GET("/dashboards/refill")
    fun getRefill(@Header("Authorization") token: String): Deferred<RefillResponse>

    @GET("/dashboards/profit")
    fun getProfit(@Header("Authorization") token: String): Deferred<ProfitResponse>

    @GET("/dashboards/bonus")
    fun getBonus(@Header("Authorization") token: String): Deferred<BonusResponse>
}