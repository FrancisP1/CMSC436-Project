package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var itemArray = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()!!.setTitle("Lost and Found")

        val arrayAdapter: ArrayAdapter<*>
        var itemList = findViewById<ListView>(R.id.itemList)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemArray)
        itemList.adapter = arrayAdapter

        val button = findViewById<Button>(R.id.addItem)
        button.setOnClickListener{
            var intent = Intent(this, AddItem::class.java)
            intent.putExtra("itemArray", itemArray)
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val brand = data?.getStringExtra("brand").toString()
        val item = data?.getStringExtra("item").toString()
        val color = data?.getStringExtra("color").toString()
        val size = data?.getStringExtra("size").toString()
        var description = data?.getStringExtra("description").toString()
        val array = data?.getParcelableArrayExtra("array")

        if(description.isEmpty() || description == "")
            description = "N/A"

        Log.i(TAG, brand + " " + item + " " + color + " " + size + " " + description)
    }

    companion object {
        private val TAG = "Lost and Found"
    }
}
