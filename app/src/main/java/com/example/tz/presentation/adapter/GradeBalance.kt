package com.example.tz.presentation.adapter

import com.example.tz.business.data.model.GradeResponse
import com.example.tz.business.domain.Grade

data class GradeBalance(
    val portfolioAppraisal: String,
    val percent: String,
    val inShare: String,
    val balanceOfUSD: String,
    val balanceOfRUB: String
) : Balance {
    override fun getBalanceType(): Int {
        return Balance.grade
    }
}
fun Grade.toGradeBalance(): GradeBalance {
    return GradeBalance(
        portfolioAppraisal = total.toString(),
        percent = raise.toString(),
        inShare = stock.toString(),
        balanceOfUSD = balanceUSD.toString(),
        balanceOfRUB = balanceRUB.toString()
    )
}
