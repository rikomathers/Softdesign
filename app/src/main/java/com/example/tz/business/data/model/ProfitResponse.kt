package com.example.tz.business.data.model

import com.google.gson.annotations.SerializedName

class ProfitResponse {

    @SerializedName("total")
    val total: Double? = null

    @SerializedName("raise")
    val raise: Double? = null

    @SerializedName("invest")
    val invest: Double? = null

    @SerializedName("price")
    val price: Double? = null

    @SerializedName("about")
    val about: String? = null
    override fun toString(): String {
        return "com.example.tz.business.data.model.ProfitResponse(total=$total, raise=$raise, invest=$invest, price=$price, about=$about)"
    }


}