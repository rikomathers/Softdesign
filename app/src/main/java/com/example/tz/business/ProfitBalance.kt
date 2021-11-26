package com.example.tz.business

data class ProfitBalance(
    val profitFromShares: String,
    val percent: String,
    val invested: String,
    val totalCost: String
): Balance {
    override fun getBalanceType(): Int {
        return Balance.profit
    }
}