package com.example.signup

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splashscreen : AppCompatActivity() {

    companion object {

        lateinit var spp: SharedPreferences
        lateinit var editt: SharedPreferences.Editor
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        spp = getSharedPreferences("status" , MODE_PRIVATE)
        editt= spp.edit()


        Handler(Looper.getMainLooper()).postDelayed({

            if(spp.getBoolean("status" , false)){

                startActivity(Intent(this@Splashscreen,Home_page::class.java))
                finish()
            }
            else{
                startActivity(Intent(this@Splashscreen,Signup_page::class.java))
            }

        },1500)


    }
}