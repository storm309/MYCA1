package com.example.myca1

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // XML works now!

        val imgStudent = findViewById<ImageView>(R.id.imgStudent)
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtRegNo = findViewById<EditText>(R.id.edtRegNo)
        val edtTotal = findViewById<EditText>(R.id.edtTotalClasses)
        val edtAttended = findViewById<EditText>(R.id.edtAttendedClasses)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnCheck.setOnClickListener {

            val totalStr = edtTotal.text.toString()
            val attendedStr = edtAttended.text.toString()

            if (totalStr.isEmpty() || attendedStr.isEmpty()) {
                Toast.makeText(this, "Please enter all fields!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val total = totalStr.toInt()
            val attended = attendedStr.toInt()

            if (total == 0) {
                txtResult.text = "Total classes cannot be zero."
                txtResult.setTextColor(getColor(android.R.color.holo_red_dark))
                return@setOnClickListener
            }

            val percentage = (attended.toDouble() / total) * 100

            if (percentage >= 75) {
                txtResult.text = "Eligible (Attendance: ${"%.2f".format(percentage)}%)"
                txtResult.setTextColor(getColor(android.R.color.holo_green_dark))
            } else {
                txtResult.text = "Attendance Shortage (Attendance: ${"%.2f".format(percentage)}%)"
                txtResult.setTextColor(getColor(android.R.color.holo_red_dark))
            }
        }
    }
}
