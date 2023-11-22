package com.example.atapnegeri

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.OnMapReadyCallback

class DetailGunung : AppCompatActivity(), OnMapReadyCallback {
    var dblLatitude = 0.0
    var dblLongitude = 0.0
    var strNamaGunung: String? = null
    var strDeskripsi: String? = null
    var strJalurGunung: String? = null
    var strInfoGunung: String? = null
    lateinit var strLokasiGunung: String
    lateinit var modelGunung: ModelGunung
    lateinit var googleMaps: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_gunung)

    }
}