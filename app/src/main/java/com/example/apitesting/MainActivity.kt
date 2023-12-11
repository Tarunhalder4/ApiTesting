package com.example.apitesting

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.apitesting.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val postViewModel:PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postViewModel.getPost()

        lifecycleScope.launchWhenCreated {
            postViewModel.stateFlow.collect {

                when (it) {
                    is ApiState.Loading -> {
                        Log.d("tarun", "onCreate: loading")
                    }

                    is ApiState.Success<*> -> {
                        Log.d("tarun", "onCreate 12: ${it.data}")
                    }

                    is ApiState.Error -> {
                        Log.d("tarun", "onCreate: ${it.massage}")
                    }

                    else -> {
                        Log.d("tarun", "onCreate: unwanted option")
                    }
                }
            }
        }



    }
}