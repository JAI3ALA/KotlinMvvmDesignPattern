package com.bala.core.kotlin.di.module

import com.bala.core.kotlin.domain.service.TodoService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideTodoService(retrofit: Retrofit) : TodoService {
        return retrofit.create(TodoService::class.java)
    }
}