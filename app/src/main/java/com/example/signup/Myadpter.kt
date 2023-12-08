package com.example.signup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class Myadpter(var homePage: Home_page, var blanklist: ArrayList<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return blanklist.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var forcontact = LayoutInflater.from(homePage).inflate(R.layout.forcontact,p2,false)
        return forcontact

    }

}
