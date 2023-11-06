package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {


    lateinit var submit : MaterialButton
    lateinit var input_name : TextInputEditText
    lateinit var input_user : TextInputEditText
    lateinit var password : TextInputEditText
    lateinit var email : TextInputEditText
    lateinit var ss : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit = findViewById(R.id.signup_btn)
        input_name = findViewById(R.id.input_name)
        input_user = findViewById(R.id.input_user)
        password = findViewById(R.id.input_pass)
        email = findViewById(R.id.input_email)
        ss = findViewById(R.id.ss)

        submit.setOnClickListener {

            var data = MyDataBase(this)

            data.insertdata(input_name.text.toString(),input_user.text.toString(),password.text.toString(),email.text.toString())



        }

        ss.setOnClickListener {
            startActivity(Intent(this@MainActivity,SignIn::class.java))



        }


    }
}