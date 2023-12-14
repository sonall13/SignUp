package com.example.signup

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDataBase(context: Context) : SQLiteOpenHelper(context,"mdata.db",null,1){
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(p0: SQLiteDatabase) {

         var create = "CREATE TABLE mytable (id INTEGER PRIMARY Key autoincrement , name text UNIQUE , username text UNIQUE  , email text UNIQUE , password text UNIQUE )"
         p0.execSQL(create)

         var fetchdata = "CREATE TABLE fetchdata(id INTEGER , name TEXT UNIQUE , contact NUMBER UNIQUE , email TEXT UNIQUE)"
           p0.execSQL(fetchdata)

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

    fun selecctdata(user: String, pass : String)  : Cursor{


        var select = "SELECT * FROM mytable WHERE username = '$user' AND  password = '$pass'"
        var cursor :Cursor
        cursor = readableDatabase.rawQuery(select,null)
        return cursor

    }





    fun dataadd(id: Int, name: String, contact: String, email: String) {

        var insertt = "INSERT INTO fetchdata(id,name , contact , email) VALUES ('$id','$name' ,'$contact' ,'$email')"
        try {
            writableDatabase.execSQL(insertt)

        }catch (e : Exception) {

        }
    }

    fun addeddata(id:Int) : Cursor{


        var selectt = "SELECT * FROM fetchdata WHERE id = '$id' "

        var cursorr :Cursor
        cursorr = readableDatabase.rawQuery(selectt,null)
        return cursorr

    }


    fun upadate(name: String,contact: String,email: String, id: Int) {
        var updat = "UPDATE fetchdata SET name = '$name'  contact = '$contact' email='$email' WHERE id='$id' "

        try {
            writableDatabase.execSQL(updat)

        }catch (e : Exception)
        {
//            Log.e("====", "upadate: catch", )
        }

    }


//    fun delete( id: Int)
//    {
//        var delet = "DELETE FROME mytable WHERE id = '$id' "
//        try {
//            writableDatabase.execSQL(delet)
//        }catch (e: Exception){
//        }
//    }

}
