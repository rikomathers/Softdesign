package com.example.tz.business.domain

import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.business.data.BalanceService
import com.example.tz.business.data.model.toBonus
import com.example.tz.business.data.model.toGrade
import java.lang.Exception
import javax.inject.Inject

class GetBonus @Inject constructor(
    private val balanceDataSourceImpl: BalanceDataSourceImpl
) {
    suspend fun execute(): Bonus? {
        return try{
            balanceDataSourceImpl.getBonus()?.toBonus()
        }catch(e: Exception){
            null
        }
    }
}