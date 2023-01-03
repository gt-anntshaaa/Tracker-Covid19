package com.example.covid_19tracker.repository

import com.example.covid_19tracker.data.source.remote.ApiHelper
import com.example.covid_19tracker.data.source.remote.response.CovidResponse
import com.example.covid_19tracker.util.UiState
import retrofit2.Response
import javax.inject.Inject

class MainRepoImpl @Inject constructor(private val apiHelper: ApiHelper) : MainRepo {
    override suspend fun getCovid(): UiState<Pair<Response<CovidResponse>, String>> {
        return try {
            val data = apiHelper.getCovid()
            UiState.Success(Pair(data, "Load is succesfully"))
        }catch (e: Exception){
            UiState.Failure("Load is failed")
        }
    }
}