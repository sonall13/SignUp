package com.example.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

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
    lateinit var search: androidx.appcompat.widget.SearchView



    var userlist = ArrayList<Myuserdata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)



        contact_list = findViewById(R.id.contact_list)
        addbtn = findViewById(R.id.addbtn)
        logouticon = findViewById(R.id.logouticon)
        search = findViewById(R.id.search)

        userlist.clear()

        search.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                var serch_text=ArrayList<Myuserdata>()

                for (i in 0..userlist.size-1) {
                    var name = userlist.get(i).name
                    var num=userlist.get(i).contact

                    if (name.toString().toLowerCase(Locale.ROOT).contains(newText.toString().toLowerCase())) {
                        serch_text.add(userlist.get(i))

                    }else if (num.toString().toLowerCase().contains(newText.toString().lowercase())){
                        serch_text.add(userlist.get(i))
                    }
                }

                var adapterr = Myadpter(this@Home_page,serch_text)
                contact_list.adapter = adapterr

                return false
            }
        })


        var contact_adapter =
            Myadpter(this, userlist)
        contact_list.adapter = contact_adapter


        var id = Splashscreen.sp.getInt("id", 0)
        Log.e("====ID", "onCreate: $id")
        var contact = MyDataBase(this)
        var cursor1 = contact.SelectConatctdata(id)

        while (cursor1.moveToNext()) {

            var name = cursor1.getString(1)
            var contact = cursor1.getString(2)
            var email = cursor1.getString(3)
            var id = cursor1.getInt(0)

            //[ {"name":haresh,"contact":788,"id":1},{"name":haresh1,"contact":858757,"id":2},{"name":haresh,"contact":788,"id":1},{"name":haresh,"contact":788,"id":1}]
            var myuserdata = Myuserdata(id, name, contact,email)
            userlist.add(myuserdata)

        }



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
