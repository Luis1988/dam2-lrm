package com.fusioncube.enraya;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class JuegoActivity extends Activity {
	
	private Button volver, btnReinicio;
	private ImageView  iv11, iv12, iv13;
	private ImageView  iv21, iv22, iv23;
	private ImageView  iv31, iv32, iv33;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		volver = (Button) findViewById(R.id.btnVolver);
		btnReinicio = (Button) findViewById(R.id.btnReinicio);
		iv11 = (ImageView) findViewById(R.id.iv11);
		iv12 = (ImageView) findViewById(R.id.iv12);
		iv13 = (ImageView) findViewById(R.id.iv13);
		iv21 = (ImageView) findViewById(R.id.iv21);
		iv22 = (ImageView) findViewById(R.id.iv22);
		iv23 = (ImageView) findViewById(R.id.iv23);
		iv31 = (ImageView) findViewById(R.id.iv31);
		iv32 = (ImageView) findViewById(R.id.iv32);
		iv33 = (ImageView) findViewById(R.id.iv33);
		
		controlador(this);
		
		btnReinicio.setEnabled(false);
	}

	public void controlador(JuegoActivity ja) {
		iv11.setOnClickListener(new ControladorJuego(ja));
		iv12.setOnClickListener(new ControladorJuego(ja));
		iv13.setOnClickListener(new ControladorJuego(ja));
		iv21.setOnClickListener(new ControladorJuego(ja));
		iv22.setOnClickListener(new ControladorJuego(ja));
		iv23.setOnClickListener(new ControladorJuego(ja));
		iv31.setOnClickListener(new ControladorJuego(ja));
		iv32.setOnClickListener(new ControladorJuego(ja));
		iv33.setOnClickListener(new ControladorJuego(ja));
		volver.setOnClickListener(new ControladorJuego(ja));
		btnReinicio.setOnClickListener(new ControladorJuego(ja));
	}
	
	public void limpiarCasillas() {
		iv11.setImageResource(R.drawable.nada);
		iv12.setImageResource(R.drawable.nada);
		iv13.setImageResource(R.drawable.nada);
		iv21.setImageResource(R.drawable.nada);
		iv22.setImageResource(R.drawable.nada);
		iv23.setImageResource(R.drawable.nada);
		iv31.setImageResource(R.drawable.nada);
		iv32.setImageResource(R.drawable.nada);
		iv33.setImageResource(R.drawable.nada);
		iv11.setEnabled(true);
		iv12.setEnabled(true);
		iv13.setEnabled(true);
		iv21.setEnabled(true);
		iv22.setEnabled(true);
		iv23.setEnabled(true);
		iv31.setEnabled(true);
		iv32.setEnabled(true);
		iv33.setEnabled(true);
	}
	
	public boolean todasDeshabilitadas() {
		boolean res = !iv11.isEnabled() && !iv12.isEnabled() && !iv13.isEnabled();
		if(res) {
			res = !iv21.isEnabled() && !iv22.isEnabled() && !iv23.isEnabled();
			if(res)
				res = !iv31.isEnabled() && !iv32.isEnabled() && !iv33.isEnabled();
		}
		return res;
		
	}
	
	public void habilitaReinicio(boolean flag) {
		btnReinicio.setEnabled(flag);
	}
	
	public void computadora() {
		boolean puesto = false;
		while(!puesto) {
			if(todasDeshabilitadas())
				puesto = true;
			int pos = (int) (Math.random()*8)+1;
			switch(pos) {
			case 1:
				if(iv11.isEnabled()){
					iv11.setImageResource(R.drawable.equis);
					iv11.setEnabled(false);
					puesto = true;
				}
				break;
			case 2:
				if(iv12.isEnabled()){
					iv12.setImageResource(R.drawable.equis);
					iv12.setEnabled(false);
					puesto = true;
				}
				break;
			case 3:
				if(iv13.isEnabled()){
					iv13.setImageResource(R.drawable.equis);
					iv13.setEnabled(false);
					puesto = true;
				}
				break;
			case 4:
				if(iv21.isEnabled()){
					iv21.setImageResource(R.drawable.equis);
					iv21.setEnabled(false);
					puesto = true;
				}
				break;
			case 5:
				if(iv22.isEnabled()){
					iv22.setImageResource(R.drawable.equis);
					iv22.setEnabled(false);
					puesto = true;
				}
				break;
			case 6:
				if(iv23.isEnabled()){
					iv23.setImageResource(R.drawable.equis);
					iv23.setEnabled(false);
					puesto = true;
				}
				break;
			case 7:
				if(iv31.isEnabled()){
					iv31.setImageResource(R.drawable.equis);
					iv31.setEnabled(false);
					puesto = true;
				}
				break;
			case 8:
				if(iv32.isEnabled()){
					iv32.setImageResource(R.drawable.equis);
					iv32.setEnabled(false);
					puesto = true;
				}
				break;
			case 9:
				if(iv33.isEnabled()){
					iv33.setImageResource(R.drawable.equis);
					iv33.setEnabled(false);
					puesto = true;
				}
				break;
			}
		}
	}

}
