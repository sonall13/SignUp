package com.example.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Home_page : AppCompatActivity() {
//
//    lateinit var txt : EditText
//    lateinit var edit : EditText
//    lateinit var update: Button
//    lateinit var delete: Button
//
//    var user =""


    lateinit var contact_list: ListView
    lateinit var addbtn: ImageView
    lateinit var logouticon: ImageView


    var userlist = ArrayList<Myuserdata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)



        contact_list = findViewById(R.id.contact_list)
        addbtn = findViewById(R.id.addbtn)
        logouticon = findViewById(R.id.logouticon)

        userlist.clear()


        var id = Splashscreen.sp.getInt("id", 0)
        Log.e("====ID", "onCreate: $id")
        var contact = MyDataBase(this)
        var cursor1 = contact.SelectConatctdata(id)

        while (cursor1.moveToNext()) {

            var name = cursor1.getString(1)
            var contact = cursor1.getString(2)
            var id = cursor1.getInt(0)

            //[ {"name":haresh,"contact":788,"id":1},{"name":haresh1,"contact":858757,"id":2},{"name":haresh,"contact":788,"id":1},{"name":haresh,"contact":788,"id":1}]
            var myuserdata = Myuserdata(id, name, contact)

            userlist.add(myuserdata)

        }

        var nameput = intent.getStringExtra("nameput")
        var contactput = intent.getStringExtra("contactput")
        var emailput = intent.getStringExtra("emailput")

        var contact_adapter =
            Myadpter(this, userlist)
        contact_list.adapter = contact_adapter

        addbtn.setOnClickListener {

            var intent = Intent(this@Home_page, add_contact::class.java)
            startActivity(intent)
            finish()
        }

        logouticon.setOnClickListener {

            Splashscreen.edit.putBoolean("status", false)
            Splashscreen.edit.apply()


            var intent = Intent(this@Home_page, Login_page::class.java)
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
