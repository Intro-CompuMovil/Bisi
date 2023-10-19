

/*class RutaActivity : AppCompatActivity() {

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
}*/

package com.example.proyecto

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker


class RutaActivity : AppCompatActivity() {

    private val REQUEST_LOCATION_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ruta)

        // Configuramos la biblioteca de mapas de Osmdroid
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
        Configuration.getInstance().userAgent = "RutaApp"

        // Creamos un objeto MapView
        val mapView = findViewById<MapView>(R.id.mapView)
        mapView.setTileSource(TileSourceFactory.MAPNIK)
        mapView.setMaxZoomLevel(20.0)
        mapView.setMinZoomLevel(1.0)

        // Solicitamos el permiso de ubicación exacta
        requestLocationPermission()
    }

    private fun requestLocationPermission() {
        // Verificamos si el permiso ya está otorgado
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Solicitamos el permiso al usuario
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSION)
        } else {
            // El permiso ya está otorgado, obtenemos la ubicación actual
            getDeviceLocation()
        }
    }

    private fun getDeviceLocation() {
        // Creamos un cliente de servicios de ubicación
        val locationClient = LocationServices.getFusedLocationProviderClient(this)

        // Solicitamos la ubicación actual
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        locationClient.lastLocation.addOnSuccessListener { location ->
            // Si la ubicación es válida, la mostramos en un mapa
            if (location != null) {
                // Agregamos un marcador a la ubicación actual del dispositivo
                val marker = Marker(mapView.projection.toScreenLocation(location.toLatLng()))
                marker.position = location.toLatLng()
                marker.title = "Ubicación actual"
                mapView.addMarker(marker)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // Si el permiso fue otorgado, obtenemos la ubicación actual
        if (requestCode == REQUEST_LOCATION_PERMISSION && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getDeviceLocation()
        } else {
            // El permiso fue denegado, mostramos un mensaje al usuario
            Toast.makeText(this, "Permiso de ubicación denegado", Toast.LENGTH_SHORT).show()
        }
    }
}


