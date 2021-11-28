package com.example.tz.business.domain

import com.google.gson.annotations.SerializedName

data class Bonus(
    val totalRUB: Double? = null,
    val totalUSD: Double? = null,
    val team: Double? = null,
    val refillUSD: Double? = null,
    val refillRUB: Double? = null,
    val about: String? = null
)
