package com.example.imadexam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private val itemNames = ArrayList<String>()
    private val categories = ArrayList<String>()
    private val quantities = ArrayList<Int>()
    private val comments = ArrayList<String>()

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtItem = findViewById<EditText>(R.id.edtItem)
        val edtCategory = findViewById<EditText>(R.id.edtCategory)
        val edtQuantity = findViewById<EditText>(R.id.edtQuantity)
        val edtComment = findViewById<EditText>(R.id.edtComment)

        val btnAdd = findViewById<Button>(R.id.btnAddGear)
        val btnView = findViewById<Button>(R.id.btnViewDetails)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)

        btnAdd.setOnClickListener {

            val item = edtItem.text.toString()
            val category = edtCategory.text.toString()
            val quantityText = edtQuantity.text.toString()
            val comment = edtComment.text.toString()

            if (item.isEmpty() ||
                category.isEmpty() ||
                quantityText.isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Please fill in all required fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val quantity = quantityText.toInt()

            itemNames.add(item)
            categories.add(category)
            quantities.add(quantity)
            comments.add(comment)

            var total = 0

            for (i in quantities.indices) {
                total += quantities[i]
            }

            txtTotal.text = "Total Items Packed: $total"

            Toast.makeText(
                this,
                "Gear Added Successfully",
                Toast.LENGTH_SHORT
            ).show()

            edtItem.text.clear()
            edtCategory.text.clear()
            edtQuantity.text.clear()
            edtComment.text.clear()
        }

        btnView.setOnClickListener {

            val intent = Intent(this, ThirdActivity::class.java)

            intent.putStringArrayListExtra(
                "items",
                itemNames
            )

            intent.putStringArrayListExtra(
                "categories",
                categories
            )

            intent.putIntegerArrayListExtra(
                "quantities",
                quantities
            )

            intent.putStringArrayListExtra(
                "comments",
                comments
            )

            startActivity(intent)
        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}