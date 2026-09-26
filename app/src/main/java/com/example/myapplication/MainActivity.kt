package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etDob = findViewById<EditText>(R.id.etDob)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        // Date picker
        etDob.setOnClickListener {

            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->

                    val formattedDate =
                        String.format(
                            "%02d/%02d/%04d",
                            selectedDay,
                            selectedMonth + 1,
                            selectedYear
                        )

                    etDob.setText(formattedDate)
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }

        // Submit button
        btnSubmit.setOnClickListener {

            val name = etName.text.toString().trim()
            val dob = etDob.text.toString().trim()
            val email = etEmail.text.toString().trim()

            // Name validation
            if (name.isEmpty()) {
                etName.error = "Please enter your name"
                etName.requestFocus()
                return@setOnClickListener
            }

            // Date validation
            if (dob.isEmpty()) {
                etDob.error = "Please select your date of birth"
                etDob.requestFocus()
                return@setOnClickListener
            }

            // Gmail validation
            if (!email.endsWith("@gmail.com", ignoreCase = true)) {
                etEmail.error = "Please enter a valid Gmail address"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            // Store user in Array/List
            UserDataStore.users.add(
                User(
                    name = name,
                    dob = dob,
                    email = email
                )
            )

            // Open Activity 2
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}