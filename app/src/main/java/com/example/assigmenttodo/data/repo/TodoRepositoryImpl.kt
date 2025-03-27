package com.example.assigmenttodo.data.repo

import com.example.assigmenttodo.data.model.Task
import com.example.assigmenttodo.data.source.remote.ApiService
import com.example.assigmenttodo.data.util.ApiResult
import com.example.assigmenttodo.domain.repo.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TodoRepository {

    override fun getTasks(): Flow<ApiResult<List<Task>>> = flow {
        emit(ApiResult.Loading)
        val response = apiService.getTasks()
        if (response.isSuccessful && response.body() != null) {
            emit(ApiResult.Success(response.body()!!))
        } else {
            emit(ApiResult.Error("Error: ${response.message()}"))
        }
}
    }
