package com.example.tz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RawRes
import androidx.fragment.app.Fragment
import com.example.tz.business.*
import com.example.tz.databinding.FragmentMainBinding

class MainFragment : Fragment() {
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
        adapter?.setRowItems(createList())
    }

    private fun createList(): List<RowType> {
        return listOf(
            GradeRowType(
                "256,869.02 $",
                "56%",
                "85,875.74 $",
                "84546549",
                "4378"
            ), RefillRowType(
                "375,869.02 $",
                "85,875.74 $",
                "41,875.74 $",
                "65546549"
            ), BonusRowType(
                "600,869.02 $",
                "789",
                "52,875.74 $",
                "14146549"
            ), ProfitRowType(
                "256,869.02 $",
                "56%",
                "85,875.74 $",
                "56"
            ), BonusRowType(
                "600,869.02 $",
                "789",
                "52,875.74 $",
                "14146549"
            ), ProfitRowType(
                "256,869.02 $",
                "56%",
                "85,875.74 $",
                "56"
            ), GradeRowType(
                "256,869.02 $",
                "56%",
                "85,875.74 $",
                "84546549",
                "4378"
            ), RefillRowType(
                "375,869.02 $",
                "85,875.74 $",
                "41,875.74 $",
                "65546549"
            )
        )

    }
}