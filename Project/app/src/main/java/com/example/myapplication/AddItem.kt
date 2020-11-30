package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class AddItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item)

        getSupportActionBar()!!.setTitle("Lost and Found")

        val header = findViewById<TextView>(R.id.header)

        val spinner = findViewById<Spinner>(R.id.item_type)

        ArrayAdapter.createFromResource(
                this, R.array.item_types, android.R.layout.simple_spinner_item
        ).also {
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val arrayAdapter: ArrayAdapter<*>
        val itemList = findViewById<ListView>(R.id.itemList)
        val itemArray: ArrayList<*> = ArrayList<Button>()

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemArray)
        itemList.adapter = arrayAdapter

        val brandText = findViewById<EditText>(R.id.brand)
        val itemText = findViewById<EditText>(R.id.item)
        val colorText = findViewById<EditText>(R.id.color)
        val sizeText = findViewById<EditText>(R.id.size)
        val descriptionText = findViewById<EditText>(R.id.furtherDescription)

        val enterButton = findViewById<Button>(R.id.enterItem)

        enterButton.setOnClickListener {
            if(!(brandText.text.isEmpty() || itemText.text.isEmpty() || colorText.text.isEmpty() ||
                sizeText.text.isEmpty())) {
                val brandText = brandText.text
                val itemText = itemText.text
                val colorText = colorText.text
                val sizeText = sizeText.text
                val descriptionText = descriptionText.text

                val resultIntent = Intent()
                resultIntent.putExtra("brand", brandText.toString())
                resultIntent.putExtra("item", itemText.toString())
                resultIntent.putExtra("color", colorText.toString())
                resultIntent.putExtra("size", sizeText.toString())
                resultIntent.putExtra("description", descriptionText.toString())
                resultIntent.putExtra("array", intent.getStringExtra("itemArray"))
                setResult(0, resultIntent)
                finish()
            }
        }
    }

    companion object {
        private val TAG = "Lost and Found"
    }
}
