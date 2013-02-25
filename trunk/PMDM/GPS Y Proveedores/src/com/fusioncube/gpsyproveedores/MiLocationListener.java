package com.fusioncube.gpsyproveedores;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class MiLocationListener implements LocationListener {
	
	private GPSActivity vista;
	
	public MiLocationListener(GPSActivity vista) {
		this.vista = vista;
	}

	@Override
	public void onLocationChanged(Location loc) {
		vista.setLatitud(String.valueOf(loc.getLatitude()));
		vista.setLongitud(String.valueOf(loc.getLongitude()));
		vista.setPrecision(String.valueOf(loc.getAccuracy()));
	}

	@Override
	public void onProviderDisabled(String arg0) {
		Toast.makeText(vista.getApplicationContext(),"Gps Desactivado",Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onProviderEnabled(String arg0) {
		Toast.makeText(vista.getApplicationContext(),"Gps Activo",Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

}
