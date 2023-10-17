package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class IniRegis : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ini_regis)

        val registro = findViewById<Button>(R.id.registrar)
        val iniciar = findViewById<Button>(R.id.inicio_sesion)

        registro.setOnClickListener {
            val pantalla_registro = Intent (this, Registro::class.java)
            startActivity(pantalla_registro)
        }
    }
}