package com.example.assigmenttodo.domain.usecases

import com.example.assigmenttodo.data.model.Task
import com.example.assigmenttodo.domain.repo.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val repository: TodoRepository) {
    operator fun invoke(): Flow<List<Task>> {
        return repository.getTasks()
    }
}
