package com.study.imcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textViewResult)
        val tvClassification = findViewById<TextView>(R.id.textViewClassification)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        val classification = if (result < 18.5f){
            "MAGREZA"
        } else if (result in 18.5f..24.9f){
            "PESO IDEAL"
        } else if(result in 25f..29.9f){
            "SOBREPESO"
        } else if (result in 30f..39.9f) {
            "OBESIDADE"
        } else{
            "OBESIDADE GRAVE"
        }

        tvClassification.text = getString(R.string.message_classification, classification)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}