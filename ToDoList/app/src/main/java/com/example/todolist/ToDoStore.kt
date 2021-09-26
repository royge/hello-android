package com.example.todolist

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson
import java.io.Serializable

class ToDoStore(private val context: Context) {
    class ToDo (var description: String, var isImportant: Boolean): Serializable {
        override fun toString(): String {
            if (isImportant) {
                return "❗️$description"
            }
            return description
        }

        fun text(): String {
            return description
        }

        fun toJson(): String {
            val gson = Gson()
            return gson.toJson(this)
        }

        companion object {
            fun fromJson(json: String): ToDo {
                val gson = Gson()
                return gson.fromJson(json, ToDo::class.java)
            }
        }
    }

    fun get(): List<ToDo> {
        val todoList = context.getSharedPreferences(
            TODOS_STORE_KEY,
            MODE_PRIVATE,
        )
            .getStringSet(TODOS_KEY, setOf())
            ?.toMutableSet()
            ?.toList() as List<String>

        var todos = ArrayList<ToDo>(todoList.count())

        for (todoJson in todoList) {
            todos.add(ToDo.fromJson(todoJson))
        }

        return todos
    }

    fun add(todo: ToDo) {
        if (todo.description.trim() == "") {
            return
        }

        val prefs = context.getSharedPreferences(
            TODOS_STORE_KEY,
            MODE_PRIVATE,
        )

        val todos = prefs.getStringSet(TODOS_KEY, setOf())
            ?.toMutableSet()
        todos?.add(todo.toJson())

        prefs.edit().putStringSet(TODOS_KEY, todos).apply()
    }

    fun remove(todo: ToDo) {
        val prefs = context.getSharedPreferences(
            TODOS_STORE_KEY,
            MODE_PRIVATE,
        )

        val todos = prefs.getStringSet(TODOS_KEY, setOf())
            ?.toMutableSet()
        todos?.remove(todo.toJson())

        prefs.edit().putStringSet(TODOS_KEY, todos).apply()
    }

    fun removeAll() {
        val prefs = context.getSharedPreferences(
            TODOS_STORE_KEY,
            MODE_PRIVATE,
        )

        prefs.edit().putStringSet(TODOS_KEY, null).apply()
    }

    companion object {
        const val TODOS_KEY: String = "todos"
        const val TODOS_STORE_KEY: String = "com.example.todolist.sharedprefs"
    }
}