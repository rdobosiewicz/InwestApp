package com.example.inwestanalist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.inwestanalist.dataBase.WskaznikiDataBase
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.android.synthetic.main.activity_library.*

class Library : AppCompatActivity() {

    private lateinit var wskaznikiList: ArrayList<WskaznikiDataBase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        var firebaseDatabase = FirebaseDatabase.getInstance("https://investapp-a565e-default-rtdb.firebaseio.com/")
        var databaseReference = firebaseDatabase.getReference("Wskazniki")

       wskaznikiList = arrayListOf()


        databaseReference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for(data in snapshot.children){
                    val pro = data.getValue(WskaznikiDataBase::class.java)
                    wskaznikiList.add(pro!!)
                }
                mainLibraryArray.adapter = MyNameAdapter(this@Library,wskaznikiList)

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

    }
}

class MyNameAdapter(context: Context, val wskaznikiList: List<WskaznikiDataBase>): BaseAdapter(){

    private val mContext: Context = context

    //responsible for how many rows in my list
    override fun getCount(): Int {
        return wskaznikiList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        return "Test"
    }
    // responsible for rendering out ech row
    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

        val textView = TextView(mContext)

        val nameS = wskaznikiList[position]

        textView.text = nameS.nazwa

        textView.textSize = 20F

        return textView

    }
}