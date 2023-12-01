package com.example.atapnegeri.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.atapnegeri.R

class LoadActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceSate: Bundle?){
        super.onCreate(savedInstanceSate)
        setContentView(R.layout.activity_load)

        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        },5000)

    }
}