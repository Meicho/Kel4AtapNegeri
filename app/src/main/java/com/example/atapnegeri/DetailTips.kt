package com.example.atapnegeri

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailTips : AppCompatActivity() {
    lateinit var modelPeralatan: ModelPeralatan
    var strNamaAlat: String? = null
    var strTips: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_peralatan)

    }
}