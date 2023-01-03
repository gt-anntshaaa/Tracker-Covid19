package com.example.covid_19tracker.data.source.remote

import com.example.covid_19tracker.data.source.remote.response.CovidResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getCovid(): Response<CovidResponse> {
        return apiService.getCovid()
    }
}