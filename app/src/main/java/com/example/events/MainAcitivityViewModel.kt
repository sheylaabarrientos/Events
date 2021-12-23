package com.example.events

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events.data.base.ApiInterface
import com.example.events.data.base.RetroInstance
import com.example.events.domain.User
import com.example.events.domain.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainAcitivityViewModel : ViewModel() {
    var createNewUserLiveData: MutableLiveData<UserResponse> = MutableLiveData()

    fun getCreateNewUserObserver(): MutableLiveData<UserResponse> {
        return createNewUserLiveData
    }

    fun creatNewUser(user: User) {
        val retroService = RetroInstance.getRetroInstance().create(ApiInterface::class.java)
        val call = retroService.createUser(user)
        call.enqueue(object : Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                createNewUserLiveData.postValue(null)
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    createNewUserLiveData.postValue(response.body())
                } else {
                    createNewUserLiveData.postValue(null)
                }
            }
        })
    }
}
