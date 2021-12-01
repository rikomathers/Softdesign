package com.example.tz.framework.presentation.adapter

import androidx.recyclerview.widget.RecyclerView

interface Balance {
    companion object {
        const val grade =  1
        const val refill = 2
        const val profit = 3
        const val bonus = 4
    }
    fun getBalanceType():Int
}