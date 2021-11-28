package com.example.tz.presentation.adapter

data class BonusBalance(
    val expectedBonus: String,
    val inTeam: String,
    val replenishedRUB: String,
    val withdrawnRUB: String
) : Balance {

    override fun getBalanceType(): Int {
        return Balance.bonus
    }
}