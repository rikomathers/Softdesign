package com.example.tz.business.data

import android.util.Log
import com.example.tz.BuildConfig
import com.example.tz.business.data.model.BonusResponse
import com.example.tz.business.data.model.GradeResponse
import com.example.tz.business.data.model.ProfitResponse
import com.example.tz.business.data.model.RefillResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object BalanceDataSourceImpl {
    private const val CONNECT_TIMEOUT_SECONDS = 12L
    private const val READ_TIMEOUT_SECONDS = 12L

    private const val TOKEN ="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYwZTBhNzU2NTBlZmYwM2M4NGU3ZTA1YiIsInJvbGUiOiJzdXBlcmFkbWluIiwib3duZXIiOiJzdXBlcmFkbWluIiwiaWF0IjoxNjI1NDA1NDA1LCJleHAiOjE2MjYwMTAyMDV9.B6Y2JXfF28g62QdQCf577L3sLMcAOY95RSKhcCGWrXU"


    suspend fun getGrade(): GradeResponse? {
        return try {
            balanceService.getGrade(TOKEN).await()
        } catch (e: Exception) {
            Log.w("BalanceDataSource", e)
            null
        }
    }
    suspend fun getRefill(): RefillResponse? {
        return try {
            balanceService.getRefill(TOKEN).await()
        } catch (e: Exception) {
            Log.w("BalanceDataSource", e)
            null
        }
    }
    suspend fun getProfit(): ProfitResponse? {
        return try {
            balanceService.getProfit(TOKEN).await()
        } catch (e: Exception) {
            Log.w("BalanceDataSource", e)
            null
        }
    }
    suspend fun getBonus(): BonusResponse? {
        return try {
            balanceService.getBonus(TOKEN).await()
        } catch (e: Exception) {
            Log.w("BalanceDataSource", e)
            null
        }
    }



    private val BASE_URL = "https://sandbox.skill-branch.ru/"
    private val balanceService: BalanceService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                provideOkHttpClient(
                    httpLoggingInterceptor = provideLoggingInterceptor(),
                    headerInterceptor = provideHeaderInterceptor()
                )
            )
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BalanceService::class.java)
    }

    private fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: HeaderInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(headerInterceptor)
            .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }


    private fun provideHeaderInterceptor(): HeaderInterceptor {
        return HeaderInterceptor()
    }
}