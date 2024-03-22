package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screen.AddTodoScreen
import com.example.myapplication.screen.TodoListScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "todoList") {
                composable("todoList") {
                    TodoListScreen(onNavigateToAddTask = {
                        navController.navigate("addTodo")
                    })
                }
                composable("addTodo") {
                    AddTodoScreen(onTaskAdded = {
                        navController.popBackStack()
                    })
                }
            }
        }
    }
}