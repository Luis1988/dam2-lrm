package com.fusioncube.enraya;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class RankingActivity extends Activity {

	private ListView lvRanking;
	private Button btnVolver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking);

		lvRanking = (ListView) findViewById(R.id.lvRanking);
		btnVolver = (Button) findViewById(R.id.btnVolver2);

		ArrayList<String> datos = new ArrayList<String>();
		rellenaLista(datos);
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
		lvRanking.setAdapter(adaptador);
		
		btnVolver.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), AdminActivity.class);
				startActivity(i);
			}
		});
	}

	public void rellenaLista(ArrayList<String> datos) {
		AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		Cursor fila = bd.rawQuery("select nombre, pganadas, pempatadas, pperdidas from jugadores", null);
		if(fila.moveToFirst())
			do {
				datos.add(fila.getString(0)+" - G:"+fila.getString(1)+" - E:"+
						fila.getString(2)+" - P:"+fila.getString(3));
			} while(fila.moveToNext());
		bd.close();
	}
	
	@Override
	public void onBackPressed() {
		Intent i = new Intent(this, AdminActivity.class);
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
