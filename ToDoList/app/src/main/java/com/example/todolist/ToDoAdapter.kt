package com.example.todolist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(private val todos: List<ToDoStore.ToDo>): RecyclerView.Adapter<ToDoAdapter.ToDoHolder>() {
    class ToDoHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        lateinit var todo: ToDoStore.ToDo

        fun bindToDo(todo: ToDoStore.ToDo) {
            this.todo = todo
            view.findViewById<TextView>(R.id.textView).text = todo.toString()
        }

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val intent = Intent(view.context, CreateToDo::class.java)
            intent.putExtra("todo", todo)
            startActivity(view.context, intent, null)
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