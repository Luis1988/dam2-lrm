package com.fusioncube.enraya;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class ControladorClick implements OnClickListener {

	private Inicio3RayaActivity ira;

	public ControladorClick(Inicio3RayaActivity ira) {
		this.ira = ira;
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.btnInicio) {
			ira.showDialog(ira.DIALOGO_SELECCION);
		}
		if(v.getId() == R.id.btnAcercaDe) {
			ira.showDialog(ira.DIALOGO_ALERTA);
		}
		if(v.getId() == R.id.btnAdmin) {
			Intent i = new Intent(ira.getApplicationContext(), AdminActivity.class);
			ira.startActivity(i);
		}
		if(v.getId() == R.id.btnSalir) {
			ira.showDialog(ira.DIALOGO_CONFIRMACION);
		}
	}

}
