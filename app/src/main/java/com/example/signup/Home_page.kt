package com.example.signup

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView

class Home_page : AppCompatActivity() {
//
//    lateinit var txt : EditText
//    lateinit var edit : EditText
//    lateinit var update: Button
//    lateinit var delete: Button
//
//    var user =""


    lateinit var contact_list : ListView
    lateinit var addbtn : ImageView
    lateinit var logouticon : ImageView

    var numarray = ArrayList<String>()
    var conarray = ArrayList<String>()
    var emailarray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home_page)


    contact_list = findViewById(R.id.contact_list)
        addbtn = findViewById(R.id.addbtn)
        logouticon = findViewById(R.id.logouticon)

        numarray.clear()
        conarray.clear()
        emailarray.clear()

        var id= Splashscreen.sp.getInt("id",1)
        var contact = MyDataBase(this)

        var cursor1 : Cursor
         cursor1= contact.addeddata(id)


        while (cursor1.moveToNext()){

            numarray.add(cursor1.getString(1))
            conarray.add(cursor1.getString(2))

        }

        var contact_adapter = Myadpter(this, numarray,conarray,emailarray)
        contact_list.adapter = contact_adapter

        addbtn.setOnClickListener {

            var intent = Intent(this@Home_page,add_contact::class.java)
            startActivity(intent)
            finish()
        }

        logouticon.setOnClickListener {

//            Splashscreen.edit.putBoolean("status",false)
//            Splashscreen.edit.apply()

            var intent = Intent(this@Home_page,Login_page::class.java)
            startActivity(intent)
            finish()
        }

   }
}

















//        update = findViewById(R.id.update)
//        txt = findViewById(R.id.txt)
//        edit = findViewById(R.id.edit)
//        delete = findViewById(R.id.delete)
//
//         var name = intent.getIntExtra("name",0)
//         user = intent.getStringExtra("user").toString()
//
//        txt.setText(name.toString())
//
//        update.setOnClickListener {
//
//            var up = MyDataBase(this)
//            Log.e("enter", "onCreate: enter$name ($user)")
//            up.upadate(edit.text.toString(),name)
//
//        }
//        delete.setOnClickListener {
//
//            var del=MyDataBase(this)
//            del.delete(name)
//
//        }
