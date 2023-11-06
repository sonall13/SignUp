package com.example.signup

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDataBase(context : Context ) : SQLiteOpenHelper(context,"mdata.db",null,1){
    override fun onCreate(p0: SQLiteDatabase) {

         var create = "CREATE TABLE mytable (id INTEGER PRIMARY Key autoincrement , name text UNIQUE , username text UNIQUE  , password text UNIQUE , email text UNIQUE)"
         p0.execSQL(create)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun insertdata(name: String, user: String, password: String, email: String) {

        var insert = "INSERT INTO mytable (name , username , password , email) VALUES ('$name' , '$user' ,'$password' ,'$email')"
        try {
            writableDatabase.execSQL(insert)

        }catch (e : Exception) {

        }
    }

    fun selecctdata(email: String, pass : String)  : Cursor{


        var select = "SELECT * FROM mytable WHERE email = '$email' AND  password = '$pass'"

        var cursor :Cursor

        cursor = readableDatabase.rawQuery(select,null)

        return cursor


    }


}
