package com.example.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val nameField: EditText? = findViewById(R.id.et_name)
        val heightField: EditText? = findViewById(R.id.et_height)
        val weightField: EditText? = findViewById(R.id.et_weight)
        val ageField: EditText? = findViewById(R.id.et_age)
        val textOutput: TextView? = findViewById(R.id.tv_result)
        val mainButton: Button? = findViewById(R.id.btn_name)

        mainButton?.setOnClickListener {

            try {
                val name = nameField?.text.toString()
                val height = heightField?.text.toString().toInt()
                val weight = weightField?.text.toString().toFloat()
                val age = ageField?.text.toString().toInt()


                if (name.length > 50 || (height <= 0 || height >= 250)
                    || (weight <= 0 || weight >= 250)
                    || (age <= 0 || age >= 150))
                    textOutput?.text = "Данные введены некорректно."
                else {
                    val value = name.length + height + weight + age
                    textOutput?.text = "Ответ:$value"
                }

            } catch (e: Exception) {
                textOutput?.text = "Данные введены некорректно."
            }
        }
    }
}