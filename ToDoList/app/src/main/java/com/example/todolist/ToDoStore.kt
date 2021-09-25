package com.example.todolist

import android.content.Context
import android.content.Context.MODE_PRIVATE

class ToDoStore(private val context: Context) {
    fun get(): List<String> {
        return context.getSharedPreferences(
            TODOS_STORE_KEY,
            MODE_PRIVATE,
        )
            .getStringSet(TODOS_KEY, setOf())
            ?.toMutableSet()
            ?.toList() as List<String>
    }

    fun add(todo: String) {
        val prefs = context.getSharedPreferences(
            TODOS_STORE_KEY,
            MODE_PRIVATE,
        )

        val todos = prefs.getStringSet(TODOS_KEY, setOf())
            ?.toMutableSet()
        todos?.add(todo)

        prefs.edit().putStringSet(TODOS_KEY, todos).apply()
    }

    fun remove(todo: String) {
        val prefs = context.getSharedPreferences(
            TODOS_STORE_KEY,
            MODE_PRIVATE,
        )

        val todos = prefs.getStringSet(TODOS_KEY, setOf())
            ?.toMutableSet()
        todos?.remove(todo)

        prefs.edit().putStringSet(TODOS_KEY, todos).apply()
    }

    companion object {
        const val TODOS_KEY: String = "todos"
        const val TODOS_STORE_KEY: String = "com.example.todolist.sharedprefs"
    }
}