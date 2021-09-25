package com.example.todolist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: ToDoAdapter
    private val store: ToDoStore = ToDoStore(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.addItemDecoration(DividerItemDecoration(
            recyclerView.context,
            DividerItemDecoration.VERTICAL,
        ))

        binding.fab.setOnClickListener { _ ->
            val intent = Intent(this, CreateToDo::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        layoutManager = LinearLayoutManager(this)
        adapter = ToDoAdapter(store.get())

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}