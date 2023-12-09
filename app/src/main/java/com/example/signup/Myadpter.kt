package com.example.signup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class Myadpter(var homePage: Home_page,var  numarray: ArrayList<String>, ) : BaseAdapter() {
    override fun getCount(): Int {
        return numarray.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var name : TextView

        var forcontact = LayoutInflater.from(homePage).inflate(R.layout.forcontact,p2,false)

        name=forcontact.findViewById(R.id.name)
        name.setText(numarray[p0])

        return forcontact

    }

}
