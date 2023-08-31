package com.example.proyecto

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

class Permisos {

    object permiso {

        //Función generica para solicitar permisos
        //Confirma si ya se dio un permiso en el contexto ingresado
        fun requestPermissionCamara(Context: Context, permiso: String, justificacion: String) {

            //Condicional so no se ha concedido
            if (ContextCompat.checkSelfPermission(Context, permiso) != PackageManager.PERMISSION_DENIED) {



            }

        }

    }

}