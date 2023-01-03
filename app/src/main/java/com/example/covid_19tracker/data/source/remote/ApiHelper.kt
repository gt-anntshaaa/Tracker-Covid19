package com.example.covid_19tracker.data.source.remote

import com.example.covid_19tracker.data.source.remote.response.CovidResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getCovid(): Response<CovidResponse>
}