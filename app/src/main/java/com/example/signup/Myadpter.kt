package com.example.signup

import android.app.Dialog
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView

class Myadpter(
    var homePage: Home_page,
   var userlist: ArrayList<Myuserdata>,


    ) : BaseAdapter() {
    override fun getCount(): Int = userlist.size

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {

        var textview: TextView
        var textview2: TextView
//        var editt : ImageView
//        var delete : ImageView
//        var relative : RelativeLayout
        var pop: ImageView

        var forcontact = LayoutInflater.from(homePage).inflate(R.layout.forcontact, p2, false)

        textview = forcontact.findViewById(R.id.textview)
        textview2 = forcontact.findViewById(R.id.textview2)
//        editt=forcontact.findViewById(R.id.edit)
//        delete=forcontact.findViewById(R.id.delete)
//        relative=forcontact.findViewById(R.id.relative)
        pop = forcontact.findViewById(R.id.pop)

        var dialog = Dialog(homePage)
        var editname: EditText
        var editcontact: EditText
        var editemail: EditText
        var update: Button
        var udaat = userlist.get(position)
        pop.setOnClickListener {

            Log.e("===", "getView: bgbbgh")

            var popupmenu = PopupMenu(homePage, pop)
            popupmenu.menuInflater.inflate(R.menu.popp, popupmenu.menu)
            popupmenu.setOnMenuItemClickListener { menuItem ->

                when (menuItem.itemId) {
                    R.id.edit -> {

                        dialog.window?.setLayout(
                            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                        )
//                      dialog.setCancelable(false)
                        dialog.setContentView(R.layout.dialogbox)

                        editname = dialog.findViewById(R.id.editname)
                        editcontact = dialog.findViewById(R.id.editcontact)
                        editemail = dialog.findViewById(R.id.editemail)
                        update = dialog.findViewById(R.id.update)



                        editname.setText(udaat.name)
                        editcontact.setText(udaat.contact)



//                        editemail.setText(emailarray[position])
//            val animation: Animation =
//                AnimationUtils.loadAnimation(homePage, R.anim.updateanim)
//            animation.duration = 1000
//            update.animation = animation

                        update.setOnClickListener {

                            Log.e("====POS", "getView:$position ", )

                            var up = MyDataBase(homePage)
                            Log.e("===Uc", "getView: ${editname.text.toString()}")
                            up.upadate(
                                editname.text.toString(),
                                editcontact.text.toString(),
                                editemail.text.toString(),
                                udaat.id
                            )
                            dialog.dismiss()
                            homePage.startActivity(Intent(homePage, Home_page::class.java))
                            homePage.finish()
//                dialog.setCancelable(true)
                        }
                        dialog.show()
                    }

                    R.id.delete -> {
                        var del = MyDataBase(homePage)

                        userlist.removeAt(position)
                        del.delete(position)
                        notifyDataSetChanged()


                    }
                }
                true

            }
            popupmenu.show()
        }
        textview.setText(udaat.name)
        textview2.setText(udaat.contact)
        return forcontact
    }

}


