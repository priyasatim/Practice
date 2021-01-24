package com.example.practice.data

import androidx.lifecycle.LiveData
import com.example.practice.model.User

class Repository(val dao: SignUpDao) {
    val readAllData:LiveData<List<SignupRequest>>  = dao.readAllData()

    suspend fun add(request: SignupRequest){
        dao.addData(request)
    }
}