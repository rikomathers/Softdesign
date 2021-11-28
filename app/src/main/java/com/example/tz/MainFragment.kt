package com.example.tz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tz.databinding.FragmentMainBinding
import com.example.tz.presentation.adapter.*

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null
    private var adapter: MultipleTypesAdapter? = null
    private lateinit var balanceViewModel: BalanceViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        balanceViewModel =
            ViewModelProvider(this).get(BalanceViewModel::class.java)
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