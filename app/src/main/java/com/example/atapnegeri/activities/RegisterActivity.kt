package com.example.atapnegeri.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.atapnegeri.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnSignup: Button = findViewById(R.id.btn_signup)
        val tiName: TextInputLayout = findViewById(R.id.tf_uname)
        val ke_masuk: TextView = findViewById(R.id.ke_masuk)
        val firebase: FirebaseAuth = FirebaseAuth.getInstance()
        val tiPass: TextInputLayout = findViewById(R.id.tf_pass)
        val tiEmail: TextInputLayout = findViewById(R.id.tf_email)

        ke_masuk.setOnClickListener{
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        btnSignup.setOnClickListener {
            var name = tiName.editText?.text.toString()
            val pass = tiPass.editText?.text.toString()
            val email = tiEmail.editText?.text.toString()
            if (pass.isEmpty() || email.isEmpty()){
                Toast.makeText(this, "Silahkan Masukkan Semua Data", Toast.LENGTH_SHORT).show()
            }else{
                firebase.createUserWithEmailAndPassword(email,pass).addOnSuccessListener {
                    Toast.makeText(this, "Berhasil Registrasi", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Gagal Registrasi", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }
}