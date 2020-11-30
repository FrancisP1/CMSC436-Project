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

    }

    companion object {
        private val TAG = "Lost and Found"
    }
}
