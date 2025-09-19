package com.example.ninegazes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnNine: Button = findViewById(R.id.btnNine)
        btnNine.setOnClickListener{
            val intent= Intent(this,FirstGazeActivity::class.java)
            startActivity(intent)
        }

    }
}