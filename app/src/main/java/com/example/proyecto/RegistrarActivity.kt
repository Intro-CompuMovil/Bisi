package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class RegistrarActivity : AppCompatActivity() {

    companion object{

        private const val My_permission_request_use_camera = 0

    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrar_activity)

        fun casillasValidacion (){

            //Captura de datos que se encuentran en los TextInputLayout
            val casillaTextNombre: TextInputLayout = findViewById(R.id.casillaNombre)
            val casillaTextCorreo: TextInputLayout = findViewById(R.id.casillaCorreo)
            val casillaTextContraseña: TextInputLayout = findViewById(R.id.casillaContraseña)
            val casillaTextUsuario: TextInputLayout = findViewById(R.id.casillaUsuario)

            //Conversion datos a string
            val nombre = casillaTextNombre.editText?.text.toString()
            val correo = casillaTextCorreo.editText?.text.toString()
            val contraseña = casillaTextContraseña.editText?.text.toString()
            val usuario = casillaTextUsuario.editText?.text.toString()


            //Implementacion funcion generica con la que se confirman si falto llenar algun espacio
            if (ValidacionFuncion.noEstanVacios(nombre, correo, usuario, contraseña)) {

                //Cambio de interfaz
                val intent = Intent(this, PrincipalActivity::class.java)
                startActivity(intent)
                //Mensaje con el que se notifica que ya fue registrado
                Toast.ToastObject.mostrarToast(this,"Ingrese a la plataforma con sus usuario y contraseña")

            }

            else {

                //Mensaje con el que advierte al usuario que no ha llenado todos los campos
                Toast.ToastObject.mostrarToast(this,"Los datos no se encuentran completos")

            }

        }

        //Boton
        val botonRegistro = findViewById<Button>(R.id.buttonRegistrarse)
        botonRegistro.setOnClickListener {

            casillasValidacion()

        }

        //Imagen como boton
        val FotoBoton = findViewById<ImageView>(R.id.imageFoto)
        FotoBoton.setOnClickListener{

            // Permiso de la cámara
            val CAMERA_PERMISSION = Manifest.permission.CAMERA

            //Llama funcion generica permiso
            Permisos.permiso.requestPermissionCamara(baseContext, CAMERA_PERMISSION, "Necesitamos acceder a la cámara")

        }

    }

}