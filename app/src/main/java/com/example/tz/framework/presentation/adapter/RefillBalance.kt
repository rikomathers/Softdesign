package com.example.tz.framework.presentation.adapter

import com.example.tz.business.domain.Grade
import com.example.tz.business.domain.Refill

data class RefillBalance(
    val total: String,
    val withdrawn: String,
    val refillUSD: String,
    val refillRUB: String
): Balance {

    override fun getBalanceType(): Int {
        return Balance.refill
    }
}
fun Refill.toRefillBalance(): RefillBalance {
    return RefillBalance(
        total = total.toString(),
        withdrawn = withdrawn.toString(),
        refillUSD = refillUSD.toString(),
        refillRUB = refillRUB.toString()
    )
}