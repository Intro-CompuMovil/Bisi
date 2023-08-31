package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //Relación con el archivo layout
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonIniciar: Button = findViewById<Button>(R.id.buttonIniciar)
        buttonIniciar.setOnClickListener {

            //Cambio de pantalla
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)

        }

    }

}