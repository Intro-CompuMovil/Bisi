package com.example.proyecto

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class RutaActivity : AppCompatActivity() {

    // Este método se llama cuando la actividad se crea por primera vez
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ruta)

        // Añadir el mapa al RelativeLayout
        val mapa = findViewById<RelativeLayout>(R.id.mapa)
        val mapView = MapView(this)
        mapView.onResume()
        mapView.layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        mapa.addView(mapView)

        mapView.setClickable(true)
        mapView.setBuiltInZoomControls(true)

        val mapController = mapView.controller
        mapController.setCenter(GeoPoint(4.66288596941014, -74.28583371564271))
        mapController.setZoom(15)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // Comprobar si el permiso fue concedido
        if (requestCode == 100 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permiso concedido
        } else {
            // Permiso denegado
            Toast.makeText(this, "Permiso de ubicación precisa denegado", Toast.LENGTH_SHORT).show()
        }
    }
}


