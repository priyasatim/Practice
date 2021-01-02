package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.model.User
import com.example.practice.webservice.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //retrofit builder
        var retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build()

        //object to call method
        var jsonPlaceholderApi = retrofit.create(API::class.java)

        var call :Call<List<User>> = jsonPlaceholderApi.getList()

        call.enqueue(object :Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("error",t.message.toString())
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val users:List<User> = response.body()!!

                var stringBuilder  = StringBuilder()
                for(user in users){
                    stringBuilder.append(user.id)
                    stringBuilder.append("\n")
                    stringBuilder.append(user.title)
                    stringBuilder.append("\n")
                    stringBuilder.append(user.body)
                    stringBuilder.append("\n")
                }
                binding.tvName.text = stringBuilder
            }
        })

    }
}