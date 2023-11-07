package com.example.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {

    lateinit var txt : EditText
    lateinit var edit : EditText
    lateinit var update: Button
    lateinit var delete: Button

    var user =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        update = findViewById(R.id.update)
        txt = findViewById(R.id.txt)
        edit = findViewById(R.id.edit)
        delete = findViewById(R.id.delete)

         var name = intent.getIntExtra("name",0)
         user = intent.getStringExtra("user").toString()

        txt.setText(name.toString())

        update.setOnClickListener {

            var up = MyDataBase(this)
            Log.e("enter", "onCreate: enter$name ($user)")
            up.upadate(edit.text.toString(),name)

        }
        delete.setOnClickListener {

            var del=MyDataBase(this)
            del.delete(name)

        }
    }
}