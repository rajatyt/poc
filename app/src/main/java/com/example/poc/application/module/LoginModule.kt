package com.example.poc.application.module

import com.example.poc.login.data.LoginRemoteApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class LoginModule {


    @Provides
    @Singleton
    fun providesLoginRemoteService(retrofit: Retrofit): LoginRemoteApi {
        return retrofit.create(LoginRemoteApi::class.java)
    }
}