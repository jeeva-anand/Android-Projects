package com.example.demo;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.demo.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

  private GoogleMap mGoogleMap;

  FloatingActionButton mLocationFab;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActivityMapsBinding binding = ActivityMapsBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    SupportMapFragment mapFragment =
        (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

    mLocationFab = binding.fab;
    if (mapFragment != null) {
      mapFragment.getMapAsync(this);
    }

    mLocationFab.setOnClickListener(
        v -> {
          if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                  != PackageManager.PERMISSION_GRANTED
              && ActivityCompat.checkSelfPermission(
                      this, Manifest.permission.ACCESS_COARSE_LOCATION)
                  != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
          }
          locationManager.requestSingleUpdate(
              LocationManager.GPS_PROVIDER, this, Looper.getMainLooper());
        });

    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
      return;
    }
    locationManager.requestLocationUpdates(
        LocationManager.GPS_PROVIDER, 60 * 1000, 1000, this, Looper.myLooper());
  }

  LocationManager locationManager;

  /**
   * Manipulates the map once available. This callback is triggered when the map is ready to be
   * used. This is where we can add markers or lines, add listeners or move the camera. In this
   * case, we just add a marker near Sydney, Australia. If Google Play services is not installed on
   * the device, the user will be prompted to install it inside the SupportMapFragment. This method
   * will only be triggered once the user has installed Google Play services and returned to the
   * app.
   */
  @Override
  public void onMapReady(@NonNull GoogleMap googleMap) {
    mGoogleMap = googleMap;

    // Add a marker in Sydney and move the camera

    LatLng coordinates = new LatLng(-34, 151);
    mGoogleMap.addMarker(new MarkerOptions().position(coordinates).title("Marker in Sydney"));
    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(coordinates));
  }

  @Override
  public void onLocationChanged(@NonNull Location location) {
    Log.d(getClass().getSimpleName(), location.toString());
    LatLng coordinates = new LatLng(location.getLatitude(), location.getLongitude());
    mGoogleMap.addMarker(new MarkerOptions().position(coordinates).title("Current Location"));

    mGoogleMap.animateCamera(
        CameraUpdateFactory.newLatLngZoom(coordinates, mGoogleMap.getMaxZoomLevel()));
  }
}
