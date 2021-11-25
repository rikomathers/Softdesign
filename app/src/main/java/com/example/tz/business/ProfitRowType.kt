package com.example.tz.business

data class ProfitRowType(
    val profitFromShares: String,
    val percent: String,
    val invested: String,
    val totalCost: String
): RowType {
    override fun getItemViewType(): Int {
        return RowType.profit
    }
}