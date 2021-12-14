package com.example.inwestanalist


import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCanceledListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), OnCanceledListener, OnFailureListener {

    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = getInstance()
        auth.signInAnonymously().addOnCanceledListener(this).addOnFailureListener(this)



        // declare the animation
        val runOfPhoto = AnimationUtils.loadAnimation(this,R.anim.photo)
        val runButton = AnimationUtils.loadAnimation(this, R.anim.button)
        mainImage.startAnimation(runOfPhoto)
        mainStart.startAnimation(runButton)




        mainStart.setOnClickListener {

            val intent = Intent(this, Analist::class.java)
            startActivity(intent)

        }


    }

    override fun onCanceled() {

    }

    override fun onFailure(p0: Exception) {

    }


}