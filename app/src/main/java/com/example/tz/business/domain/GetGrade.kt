package com.example.tz.business.domain

import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.business.data.model.toGrade
import java.lang.Exception

class GetGrade {
   suspend fun execute(): Grade? {
        return try{
            BalanceDataSourceImpl.getGrade()?.toGrade()

        }catch(e:Exception){
            null
        }
    }
}