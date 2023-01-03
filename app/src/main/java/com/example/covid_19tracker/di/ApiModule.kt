package com.example.covid_19tracker.di

import com.example.covid_19tracker.data.source.remote.ApiHelper
import com.example.covid_19tracker.data.source.remote.ApiService
import com.example.covid_19tracker.data.source.remote.ApiHelperImpl
import com.example.covid_19tracker.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun provideApiHelper(apiService: ApiService) : ApiHelper{
        return ApiHelperImpl(apiService)
    }

    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}