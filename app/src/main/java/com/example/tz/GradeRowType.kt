package com.example.tz

import androidx.recyclerview.widget.RecyclerView

data class GradeRowType(
    val portfolioAppraisal: String,
    val percent: String,
    val inShare: String,
    val balanceOfUSD: String,
    val balanceOfRUB: String
) : RowType {
    override fun getItemViewType(): Int {
        return 1
    }
}