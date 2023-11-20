package com.example.atapnegeri

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Adapter

class MainActivity : AppCompatActivity() {

    var modelMain : MutableList<ModelMain> = ArrayList()
    lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        if (Build.VERSION.SDK_INT >= 21){
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT

        }

        setSupportActionBar(toolbar)
        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        mainAdapter = MainAdapter(this, modelMain)
        rv,Lokasi.setLayoutManager(LinearLayoutManager(this))
        mainAdapter = MainAdapter(this, modelMain)
        rvLokasi.setLayoutManager(LinearLayoutManager(this))
        rvLokasi.setAdapter(mainAdapter)
        rvLokasi.setHasFixedSize(true)

    }
}