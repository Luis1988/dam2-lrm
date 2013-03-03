package com.fusioncube.enraya;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JuegoActivity extends Activity {

	private Button volver, btnReinicio;
	private ImageView  iv11, iv12, iv13;
	private ImageView  iv21, iv22, iv23;
	private ImageView  iv31, iv32, iv33;
	private TextView tvEstadisticas;
	private String usuario;
	String[][] matriz = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};

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
		tvEstadisticas = (TextView) findViewById(R.id.tvEstadisticas);

		Bundle recogerDatos = getIntent().getExtras();
		usuario = recogerDatos.getString("usuario");
		AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		Cursor fila = bd.rawQuery("select * from jugadores where nombre like '"+usuario+"'", null);
		if(fila.moveToFirst())
			tvEstadisticas.setText(fila.getString(0)+" - G:"+fila.getString(1)+
					" - E:"+fila.getString(2)+" - P:"+fila.getString(3));
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
		String[][] matrizVacia = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};
		matriz = matrizVacia;
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

	public String computadora() {
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
					matriz[0][0] = "X";
					puesto = true;
				}
				break;
			case 2:
				if(iv12.isEnabled()){
					iv12.setImageResource(R.drawable.equis);
					iv12.setEnabled(false);
					matriz[0][1] = "X";
					puesto = true;
				}
				break;
			case 3:
				if(iv13.isEnabled()){
					iv13.setImageResource(R.drawable.equis);
					iv13.setEnabled(false);
					matriz[0][2] = "X";
					puesto = true;
				}
				break;
			case 4:
				if(iv21.isEnabled()){
					iv21.setImageResource(R.drawable.equis);
					iv21.setEnabled(false);
					matriz[1][0] = "X";
					puesto = true;
				}
				break;
			case 5:
				if(iv22.isEnabled()){
					iv22.setImageResource(R.drawable.equis);
					iv22.setEnabled(false);
					matriz[1][1] = "X";
					puesto = true;
				}
				break;
			case 6:
				if(iv23.isEnabled()){
					iv23.setImageResource(R.drawable.equis);
					iv23.setEnabled(false);
					matriz[1][2] = "X";
					puesto = true;
				}
				break;
			case 7:
				if(iv31.isEnabled()){
					iv31.setImageResource(R.drawable.equis);
					iv31.setEnabled(false);
					matriz[2][0] = "X";
					puesto = true;
				}
				break;
			case 8:
				if(iv32.isEnabled()){
					iv32.setImageResource(R.drawable.equis);
					iv32.setEnabled(false);
					matriz[2][1] = "X";
					puesto = true;
				}
				break;
			case 9:
				if(iv33.isEnabled()){
					iv33.setImageResource(R.drawable.equis);
					iv33.setEnabled(false);
					matriz[2][2] = "X";
					puesto = true;
				}
				break;
			}
		}
		return compruebaMatriz();
	}
	
	public String compruebaMatriz() {
		String res = "-";
		if(matriz[0][0].equals(matriz[0][1]) && matriz[0][0].equals(matriz[0][2]) && !matriz[0][0].equals("-"))
			res = matriz[0][0];
		else if(matriz[0][0].equals(matriz[1][0]) && matriz[0][0].equals(matriz[2][0]) && !matriz[0][0].equals("-"))
			res = matriz[0][0];
		else if(matriz[0][0].equals(matriz[1][1]) && matriz[0][0].equals(matriz[2][2]) && !matriz[0][0].equals("-"))
			res = matriz[0][0];
		else if(matriz[0][1].equals(matriz[1][1]) && matriz[0][1].equals(matriz[2][1]) && !matriz[0][0].equals("-"))
			res = matriz[0][1];
		else if(matriz[0][2].equals(matriz[1][2]) && matriz[0][2].equals(matriz[2][2]) && !matriz[0][0].equals("-"))
			res = matriz[0][2];
		else if(matriz[1][0].equals(matriz[1][1]) && matriz[1][0].equals(matriz[1][2]) && !matriz[0][0].equals("-"))
			res = matriz[1][0];
		else if(matriz[2][0].equals(matriz[2][1]) && matriz[2][0].equals(matriz[2][2]) && !matriz[0][0].equals("-"))
			res = matriz[2][0];
		else if(matriz[2][0].equals(matriz[1][1]) && matriz[2][0].equals(matriz[0][2]) && !matriz[0][0].equals("-"))
			res = matriz[2][0];
		return res;
	}
	
	public void deshabilitarTodos() {
		iv11.setEnabled(false);
		iv12.setEnabled(false);
		iv13.setEnabled(false);
		iv21.setEnabled(false);
		iv22.setEnabled(false);
		iv23.setEnabled(false);
		iv31.setEnabled(false);
		iv32.setEnabled(false);
		iv33.setEnabled(false);
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void modificaEstadisticas(String s) {
		tvEstadisticas.setText(s);
	}
	
	public String getEstadistica() {
		return String.valueOf(tvEstadisticas.getText());
	}
	
	@Override
	public void onBackPressed() {
		Intent i = new Intent(this, Inicio3RayaActivity.class);
		startActivity(i);
		finish();
		return;
	}
	
	@Override
	protected void onStop() {
	    setResult(2);
	    super.onStop();
	}
	@Override
	protected void onDestroy() {
	    setResult(2);
	    super.onDestroy();
	}

}
