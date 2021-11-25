package com.example.tz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tz.business.RowType

class MultipleTypesAdapter : RecyclerView.Adapter<ViewHolderFactory>() {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFactory {
        val layoutInflater = LayoutInflater.from(parent.context)
        when(viewType){
            RowType.grade ->{
                val view = layoutInflater.inflate(R.layout.recycler_item_grade,parent, false)
                return ViewHolderFactory.GradeViewHolder(view)
            }
            RowType.refill ->{
                val view = layoutInflater.inflate(R.layout.recycler_item_refill,parent, false)
                return ViewHolderFactory.RefillViewHolder(view)
            }
            RowType.profit ->{
                val view = layoutInflater.inflate(R.layout.recycler_item_profit,parent, false)
                return ViewHolderFactory.ProfitViewHolder(view)
            }
            else ->{
                val view = layoutInflater.inflate(R.layout.recycler_item_bonus,parent, false)
                return ViewHolderFactory.BonusViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolderFactory, position: Int) {
        holder.bind(rowItemsList[position])
    }
    override fun getItemCount(): Int {
        return rowItemsList.size
    }
}