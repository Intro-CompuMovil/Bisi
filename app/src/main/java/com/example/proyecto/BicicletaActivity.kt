package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

class BicicletaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bicicleta)



        val destacadas = findViewById<RelativeLayout>(R.id.destacadas)
        destacadas.setOnClickListener {
            val pantalla_destacadas = Intent (this, RutaActivity::class.java)
            startActivity(pantalla_destacadas)
        }

        val novedades = findViewById<RelativeLayout>(R.id.novedades)
        novedades.setOnClickListener {
            val pantalla_novedades = Intent (this, RutaActivity::class.java)
            startActivity(pantalla_novedades)
        }
    }



}
