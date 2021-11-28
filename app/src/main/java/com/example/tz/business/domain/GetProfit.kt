package com.example.tz.business.domain

import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.business.data.model.toProfit
import java.lang.Exception

class GetProfit {
    suspend fun execute(): Profit? {
        return try {
            BalanceDataSourceImpl.getProfit()?.toProfit()
        } catch (e: Exception) {
            null
        }
    }
}