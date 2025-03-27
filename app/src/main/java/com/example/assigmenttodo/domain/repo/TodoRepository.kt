package com.example.assigmenttodo.domain.repo

import com.example.assigmenttodo.data.model.Task
import com.example.assigmenttodo.data.util.ApiResult
import kotlinx.coroutines.flow.Flow

interface  TodoRepository{
     fun getTasks(): Flow<ApiResult<List<Task>>>
}