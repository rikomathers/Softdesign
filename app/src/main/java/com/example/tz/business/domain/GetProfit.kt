package com.example.tz.business.domain

import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.business.data.model.toProfit
import java.lang.Exception
import javax.inject.Inject

class GetProfit @Inject constructor(
    private val balanceDataSourceImpl: BalanceDataSourceImpl
){
    suspend fun execute(): Profit? {
        return try {
            balanceDataSourceImpl.getProfit()?.toProfit()
        } catch (e: Exception) {
            null
        }
    }
}