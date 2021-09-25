package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class CreateToDo : AppCompatActivity() {
    lateinit var button:Button
    lateinit var checkBox:CheckBox
    lateinit var editText: EditText

    private val store: ToDoStore = ToDoStore(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        button = findViewById(R.id.button)
        checkBox = findViewById(R.id.checkBox)
        editText = findViewById(R.id.editText)

        button.setOnClickListener{
            var todoDesc = editText.text.toString()
            if (checkBox.isChecked) {
                todoDesc = "❗️$todoDesc"
            }
            store.add(todoDesc)
            finish()
        }
    }
}