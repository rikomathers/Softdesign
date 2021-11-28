package com.example.tz.business.data.model

import com.example.tz.business.domain.Grade
import com.example.tz.business.domain.Refill
import com.google.gson.annotations.SerializedName

class RefillResponse {

    @SerializedName("total")
    val total: Double? = null

    @SerializedName("withdrawn")
    val withdrawn: Double? = null

    @SerializedName("refillUSD")
    val refillUSD: Double? = null

    @SerializedName("refillRUB")
    val refillRUB: Double? = null

    @SerializedName("about")
    val about: String? = null

    override fun toString(): String {
        return "com.example.tz.business.data.model.RefillResponse(total=$total, withdrawn=$withdrawn, refillUSD=$refillUSD, refillRUB=$refillRUB, about=$about)"
    }
}
fun RefillResponse.toRefill(): Refill {
    return Refill(
        total = total,
        withdrawn = withdrawn,
        refillUSD = refillUSD,
        refillRUB = refillRUB,
        about = about
    )
}