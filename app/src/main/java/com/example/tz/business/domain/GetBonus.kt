package com.example.tz.business.domain

import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.business.data.model.toBonus
import com.example.tz.business.data.model.toGrade
import java.lang.Exception

class GetBonus {
    suspend fun execute(): Bonus? {
        return try{
            BalanceDataSourceImpl.getBonus()?.toBonus()
        }catch(e: Exception){
            null
        }
    }
}