package com.bala.core.kotlin.data.repository

import com.bala.core.kotlin.domain.entity.PhotoEntity
import com.bala.core.kotlin.domain.remote.response.ApiResponse
import com.bala.core.kotlin.domain.repository.BaseTodoRepository
import com.bala.core.kotlin.domain.service.TodoService
import javax.inject.Inject

class TodoRepository @Inject constructor(private val service: TodoService) :
    BaseTodoRepository(service) {

    override suspend fun getPhotoList(): ApiResponse<List<PhotoEntity>> {
        return handleRequest { service.getPhotoDetails() }
    }
}