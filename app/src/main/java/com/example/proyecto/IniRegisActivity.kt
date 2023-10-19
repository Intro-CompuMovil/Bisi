package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class IniRegisActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ini_regis)

        val registro = findViewById<Button>(R.id.registrar)
        val iniciar = findViewById<Button>(R.id.inicio_sesion)

        registro.setOnClickListener {
            val pantalla_registroActivity = Intent (this, RegistroActivity::class.java)
            startActivity(pantalla_registroActivity)
        }

        iniciar.setOnClickListener {
            val pantalla_inicioActivity = Intent (this, InicioActivity::class.java)
            startActivity(pantalla_inicioActivity)
        }
    }
}