package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PrincipalActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {

        //Coneccion con el archivo layout
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal_activity)

        val buttonRegistrar: Button = findViewById<Button>(R.id.buttonRegistro)
        buttonRegistrar.setOnClickListener {

            //Cambio de interfaz a registro
            val intent = Intent(this, RegistrarActivity::class.java)
            startActivity(intent)

        }


        val buttonIniciarSesion: Button = findViewById<Button>(R.id.buttonIniciarSesion)
        buttonIniciarSesion.setOnClickListener {

            //Cambio de interfaz a inicio de sesion
            val intent = Intent(this, IniciarSesionActivity::class.java)
            startActivity(intent)

        }

    }

}