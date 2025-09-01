package com.example.lab_week_01

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import android.view.Gravity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener {
            val nameText = findViewById<TextInputEditText>(R.id.name_input)
                ?.text.toString().trim()

            val nimText = findViewById<TextInputEditText>(R.id.nim_input)
                ?.text.toString().trim()

            if (nameText.isNotEmpty() && nimText.isNotEmpty()) {
                if(nimText.length != 11){
                    val toast = Toast.makeText(this, getString(R.string.nim_Error), Toast.LENGTH_LONG)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()
                }
                else{
                    nameDisplay.text = getString(R.string.name_greet).plus(" ").plus(nameText)
                }
            }
            else{
                val toast = Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
        }
    }
}