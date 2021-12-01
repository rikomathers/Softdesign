package com.example.tz.framework.presentation.adapter

import com.example.tz.business.domain.Profit

data class ProfitBalance(
    val total: String,
    val raise: String,
    val invest: String,
    val price: String
) : Balance {
    override fun getBalanceType(): Int {
        return Balance.profit
    }
}
fun Profit.toProfitBalance(): ProfitBalance {
    return ProfitBalance(
        total = total.toString(),
        raise = raise.toString(),
        invest = invest.toString(),
        price = price.toString()
    )
}