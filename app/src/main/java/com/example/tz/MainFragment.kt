package com.example.tz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tz.business.*
import com.example.tz.databinding.FragmentMainBinding

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
        adapter?.setRowItems(createList())
    }

    override fun onResume() {
        super.onResume()
        balanceViewModel.loadBalance()
    }

    private fun createList(): List<Balance> {
        return listOf(
            GradeBalance(
                "256,869.02 $",
                "56%",
                "85,875.74 $",
                "84546549",
                "4378"
            ), RefillBalance(
                "375,869.02 $",
                "85,875.74 $",
                "41,875.74 $",
                "65546549"
            ), BonusBalance(
                "600,869.02 $",
                "789",
                "52,875.74 $",
                "14146549"
            ), ProfitBalance(
                "256,869.02 $",
                "56%",
                "85,875.74 $",
                "56"
            ), BonusBalance(
                "600,869.02 $",
                "789",
                "52,875.74 $",
                "14146549"
            ), ProfitBalance(
                "256,869.02 $",
                "56%",
                "85,875.74 $",
                "56"
            ), GradeBalance(
                "256,869.02 $",
                "56%",
                "85,875.74 $",
                "84546549",
                "4378"
            ), RefillBalance(
                "375,869.02 $",
                "85,875.74 $",
                "41,875.74 $",
                "65546549"
            )
        )

    }
}