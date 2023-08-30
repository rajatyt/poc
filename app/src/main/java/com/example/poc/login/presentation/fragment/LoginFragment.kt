package com.example.poc.login.presentation.fragment

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.datastore.core.DataStore
import com.example.poc.R
import com.example.poc.application.PocApplication
import com.example.poc.application.component.DaggerViewModelFactory
import com.example.poc.databinding.FragmentLoginBinding
import com.example.poc.login.data.model.ChildModel
import com.example.poc.login.data.model.ParentModel
import com.example.poc.login.presentation.adapter.PageAdapter
import com.example.poc.login.presentation.viewModel.LoginViewModel
import com.google.android.material.tabs.TabLayoutMediator
import java.util.prefs.Preferences

import javax.inject.Inject

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding




    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory



    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        PocApplication.appContext.applicationComponent.doInject(this)
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    @SuppressLint("CheckResult")
    private fun init() {
//        binding.viewPager.isUserInputEnabled=false
        val adapter = PageAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        adapter.addFragment(StoreTransactionFragment(), "Store Transaction")
        adapter.addFragment(OnlineTransactionFragment(), "Online Transaction")

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

//        getTabLayout()
//        loginViewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]
//        binding.rcyMain.layoutManager=LinearLayoutManager(requireContext())
//        val parentAdapter = ParentAdapter(parentItem)
//        binding.rcyMain.adapter = parentAdapter

    }

    private fun dataStore() {

    }




}