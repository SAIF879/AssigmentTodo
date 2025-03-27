package com.example.assigmenttodo.presentation.ui.screens.home

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assigmenttodo.data.model.Task
import com.example.assigmenttodo.data.util.ApiResult
import com.example.assigmenttodo.domain.usecases.GetTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    ) : ViewModel() {

    private val _tasks = MutableStateFlow<ApiResult<List<Task>>>(ApiResult.Loading)
    val tasks: StateFlow<ApiResult<List<Task>>> = _tasks.asStateFlow()

    init {
        loadTasks()
    }



    private fun loadTasks() {
        viewModelScope.launch {
            getTasksUseCase().collect { result ->
                _tasks.update {
                    result
                }
            }
        }

    }
    }