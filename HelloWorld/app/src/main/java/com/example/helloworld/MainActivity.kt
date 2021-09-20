package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener{
            val bmi = getBMI(
                findViewById<EditText>(R.id.weightEditText).text.toString().toDouble(),
                findViewById<EditText>(R.id.heightEditText).text.toString().toDouble(),
            )

            val resultIntent = Intent(this, BMIResultsActivity::class.java)
            resultIntent.putExtra("result", "BMI: " + String.format("%.2f", bmi))

            startActivity(resultIntent)
        }
    }

    private fun getBMI(weight: Double, height: Double): Double {
        return weight / ( height * height )
    }
}