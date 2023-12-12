package com.example.signup

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Myadpter(
    var homePage: Home_page,
    var numarray: ArrayList<String>,
   var conarray: ArrayList<String>
) : BaseAdapter() {
    override fun getCount(): Int {
        return numarray.size
        return conarray.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var textview : TextView
        var textview2 : TextView
        var editt : ImageView
        var delete : ImageView

        var forcontact = LayoutInflater.from(homePage).inflate(R.layout.forcontact,p2,false)

        textview=forcontact.findViewById(R.id.textview)
        textview2=forcontact.findViewById(R.id.textview2)
        editt=forcontact.findViewById(R.id.edit)
        delete=forcontact.findViewById(R.id.delete)

        var dialog = Dialog(homePage)

        editt.setOnClickListener {

            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dialogbox)
        }

        textview.setText(numarray[p0])
        textview2.setText(conarray[p0])

        return forcontact

    }

}
