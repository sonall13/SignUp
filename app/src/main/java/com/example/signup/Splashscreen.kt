package com.example.signup

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log

class Splashscreen : AppCompatActivity() {

    companion object {
        lateinit var sp: SharedPreferences
        lateinit var edit: SharedPreferences.Editor
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        sp= getSharedPreferences("statuss", MODE_PRIVATE)
        edit = sp.edit()




        Handler(Looper.getMainLooper()).postDelayed({
        var Islogin =    sp.getBoolean("status",false)

            Log.e("S======", "onCreate: $Islogin", )

            if (Islogin){
                startActivity(Intent(this@Splashscreen,Home_page::class.java))
                finish()


            }
            else{

                startActivity(Intent(this@Splashscreen,Login_page::class.java))
                finish()
            }
        },1500)


    }
}