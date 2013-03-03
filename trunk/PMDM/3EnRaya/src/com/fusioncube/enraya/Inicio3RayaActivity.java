package com.fusioncube.enraya;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;

public class Inicio3RayaActivity extends Activity {
	
	private Button btnAcercaDe, btnAdmin, btnSalir, btnInicio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio3_raya);
		
		btnAcercaDe = (Button) findViewById(R.id.btnAcercaDe);
		btnAdmin = (Button) findViewById(R.id.btnAdmin);
		btnSalir = (Button) findViewById(R.id.btnSalir);
		btnInicio = (Button) findViewById(R.id.btnInicio);
		
		controlador(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio3_raya, menu);
		return true;
	}
	
	public void controlador(Inicio3RayaActivity ira) {
		btnAcercaDe.setOnClickListener(new ControladorClick(ira));
		btnAdmin.setOnClickListener(new ControladorClick(ira));
		btnSalir.setOnClickListener(new ControladorClick(ira));
		btnInicio.setOnClickListener(new ControladorClick(ira));
	}

}
