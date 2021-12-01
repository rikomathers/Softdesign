package com.example.tz.framework.presentation.adapter

import com.example.tz.business.domain.Bonus

data class BonusBalance(
    val totalRUB: String,
    val totalUSD: String,
    val team: String,
    val refillUSD: String,
    val refillRUB: String
) : Balance {

    override fun getBalanceType(): Int {
        return Balance.bonus
    }
}
fun Bonus.toBonusBalance(): BonusBalance {
    return BonusBalance(
        totalRUB = totalRUB.toString(),
        totalUSD = totalUSD.toString(),
        team = team?.toInt().toString(),
        refillUSD = refillUSD.toString(),
        refillRUB = refillRUB.toString()
    )
}