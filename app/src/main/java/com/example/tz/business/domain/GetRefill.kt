package com.example.tz.business.domain

import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.business.data.model.toGrade
import com.example.tz.business.data.model.toRefill
import java.lang.Exception
import javax.inject.Inject

class GetRefill @Inject constructor(
    private val balanceDataSourceImpl: BalanceDataSourceImpl
){
    suspend fun execute(): Refill? {
        return try{
            balanceDataSourceImpl.getRefill()?.toRefill()
        }catch(e: Exception){
            null
        }
    }
}