package com.example.apitesting

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apitesting.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel:DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rec.layoutManager = LinearLayoutManager(this)


        viewModel.getData()
        viewModel.data.observe(this, object : Observer<Images> {
            override fun onChanged(value: Images) {
                val adapter = DataAdapter(this@MainActivity, viewModel.data.value?.images)
                binding.rec.adapter = adapter
            }

        })

    }




}