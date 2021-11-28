package com.example.tz.business.domain

import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.business.data.model.toGrade
import com.example.tz.business.data.model.toRefill
import java.lang.Exception

class GetRefill {
    suspend fun execute(): Refill? {
        return try{
            BalanceDataSourceImpl.getRefill()?.toRefill()
        }catch(e: Exception){
            null
        }
    }
}