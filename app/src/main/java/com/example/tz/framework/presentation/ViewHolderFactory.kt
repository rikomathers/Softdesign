package com.example.tz.framework.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tz.R
import com.example.tz.databinding.RecyclerItemBonusBinding
import com.example.tz.databinding.RecyclerItemGradeBinding
import com.example.tz.databinding.RecyclerItemProfitBinding
import com.example.tz.databinding.RecyclerItemRefillBinding
import com.example.tz.framework.presentation.adapter.*

open class ViewHolderFactory(itemView: View) : RecyclerView.ViewHolder(itemView) {
    open fun bind(balance: Balance) {}
    class GradeViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemGradeBinding.bind(itemView)
        override fun bind(balance: Balance) {
            (balance as GradeBalance)
            binding.tvPortfolioAppraisal.text = binding.root.context?.getString(
                R.string.dollars,
                balance.total
            )
            binding.tvPercent.text = binding.root.context?.getString(
                R.string.percent,
                balance.raise
            )
            binding.tvInShare.text = binding.root.context?.getString(
                R.string.dollars,
                balance.total
            )
            binding.tvBalanceOfUSD.text = binding.root.context?.getString(
                R.string.dollars,
                balance.balanceUSD
            )
            binding.tvBalanceOfRUB.text = binding.root.context?.getString(
                R.string.rubles,
                balance.balanceRUB
            )
        }
    }

    class RefillViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemRefillBinding.bind(itemView)
        override fun bind(balance: Balance) {
            (balance as RefillBalance)
            binding.tvReplenished.text = balance.total
            binding.tvWithdrawn.text = balance.withdrawn
            binding.tvReplenishedRUB.text = balance.refillRUB
        }
    }

    class ProfitViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemProfitBinding.bind(itemView)
        override fun bind(balance: Balance) {
            (balance as ProfitBalance)
            binding.tvProfitFromShares.text = binding.root.context?.getString(
                R.string.dollars,
                balance.total
            )
            binding.tvPercent.text = balance.raise
            binding.tvInvested.text = binding.root.context?.getString(
                R.string.dollars,
                balance.invest
            )
            binding.tvTotalCost.text = binding.root.context?.getString(
                R.string.dollars,
                balance.price
            )
        }
    }

    class BonusViewHolder(itemView: View) :
        ViewHolderFactory(itemView) {
        private val binding = RecyclerItemBonusBinding.bind(itemView)
        lateinit var balance: BonusBalance
        override fun bind(balance: Balance) {
            this.balance = (balance as BonusBalance)
            binding.tvInTeam.text = balance.team
            binding.btRUB.setOnClickListener{
                initRub()
            }
        }
        private fun initRub(){
            binding.tvExpectedBonus.text = balance.totalRUB
            binding.tvReplenishedRUB.text = balance.refillRUB
            binding.ivSquareRUB.setBackgroundColor(33000000)
        }
    }
}

