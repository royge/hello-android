package com.example.quicknotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(
            recyclerView.context,
            DividerItemDecoration.VERTICAL,
        ))

        adapter = QuoteAdapter(arrayListOf(
            "Do all the good you can",
            "God is most glorified in us when we are most satisfied in Him",
            "Faith does not eliminate questions. But faith knows where to take them.",
            "True faith means holding nothing back. ",
            "Worrying is arrogant because God knows what He's doing.",
        ))
        recyclerView.adapter = adapter
    }
}