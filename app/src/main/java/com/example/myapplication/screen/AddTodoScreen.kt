package com.example.myapplication.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.repo.TodoDataStore

@Composable
fun AddTodoScreen(onTaskAdded: () -> Unit) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Task") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
//            if (text.length != 0) {
            TodoDataStore.addItem(text)
            onTaskAdded()
//            }
        }) {
            Text("Submit")
        }
    }
}