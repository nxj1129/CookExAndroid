package com.example.jugovac_finalproject.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jugovac_finalproject.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val konzum = LatLng(45.803251, 16.006248)
        mMap.addMarker(
            MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.konzum_icon))
                .position(konzum)
                .title("Super Konzum Radnicka")
                .snippet("Radnička cesta 49")
        )

        val lidl = LatLng(45.807751, 15.954415)
        mMap.addMarker(
            MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lidl_icon))
                .position(lidl)
                .title("Lidl Tresnjevka")
                .snippet("Nova cesta 7")
        )

        val spar = LatLng(45.812365, 15.985870)
        mMap.addMarker(
            MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.spar_icon))
                .position(spar)
                .title("Super Spar")
                .snippet("Martićeva ul. 13")
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(spar, 12.0f))
    }
}
