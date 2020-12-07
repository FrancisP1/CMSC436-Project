package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView


class ClaimItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.claim_item)

        getSupportActionBar()!!.setTitle("Lost and Found")

        val header = findViewById<TextView>(R.id.header)

        val attributes = findViewById<TextView>(R.id.attributes)

        val date = intent.getStringExtra("date")

        Log.i(TAG, " " + date)


        attributes.text = "\n" + intent.getStringExtra("brand") + "\n" + intent.getStringExtra("item") +
                "\n" + "\nFound on: " +
                intent.getStringExtra("date") + "\n\nCome to 2117 Mitchell Building to retrieve your lost item"

    }

    companion object {
        private val TAG = "Lost and Found"
    }
}
