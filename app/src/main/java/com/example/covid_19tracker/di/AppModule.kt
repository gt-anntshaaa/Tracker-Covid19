package com.example.covid_19tracker.di

import com.example.covid_19tracker.data.source.remote.ApiHelper
import com.example.covid_19tracker.repository.MainRepo
import com.example.covid_19tracker.repository.MainRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainRepo(apiHelper: ApiHelper) : MainRepo = MainRepoImpl(apiHelper)
}