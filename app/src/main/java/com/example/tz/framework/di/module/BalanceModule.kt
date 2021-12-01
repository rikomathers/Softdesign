package com.example.tz.framework.di.module

import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.business.domain.GetBonus
import com.example.tz.business.domain.GetGrade
import com.example.tz.business.domain.GetProfit
import com.example.tz.business.domain.GetRefill
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class BalanceModule {

    @Provides
    fun getGrade(balanceDataSourceImpl: BalanceDataSourceImpl):GetGrade{
        return GetGrade(balanceDataSourceImpl)
    }

    @Provides
    fun getRefill(balanceDataSourceImpl: BalanceDataSourceImpl):GetRefill{
        return GetRefill(balanceDataSourceImpl)
    }

    @Provides
    fun getProfit(balanceDataSourceImpl: BalanceDataSourceImpl):GetProfit{
        return GetProfit(balanceDataSourceImpl)
    }

    @Provides
    fun getBonus(balanceDataSourceImpl: BalanceDataSourceImpl):GetBonus{
        return GetBonus(balanceDataSourceImpl)
    }
}