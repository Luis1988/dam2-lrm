package com.fusioncube.editordetexto_lrm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InternaActivity extends Activity {
	
	private Button btnGuardar, btnCargar;
	private EditText editEditor, editFichero;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_interna);

		btnGuardar = (Button) findViewById(R.id.btnGuardar);
		btnCargar = (Button) findViewById(R.id.btnCargar);
		editEditor = (EditText) findViewById(R.id.editEditor);
		editFichero = (EditText) findViewById(R.id.editFichero);

		btnGuardar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String FILENAME = editFichero.getText().toString();
				String editor = editEditor.getText().toString();
				try {
					OutputStreamWriter fout = 
							new OutputStreamWriter(
									openFileOutput(FILENAME, Context.MODE_PRIVATE));
					fout.write(editor);
					fout.close();
				} catch (FileNotFoundException e) {
					Log.e("Ficheros Internos", "Error al encontrar el fichero");
				} catch (IOException e){
					Log.e("Ficheros Internos", "Error al guardar el fichero");
				}
			}
		});

		btnCargar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					String FILENAME = editFichero.getText().toString();
					BufferedReader fin = new BufferedReader(
							new InputStreamReader(
									openFileInput(FILENAME)));
					editEditor.setText("");
					String texto;
					while((texto = fin.readLine())!= null){
						editEditor.setText(editEditor.getText()+"\n"+texto);
					}
					fin.close();
				} catch (FileNotFoundException e) {
					Log.e("Ficheros Internos", "Error al encontrar el fichero");
				} catch (IOException e){
					Log.e("Ficheros Internos", "Error al cargar el fichero");
				}				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
