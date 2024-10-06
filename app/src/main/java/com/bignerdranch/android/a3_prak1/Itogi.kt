package com.bignerdranch.android.a3_prak1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Itogi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itogi)
        val intent = intent
        val meters = intent.getIntExtra("meters", 0)
        val result = intent.getStringExtra("result") ?: "0"
        val textViewMet: TextView = findViewById(R.id.MetersRes)
        val t: TextView = findViewById(R.id.OconRes)
        textViewMet.text = "Meters Count: \t$meters"
        t.text = "Result: \t$result"
    }
    fun backto(view: View) {
        val intent = Intent(this, Calc::class.java)
        startActivity(intent)
    }
}