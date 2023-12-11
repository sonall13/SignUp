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
    var numarray = ArrayList<String>()
    var conarray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home_page)

//        numarray.add("df")
//        numarray.add("df")
//        numarray.add("df")
//        numarray.add("df")

    contact_list = findViewById(R.id.contact_list)
        addbtn = findViewById(R.id.addbtn)

        numarray.clear()
        conarray.clear()

        var id= Login_page.sp.getInt("id",1)
        var contact = MyDataBase(this)

        var cursor1 : Cursor
         cursor1= contact.addeddata(id)


        while (cursor1.moveToNext()){

            numarray.add(cursor1.getString(1))
            conarray.add(cursor1.getString(2))

        }

        var contact_adapter = Myadpter(this, numarray,conarray)
        contact_list.adapter = contact_adapter

        addbtn.setOnClickListener {

            var intent = Intent(this@Home_page,add_contact::class.java)
            startActivity(intent)
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
