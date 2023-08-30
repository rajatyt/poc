package com.example.poc.application.component

import com.example.poc.application.PocApplication
import com.example.poc.application.module.LoginModule
import com.example.poc.application.module.NetworkModule
import com.example.poc.application.module.ViewModelModule
import com.example.poc.home.presentation.dashboardScreen
import com.example.poc.login.presentation.fragment.LoginFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LoginModule::class,NetworkModule::class,ViewModelModule::class])
interface ApplicationComponent {

    fun doInject(pocApplication: PocApplication)

    fun DaggerViewModelFactory(): DaggerViewModelFactory

    fun doInject(loginFragment: LoginFragment)

    fun doInject(dashboardScreen: dashboardScreen)
}