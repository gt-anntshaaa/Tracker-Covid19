package com.example.covid_19tracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.covid_19tracker.data.model.Covid
import com.example.covid_19tracker.data.source.remote.response.CovidResponse
import com.example.covid_19tracker.databinding.ActivityMainBinding
import com.example.covid_19tracker.util.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.covid.observe(this, Observer {
            when(it){
                is UiState.Loading -> {}
                is UiState.Success -> {
                    val covid = it.values.first
                    val data = covid.body()?.listData?.map {
                        Covid(it.jumlahKasus, it.jumlahMeninggal, it.jumlahSembuh)
                    }

                    val dataCovid = data?.map {
                        binding.totalCase.text = it.total_kasus.toString()
                        binding.totalMeninggal.text = it.total_meningal.toString()
                        binding.totalSembuh.text = it.total_sembuh.toString()
                    }
                }
                is UiState.Failure ->{
                    Toast.makeText(this, "${it.error}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}




