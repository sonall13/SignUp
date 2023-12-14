package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class add_contact : AppCompatActivity() {

    lateinit var profileIv : ImageView
    lateinit var firstNameEt : EditText
    lateinit var phoneNumberEt : EditText
    lateinit var emailEt : EditText
    lateinit var savefab : Button
    lateinit var cancel : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)



        profileIv =findViewById(R.id.profileIv)
        firstNameEt =findViewById(R.id.firstNameEt)
        phoneNumberEt =findViewById(R.id.phoneNumberEt)
        emailEt =findViewById(R.id.emailEt)
        savefab =findViewById(R.id.savefab)
        cancel =findViewById(R.id.cancel)

        var id=Splashscreen.sp.getInt("id",1)

        savefab.setOnClickListener {

            var add = MyDataBase(this)
            add.dataadd(id,firstNameEt.text.toString(),phoneNumberEt.text.toString(),emailEt.text.toString())

//            Toast.makeText(this, "data added", Toast.LENGTH_SHORT).show()

               var intrntdata = Intent(this@add_contact,Home_page::class.java)
                    .putExtra("nameput",firstNameEt.text.toString())
                    .putExtra("contactput",phoneNumberEt.text.toString())
                    .putExtra("emailput",emailEt.text.toString())
                startActivity(intrntdata)
                finish()

        }
        cancel.setOnClickListener {

            var intent = Intent(this@add_contact,Home_page::class.java)
            startActivity(intent)
            finish()

        }


    }
}