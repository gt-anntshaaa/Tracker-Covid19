package com.example.covid_19tracker.data.source.remote

import com.example.covid_19tracker.data.source.remote.response.CovidResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("prov.json")
    suspend fun getCovid(): Response<CovidResponse>
}