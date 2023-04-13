package com.study.imcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputHeight: EditText = findViewById(R.id.editTextHeight)
        val inputWeight: EditText = findViewById(R.id.editTextWeight)
        val btnCalc: Button = findViewById(R.id.btnCalc)

        btnCalc.setOnClickListener {

            val stringHeight = inputHeight.text.toString()
            val stringWeight = inputWeight.text.toString()

            if (stringHeight.isNotEmpty() && stringWeight.isNotEmpty()) {

                    val height: Float = stringHeight.toFloat()
                    val finalHeight: Float = height * height

                    val weight: Float = stringWeight.toFloat()
                    val result: Float = weight / finalHeight


                    val intent = Intent(this, ResultActivity::class.java)
                        .apply {
                            putExtra("EXTRA_RESULT", result)
                        }
                    startActivity(intent)
                } else{
                    Toast.makeText(this, "Preencha todos os cmapos", Toast.LENGTH_LONG).show()
            }

         }
    }
}

