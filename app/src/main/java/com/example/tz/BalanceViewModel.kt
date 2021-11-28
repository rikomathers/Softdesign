package com.example.tz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.business.domain.GetGrade
import com.example.tz.presentation.adapter.Balance
import com.example.tz.presentation.adapter.toGradeBalance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BalanceViewModel:ViewModel() {
    private val getGrade = GetGrade()
    private val _rowItemsList = MutableLiveData<List<Balance>>()
    val rowItemsList:LiveData<List<Balance>> = _rowItemsList
    fun loadBalance() {

        viewModelScope.launch(Dispatchers.IO) {
            val arrayBalance = ArrayList<Balance>()
            getGrade.execute()?.toGradeBalance()?.let { arrayBalance.add(it) }
            BalanceDataSourceImpl.getRefill()
            BalanceDataSourceImpl.getProfit()
            BalanceDataSourceImpl.getBonus()
            _rowItemsList.postValue(arrayBalance)
        }
    }
}