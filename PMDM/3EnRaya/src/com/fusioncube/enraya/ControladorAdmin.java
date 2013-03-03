package com.fusioncube.enraya;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ControladorAdmin implements OnClickListener {
	
	private AdminActivity aa;
	
	public ControladorAdmin(AdminActivity aa) {
		this.aa = aa;
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.btnAlta) {
			if(!aa.getUsuario().equals("")) {
				alta(aa.getUsuario());
			}
		}
		if(v.getId() == R.id.btnRanking) {
			Intent i = new Intent(aa.getApplicationContext(), RankingActivity.class);
			aa.startActivity(i);
		}
		if(v.getId() == R.id.btnVolver1) {
			Intent i = new Intent(aa.getApplicationContext(), Inicio3RayaActivity.class);
			aa.startActivity(i);
		}
	}
	
	public void alta(String usuario) {
		AdminSQLite admin = new AdminSQLite(aa.getApplicationContext(), "administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		ContentValues registro = new ContentValues();
		registro.put("nombre", usuario);
		registro.put("pganadas", "0");
		registro.put("pempatadas", "0");
		registro.put("pperdidas", "0");
		bd.insert("jugadores", null, registro);
		bd.close();
		aa.vaciaUsuario();
		Toast.makeText(aa.getApplicationContext(), "Alta realizada correctamente", Toast.LENGTH_SHORT).show();
	}

}
