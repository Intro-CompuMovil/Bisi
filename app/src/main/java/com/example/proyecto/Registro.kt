package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        val inicio = findViewById<Button>(R.id.registrar)

        inicio.setOnClickListener {
            val pantalla_ini_regis = Intent (this, IniRegis::class.java)
            startActivity(pantalla_ini_regis)
            Toast.makeText(applicationContext, "¡Se registro correctamente!", Toast.LENGTH_LONG).show()
        }
    }
}