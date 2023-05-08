package com.bala.core.kotlin.domain.repository

import com.bala.core.kotlin.domain.entity.PhotoEntity
import com.bala.core.kotlin.domain.remote.response.ApiResponse
import com.bala.core.kotlin.domain.repository.base.IRepository
import com.bala.core.kotlin.domain.service.TodoService

abstract class BaseTodoRepository(service: TodoService) : IRepository {

    abstract suspend fun getPhotoList() : ApiResponse<List<PhotoEntity>>

}