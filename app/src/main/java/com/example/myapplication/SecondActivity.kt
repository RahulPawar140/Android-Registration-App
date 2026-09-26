package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tableUsers = findViewById<TableLayout>(R.id.tableUsers)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Display all stored users
        for (user in UserDataStore.users) {

            val tableRow = TableRow(this)

            tableRow.layoutParams = TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
            )

            // Name
            val nameTextView = TextView(this)
            nameTextView.text = user.name
            nameTextView.setTextColor(Color.parseColor("#111827"))
            nameTextView.textSize = 14f
            nameTextView.setPadding(12, 14, 12, 14)
            nameTextView.gravity = Gravity.CENTER_VERTICAL

            // Date of Birth
            val dobTextView = TextView(this)
            dobTextView.text = user.dob
            dobTextView.setTextColor(Color.parseColor("#111827"))
            dobTextView.textSize = 14f
            dobTextView.setPadding(12, 14, 12, 14)
            dobTextView.gravity = Gravity.CENTER_VERTICAL

            // Email
            val emailTextView = TextView(this)
            emailTextView.text = user.email
            emailTextView.setTextColor(Color.parseColor("#111827"))
            emailTextView.textSize = 14f
            emailTextView.setPadding(12, 14, 12, 14)
            emailTextView.gravity = Gravity.CENTER_VERTICAL

            tableRow.addView(nameTextView)
            tableRow.addView(dobTextView)
            tableRow.addView(emailTextView)

            tableUsers.addView(tableRow)
        }

        // Register another user
        btnBack.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}