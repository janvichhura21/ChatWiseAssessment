package com.example.chatwiseassement.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.chatwiseassement.model.User
import com.example.chatwiseassement.model.UserItem
import com.example.chatwiseassement.network.RetrofitHelper
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {
    val apiList: MutableLiveData<List<UserItem>> = MutableLiveData()
    fun getMovie(): MutableLiveData<List<UserItem>>{
        RetrofitHelper.getInstance.getMovie().enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    apiList.value=response.body()!!
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("task","error",t)
            }

        })
        return apiList
    }
}