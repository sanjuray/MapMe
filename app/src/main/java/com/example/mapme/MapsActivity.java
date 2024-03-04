package com.example.mapme;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapme.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener{

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng griet = new LatLng(17.5203,78.3674);
        mMap.addMarker(new MarkerOptions()
                .position(griet)//.visible(false) -> Maker visible and Invisisble
                //.draggable(true)//.alpha(10) -> transparency adjustment
                .snippet("One of it's Kind @"+griet)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.namma_logo_1))//rotation(degree) -> rotates the marker by that int degrees
                .title("GRIET College Marker"));//zIndex(float) -> in stacked index marker the one with more index is shown on top
        mMap.moveCamera(CameraUpdateFactory.newLatLng(griet));

        LatLng m = new LatLng(50,50);
        marker = mMap.addMarker(new MarkerOptions()
                .position(m)
                .draggable(true)
                .title("M: I'm Here!"));
        mMap.setOnMarkerDragListener(this);
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(m));
        mMap.moveCamera(CameraUpdateFactory.zoomIn());
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Toast.makeText(this, "You Got Me! @"+marker.getPosition(), Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onMarkerDrag(@NonNull Marker marker) {
        Toast.makeText(this, "You are dragging "+marker.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMarkerDragEnd(@NonNull Marker marker) {
        Toast.makeText(this, "You stopped dragging to "+marker.getPosition(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMarkerDragStart(@NonNull Marker marker) {
        Toast.makeText(this, "dragging from "+marker.getPosition(), Toast.LENGTH_SHORT).show();
    }
}