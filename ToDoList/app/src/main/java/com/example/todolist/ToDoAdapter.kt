package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(private val todos: List<String>): RecyclerView.Adapter<ToDoAdapter.ToDoHolder>() {
    class ToDoHolder(v: View): RecyclerView.ViewHolder(v) {
        private var view: View = v
        var todoDesc: String = ""

        fun bindToDo(todoDesc: String) {
            this.todoDesc = todoDesc
            view.findViewById<TextView>(R.id.textView).text = todoDesc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        return ToDoHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.to_do_row, parent, false,
        ))
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        holder.bindToDo(todos[position])
    }

    override fun getItemCount(): Int {
        return todos.count()
    }
}