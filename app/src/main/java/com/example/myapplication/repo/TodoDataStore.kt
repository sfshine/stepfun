package com.example.myapplication.repo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf


data class TodoItem(val id: Int, var task: String, var isDone: MutableState<Boolean>)


object TodoDataStore {
    private val todoItems = mutableStateListOf<TodoItem>()
    private var nextId = 1

    val items: List<TodoItem>
        get() = todoItems

    fun addItem(task: String) {
        todoItems.add(TodoItem(nextId++, task, mutableStateOf(false)))
    }

    fun toggleItemDone(id: Int) {
//        todoItems.forEach {
//            if (it.id == id) {
//                it.isDone = !it.isDone
//            }
//        }
        todoItems.find { it.id == id }?.let {
            it.isDone.value = !it.isDone.value
        }
    }
}