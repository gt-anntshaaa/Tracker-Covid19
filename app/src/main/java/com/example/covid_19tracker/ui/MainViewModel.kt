package com.example.covid_19tracker.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid_19tracker.data.source.remote.response.CovidResponse
import com.example.covid_19tracker.repository.MainRepo
import com.example.covid_19tracker.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: MainRepo) : ViewModel() {
    private val _covid = MutableLiveData<UiState<Pair<Response<CovidResponse>, String>>>()
    val covid: LiveData<UiState<Pair<Response<CovidResponse>,String>>> = _covid

    init {
        loadDataCovid()
    }

    private fun loadDataCovid() = viewModelScope.launch {
        _covid.value = UiState.Loading
        val result = repo.getCovid()
        if (result is UiState.Success){
            _covid.value = UiState.Success(result.values)
        }else if (result is UiState.Failure){
            _covid.value = UiState.Failure(result.error)
        }else{
            throw Exception("Hasil tidak ditemukan")
        }
    }
}