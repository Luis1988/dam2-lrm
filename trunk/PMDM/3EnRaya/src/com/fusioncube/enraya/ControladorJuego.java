package com.fusioncube.enraya;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class ControladorJuego implements OnClickListener {

	private JuegoActivity ja;
	private static boolean pierde = false;
	private MediaPlayer mpGanar, mpPerder, mpEmpatar;

	public ControladorJuego(JuegoActivity ja) {
		this.ja = ja;
		pierde = false;
		mpGanar = MediaPlayer.create(ja.getApplicationContext(), R.raw.button1);
		mpPerder = MediaPlayer.create(ja.getApplicationContext(), R.raw.button2);
		mpEmpatar = MediaPlayer.create(ja.getApplicationContext(), R.raw.button3);
		if(ja.todasDeshabilitadas())
			ja.habilitaReinicio(true);
	}

	@Override
	public void onClick(View v) {
		String estadistica = ja.getEstadistica();
		if(v.getId() == R.id.btnVolver) {
			Intent i = new Intent(ja.getApplicationContext(), Inicio3RayaActivity.class);
			ja.startActivity(i);
		}
		else if(v.getId() == R.id.btnReinicio) {
			ja.limpiarCasillas();
			if(pierde)
				ja.computadora();
			ja.habilitaReinicio(false);
		}
		else{
			ImageView iv = (ImageView) v;
			AdminSQLite admin=new AdminSQLite(ja.getApplicationContext(), "administracion", null, 1);
	        SQLiteDatabase bd=admin.getWritableDatabase();
	        Cursor fila = bd.rawQuery("select * from jugadores where nombre like '"+ja.getUsuario()+"'", null);
	        int g = 0, e = 0, p = 0;
	        if(fila.moveToFirst()){
	        	g = Integer.parseInt(fila.getString(1));
	        	e = Integer.parseInt(fila.getString(2));
	        	p = Integer.parseInt(fila.getString(3));
	        }
			if(iv.isEnabled()) {
				iv.setImageResource(R.drawable.circulo);
				rellenaMatriz(v.getId());
				iv.setEnabled(false);
				String res = ja.compruebaMatriz();
				if(res.equals("-"))
					res = ja.computadora();
				if(res.equals("O")) {
					Toast.makeText(ja.getApplicationContext(), "Has ganado la partida", Toast.LENGTH_SHORT).show();
					mpGanar.start();
					g++;
					ja.deshabilitarTodos();
					pierde = false;
				}
				else if(res.equals("X")) {
					Toast.makeText(ja.getApplicationContext(), "Has perdido la partida", Toast.LENGTH_SHORT).show();
					mpPerder.start();
					p++;
					ja.deshabilitarTodos();
					pierde = true;
				}
			}
			if(ja.todasDeshabilitadas()) {
				if(ja.compruebaMatriz().equals("-")) {
					Toast.makeText(ja.getApplicationContext(), "Has empatado la partida", Toast.LENGTH_SHORT).show();
					mpEmpatar.start();
					e++;
				}
				ja.habilitaReinicio(true);
			}
			ContentValues registro = new ContentValues();
			registro.put("nombre", ja.getUsuario());
			registro.put("pganadas", String.valueOf(g));
			registro.put("pempatadas", String.valueOf(e));
			registro.put("pperdidas", String.valueOf(p));
			bd.update("jugadores", registro, "nombre like '"+ja.getUsuario()+"'", null);
			estadistica = fila.getString(0)+" - G:"+fila.getString(1)+
					" - E:"+fila.getString(2)+" - P:"+fila.getString(3);
			bd.close();
		}
		ja.modificaEstadisticas(estadistica);
	}

	private void rellenaMatriz(int id) {
		switch(id){
		case R.id.iv11:
			ja.matriz[0][0] = "O";
			break;
		case R.id.iv12:
			ja.matriz[0][1] = "O";
			break;
		case R.id.iv13:
			ja.matriz[0][2] = "O";
			break;
		case R.id.iv21:
			ja.matriz[1][0] = "O";
			break;
		case R.id.iv22:
			ja.matriz[1][1] = "O";
			break;
		case R.id.iv23:
			ja.matriz[1][2] = "O";
			break;
		case R.id.iv31:
			ja.matriz[2][0] = "O";
			break;
		case R.id.iv32:
			ja.matriz[2][1] = "O";
			break;
		case R.id.iv33:
			ja.matriz[2][2] = "O";
			break;
		}
	}

}
