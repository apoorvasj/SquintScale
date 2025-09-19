package com.example.ninegazes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnProvider: Button = findViewById(R.id.btnProvider)
        btnProvider.setOnClickListener{
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        val btnPatient: Button = findViewById(R.id.btnPatient)
        btnProvider.setOnClickListener{
            val intent1= Intent(this,LoginActivity::class.java)
            startActivity(intent1)
        }

    }
}