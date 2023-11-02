package com.example.signup

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDataBase(context : Context ) : SQLiteOpenHelper(context,"mdata.db",null,1){
    override fun onCreate(p0: SQLiteDatabase) {

         var create = "CREATE TABLE mytable (id INTEGER PRIMARY Key autoincrement , name text UNIQUE , username text UNIQUE )"
         p0.execSQL(create)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertdata(name: String, user: String) {

        var insert = "INSERT INTO mytable (name , username) VALUES ('$name' , '$user')"
        writableDatabase.execSQL(insert)


    }


}
