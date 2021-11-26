package com.example.tz.business

data class RefillBalance(
    val replenished: String,
    val withdrawn: String,
    val replenishedRUB: String,
    val withdrawnRUB: String
): Balance {

    override fun getBalanceType(): Int {
        return Balance.refill
    }
}