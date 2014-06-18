package info.srihawong.bikeshop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Banpot.S on 14/5/2557.
 */
public class Location implements LocationListener{
    private final static int
            CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private LocationManager locationManager;
    private LocationListener locationListener;

    public android.location.Location location;

    public void init(Context context) {
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                CONNECTION_FAILURE_RESOLUTION_REQUEST,// minTime in ms
                0,// minDistance in meters
                this
        );
    }

    public double getLatitude() {
        return location.getLatitude();
    }

    public double getLongitude() {
        return location.getLongitude();
    }

    @Override
    public void onLocationChanged(android.location.Location location) {
        this.location = location;
        Log.d("tui", String.valueOf(location.getLatitude()));
        Log.d("tui", String.valueOf(location.getLongitude()));
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

    public double getDistance(double lat,double lng){
        double toLat = location.getLatitude();
        double toLng = location.getLongitude();
        return Math.acos(Math.sin(lat)*Math.sin(toLat)+Math.cos(lat)*Math.cos(toLat)*Math.cos(toLng-lng))*6371;
    }
}



