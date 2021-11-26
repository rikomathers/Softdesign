package com.example.tz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tz.business.Balance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BalanceViewModel:ViewModel() {
    private val _rowItemsList = MutableLiveData<List<Balance>>()
    val rowItemsList:LiveData<List<Balance>> = _rowItemsList
    fun loadBalance() {

        viewModelScope.launch(Dispatchers.IO) {
            val jokes = BalanceDataSourceImpl.getBalance()
        }
    }
}