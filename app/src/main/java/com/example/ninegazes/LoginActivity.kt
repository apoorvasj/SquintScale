package com.example.ninegazes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val btnLogin: Button= findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener{
            val intent= Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }

    }
}