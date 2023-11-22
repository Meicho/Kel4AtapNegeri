package com.example.atapnegeri

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.atapnegeri.ListGunung.Companion.setWindowFlag
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


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        setSupportActionBar(toolbar)
        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val mapFragment = supportFragmentManager.findFragmentById(R.idmapView) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        modelGunung = intent.getSerializableExtra(DETAIL_GUNUNG) as ModelGunung
        if (modelGunung != null){
            strLokasiGunung = modelGunung.strLokasiGunung
            strNamaGunung = modelGunung.strNamaGunung
            strDeskripsi = modelGunung.strDeskripsi
            strJalurGunung = modelGunung.strJalurPendakian
            strInfoGunung = modelGunung.strInfoGunung
            dblLatitude = modelGunung.strLat
            dblLongitude = modelGunung.strLong

            Glide.with(this)
                .load(modelGunung.strImageGunung)
                .into(imageGunung)

            tvNamaGunung.setText(strNamaGunung)
            tvLokasiGunung.setText(strLokasiGunung)
            tvDeskripsi.setText(strDeskripsi)
            tvJalurGunung.setText(strJalurGunung)
            tvInfoGunung.setText(strInfoGunung)
        }
    }
    override fun onMapReady(googleMap: GoogleMap) {
        googleMaps = googleMap
        val latLng = LatLng(dblLatitude, dblLongitude)
        googleMaps.addMarker(MarkerOptions().position(latLng).title(strNamaGunung))
        googleMaps.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        googleMaps.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f))
        googleMaps.uiSettings.setAllGesturesEnabled(true)
        googleMaps.uiSettings.isZoomGesturesEnabled = true
        googleMaps.isTrafficEnabled = true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}