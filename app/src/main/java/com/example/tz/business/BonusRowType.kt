package com.example.tz.business

data class BonusRowType(
    val expectedBonus: String,
    val inTeam: String,
    val replenishedRUB: String,
    val withdrawnRUB: String
) : RowType {

    override fun getItemViewType(): Int {
        return RowType.bonus
    }
}