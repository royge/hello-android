package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        if (intent.hasExtra("todo")) {
            return editToDo()
        }

        button.setOnClickListener{
            store.add(ToDoStore.ToDo(
                editText.text.toString(),
                checkBox.isChecked,
            ))
            finish()
        }
    }

    private fun editToDo() {
        val todo = intent.extras?.getSerializable("todo") as ToDoStore.ToDo

        checkBox.isChecked = todo.isImportant
        checkBox.isEnabled = false

        editText.setText(todo.text())
        editText.isEnabled = false

        button.text = "Complete"
        button.setOnClickListener{
            store.remove(todo)
            finish()
        }
    }
}