package com.fusioncube.enraya;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AdminActivity extends Activity {
	
	private EditText etUsuario;
	private Button btnAlta, btnRanking, btnVolver1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		
		etUsuario = (EditText) findViewById(R.id.etUsuario);
		btnAlta = (Button) findViewById(R.id.btnAlta);
		btnRanking = (Button) findViewById(R.id.btnRanking);
		btnVolver1 = (Button) findViewById(R.id.btnVolver1);
		
		controlador(this);
	}
	
	public void controlador(AdminActivity aa) {
		btnAlta.setOnClickListener(new ControladorAdmin(aa));
		btnRanking.setOnClickListener(new ControladorAdmin(aa));
		btnVolver1.setOnClickListener(new ControladorAdmin(aa));
	}
	
	public String getUsuario() {
		return String.valueOf(etUsuario.getText());
	}
	
	public void vaciaUsuario() {
		etUsuario.setText("");
	}

}
