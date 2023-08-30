package com.example.poc.login.presentation.viewModel

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poc.login.data.LoginRemoteApi
import com.example.poc.login.data.LoginRemoteModelItem
import com.google.gson.JsonObject
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class LoginViewModel @Inject constructor(private val loginApiService: LoginRemoteApi) :
    ViewModel() {
    private val _postsLiveData = MutableLiveData<List<LoginRemoteModelItem>>()
    val postsLiveData: LiveData<List<LoginRemoteModelItem>> = _postsLiveData

    @SuppressLint("CheckResult")
    fun getPost() {
        viewModelScope.launch {
            Log.i("DATA","Coroutine is running in ${Thread.currentThread().name}")
            try {
                val response= withContext(Dispatchers.IO){
                    loginApiService.getPosts()
                }
                if (response.isSuccessful){
                    val posts=response.body()
                    _postsLiveData.value=posts!!
                }
                else{
                    when(response.code()){
                        400->Log.i("DATA","Response is 400")
                        500->Log.i("DATA","response is 500")
                        else -> {"Unknown Error"}
                    }
                }

            }catch (e:Exception){
                Log.i("ERROR",e.message.toString())
            }
        }

    }

}