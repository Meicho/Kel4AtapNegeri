package com.example.atapnegeri.activities

import Adapter.MainAdapter
import Model.ModelMain
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.atapnegeri.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    private var modelMain: MutableList<ModelMain> = ArrayList()
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance()

        // Initialize Firebase Realtime Database
        databaseReference = FirebaseDatabase.getInstance().reference.child("gunung")

        // UI initialization code
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = resources.getColor(android.R.color.transparent, theme)
        }

        val rvLokasi: RecyclerView = findViewById(R.id.rvLokasi)




        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        mainAdapter = MainAdapter(this, modelMain)
        rvLokasi.layoutManager = LinearLayoutManager(this)
        rvLokasi.adapter = mainAdapter
        rvLokasi.setHasFixedSize(true)

        getLokasiGunung()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getLokasiGunung() {
        // Retrieve data from Firebase Realtime Database
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                modelMain.clear() // Clear the list before adding new data
                for (snapshot in dataSnapshot.children) {
                    val dataApi = ModelMain()
                    dataApi.strLokasi = snapshot.child("lokasi").getValue(String::class.java)
                    modelMain.add(dataApi)
                }
                mainAdapter.notifyDataSetChanged() // Notify adapter about the changes
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@MainActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    companion object {
        fun setWindowFlag(activity: AppCompatActivity, bits: Int, on: Boolean) {
            val window = activity.window
            val layoutParams = window.attributes
            if (on) {
                layoutParams.flags = layoutParams.flags or bits
            } else {
                layoutParams.flags = layoutParams.flags and bits.inv()
            }
            window.attributes = layoutParams
        }
    }
}