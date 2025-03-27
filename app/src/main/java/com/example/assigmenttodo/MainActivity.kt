package com.example.assigmenttodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.assigmenttodo.presentation.navigation.RootNavGraph
import com.example.assigmenttodo.presentation.theme.AssigmentTodoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssigmentTodoTheme {
                RootNavGraph(rememberNavController())
            }
        }
    }
}
