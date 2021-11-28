package com.example.tz.presentation.adapter

import com.example.tz.business.data.model.GradeResponse
import com.example.tz.business.domain.Grade

data class GradeBalance(
    val total: String,
    val raise: String,
    val stock: String,
    val balanceUSD: String,
    val balanceRUB: String
) : Balance {
    override fun getBalanceType(): Int {
        return Balance.grade
    }
}
fun Grade.toGradeBalance(): GradeBalance {
    return GradeBalance(
        total = total.toString(),
        raise = raise.toString(),
        stock = stock.toString(),
        balanceUSD = balanceUSD.toString(),
        balanceRUB = balanceRUB.toString()
    )
}
