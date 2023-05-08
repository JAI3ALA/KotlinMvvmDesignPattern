package com.bala.core.kotlin.domain.remote.response

sealed class ApiResponse<out T>(
    val isSuccessful : Boolean,
    val data : T?,
    val errorResponse: ErrorResponse?
) {
    data class Success<out T>(val responseData : List<T>?) : ApiResponse<List<T>>(true, responseData, null)
    data class SuccessNew<out T>(val responseData : T?) : ApiResponse<T>(true, responseData, null)
    data class Failure<out T>(val errorData: ErrorResponse?) : ApiResponse<T>(false, null, errorData)
}