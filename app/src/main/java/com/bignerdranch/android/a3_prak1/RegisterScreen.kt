package com.bignerdranch.android.a3_prak1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog


class RegisterScreen : AppCompatActivity() {

    var userlog:EditText?=null
    var userpas:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        userlog=findViewById(R.id.Login)
        userpas=findViewById(R.id.Pass)
    }

    fun Next2(view: View) {
        if(userlog!!.text.toString().isNotEmpty()&&userpas!!.text.toString().isNotEmpty())
        {
            if(userlog!!.text.toString()=="ects"&&userpas!!.text.toString()=="ects2024") {
                val intent = Intent(this, Calc::class.java)
                intent.getStringExtra(userlog.toString())
                startActivity(intent)
            }else
            {
                val alert= AlertDialog.Builder(this).setTitle("Error")
                    .setMessage("Password incorrect")
                    .setPositiveButton("ok",null)
                    .create()
                    .show()
            }


        }else
        {
            val alert= AlertDialog.Builder(this).setTitle("Error")
                .setMessage("Поля должны быть заполнены")
                .setPositiveButton("ok",null)
                .create()
                .show()
        }
    }

}