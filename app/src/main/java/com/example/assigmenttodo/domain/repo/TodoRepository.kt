package com.example.assigmenttodo.domain.repo

import com.example.assigmenttodo.data.model.Task
import kotlinx.coroutines.flow.Flow

interface  TodoRepository{
     fun getTasks(): Flow<List<Task>>
}