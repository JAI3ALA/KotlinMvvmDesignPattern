package com.bala.core.kotlin.view.activity.bala

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bala.core.kotlin.common.liveevent.SingleLiveEvent
import com.bala.core.kotlin.data.usecase.TodoUseCase
import com.bala.core.kotlin.domain.entity.PhotoEntity
import com.bala.core.kotlin.domain.remote.response.ErrorResponse
import com.bala.core.kotlin.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class TodoViewModel @Inject constructor(private val useCase: TodoUseCase) : BaseViewModel() {

    val photoEntity = MutableLiveData<List<PhotoEntity>>()
    val todoDataFailureEvent = SingleLiveEvent<ErrorResponse>()

    fun getAllList(): MutableLiveData<List<PhotoEntity>> {
        return photoEntity
    }
    fun getPhotoData() {
        photoEntity.value = null
        viewModelScope.launch {
            val response = useCase.getPhotoList()
            if (response.isSuccessful) {
                photoEntity.value = response.data
            } else {
                todoDataFailureEvent.value = response.errorResponse
            }
        }

    }
}