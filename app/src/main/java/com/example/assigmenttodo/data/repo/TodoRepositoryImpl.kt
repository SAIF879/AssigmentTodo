package com.example.assigmenttodo.data.repo

import com.example.assigmenttodo.data.model.Task
import com.example.assigmenttodo.data.source.remote.ApiService
import com.example.assigmenttodo.domain.repo.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TodoRepository {

    override fun getTasks(): Flow<List<Task>> = flow {
        emit(apiService.getTasks())
    }.catch {
        emit(emptyList())
    }.flowOn(Dispatchers.IO)


}
