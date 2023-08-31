package com.example.proyecto

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class IniciarSesionActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.iniciar_sesion_activity)

        fun casillasValidacion (){

            //Captura de datos que se encuentran en los TextInputLayout
            val casillaTextContraseña: TextInputLayout = findViewById(R.id.casillaContraseña)
            val casillaTextUsuario: TextInputLayout = findViewById(R.id.casillaUsuario)

            //Conversion datos a string
            val contraseña = casillaTextContraseña.editText?.text.toString()
            val usuario = casillaTextUsuario.editText?.text.toString()


            //Implementacion funcion generica con la que se confirman si falto llenar algun espacio
            if (ValidacionFuncion.noEstanVacios(usuario, contraseña)) {

                //Cambio de interfaz
                val intent = Intent(this, InicioActivity::class.java)
                startActivity(intent)
                //Mensaje con el que se notifica que ya fue registrado
                Toast.ToastObject.mostrarToast(this,"Ingreso de sesión exitoso")

            }

            else {

                //Mensaje con el que advierte al usuario que no ha llenado todos los campos
                Toast.ToastObject.mostrarToast(this,"Los datos no se encuentran completos")

            }

        }
        //Boton
        val botonIniciarSesion = findViewById<Button>(R.id.buttonIniciarSesion)
        botonIniciarSesion.setOnClickListener {

            //Llamado función
            casillasValidacion()


        }

    }
}