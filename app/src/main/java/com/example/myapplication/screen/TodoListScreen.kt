package com.example.myapplication.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.repo.TodoDataStore
import com.example.myapplication.repo.TodoItem

@Composable
fun TodoListScreen(onNavigateToAddTask: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToAddTask) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }
    ) {
        LazyColumn {
            items(TodoDataStore.items) { todoItem ->
                TodoItemRow(todoItem = todoItem) { id ->
                    TodoDataStore.toggleItemDone(id)
                }
            }
        }
    }
}

@Composable
fun TodoItemRow(todoItem: TodoItem, onToggleDone: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = todoItem.isDone.value,
            onCheckedChange = {
                onToggleDone(todoItem.id)
            }
        )
        Text(
            text = todoItem.task,
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f)
        )
    }
}