package com.example.styledmap;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import android.graphics.drawable.Icon;
import java.io.File;

/**
 * A styled map using JSON styles from a raw resource.
 */
public class MapsActivityRaw extends AppCompatActivity
        implements OnMapReadyCallback {

    private static final String TAG = MapsActivityRaw.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps_raw);

        // Get the SupportMapFragment and register for the callback
        // when the map is ready for use.
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

/*    public void getMapAsync(OnMapReadyCallback callback){
        GoogleMapOptions options = new GoogleMapOptions();
        options.mapType(GoogleMap.MAP_TYPE_SATELLITE)
                .compassEnabled(true)
                .rotateGesturesEnabled(true)
                .tiltGesturesEnabled(true);

    }*/
    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready for use.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // File directory = context.getFilesDir();
        //File file = new File(directory,gunMarker.bmp);
        //getMapAsync(this);
        BitmapDescriptor armedRob = BitmapDescriptorFactory.fromResource(R.drawable.armedrob);
        BitmapDescriptor assault = BitmapDescriptorFactory.fromResource(R.drawable.assault);
        BitmapDescriptor assaultTwo = BitmapDescriptorFactory.fromResource(R.drawable.assaulttwo);
        BitmapDescriptor burglary = BitmapDescriptorFactory.fromResource(R.drawable.burglary);
        BitmapDescriptor carburglary = BitmapDescriptorFactory.fromResource(R.drawable.carburglary);
        BitmapDescriptor homicide = BitmapDescriptorFactory.fromResource(R.drawable.homicide);
        BitmapDescriptor kidnap = BitmapDescriptorFactory.fromResource(R.drawable.kidnap);
        BitmapDescriptor rape = BitmapDescriptorFactory.fromResource(R.drawable.rape);
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.052235, -118.243683))
                .title("Bang bang")
                .snippet("Summary of crime")
                .icon(armedRob));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.152235, -118.243683))
                .title("Bang bang")
                .snippet("Summary of crime")
                .icon(assault));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.252235, -118.243683))
                .title("Bang bang")
                .snippet("Summary of crime")
                .icon(assaultTwo));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.352235, -118.243683))
                .title("Bang bang")
                .snippet("Summary of crime")
                .icon(burglary));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.452235, -118.243683))
                .title("Bang bang")
                .snippet("Summary of crime")
                .icon(carburglary));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.552235, -118.243683))
                .title("Bang bang")
                .snippet("Summary of crime")
                .icon(homicide));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.652235, -118.243683))
                .title("Bang bang")
                .snippet("Summary of crime")
                .icon(kidnap));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(34.752235, -118.243683))
                .title("Bang bang")
                .snippet("Summary of crime")
                .icon(rape));
        //.icon(BitmapDescriptorFactory.fromPath(String.C:\Users\AllBen\Desktop\android-samples-master2\android-samples-master\tutorials\StyledMap\app\src\main\res\drawable\gunMarker.bmp));
        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.gunmarker));
        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.gunmarker,"gunmarker"));
/*        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }*/
        // Position the map's camera near Sydney, Australia.
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(34.752235, -118.243683)));
    }

}


