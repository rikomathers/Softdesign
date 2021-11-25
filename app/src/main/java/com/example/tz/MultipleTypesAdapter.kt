package com.example.tz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tz.databinding.RecyclerItemBonusBinding
import com.example.tz.databinding.RecyclerItemGradeBinding
import com.example.tz.databinding.RecyclerItemProfitBinding
import com.example.tz.databinding.RecyclerItemRefillBinding

class MultipleTypesAdapter(private val dataSet:List<RowType>):
    RecyclerView.Adapter<ViewHolderFactory>() {
    override fun getItemViewType(position: Int): Int {
        return dataSet[position].getItemViewType()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFactory {
        val layoutInflater = LayoutInflater.from(parent.context)

        when(viewType){
            RowType.grade ->{
                val binding = RecyclerItemGradeBinding.inflate(layoutInflater, parent, false)
                return ViewHolderFactory.GradeViewHolder(binding)
            }
            RowType.refill ->{
                val binding = RecyclerItemRefillBinding.inflate(layoutInflater, parent, false)
                return ViewHolderFactory.RefillViewHolder(binding)
            }
            RowType.profit ->{
                val binding = RecyclerItemProfitBinding.inflate(layoutInflater, parent, false)
                return ViewHolderFactory.ProfitViewHolder(binding)
            }
            else ->{
                val binding = RecyclerItemBonusBinding.inflate(layoutInflater, parent, false)
                return ViewHolderFactory.BonusViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolderFactory, position: Int) {

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}