package com.bala.core.kotlin.data.usecase

import com.bala.core.kotlin.data.repository.TodoRepository
import com.bala.core.kotlin.domain.entity.PhotoEntity
import com.bala.core.kotlin.domain.remote.response.ApiResponse
import com.bala.core.kotlin.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class TodoUseCase @Inject constructor(
    private val repository: TodoRepository
) : BaseUseCase(repository) {

    suspend fun getPhotoList(): ApiResponse<List<PhotoEntity>> {
        val response = repository.getPhotoList()
        return response
    }
}