package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Signup_page : AppCompatActivity() {


    lateinit var submit : MaterialButton
    lateinit var input_name : TextInputEditText
    lateinit var input_user : TextInputEditText
    lateinit var password : TextInputEditText
    lateinit var email : TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        submit = findViewById(R.id.signup_btn)
        input_name = findViewById(R.id.input_name)
        input_user = findViewById(R.id.input_user)
        password = findViewById(R.id.input_pass)
        email = findViewById(R.id.input_email)


        submit.setOnClickListener {
            Toast.makeText(this, "DATA INSERTED", Toast.LENGTH_SHORT).show()
            var data = MyDataBase(this)

            data.insertdata(input_name.text.toString(),input_user.text.toString(),password.text.toString(),email.text.toString())

            startActivity(Intent(this@Signup_page,Home_page::class.java))
            finish()

        }


    }
}