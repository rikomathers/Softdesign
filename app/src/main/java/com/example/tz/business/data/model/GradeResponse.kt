package com.example.tz.business.data.model

import com.example.tz.business.domain.Grade
import com.google.gson.annotations.SerializedName

class GradeResponse {

    @SerializedName("total")
    val total: Double? = null

    @SerializedName("raise")
    val raise: Double? = null

    @SerializedName("stock")
    val stock: Double? = null

    @SerializedName("balanceUSD")
    val balanceUSD: Double? = null

    @SerializedName("balanceRUB")
    val balanceRUB: Double? = null

    @SerializedName("about")
    val about: String? = null

    override fun toString(): String {
        return "BalanceResponse(total=$total, raise=$raise, stock=$stock, balanceUSD=$balanceUSD, balanceRUB=$balanceRUB, about=$about)"
    }
}

fun GradeResponse.toGrade(): Grade {
    return Grade(
        total = total,
        raise = raise,
        stock = stock,
        balanceUSD = balanceUSD,
        balanceRUB = balanceRUB,
        about = about
    )
}