package com.example.proyecto

class ValidacionFuncion {

    companion object {

        //vararg -> sintaxis que me permite pasar una lista de argumentos de longitud variable
        fun noEstanVacios(vararg campos: String ): Boolean {
            
            return campos.all { it.isNotEmpty() }

        }

    }

}