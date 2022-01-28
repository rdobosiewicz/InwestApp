package com.example.inwestanalist


import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //auth = FirebaseAuth.getInstance()
        //auth.signInAnonymously()




        // declare the animation
        val runOfPhoto = AnimationUtils.loadAnimation(this,R.anim.photo)
        val runButton = AnimationUtils.loadAnimation(this, R.anim.button)
        mainImage.startAnimation(runOfPhoto)
        mainStart.startAnimation(runButton)




        mainStart.setOnClickListener {

            val analistView = Intent(this, Analist::class.java)
            startActivity(analistView)

        }

        mainHistory.setOnClickListener{

            val historyView = Intent(this, Library::class.java)
            startActivity(historyView)
        }


    }



}