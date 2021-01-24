package com.example.practice.view

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.practice.R
import com.example.practice.databinding.FragmentSplashScreenBinding
class SplashScreenFragment : Fragment() {
    lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_splash_screen, container, false)

        Handler().postDelayed(Runnable {
            findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment) }, 5000)

    return view}
}