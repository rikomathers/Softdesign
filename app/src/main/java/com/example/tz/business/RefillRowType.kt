package com.example.tz.business

data class RefillRowType(
    val replenished: String,
    val withdrawn: String,
    val replenishedRUB: String,
    val withdrawnRUB: String
): RowType {

    override fun getItemViewType(): Int {
        return RowType.refill
    }
}