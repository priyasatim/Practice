package com.example.practice.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sign_up_table")
data class SignupRequest(
    @PrimaryKey(autoGenerate = true)
    val id:Int,val first_name:String,val last_name:String,val phone_number:String,val email:String)