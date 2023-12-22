package com.example.atapnegeri.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.atapnegeri.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException


class LoginActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var tiEmail: TextInputLayout
    private lateinit var tiPass: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()
        tiEmail = findViewById(R.id.tiEmail1)
        tiPass = findViewById(R.id.tiPassword1)

        val btnLog: Button = findViewById(R.id.btn_Login1)
        btnLog.setOnClickListener {
            login()
        }

        val btnRegister: Button = findViewById(R.id.btn_register1)
        btnRegister.setOnClickListener {
           val toRegister = Intent(this, RegisterActivity::class.java)
            startActivity(toRegister)
        }
    }

    private fun showLoading() {
        // Show your loading indicator (e.g., progress bar)
    }

    private fun hideLoading() {
        // Hide your loading indicator
    }

    private fun login() {
        val email = tiEmail.editText?.text.toString()
        val password = tiPass.editText?.text.toString()

        if (email.isNotBlank() && password.isNotBlank()) {
            // Show a loading indicator
            showLoading()

            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    // Hide the loading indicator
                    hideLoading()

                    if (task.isSuccessful) {
                        // Sign in success, update UI or navigate to the next screen
                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // If sign in fails, display a more specific message to the user.
                        handleAuthFailure(task.exception)
                    }
                }
        } else {
            Toast.makeText(this, "Data Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun register() {
        val email = tiEmail.editText?.text.toString()
        val password = tiPass.editText?.text.toString()

        if (email.isNotBlank() && password.isNotBlank()) {
            // Show a loading indicator
            showLoading()

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    // Hide the loading indicator
                    hideLoading()

                    if (task.isSuccessful) {
                        // Registration success, update UI or navigate to the next screen
                        Toast.makeText(
                            this@LoginActivity, "Registration successful.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        // If registration fails, display a more specific message to the user.
                        handleAuthFailure(task.exception)
                    }
                }
        } else {
            Toast.makeText(this, "Data Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleAuthFailure(exception: Exception?) {
        when (exception) {
            is FirebaseAuthWeakPasswordException -> {
                // Handle weak password during registration
                Toast.makeText(this@LoginActivity, "Weak password", Toast.LENGTH_SHORT).show()
            }
            is FirebaseAuthUserCollisionException -> {
                // Handle if the email is already in use during registration
                Toast.makeText(this@LoginActivity, "Email already in use", Toast.LENGTH_SHORT).show()
            }
            else -> {
                // Handle other authentication failures
                Toast.makeText(this@LoginActivity, "Authentication failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
