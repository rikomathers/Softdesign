package com.example.tz.business.data

import android.util.Log
import com.example.tz.business.data.model.BonusResponse
import com.example.tz.business.data.model.GradeResponse
import com.example.tz.business.data.model.ProfitResponse
import com.example.tz.business.data.model.RefillResponse
import javax.inject.Inject

private const val TOKEN =
    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYwZTBhNzU2NTBlZmYwM2M4NGU3ZTA1YiIsInJvbGUiOiJzdXBlcmFkbWluIiwib3duZXIiOiJzdXBlcmFkbWluIiwiaWF0IjoxNjI1NDA1NDA1LCJleHAiOjE2MjYwMTAyMDV9.B6Y2JXfF28g62QdQCf577L3sLMcAOY95RSKhcCGWrXU"

class BalanceDataSourceImpl @Inject constructor(
    private val balanceService: BalanceService
) {
    suspend fun getGrade(): GradeResponse? {
        return try {
            balanceService.getGrade(TOKEN).await()
        } catch (e: Exception) {
            Log.w("BalanceDataSource", e)
            null
        }
    }

    suspend fun getRefill(): RefillResponse? {
        return try {
            balanceService.getRefill(TOKEN).await()
        } catch (e: Exception) {
            Log.w("BalanceDataSource", e)
            null
        }
    }

    suspend fun getProfit(): ProfitResponse? {
        return try {
            balanceService.getProfit(TOKEN).await()
        } catch (e: Exception) {
            Log.w("BalanceDataSource", e)
            null
        }
    }

    suspend fun getBonus(): BonusResponse? {
        return try {
            balanceService.getBonus(TOKEN).await()
        } catch (e: Exception) {
            Log.w("BalanceDataSource", e)
            null
        }
    }


}