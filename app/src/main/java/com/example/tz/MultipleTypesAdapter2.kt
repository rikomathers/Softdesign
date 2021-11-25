package com.example.tz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tz.databinding.RecyclerItemBonusBinding
import com.example.tz.databinding.RecyclerItemGradeBinding
import com.example.tz.databinding.RecyclerItemProfitBinding
import com.example.tz.databinding.RecyclerItemRefillBinding

class MultipleTypesAdapter2 : RecyclerView.Adapter<ViewHolderFactory2>() {
    var rowItemsList = ArrayList<RowType>()
        private set
    fun setRowItems(rowItemsList: List<RowType>){
        this.rowItemsList.clear()
        this.rowItemsList.addAll(rowItemsList)
        notifyDataSetChanged()
    }
    override fun getItemViewType(position: Int): Int {
        return rowItemsList[position].getItemViewType()
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFactory2 {
        val layoutInflater = LayoutInflater.from(parent.context)
        when(viewType){
            RowType.grade ->{
                val view = layoutInflater.inflate(R.layout.recycler_item_grade,parent.context, false)
                return ViewHolderFactory2.GradeViewHolder(parent)
            }
            RowType.refill ->{
                val binding = RecyclerItemRefillBinding.inflate(layoutInflater, parent, false)
                return ViewHolderFactory2.RefillViewHolder(binding)
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

    override fun onBindViewHolder(holder: ViewHolderFactory2, position: Int) {
        TODO("Not yet implemented")
    }
}