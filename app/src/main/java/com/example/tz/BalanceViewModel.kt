package com.example.tz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.business.domain.GetBonus
import com.example.tz.business.domain.GetGrade
import com.example.tz.business.domain.GetProfit
import com.example.tz.business.domain.GetRefill
import com.example.tz.presentation.adapter.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BalanceViewModel:ViewModel() {
    private val getGrade = GetGrade()
    private val getRefill = GetRefill()
    private val getProfit = GetProfit()
    private val getBonus = GetBonus()
    private val _rowItemsList = MutableLiveData<List<Balance>>()
    val rowItemsList:LiveData<List<Balance>> = _rowItemsList
    fun loadBalance() {

        viewModelScope.launch(Dispatchers.IO) {
            val arrayBalance = ArrayList<Balance>()
            getGrade.execute()?.toGradeBalance()?.let { arrayBalance.add(it) }
            getRefill.execute()?.toRefillBalance()?.let { arrayBalance.add(it) }
            getProfit.execute()?.toProfitBalance()?.let { arrayBalance.add(it) }
            getBonus.execute()?.toBonusBalance()?.let { arrayBalance.add(it) }
            _rowItemsList.postValue(arrayBalance)
        }
    }
}