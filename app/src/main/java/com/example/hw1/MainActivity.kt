package com.example.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var nameField: EditText? = null
    private var heightField: EditText? = null
    private var weightField: EditText? = null
    private var ageField: EditText? = null
    private var mainButton: Button? = null
    private var textOutput: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameField = findViewById(R.id.et_Name)
        heightField = findViewById(R.id.et_Height)
        weightField = findViewById(R.id.et_Weight)
        ageField = findViewById(R.id.et_Age)
        mainButton = findViewById(R.id.button)
        textOutput = findViewById(R.id.textView)

        mainButton?.setOnClickListener {

            val name = nameField?.text.toString()
            val height = heightField?.text.toString()
            val weight = weightField?.text.toString()
            val age = ageField?.text.toString()

            if(name == "" || height == "" || weight == "" || age == "")
                textOutput?.text = "Данные введены некорректно."
            else {
                if (name.length > 50 || (height.toInt() <= 0 || height.toInt() >= 250)
                    || (weight.toInt() <= 0 || weight.toInt() >= 250)
                    || (age.toInt() <= 0 || age.toInt() >= 150))
                    textOutput?.text = "Данные введены некорректно."
                else {
                    var value = name.length + height.toInt() + weight.toInt() + age.toInt()
                    textOutput?.text ="Ответ:$value"
                }
            }
        }
    }
}