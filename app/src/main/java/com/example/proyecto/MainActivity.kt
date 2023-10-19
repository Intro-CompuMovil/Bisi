package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity_main)

        val inicio = findViewById<Button>(R.id.inicio)

        inicio.setOnClickListener {
            val pantalla_ini_regis = Intent (this, IniRegisActivity::class.java)
            startActivity(pantalla_ini_regis)
        }
    }
}