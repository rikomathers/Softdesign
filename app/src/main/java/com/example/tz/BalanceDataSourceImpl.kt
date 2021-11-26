package com.example.tz

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.util.concurrent.TimeUnit

object BalanceDataSourceImpl {
    private const val CONNECT_TIMEOUT_SECONDS = 10L
    private const val READ_TIMEOUT_SECONDS = 10L

    suspend fun getBalance(): BalanceResponse {
        return try {
            balanceService.getGrade()
        } catch (e: Exception) {
            Log.w("", e)
            BalanceResponse()
        }
    }

    private val balanceService: BalanceService by lazy {
        Retrofit.Builder()
            .baseUrl("https://sandbox.skill-branch.ru/dashboards/")
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