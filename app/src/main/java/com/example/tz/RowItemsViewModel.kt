package com.example.tz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tz.business.RowType

class RowItemsViewModel:ViewModel() {
    private val _rowItemsList = MutableLiveData<List<RowType>>()
    val rowItemsList:LiveData<List<RowType>> = _rowItemsList
}