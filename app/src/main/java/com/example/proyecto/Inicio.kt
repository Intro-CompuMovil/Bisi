package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Inicio : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)

        val iniciar_sesion = findViewById<Button>(R.id.iniciar)

        iniciar_sesion.setOnClickListener {
            val pantalla_principal = Intent (this, Principal::class.java)
            startActivity(pantalla_principal)
        }
    }
}