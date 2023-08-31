package com.example.proyecto
import android.widget.Toast
import android.content.Context

class Toast  {

    object ToastObject {

        //funcion generica para imprimir un mensaje en pantalla
        fun mostrarToast(context: Context, mensaje: String) {

            val duracion = Toast.LENGTH_LONG
            val toast = Toast.makeText(context, mensaje, duracion)
            toast.show()

        }

    }

}