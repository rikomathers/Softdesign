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
            initRUB()
            binding.btRUB.setOnClickListener{initRUB()}
            binding.btUSD.setOnClickListener{initUSD()}
        }
        private fun initRUB(){
            binding.tvExpectedBonus.text = binding.root.context?.getString(
                R.string.rubles,
                balance.totalRUB
            )
            binding.tvReplenishedRUB.text = binding.root.context?.getString(
                R.string.rubles,
                balance.refillRUB
            )
            binding.btRUB.alpha = 1f
            binding.btUSD.alpha = 0.1f
            binding.tvReplenished.text = binding.root.context?.getString(
                R.string.replenished_RUB
            )
            binding.tvWithdrawn.text = binding.root.context?.getString(
                R.string.withdrawn_RUB
            )
        }
        private fun initUSD(){
            binding.tvExpectedBonus.text = binding.root.context?.getString(
                R.string.dollars,
                balance.totalUSD
            )
            binding.tvReplenishedRUB.text = binding.root.context?.getString(
                R.string.dollars,
                balance.refillUSD
            )
            binding.btUSD.alpha = 1f
            binding.btRUB.alpha = 0.1f
            binding.tvReplenished.text = binding.root.context?.getString(
                R.string.replenished_USD
            )
            binding.tvWithdrawn.text = binding.root.context?.getString(
                R.string.withdrawn_USD
            )
        }
    }
}

