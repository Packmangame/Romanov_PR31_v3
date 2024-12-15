package com.bignerdranch.android.a3_prak1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.coroutines.selects.select
import java.text.FieldPosition

private lateinit var pref: SharedPreferences
var Square: EditText?=null
private var choose: TextView? = null

class Calc : AppCompatActivity() {
    private var spin: Spinner? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        Square = findViewById(R.id.square)
        spin = findViewById(R.id.spinner)
        choose = findViewById(R.id.res)
        var select = spin!!.selectedItemPosition
        pref = getPreferences(MODE_PRIVATE)

    }

    fun Back1(view: View) {
        val intent = Intent(this, RegisterScreen::class.java)
        startActivity(intent)
    }

    fun Calculated(view: View) {
        try {

            val rez = findViewById<TextView>(R.id.res)
            val num = Square!!.text.toString().toInt()
            val ans = findViewById<TextView>(R.id.Ans)
            var select = spin!!.selectedItemPosition
            var finish = 0
            pref = getPreferences(MODE_PRIVATE)
            val temp: Double
            choose!!.text = select.toString()
            when (select) {
                0 -> {
                    if (num > 20 && num < 30) finish = (num * 1012 * 1.4).toInt()
                }

                1 -> {
                    if (num > 30 && num < 50) finish = num * 1012
                }

                2 -> {
                    if (num > 50 && num < 70) finish = (num * 1012 * 1.2).toInt()
                }

                3 -> {
                    if (num > 15 && num < 20) finish = (num * 1012 * 1.1).toInt()
                }
            }

            if (finish > 0) {
                val ans = findViewById<TextView>(R.id.Ans)
                ans!!.text = finish.toString() + " м"
                val intent = Intent(this, Itogi::class.java)
                intent.putExtra("meters", num)
                intent.putExtra("result", finish.toString())
                startActivity(intent)
            } else {
                rez!!.text = "Недопустимый диапазон"
            }
        }catch (e:Exception)
        {
            val alert= AlertDialog.Builder(this).setTitle("Error")
                .setMessage("Data is empty. Try again")
                .setPositiveButton("ok",null)
                .create()
                .show()
        }


    }




}
