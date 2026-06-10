package com.example.imadexam

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView


class ThirdActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        val txtDetails = findViewById<TextView>(R.id.txtDetails)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val items =
            intent.getStringArrayListExtra("items")

        val categories =
            intent.getStringArrayListExtra("categories")

        val quantities =
            intent.getIntegerArrayListExtra("quantities")

        val comments =
            intent.getStringArrayListExtra("comments")

        var displayText = ""

        if (items != null) {

            for (i in items.indices) {

                displayText +=
                    "Item: ${items[i]}\n" +
                            "Category: ${categories?.get(i)}\n" +
                            "Quantity: ${quantities?.get(i)}\n" +
                            "Comment: ${comments?.get(i)}\n\n"
            }
        }

        txtDetails.text = displayText

        btnBack.setOnClickListener {
            finish()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}