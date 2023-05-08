package com.bala.core.kotlin.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bala.core.kotlin.di.key.ViewModelKey
import com.bala.core.kotlin.view.activity.bala.TodoViewModel
import com.bala.core.kotlin.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TodoViewModel::class)
    fun bindTodoViewModel(todoViewModel: TodoViewModel): ViewModel
}