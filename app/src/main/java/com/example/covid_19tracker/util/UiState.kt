package com.example.covid_19tracker.util

sealed class UiState<out T>{
    object Loading : UiState<Nothing>()
    data class Success<out T>(val values: T) : UiState<T>()
    data class Failure(val error: String) : UiState<Nothing>()
}
