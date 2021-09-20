package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BMIResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiresults)
    }

    override fun onStart() {
        super.onStart()

        val result = intent.extras?.getString("result")
        findViewById<TextView>(R.id.resultsTextView).text = result
    }
}