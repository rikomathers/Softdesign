package com.example.tz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tz.databinding.RecyclerItemBonusBinding
import com.example.tz.databinding.RecyclerItemGradeBinding
import com.example.tz.databinding.RecyclerItemProfitBinding
import com.example.tz.databinding.RecyclerItemRefillBinding

open class ViewHolderFactory(itemView: View) : RecyclerView.ViewHolder(itemView) {

    open fun bind(rowItem:RowType){

    }

    class GradeViewHolder(private val binding: RecyclerItemGradeBinding) :
        ViewHolderFactory(binding) {
        override fun bind(rowItem:RowType) {

        }
    }

    class RefillViewHolder(private val binding: RecyclerItemRefillBinding) :
        ViewHolderFactory(binding) {
        override fun bind(rowItem:RowType) {

        }
    }

    class ProfitViewHolder(private val binding: RecyclerItemProfitBinding) :
        ViewHolderFactory(binding) {
        override fun bind(rowItem:RowType) {

        }
    }

    class BonusViewHolder(private val binding: RecyclerItemBonusBinding) :
        ViewHolderFactory(binding) {
        override fun bind(rowItem:RowType) {

        }
    }
}
