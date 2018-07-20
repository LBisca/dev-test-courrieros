package com.courrieros

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.courrieros.reader.CsvReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        textView.text =  CsvReader().readInput(resources.openRawResource(R.raw.client_orders))
    }
}


