package com.example.signup

import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Login_page : AppCompatActivity() {

    lateinit var login_btn : MaterialButton
    lateinit var input_user : TextInputEditText
    lateinit var pass : TextInputEditText
    lateinit var create_acc:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        login_btn = findViewById(R.id.login_btn)
        input_user = findViewById(R.id.input_user)
        pass = findViewById(R.id.pass)
        create_acc = findViewById(R.id.create_acc)




        login_btn.setOnClickListener {

//            Toast.makeText(this, "SIGNING IN.", Toast.LENGTH_SHORT).show()
            var ab = 0
            var select = MyDataBase(this)
            var data : Cursor
            data = select.selecctdata(input_user.text.toString(),pass.text.toString())

            while (data.moveToNext())
            {
                 ab = data.getInt(0)
                Splashscreen.edit.putInt("id",ab)
                Splashscreen.edit.putBoolean("status",true)
                Splashscreen.edit.apply()
                Log.e("L====", "onCreate: ${Splashscreen.sp.getBoolean("status",false)}" )
                startActivity(Intent(this@Login_page ,Home_page::class.java))
                finish()
            }
        }
        create_acc.setOnClickListener {

            startActivity(Intent(this@Login_page,Signup_page::class.java))
            finish()

        }

    }

}