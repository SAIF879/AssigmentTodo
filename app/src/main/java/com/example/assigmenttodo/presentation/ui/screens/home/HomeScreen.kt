package com.example.assigmenttodo.presentation.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.assigmenttodo.data.model.Task
import com.example.assigmenttodo.data.util.ApiResult
import com.example.assigmenttodo.presentation.ui.components.TaskItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(todoList: ApiResult<List<Task>>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TASK LIST", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF121212)
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    /* todo: on click add item */
                },
                containerColor = Color.Cyan,
                contentColor = Color.Black
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Task")
            }
        },
        containerColor = Color.Black 
    ){ paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (todoList) {
                is ApiResult.Error -> {
                    // Show error message
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "Error loading tasks",
                            color = Color.Red,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                ApiResult.Loading -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.Cyan
                        )
                    }
                }
                is ApiResult.Success -> {
                    val tasks = todoList.data ?: emptyList()
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        items(tasks) { task ->
                            TaskItem(
                                task = task,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}

