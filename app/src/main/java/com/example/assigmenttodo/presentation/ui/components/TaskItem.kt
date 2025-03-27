package com.example.assigmenttodo.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assigmenttodo.data.model.Task


@Composable
fun TaskItem(task: Task) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (task.completed == true) Color.DarkGray else Color(0xFF222222),
        )) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(0.8f)) {
                    Text(
                        text = task.title ?: "NO DATA",
                        color = if (task.completed == true) Color.LightGray else Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = "User ID: ${task.userId}",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
                Checkbox(
                    checked = task.completed ?: false,
                    onCheckedChange = null,
                    modifier = Modifier.padding(start = 8.dp),
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Cyan,
                        uncheckedColor = Color.Gray,
                        checkmarkColor = Color.Black
                    )
                )
            }
        }
}

@Preview
@Composable
fun PreviewTaskItem() {
    Box(modifier = Modifier.background(Color.Black)) {
        TaskItem(task = Task(1, 1, "Sample Task", true))
    }
}