package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayAdapter: ArrayAdapter<*>
        val itemList = findViewById<ListView>(R.id.itemList)
        val itemArray: ArrayList<*> = ArrayList<Button>()

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemArray)
        itemList.adapter = arrayAdapter

        val button = findViewById<Button>(R.id.changeList)
        button.setOnClickListener{
            var intent = Intent(this, ClaimItem::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private val TAG = "Lost and Found"
    }
}
