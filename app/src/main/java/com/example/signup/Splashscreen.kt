package com.example.signup

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splashscreen : AppCompatActivity() {

    companion object {

        lateinit var sp: SharedPreferences
        lateinit var edit: SharedPreferences.Editor
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        sp = getSharedPreferences("status" , MODE_PRIVATE)
        edit= sp.edit()


        Handler(Looper.getMainLooper()).postDelayed({

            if(sp.getBoolean("status" , false)){

                startActivity(Intent(this@Splashscreen,Home_page::class.java))
                finish()
            }
            else{
                startActivity(Intent(this@Splashscreen,Signup_page::class.java))
            }

        },1500)


    }
}