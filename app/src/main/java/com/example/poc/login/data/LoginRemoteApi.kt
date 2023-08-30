package com.example.poc.login.data

import com.google.gson.JsonObject
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface LoginRemoteApi {

    @GET("/posts")
    suspend fun getPosts(): Response<List<LoginRemoteModelItem>>

}