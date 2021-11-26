package com.example.tz.business

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