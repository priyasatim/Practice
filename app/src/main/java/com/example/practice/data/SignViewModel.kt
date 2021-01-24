package com.example.practice.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignViewModel(application:Application):AndroidViewModel(application) {
    val readAllData : LiveData<List<SignupRequest>> = TODO()
    val repository : Repository

    init {
        val signUpDao = SignUpDatabase.getDatabase(application).dao()
        repository = Repository(signUpDao)
        readAllData = repository.readAllData
    }
    fun addData(data:SignupRequest){
        viewModelScope.launch (Dispatchers.IO){
            repository.add(data)
        }
    }

}