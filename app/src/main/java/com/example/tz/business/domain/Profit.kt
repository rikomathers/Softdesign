package com.example.tz.business.domain

import com.google.gson.annotations.SerializedName

data class Profit(
    val total: Double? = null,
    val raise: Double? = null,
    val invest: Double? = null,
    val price: Double? = null,
    val about: String? = null
)
