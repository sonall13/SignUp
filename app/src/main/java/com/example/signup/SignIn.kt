package com.example.signup

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignIn : AppCompatActivity() {

    lateinit var signup_btn : MaterialButton
    lateinit var input_user : TextInputEditText
    lateinit var pass : TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signup_btn = findViewById(R.id.signup_btn)
        input_user = findViewById(R.id.input_user)
        pass = findViewById(R.id.pass)


        signup_btn.setOnClickListener {
            var ab = ""


            var select = MyDataBase(this)

            var data : Cursor
            data = select.selecctdata(input_user.text.toString(),pass.text.toString())

            while (data.moveToNext())
            {
                 ab = data.getString(0)
            }

            startActivity(Intent(this@SignIn , MainActivity2::class.java).putExtra("name",ab))



        }



    }
}