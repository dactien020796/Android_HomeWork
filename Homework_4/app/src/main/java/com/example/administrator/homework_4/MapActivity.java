package com.example.administrator.homework_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Intent intent = getIntent();
        DiaDiem diaDiem = (DiaDiem) intent.getSerializableExtra("DIADIEM");
        // Add a marker in Sydney and move the camera
        LatLng toado = new LatLng(diaDiem.getKinhDo(),diaDiem.getViDo());
        Marker marker = mMap.addMarker(new MarkerOptions().position(toado).title(diaDiem.getTen()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(toado,16));
        mMap.setInfoWindowAdapter(new CustomInfoAdapter(MapActivity.this,diaDiem));
        marker.showInfoWindow();
    }

}
