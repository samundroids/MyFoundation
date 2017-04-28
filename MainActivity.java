package com.frost.maps_android;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {
    // data are ready to insert, passes on googleMap, put that on mMap
    // Checks if permissions are available for this app
    // tried to connect but not able to connect
    // for location, to get high accuracy location

    private GoogleMap mMap;
    ArrayList<LatLng> markerPointsArrayList;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    public static final int MY_PERMISSION_REQUEST_LOCATION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            checkLocationPermission();
        }

        // Initializing
        markerPointsArrayList = new ArrayList<>();

        //obtain the SupportMapFragment and get notified when the map is ready to be used
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
                mapFragment.getMapAsync(this);
    }

    private void checkLocationPermission() {
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) // we will use android ko aafno manifest
                == PackageManager.PERMISSION_GRANTED){
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
            else{
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    if(markerPointsArrayList.size()>1){
                        markerPointsArrayList.clear();
                        mMap.clear();
                    }
                    // adding new item to arraylist
                    markerPointsArrayList.add(latLng);


                    MarkerOptions options = new MarkerOptions();

                    options.position(latLng);

                    if (markerPointsArrayList.size() == 1){
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)){

                        }else if () //complete by github
                    }
                }
            }
        }

    }

    private void buildGoogleApiClient() {
    }
}

//test push