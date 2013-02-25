package com.fusioncube.gpsyproveedores;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class GPSActivity extends Activity {

	private EditText etLatitud, etLongitud, etPrecision;
	private Button btnActivar, btnDesactivar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);

		etLatitud = (EditText) findViewById(R.id.etLatitud);
		etLongitud = (EditText) findViewById(R.id.etLongitud);
		etPrecision = (EditText) findViewById(R.id.etPrecision);
		btnActivar = (Button) findViewById(R.id.btnActivar);
		btnDesactivar = (Button) findViewById(R.id.btnDesactivar);

		final LocationManager milocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		final LocationListener milocListener = new MiLocationListener(this);

		btnActivar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			    milocManager.requestLocationUpdates(
			        LocationManager.GPS_PROVIDER, 0, 0, milocListener);
			}
		});

		btnDesactivar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				milocManager.removeUpdates(milocListener);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.g, menu);
		return true;
	}

	public void setLatitud(String s) {
		etLatitud.setText(s);
	}

	public void setLongitud(String s) {
		etLongitud.setText(s);
	}

	public void setPrecision(String s) {
		etPrecision.setText(s);
	}

}
