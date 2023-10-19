package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class PrincipalActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        //Reto
        val reto = findViewById<RelativeLayout>(R.id.cuadro1)
        reto.setOnClickListener {
            val pantalla_reto = Intent (this, RetosActivity::class.java)
            startActivity(pantalla_reto)
        }

        //Crear ruta
        val crear_ruta = findViewById<RelativeLayout>(R.id.crear_ruta)
        crear_ruta.setOnClickListener {
            val pantalla_crear_ruta = Intent (this, CrearRutaActivity::class.java)
            startActivity(pantalla_crear_ruta)
        }

        //Perfil
        val perfil = findViewById<RelativeLayout>(R.id.perfil)
        perfil.setOnClickListener {
            val pantalla_perfilActivity = Intent (this, PerfilActivity::class.java)
            startActivity(pantalla_perfilActivity)
        }

        //Casita
        val casita = findViewById<ImageView>(R.id.casa)
        casita.setOnClickListener {
            val pantalla_casita = Intent (this, PrincipalActivity::class.java)
            startActivity(pantalla_casita)
        }

        //Bicicleta
        val bicicleta = findViewById<ImageView>(R.id.bici)
        bicicleta.setOnClickListener {
            val pantalla_bicicletaActivity = Intent (this, BicicletaActivity::class.java)
            startActivity(pantalla_bicicletaActivity)
        }

        //Amigos
        val amigos = findViewById<ImageView>(R.id.imageView6)
        amigos.setOnClickListener {
            val pantalla_amigosActivity = Intent (this, AmigosActivity::class.java)
            startActivity(pantalla_amigosActivity)
        }


    }
}