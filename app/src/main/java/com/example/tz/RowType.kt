package com.example.tz

import androidx.recyclerview.widget.RecyclerView

interface RowType {
    companion object {
        const val grade =  1
        const val refill = 2
        const val profit = 3
        const val bonus = 4
    }
    fun getItemViewType():Int
}