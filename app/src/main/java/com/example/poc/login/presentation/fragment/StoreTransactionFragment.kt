package com.example.poc.login.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poc.R
import com.example.poc.databinding.FragmentStoreTransactionBinding
import com.example.poc.login.data.model.ChildModel
import com.example.poc.login.data.model.ParentModel
import com.example.poc.login.presentation.adapter.ParentAdapter


class StoreTransactionFragment : Fragment() {

    lateinit var binding: FragmentStoreTransactionBinding
    val childModel1= listOf(
        ChildModel("1"),
        ChildModel("2"),
        ChildModel("3"),
        ChildModel("4")
    )
    val childModel2= listOf(
        ChildModel("5"),
        ChildModel("6"),
        ChildModel("7"),
        ChildModel("8")
    )

    val parentItem= listOf(
        ParentModel("Transaction ID:1111",childModel1),
        ParentModel("Transaction ID:22222",childModel2),
        ParentModel("Transaction ID:1111",childModel1),
        ParentModel("Transaction ID:22222",childModel2),
        ParentModel("Transaction ID:22222",childModel2)

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_store_transaction,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.rcyMain.layoutManager = LinearLayoutManager(requireContext())
        val parentAdapter = ParentAdapter(parentItem)
        binding.rcyMain.adapter = parentAdapter

    }
}