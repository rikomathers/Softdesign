package com.example.tz.business.domain

import com.google.gson.annotations.SerializedName

data class Grade(
    val total: Double? = null,

    val raise: Double? = null,

    val stock: Double? = null,

    val balanceUSD: Double? = null,

    val balanceRUB: Double? = null,

    val about: String? = null,

) {}
