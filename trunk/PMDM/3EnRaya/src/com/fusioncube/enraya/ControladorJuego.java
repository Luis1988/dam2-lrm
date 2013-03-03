package com.fusioncube.enraya;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ControladorJuego implements OnClickListener {

	private JuegoActivity ja;

	public ControladorJuego(JuegoActivity ja) {
		this.ja = ja;
		if(ja.todasDeshabilitadas())
			ja.habilitaReinicio(true);
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.btnVolver) {
			Intent i = new Intent(ja.getApplicationContext(), Inicio3RayaActivity.class);
			ja.startActivity(i);
		}
		else if(v.getId() == R.id.btnReinicio) {
			ja.limpiarCasillas();
			ja.habilitaReinicio(false);
		}
		else{
			ImageView iv = (ImageView) v;
			if(iv.isEnabled()) {
				iv.setImageResource(R.drawable.circulo);
				iv.setEnabled(false);
				ja.computadora();
			}
			if(ja.todasDeshabilitadas())
				ja.habilitaReinicio(true);
		}
	}

}
