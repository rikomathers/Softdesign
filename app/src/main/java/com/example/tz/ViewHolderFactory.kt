package com.example.tz

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tz.databinding.RecyclerItemBonusBinding
import com.example.tz.databinding.RecyclerItemGradeBinding
import com.example.tz.databinding.RecyclerItemProfitBinding
import com.example.tz.databinding.RecyclerItemRefillBinding
import com.example.tz.presentation.adapter.*

open class ViewHolderFactory(itemView: View) : RecyclerView.ViewHolder(itemView) {
    open fun bind(balance: Balance){}
    class GradeViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemGradeBinding.bind(itemView)
        override fun bind(balance: Balance) {
            (balance as GradeBalance)
            binding.tvPortfolioAppraisal.text =binding.root.context?.getString(
                R.string.dollars,
                balance.portfolioAppraisal
            )
            binding.tvPercent.text = binding.root.context?.getString(
                R.string.percent,
                balance.percent
            )
            binding.tvInShare.text = balance.inShare
            binding.tvBalanceOfUSD.text = balance.balanceOfUSD
            binding.tvBalanceOfRUB.text = balance.balanceOfUSD
        }
    }
    class RefillViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemRefillBinding.bind(itemView)
        override fun bind(balance: Balance) {
            (balance as RefillBalance)
            binding.tvReplenished.text = balance.replenished
            binding.tvWithdrawn.text = balance.withdrawn
            binding.tvReplenishedRUB.text = balance.replenishedRUB
            binding.tvWithdrawnRUB.text = balance.withdrawnRUB
        }
    }
    class ProfitViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemProfitBinding.bind(itemView)
        override fun bind(balance: Balance) {
            (balance as ProfitBalance)
            binding.tvProfitFromShares.text = balance.profitFromShares
            binding.tvPercent.text = balance.percent
            binding.tvInvested.text = balance.invested
            binding.tvTotalCost.text = balance.totalCost
        }
    }
    class BonusViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemBonusBinding.bind(itemView)
        override fun bind(balance: Balance) {
            (balance as BonusBalance)
            binding.tvExpectedBonus.text = balance.expectedBonus
            binding.tvInTeam.text = balance.inTeam
            binding.tvReplenishedRUB.text = balance.replenishedRUB
            binding.tvWithdrawnRUB.text = balance.withdrawnRUB
        }
    }
}

