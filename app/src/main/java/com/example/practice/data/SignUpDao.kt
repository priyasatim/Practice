package com.example.practice.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SignUpDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addData(signupRequest: SignupRequest)

    @Query("SELECT * FROM sign_up_table ORDER BY id ASC")
    fun readAllData() :LiveData<List<SignupRequest>>
}