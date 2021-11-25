package com.example.tz

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tz.business.RowType
import com.example.tz.databinding.RecyclerItemBonusBinding
import com.example.tz.databinding.RecyclerItemGradeBinding
import com.example.tz.databinding.RecyclerItemProfitBinding
import com.example.tz.databinding.RecyclerItemRefillBinding

open class ViewHolderFactory(itemView: View) : RecyclerView.ViewHolder(itemView) {
    open fun bind(rowType: RowType) {
    }

    class GradeViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        val binding = RecyclerItemGradeBinding.bind(itemView)
        override fun bind(rowItem: RowType) {

        }
    }

    class RefillViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        val binding = RecyclerItemRefillBinding.bind(itemView)
        override fun bind(rowItem: RowType) {

        }
    }

    class ProfitViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        val binding = RecyclerItemProfitBinding.bind(itemView)
        override fun bind(rowItem: RowType) {

        }
    }

    class BonusViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        val binding = RecyclerItemBonusBinding.bind(itemView)
        override fun bind(rowItem: RowType) {

        }
    }
}

