package com.fusioncube.enraya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AcercaDeActivity extends Activity {
	
	private TextView tvAutor;
	private Button btnVolver;
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acercade);
		
		tvAutor = (TextView) findViewById(R.id.tvAutor);
		btnVolver = (Button) findViewById(R.id.btnSalir);
		
		tvAutor.setText(Html.fromHtml(getString(R.string.txtAcercaDe)));
		btnVolver.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), Inicio3RayaActivity.class);
				startActivity(i);
			}
		});
	}

}
