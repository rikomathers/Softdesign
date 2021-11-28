package com.example.tz.business.data.model

import com.google.gson.annotations.SerializedName

class BonusResponse {

    @SerializedName("totalRUB")
    val totalRUB: Double? = null

    @SerializedName("totalUSD")
    val totalUSD: Double? = null

    @SerializedName("team")
    val team: Double? = null

    @SerializedName("refillUSD")
    val refillUSD: Double? = null

    @SerializedName("refillRUB")
    val refillRUB: Double? = null

    @SerializedName("about")
    val about: Double? = null

    override fun toString(): String {
        return "com.example.tz.business.data.model.BonusResponse(totalRUB=$totalRUB, totalUSD=$totalUSD, team=$team, refillUSD=$refillUSD, refillRUB=$refillRUB, about=$about)"
    }


}