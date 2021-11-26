package com.example.tz.business

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