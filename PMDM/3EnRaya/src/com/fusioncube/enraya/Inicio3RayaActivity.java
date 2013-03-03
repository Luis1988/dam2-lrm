package com.fusioncube.enraya;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

public class Inicio3RayaActivity extends Activity {

	private Button btnAcercaDe, btnAdmin, btnSalir, btnInicio;
	static final int DIALOGO_ALERTA = 1;
	static final int DIALOGO_CONFIRMACION = 2;
	static final int DIALOGO_SELECCION = 3;
	static String USUARIO = "";

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

	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialogo = null;

		switch(id) {
		case DIALOGO_ALERTA:
			dialogo = crearDialogoAlerta();
			break;
		case DIALOGO_CONFIRMACION:
			dialogo = crearDialogoConfirmacion();
			break;
		case DIALOGO_SELECCION:
			dialogo = crearDialogoSeleccion();
			break;
		default:
			dialogo = null;
			break;
		}

		return dialogo;
	}

	private Dialog crearDialogoAlerta() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("Acerca De");
		builder.setMessage(Html.fromHtml(getString(R.string.txtAcercaDe)));
		builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});

		return builder.create();
	}

	private Dialog crearDialogoConfirmacion() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("¿Salir?");
		builder.setMessage("¿Desea salir realmente?");
		builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Log.i("Dialogos", "Confirmacion Cancelada.");
				dialog.cancel();
				System.exit(0);
				android.os.Process.killProcess(android.os.Process.myPid());
			}
		});
		builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Log.i("Dialogos", "Confirmacion Cancelada.");
				dialog.cancel();
			}
		});

		return builder.create();
	}

	private Dialog crearDialogoSeleccion() {
		AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
		SQLiteDatabase bd = admin.getWritableDatabase();
		Cursor fila = bd.rawQuery("select * from jugadores", null);
		ArrayList<String> datos = new ArrayList<String>();
		if(fila.moveToFirst())
			do {
				datos.add(fila.getString(0));
			} while(fila.moveToNext());
		final String[] items = new String[datos.size()];
		for (int i = 0; i < datos.size(); i++) {
			items[i] = datos.get(i);
		}

		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("Selección usuario");
		builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				Log.i("Dialogos", "Opción elegida: " + items[item]);
				USUARIO = items[item];
				Intent i = new Intent(getApplicationContext(), JuegoActivity.class);
				i.putExtra("usuario", USUARIO);
				startActivity(i);
				dialog.cancel();
			}
		});

		return builder.create();
	}

	@Override
	public void onBackPressed() {
		showDialog(DIALOGO_CONFIRMACION);
		return;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if(resultCode==2){
	        finish();
	    }
	}

}
