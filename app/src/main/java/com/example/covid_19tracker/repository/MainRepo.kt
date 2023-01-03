package com.example.covid_19tracker.repository

import com.example.covid_19tracker.data.source.remote.response.CovidResponse
import com.example.covid_19tracker.util.UiState
import retrofit2.Response

interface MainRepo {
    suspend fun getCovid() : UiState<Pair<Response<CovidResponse>, String>>
}