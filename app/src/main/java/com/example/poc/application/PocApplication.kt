package com.example.poc.application

import android.app.Application
import com.example.poc.application.component.ApplicationComponent
import com.example.poc.application.component.DaggerApplicationComponent
import com.example.poc.application.module.LoginModule
import com.example.poc.application.module.NetworkModule
import javax.inject.Inject

class PocApplication : Application() {

    @Inject
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appContext=this
        applicationComponent = DaggerApplicationComponent
            .builder()
            .loginModule(LoginModule())
            .build()

        applicationComponent.doInject(this)

    }

    companion object {
        //use this for dagger
        lateinit var appContext: PocApplication
    }
}