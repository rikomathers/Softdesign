package com.example.tz.framework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tz.business.data.BalanceDataSourceImpl
import com.example.tz.databinding.FragmentMainBinding
import com.example.tz.framework.presentation.BalanceViewModel
import com.example.tz.framework.presentation.MultipleTypesAdapter
import javax.inject.Inject

class MainFragment @Inject constructor(
    private val balanceViewModel: BalanceViewModel
): Fragment() {

    private var binding: FragmentMainBinding? = null
    private var adapter: MultipleTypesAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MultipleTypesAdapter()
        binding?.recyclerView?.adapter = adapter
        subscribeObservers()
        balanceViewModel.loadBalance()
    }

    private fun subscribeObservers(){
        balanceViewModel.rowItemsList.observe(viewLifecycleOwner){
            adapter?.setRowItems(it)
        }

    }
}