package com.example.tz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tz.databinding.RecyclerItemBonusBinding
import com.example.tz.databinding.RecyclerItemGradeBinding
import com.example.tz.databinding.RecyclerItemProfitBinding
import com.example.tz.databinding.RecyclerItemRefillBinding

open class ViewHolderFactory2(itemView: View) : RecyclerView.ViewHolder(itemView) {


    class GradeViewHolder(itemView: View) :
        ViewHolderFactory2(itemView) {
        val binding = RecyclerItemGradeBinding.bind(itemView)
        fun bind(rowItem: RowType) {

        }
    }

    class RefillViewHolder(itemView: View) :
        ViewHolderFactory2(itemView) {
        fun bind(rowItem: RowType) {

        }
    }

    class ProfitViewHolder(itemView: View) :
        ViewHolderFactory2(itemView) {
        fun bind(rowItem: RowType) {

        }
    }

    class BonusViewHolder(itemView: View) :
        ViewHolderFactory2(itemView) {
        fun bind(rowItem: RowType) {

        }
    }
}

