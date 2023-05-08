package com.bala.core.kotlin.domain.service

import com.bala.core.kotlin.domain.entity.PhotoEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TodoService {

    @GET("https://jsonplaceholder.typicode.com/photos")
    suspend fun getPhotoDetails() : Response<ArrayList<PhotoEntity>>

}