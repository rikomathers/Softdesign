package com.example.tz.business.domain

import com.google.gson.annotations.SerializedName

data class Refill(
    val total: Double? = null,
    val withdrawn: Double? = null,
    val refillUSD: Double? = null,
    val refillRUB: Double? = null,
    val about: String? = null
)
