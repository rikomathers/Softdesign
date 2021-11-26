package com.example.tz

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tz.business.*
import com.example.tz.databinding.RecyclerItemBonusBinding
import com.example.tz.databinding.RecyclerItemGradeBinding
import com.example.tz.databinding.RecyclerItemProfitBinding
import com.example.tz.databinding.RecyclerItemRefillBinding

open class ViewHolderFactory(itemView: View) : RecyclerView.ViewHolder(itemView) {
    open fun bind(rowType: RowType) {
    }

    class GradeViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemGradeBinding.bind(itemView)
        override fun bind(rowItem: RowType) {
            (rowItem as GradeRowType)
            binding.tvPortfolioAppraisal.text = rowItem.portfolioAppraisal
            binding.tvPercent.text = rowItem.percent
            binding.tvInShare.text = rowItem.inShare
            binding.tvBalanceOfUSD.text = rowItem.balanceOfUSD
            binding.tvBalanceOfRUB.text = rowItem.balanceOfUSD
        }
    }

    class RefillViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemRefillBinding.bind(itemView)
        override fun bind(rowItem: RowType) {
            (rowItem as RefillRowType)
            binding.tvReplenished.text = rowItem.replenished
            binding.tvWithdrawn.text = rowItem.withdrawn
            binding.tvReplenishedRUB.text = rowItem.replenishedRUB
            binding.tvWithdrawnRUB.text = rowItem.withdrawnRUB
        }
    }

    class ProfitViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemProfitBinding.bind(itemView)
        override fun bind(rowItem: RowType) {
            (rowItem as ProfitRowType)
            binding.tvProfitFromShares.text = rowItem.profitFromShares
            binding.tvPercent.text = rowItem.percent
            binding.tvInvested.text = rowItem.invested
            binding.tvTotalCost.text = rowItem.totalCost
        }
    }

    class BonusViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemBonusBinding.bind(itemView)
        override fun bind(rowItem: RowType) {
            (rowItem as BonusRowType)
            binding.tvExpectedBonus.text = rowItem.expectedBonus
            binding.tvInTeam.text = rowItem.inTeam
            binding.tvReplenishedRUB.text = rowItem.replenishedRUB
            binding.tvWithdrawnRUB.text = rowItem.withdrawnRUB
        }
    }
}

