package com.bala.core.kotlin.view.activity.bala

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bala.core.kotlin.BR
import com.bala.core.kotlin.R
import com.bala.core.kotlin.common.logger.Logger
import com.bala.core.kotlin.databinding.ActivityTodoBinding
import com.bala.core.kotlin.domain.entity.PhotoEntity
import com.bala.core.kotlin.view.activity.base.BaseActivity
import com.bala.core.kotlin.view.activity.base.RecyclerViewAdapterNew


private const val TAG = "TodoActivity"


class TodoActivity : BaseActivity<TodoViewModel, ActivityTodoBinding>() {

    override val layoutRes = R.layout.activity_todo
    override val bindingVariable = BR.viewModel
    override val viewModelClass = TodoViewModel::class.java

    private lateinit var binding: ActivityTodoBinding
    var photoEntityList: ArrayList<PhotoEntity> = arrayListOf()
    lateinit var myAdapter: RecyclerViewAdapterNew

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_todo)
        observeTodoDataFailureEvent()
    }

    private fun observeTodoDataFailureEvent() {
        viewModel.todoDataFailureEvent.observe(this, Observer {
            Toast.makeText(this, "Error: $it", Toast.LENGTH_SHORT).show()
            Logger.Error(TAG, "Todo data fetch failed -> $it")
        })

        viewModel.getPhotoData()
        viewModel.getAllList().observe(this, Observer {
            if (it != null) {
                photoEntityList.addAll(it)
                myAdapter = RecyclerViewAdapterNew(photoEntityList)
                binding.getMyList.adapter = myAdapter
            }
        })


    }
}