package com.example.tz.business.domain

import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.business.data.model.toGrade
import java.lang.Exception
import javax.inject.Inject

class GetGrade @Inject constructor(
    private val balanceDataSourceImpl: BalanceDataSourceImpl
) {
   suspend fun execute(): Grade? {
        return try{
            balanceDataSourceImpl.getGrade()?.toGrade()
        }catch(e:Exception){
            null
        }
    }
}