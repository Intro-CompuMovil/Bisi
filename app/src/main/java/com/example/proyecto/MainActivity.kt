package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inicio = findViewById<Button>(R.id.inicio)

        inicio.setOnClickListener {
            val pantalla_ini_regis = Intent (this, IniRegis::class.java)
            startActivity(pantalla_ini_regis)
        }
    }
}