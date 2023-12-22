package com.example.atapnegeri.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.atapnegeri.R

class HomeActivity : AppCompatActivity() {
    private lateinit var prefManager: PrefManager
    private lateinit var infoGunung: CardView
    private lateinit var Peralatan: CardView
    private lateinit var userProfil: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        infoGunung = findViewById(R.id.infoGunung)
        Peralatan = findViewById(R.id.Peralatan)

        var username: TextView = findViewById(R.id.txUsername)

        prefManager = PrefManager(this)
        username.text = prefManager.getUsername().toString()


        infoGunung.setOnClickListener {
            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)
        }

        Peralatan.setOnClickListener {
            val intent = Intent(this@HomeActivity, PeralatanActivity::class.java)
            startActivity(intent)
        }


    }

    private fun checkLogin(){
        if (prefManager.isLogin() == false){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}