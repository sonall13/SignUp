package com.example.signup

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class add_contact : AppCompatActivity() {

    lateinit var profileIv : ImageView
    lateinit var firstNameEt : EditText
    lateinit var phoneNumberEt : EditText
    lateinit var emailEt : EditText
    lateinit var savefab : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)



        profileIv =findViewById(R.id.profileIv)
        firstNameEt =findViewById(R.id.firstNameEt)
        phoneNumberEt =findViewById(R.id.phoneNumberEt)
        emailEt =findViewById(R.id.emailEt)
        savefab =findViewById(R.id.savefab)

        var id=Login_page.sp.getInt("id",1)

        savefab.setOnClickListener {

            var add = MyDataBase(this)
            add.dataadd(id,firstNameEt.text.toString(),phoneNumberEt.text.toString(),emailEt.text.toString())

//            Toast.makeText(this, "data added", Toast.LENGTH_SHORT).show()

                var intrnt = Intent(this@add_contact,Home_page::class.java).putExtra("namee",firstNameEt.text.toString()).putExtra("userr",phoneNumberEt.text.toString())
                startActivity(intrnt)
                finish()

        }


    }
}