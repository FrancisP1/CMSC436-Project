package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    var itemArray = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()!!.setTitle("Lost and Found")

        //val database = FirebaseDatabase.getInstance().reference
        //database.setValue("Adidas")

        val button = findViewById<Button>(R.id.addItem)
        button.setOnClickListener{
            var intent = Intent(this, AddItem::class.java)
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null) {
            if(data.getBooleanExtra("entered", false)) {
                val current = LocalDateTime.now()
                val formatter = DateTimeFormatter.ISO_LOCAL_DATE
                val formatted = current.format(formatter)

                val brand = data?.getStringExtra("brand").toString()
                val item = data?.getStringExtra("item").toString()
                val color = data?.getStringExtra("color").toString()
                val size = data?.getStringExtra("size").toString()
                var description = data?.getStringExtra("description").toString()
                val date = formatted

                if(description.isEmpty() || description == "")
                    description = "N/A"

                val layout = findViewById<LinearLayout>(R.id.layout)

                val row = LinearLayout(this)
                row.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

                val temp = Button(this)
                itemArray.add(temp)
                for(a in 0..itemArray.size) {
                    temp.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT)
                    temp.text = brand + ": " + item + "   " + date
                    val temp2 = 1
                    temp.id = temp2
                }
                row.addView(temp)
                layout.addView(row)
                setContentView(layout)

                temp.setOnClickListener {
                    var intent = Intent(this, ClaimItem::class.java)
                    intent.putExtra("brand", brand)
                    intent.putExtra("item", item)
                    intent.putExtra("color", color)
                    intent.putExtra("size", size)
                    intent.putExtra("description", description)
                    intent.putExtra("date", date)

                    startActivityForResult(intent, 0)
            }
        }


        }
    }

    companion object {
        private val TAG = "Lost and Found"
    }
}
