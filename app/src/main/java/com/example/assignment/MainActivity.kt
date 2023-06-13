package com.example.assignment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val todayEditText = findViewById<EditText>(R.id.todayEditText)
        val dobEditText   = findViewById<EditText>(R.id.dobEditText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        submitButton.setOnClickListener {

            val todayDate = todayEditText.text.toString()
            val dobDate = dobEditText.text.toString()

            val todayDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val dobDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

            val todayDateObj = todayDateFormat.parse(todayDate)
            val dobDateObj = dobDateFormat.parse(dobDate)

            if (todayDateObj == null || dobDateObj == null) {
                resultTextView.text = "Invalid date format"
            } else {
                val calendar = Calendar.getInstance()
                val currentYear = calendar.get(Calendar.YEAR)

                val dobCalendar = Calendar.getInstance()
                dobCalendar.setTime(dobDateObj)
                val dobYear = dobCalendar.get(Calendar.YEAR)

                val years = currentYear - dobYear
                val months = (currentYear - dobYear) / 12
                val days = (currentYear - dobYear) % 365

                resultTextView.text = "You are $years years, $months months, and $days days old."
            }

        }
        fun onBackPressed() {
            // Do nothing
        }
    }
}
