package com.fusioncube.editordetexto_lrm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RawActivity extends Activity {
	
	private EditText editRaw;
	private Button btnAbrirRaw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_raw);
		
		editRaw = (EditText) findViewById(R.id.editRaw);
		btnAbrirRaw = (Button) findViewById(R.id.btnAbrirRaw);
		
		btnAbrirRaw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try{
					InputStream fraw = 
							getResources().openRawResource(R.raw.prueba_raw);
					BufferedReader brin = 
							new BufferedReader(new InputStreamReader(fraw));
					String linea;
					while((linea = brin.readLine()) != null){
						editRaw.setText(editRaw.getText()+"\n"+linea);
					}
					brin.close();
					fraw.close();
				} catch (Exception ex){
					Log.e("Ficheros Raw", "Error al leer el fichero desde recurso raw");
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
