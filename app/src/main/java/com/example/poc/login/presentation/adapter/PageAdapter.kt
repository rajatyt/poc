package com.example.poc.login.presentation.adapter

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.poc.login.presentation.fragment.LoginFragment
import com.example.poc.login.presentation.fragment.OnlineTransactionFragment
import com.example.poc.login.presentation.fragment.StoreTransactionFragment

class PageAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    private val fragmentList = mutableListOf<Fragment>()
    private val fragmentTitleList = mutableListOf<String>()
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    fun getPageTitle(position: Int): String {
        return fragmentTitleList[position]
    }

}