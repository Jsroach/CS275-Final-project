package com.example.styledmap;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class DangerousLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        List<Crime> crimes = new ArrayList<>();
        double minDistanceMiles = Double.MAX_VALUE;
        for(Crime crime : crimes) {
            double dist = distance(latitude, longitude, crime.getLatitude(), crime.getLongitude());
            minDistanceMiles = min(dist, minDistanceMiles);
        }

        double limitMiles = 0;

        reportDangerous(minDistanceMiles < limitMiles);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    private void reportDangerous(boolean isDangerous) {
        Log.d("INFO", isDangerous ? "Dangerous!" : "Safe.");
    }

    // distance in miles.
    private double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            return (dist);
        }
    }
}
