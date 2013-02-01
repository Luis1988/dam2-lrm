package calc.cienf;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
public class Calculator extends Activity {
    /** Called when the activity is first created. */
   
    Button btn01, btn02, btn03, btn04, btn05, btnLog, btnPowXY;
    Button btn06, btn07, btn08, btn09, btn00, btnTan, btnLn;
    Button btnSumar, btnBorrar, btnIgual, btnSin, btnCos;
    Button btnRestar, btnDividir, btnCambiaSigno, btnHyp;
    Button btnMultiplicar, btnDecimal, btnEXP, btnMPlus;
    Button btnBorrado, btnShift, btnDRG, btnFSE, btnMR, btnMS;
    Button btnSqrt, btnPowX2, btnPercentage, btnAbre;
    Button btnCierra;
    Vibrator vibrator;
    TextView txtFuncion, txtMemoria, txtError, txtHyp, txtShift;
    TextView txtDEG, txtRAD, txtGRAD;
    int op, decimal, seop; 	// nada = 0, suma = 1, resta = 2, multiplicacion = 3
    int op2, op3;			// division = 4, pow(x,y) = 5
    int longitudTexto;		// decimal comprueba si el dato en la calculadora tiene decimal (1) o no (0)
    int SHIFT;				// noseopera = 0, seopera = 1;
    int EXP, M, E, hyp, DRG;// no hay 10^n = 0, si hay = 1;
    String cambio;			// cambio sirve para poder almacenar el valor anterior en la calculadora
    String vValor01, vValor02;
    double memoria;
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       
       
        btn00 = (Button) findViewById(R.id.btn00);
        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        btn03 = (Button) findViewById(R.id.btn03);
        btn04 = (Button) findViewById(R.id.btn04);
        btn05 = (Button) findViewById(R.id.btn05);
        btn06 = (Button) findViewById(R.id.btn06);
        btn07 = (Button) findViewById(R.id.btn07);
        btn08 = (Button) findViewById(R.id.btn08);
        btn09 = (Button) findViewById(R.id.btn09);
        btnSumar = (Button) findViewById(R.id.btnSumar);
        btnRestar = (Button) findViewById(R.id.btnRestar);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        btnBorrado = (Button) findViewById(R.id.btnBorrado);
        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnDividir = (Button) findViewById(R.id.btnDivision);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnDecimal = (Button) findViewById(R.id.btnDecimal);
        btnCambiaSigno = (Button) findViewById(R.id.btnCambiaSigno);
        btnEXP = (Button) findViewById(R.id.btnEXP);
        btnShift = (Button) findViewById(R.id.btnShift);
        btnDRG = (Button) findViewById(R.id.btnDRG);
        btnFSE = (Button) findViewById(R.id.btnFSE);
        btnMR = (Button) findViewById(R.id.btnMR);
        btnMS = (Button) findViewById(R.id.btnMS);
        btnMPlus = (Button) findViewById(R.id.btnMPlus);
        btnHyp = (Button) findViewById(R.id.btnHyp);
        btnSin = (Button) findViewById(R.id.btnSin);
        btnCos = (Button) findViewById(R.id.btnCos);
        btnTan = (Button) findViewById(R.id.btnTan);
        btnLn = (Button) findViewById(R.id.btnLn);
        btnLog = (Button) findViewById(R.id.btnLog);
        btnPowXY = (Button) findViewById(R.id.btnPowXY);
        btnSqrt = (Button) findViewById(R.id.btnSqrt);
        btnPowX2 = (Button) findViewById(R.id.btnPowX2);
        btnPercentage = (Button) findViewById(R.id.btnPercentage);
        btnAbre = (Button) findViewById(R.id.btnAbre);
        btnCierra = (Button) findViewById(R.id.btnCierra);
        txtMemoria = (TextView) findViewById(R.id.txtMemoria);
        txtError = (TextView) findViewById(R.id.txtError);
        txtFuncion = (TextView) findViewById(R.id.txtFuncion);
        txtHyp = (TextView) findViewById(R.id.txtHyp);
        txtShift = (TextView) findViewById(R.id.txtShift);
        txtDEG = (TextView) findViewById(R.id.txtDEG);
        txtRAD = (TextView) findViewById(R.id.txtRAD);
        txtGRAD = (TextView) findViewById(R.id.txtGRAD);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        
        txtFuncion.setText("0");
        txtDEG.setText("DEG");
          
        memoria = 0;
        op = 0;
        seop = 0;
        cambio="1";
        DRG = 0;
        EXP = 0;
        op2 = 0;
        op3 = 0;
        M = 0;
        E = 0;
        hyp = 0;
        longitudTexto = 0;
        SHIFT = 0;
        
       
        btn01.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
         if(E==0){
        	 hyp = 0;
        	 txtHyp.setText("");
        	 SHIFT = 0;
        	 txtShift.setText("");
        	 fBotonPulsado("1");
         }
         }//fin onClick 01
         });//fin onClickListener 01
        btn02.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
         if(E==0){
        	 hyp = 0;
        	 txtHyp.setText("");
        	 SHIFT = 0;
        	 txtShift.setText("");
        	 fBotonPulsado("2");
         }
         }//fin onClick 02
         });//fin onClickListener 02
        btn03.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
         if(E==0){
        	 hyp = 0;
        	 txtHyp.setText("");
        	 SHIFT = 0;
        	 txtShift.setText("");
        	 fBotonPulsado("3");
         }
         }//fin onClick 03
         });//fin onClickListener 03
        btn04.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
         if(E==0){
        	 hyp = 0;
    	 	 txtHyp.setText("");
    	 	 SHIFT = 0;
    	 	 txtShift.setText("");
        	 fBotonPulsado("4");
         }
         }//fin onClick 04
         });//fin onClickListener 04
        btn05.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
         if(E==0){
        	 hyp = 0;
        	 txtHyp.setText("");
        	 SHIFT = 0;
        	 txtShift.setText("");
        	 fBotonPulsado("5");
         }
         }//fin onClick 05
         });//fin onClickListener 05
        btn06.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
         if(E==0){
        	 hyp = 0;
        	 txtHyp.setText("");
        	 SHIFT = 0;
        	 txtShift.setText("");
        	 fBotonPulsado("6");
         }
         }//fin onClick 06
         });//fin onClickListener 06
        btn07.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
       	 if(E==0){ 
        	 hyp = 0;
        	 txtHyp.setText("");
        	 SHIFT = 0;
        	 txtShift.setText("");
       		 fBotonPulsado("7");
       	 }
         }//fin onClick 07
         });//fin onClickListener 07
        btn08.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
         if(E==0){
        	 hyp = 0;
        	 txtHyp.setText("");
        	 SHIFT = 0;
        	 txtShift.setText("");
        	 fBotonPulsado("8");
         }
         }//fin onClick 08
         });//fin onClickListener 08
        btn09.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
       	 if(E==0){
        	 hyp = 0;
        	 txtHyp.setText("");
        	 SHIFT = 0;
        	 txtShift.setText("");
       		 fBotonPulsado("9");
       	 }
         }//fin onClick 09
         });//fin onClickListener 09
        btn00.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
       	 if(E==0){
        	 hyp = 0;
        	 txtHyp.setText("");
        	 SHIFT = 0;
        	 txtShift.setText("");
       		 fBotonPulsado("0");
       	 }
         }//fin onClick 00
         });//fin onClickListener 00
        btnDecimal.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            	if(E==0){
            	if(decimal==0){
            		if(SHIFT == 0){
            		fBotonPulsado(".");
            		decimal=1;
            		}
            		if(SHIFT == 1){
                		op2 = 23;
                		fActualizar();
                	}
            	}}
            	}//fin onClick 00
            });//fin onClickListener 00
        btnBorrar.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
    	 if(E==1){
        	 E=0;
    		 txtError.setText("");
    	 }
    	 hyp = 0;
    	 txtHyp.setText("");
    	 SHIFT = 0;
    	 txtShift.setText("");
         fBorrar();
         }//fin onClick btnBorrar
         });//fin onClickListener btnBorrar
        btnBorrado.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
           	 hyp = 0;
        	 txtHyp.setText("");
        	 SHIFT = 0;
        	 txtShift.setText("");
             fBorrado();
            }
            }//fin onClick btnBorrado
            });//fin onClickListener btnBorrado
        btnCambiaSigno.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
           	if(E==0){
           	 hyp = 0;
        	 txtHyp.setText("");
        	 SHIFT = 0;
        	 txtShift.setText("");
           	 fCambiarSigno();
           	}
            }//fin onClick btnCambiaSigno
            });//fin onClickListener btnCambiaSigno
        btnSqrt.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
           	if(E==0){
           		hyp = 0;
           		txtHyp.setText("");
           		if(SHIFT == 0)
           			op2 = 2;
           		if(SHIFT == 1){
           			op2 = 18;
           		}
            	fActualizar();
           	}
            }//fin onClick btnSqrt
            });//fin onClickListener btnSqrt
        btnPowX2.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
           	 	hyp = 0;
           	 	txtHyp.setText("");
           	 	if(SHIFT == 0)
           	 		op2 = 3;
           	 	if(SHIFT == 1){
           	 		op2 = 19;
           	 	}
            	fActualizar();
            }
            }//fin onClick btnPowX2
            });//fin onClickListener btnPowX2
        btnPercentage.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
           	if(E==0){
           	 	hyp = 0;
           	 	txtHyp.setText("");
           	 	if(SHIFT == 0)
           	 		op2 = 1;
           	 	if(SHIFT == 1){
           	 		op2 = 20;
           	 	}
            	fActualizar();
           	}
            }//fin onClick btnPercentage
            });//fin onClickListener btnPercentage
        btnSin.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
           	if(E==0){
           		if(hyp == 0 && SHIFT == 0)
           			op2 = 4;
           		if(hyp == 1 && SHIFT == 0)
           			op2 = 9;
           		if(hyp == 0 && SHIFT == 1)
           			op2 = 12;
           		if(hyp == 1 && SHIFT == 1)
           			op2 = 15;
            	fActualizar();
           	}
            }//fin onClick btnSin
            });//fin onClickListener btnSin
        btnCos.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
           	if(E==0){
            	if(hyp == 0 && SHIFT == 0)
            		op2 = 5;
            	if(hyp == 1 && SHIFT == 0)
            		op2 = 10;
            	if(hyp == 0 && SHIFT == 1)
            		op2 = 13;
            	if(hyp == 1 && SHIFT == 1)
            		op2 = 16;
            	fActualizar();
           	}
            }//fin onClick btnCos
            });//fin onClickListener btnCos
        btnTan.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
           	if(E==0){
           		if(hyp == 0){
           			if(SHIFT == 0)
           				op2 = 6;
           			if(SHIFT == 1)
               			op2 = 14;
           		}
           		if(hyp == 1){
           			if(SHIFT == 0)
           				op2 = 11;
           			if(SHIFT == 1)
               			op2 = 17;
           		}
           		fActualizar();
           	}
            }//fin onClick btnTan
            });//fin onClickListener btnTan
        btnLn.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
           	 	hyp = 0;
           	 	txtHyp.setText("");
            	if(SHIFT == 0)
            		op2 = 7;
            	if(SHIFT == 1){
            		op2 = 21;
            	}
            	fActualizar();
            }
            }//fin onClick btnLn
            });//fin onClickListener btnLn
        btnLog.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
           	 	hyp = 0;
           	 	txtHyp.setText("");
            	if(SHIFT == 0)
            		op2 = 8;
            	if(SHIFT == 1){
            		op2 = 22;
            	}
            	fActualizar();
            }
            }//fin onClick btnLog
            });//fin onClickListener btnLog
        btnSumar.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
         if(E==0){
    	 	 hyp = 0;
       	 	 txtHyp.setText("");
       	 	 SHIFT = 0;
       	 	 txtShift.setText("");
        	 fCambiar();
        	 op=1;
         }
         }//fin onClick btnSumar
         });//fin onClickListener btnSumar
        btnRestar.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
       	 	 	hyp = 0;
       	 	 	txtHyp.setText("");
       	 	 	SHIFT = 0;
       	 	 	txtShift.setText("");
            	fCambiar();
            	op=2;
            }
            }//fin onClick btnRestar
            });//fin onClickListener btnRestar
        btnMultiplicar.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
       	 	 	hyp = 0;
       	 	 	txtHyp.setText("");
       	 	 	SHIFT = 0;
       	 		txtShift.setText("");
            	fCambiar();
            	op=3;
            }
            }//fin onClick btnMultiplicar
            });//fin onClickListener btnMultiplicar
        btnDividir.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
       	 	 	hyp = 0;
       	 	 	txtHyp.setText("");
       	 	 	SHIFT = 0;
       	 		txtShift.setText("");
            	fCambiar();
            	op=4;
            }
            }//fin onClick btnDividir
            });//fin onClickListener btnDividir
        btnPowXY.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
       	 	 	hyp = 0;
       	 	 	txtHyp.setText("");
            	if(SHIFT == 0){
            		fCambiar();
            		op = 5;
            	}
            	if(SHIFT == 1){
            		fCambiar();
            		op = 6;
            		SHIFT = 0;
              	  	txtShift.setText("");
            	}
            }
            }//fin onClick btnPowXY
            });//fin onClickListener btnPowXY
        btnEXP.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
       	 	 	hyp = 0;
       	 	 	txtHyp.setText("");
       	 	 	if(SHIFT==0){
            	decimal = 1;
            	if(EXP == 0){
                	longitudTexto = ((String) txtFuncion.getText()).length()+3;
                }
            	fBotonPulsado("E");
       	 	 	}
       	 	 	if(SHIFT==1){
       	 	 		SHIFT = 0;
       	 	 		txtShift.setText("");
       	 	 		op2 = 24;
       	 	 		fActualizar();
       	 	 	}
             }
            }//fin onClick btnEXP
            });//fin onClickListener btnEXP
        btnIgual.setOnClickListener(new OnClickListener(){
         public void onClick(View v) {
        	 vibrator.vibrate(250);
         if(E==0){
    	 	 hyp = 0;
       	 	 txtHyp.setText("");
       	 	 SHIFT = 0;
       	 	 txtShift.setText("");
        	 fIgual();
         }
         }//fin onClick btnIgual
         });//fin onClickListener btnIgual
        btnMS.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
       	 	 	hyp = 0;
       	 	 	txtHyp.setText("");
       	 	 	SHIFT = 0;
       	 	 	txtShift.setText("");
            	op3 = 1;
            	fMemoria();
            }
            }//fin onClick btnMS
            });//fin onClickListener btnMS
        btnMR.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
       	 	 	hyp = 0;
       	 	 	txtHyp.setText("");
       	 	 	SHIFT = 0;
       	 	 	txtShift.setText("");
            	op3 = 2;
            	fMemoria();
            }
            }//fin onClick btnMR
            });//fin onClickListener btnMR
        btnMPlus.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
       	 	 	hyp = 0;
       	 	 	txtHyp.setText("");
       	 	 	SHIFT = 0;
       	 		txtShift.setText("");
            	op3 = 3;
            	fMemoria();
            }
            }//fin onClick btnMPlus
            });//fin onClickListener btnMPlus
        btnHyp.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
            	if(hyp == 0){
            		hyp = 1;
            		txtHyp.setText("HYP");
            	}
            	else{
           	 	 	hyp = 0;
           	 	 	txtHyp.setText("");
            	}
            }
            }//fin onClick btnHyp
            });//fin onClickListener btnHyp
        btnShift.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
            	if(SHIFT == 0){
            		SHIFT = 1;
            		txtShift.setText("SHIFT");
            	}
            	else{
           	 	 	SHIFT = 0;
           	 	 	txtShift.setText("");
            	}
            }
            }//fin onClick btnShift
            });//fin onClickListener btnShift
        btnDRG.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	vibrator.vibrate(250);
            if(E==0){
            	hyp = 0;
            	txtHyp.setText("");
            	fDRG();
            }
            }//fin onClick btnDRG
            });//fin onClickListener btnDRG
        }//fin onCreate
 		
       
    private void fBotonPulsado(String vNumero){
     if(seop==1){
    	 txtFuncion.setText("0");
    	 seop=0;
     }
     if(txtFuncion.getText()==cambio){
    	 txtFuncion.setText("0");
    	 cambio="1";
     }
     if(txtFuncion.getText()=="0")
    	 txtFuncion.setText("");
     if(vNumero=="E"){
    	 EXP = 1;
     }
     String vTexto = (String) txtFuncion.getText();
     if(vTexto.length()<19){
    	 if(vTexto.contains("E") && vTexto.length()<longitudTexto){
    		 vTexto += vNumero;
        	 txtFuncion.setText(vTexto);
    	 }
    	 if(!vTexto.contains("E")){
    	 vTexto += vNumero;
    	 txtFuncion.setText(vTexto);
    	 }
     }
    }//fin fBotonPulsado
    private void fCambiar(){
    	seop=0;
    	vValor01 = (String) txtFuncion.getText();
        cambio = (String) txtFuncion.getText();
        decimal=0;
        EXP=0;
        longitudTexto = 0;
    }//fin fCambiar
    private void fCambiarSigno(){
    	if(EXP==1){
    		txtFuncion.setText(((String) txtFuncion.getText()).replace("E","E-"));
    		if(txtFuncion.getText().toString().contains("--"))
    				txtFuncion.setText(((String) txtFuncion.getText()).replace("E--","E"));
    	}
    	else{
	    	String resultado = (String) txtFuncion.getText();
	    	double res = 0;
			res = Double.parseDouble(resultado);
			res = 0 - res;
			resultado = Double.toString(res);
			if(resultado.endsWith(".0"))
		    	  txtFuncion.setText(Integer.toString((int) res));
		    else
		    	  txtFuncion.setText(Double.toString(res));
    	}
		
    }//fin fCambiarSigno
    private void fActualizar(){
    	double vNumero = 0.0;
    	String resultado = (String) txtFuncion.getText();
    	if(op2==1){	// Operación de porcentaje
    		vNumero = Double.parseDouble(resultado)/100;
    	}
    	if(op2==2){ // Operación de raíz cuadrada
    		vNumero = Math.sqrt(Double.parseDouble(resultado));
    	}
    	if(op2==3){	// Operación de potencia al cuadrado
    		vNumero = Math.pow(Double.parseDouble(resultado),2);
    	}
    	if(op2==4){ // Operación del seno de x
    		if(DRG == 0)
    			vNumero = Math.sin(Math.toRadians(Double.parseDouble(resultado)));
    		if(DRG == 1)
    			vNumero = Math.sin(Double.parseDouble(resultado));
    		if(DRG == 2){
    			vNumero = Double.parseDouble(resultado)*360/400;
    			vNumero = Math.sin(Math.toRadians(vNumero));
    		}
    	}
    	if(op2==5){ // Operación del coseno de x
    		if(DRG == 0)
    			vNumero = Math.cos(Math.toRadians(Double.parseDouble(resultado)));
    		if(DRG == 1)
    			vNumero = Math.cos(Double.parseDouble(resultado));
    		if(DRG == 2){
    			vNumero = Double.parseDouble(resultado)*360/400;
    			vNumero = Math.cos(Math.toRadians(vNumero));
    		}
    	}
    	if(op2==6){ // Operación del tangente de x
    		if(DRG == 0)
    			vNumero = Math.tan(Math.toRadians(Double.parseDouble(resultado)));
    		if(DRG == 1)
    			vNumero = Math.tan(Double.parseDouble(resultado));
    		if(DRG == 2){
    			vNumero = Double.parseDouble(resultado)*360/400;
    			vNumero = Math.tan(Math.toRadians(vNumero));
    		}
    	}
    	if(op2==7){ // Operación del logaritmo neperiano
    		vNumero = Math.log(Double.parseDouble(resultado));
    	}
    	if(op2==8){ // Operación del logaritmo en base 10
    		vNumero = Math.log10(Double.parseDouble(resultado));
    	}
    	if(op2==9){ // Operación del seno hiperbólico
   	 	 	hyp = 0;
   	 	 	txtHyp.setText("");
   	 	 	if(DRG == 0)
   	 	 		vNumero = Math.sinh(Math.toRadians(Double.parseDouble(resultado)));
			if(DRG == 1)
				vNumero = Math.sinh(Double.parseDouble(resultado));
			if(DRG == 2){
				vNumero = Double.parseDouble(resultado)*360/400;
				vNumero = Math.sinh(Math.toRadians(vNumero));
			}
    	}
    	if(op2==10){ // Operación del coseno hiperbólico
   	 	 	hyp = 0;
   	 	 	txtHyp.setText("");
	   	 	if(DRG == 0)
		 	 	vNumero = Math.cosh(Math.toRadians(Double.parseDouble(resultado)));
			if(DRG == 1)
				vNumero = Math.cosh(Double.parseDouble(resultado));
			if(DRG == 2){
				vNumero = Double.parseDouble(resultado)*360/400;
				vNumero = Math.cosh(Math.toRadians(vNumero));
			}
    	}
    	if(op2==11){ // Operación de la tangente hiperbólica
   	 	 	hyp = 0;
   	 	 	txtHyp.setText("");
	   	 	if(DRG == 0)
		 	 	vNumero = Math.tanh(Math.toRadians(Double.parseDouble(resultado)));
			if(DRG == 1)
				vNumero = Math.tanh(Double.parseDouble(resultado));
			if(DRG == 2){
				vNumero = Double.parseDouble(resultado)*360/400;
				vNumero = Math.tanh(Math.toRadians(vNumero));
			}
    	}
    	if(op2==12){ // Operación arco del seno
    		SHIFT = 0;
    		txtShift.setText("");
    		if(DRG == 0)
		 	 	vNumero = Math.asin(Math.toRadians(Double.parseDouble(resultado)));
			if(DRG == 1)
				vNumero = Math.asin(Double.parseDouble(resultado));
			if(DRG == 2){
				vNumero = Double.parseDouble(resultado)*360/400;
				vNumero = Math.asin(Math.toRadians(vNumero));
			}
    	}
    	if(op2==13){ // Operación arco del coseno
    		SHIFT = 0;
    		txtShift.setText("");
    		if(DRG == 0)
		 	 	vNumero = Math.acos(Math.toRadians(Double.parseDouble(resultado)));
			if(DRG == 1)
				vNumero = Math.acos(Double.parseDouble(resultado));
			if(DRG == 2){
				vNumero = Double.parseDouble(resultado)*360/400;
				vNumero = Math.acos(Math.toRadians(vNumero));
			}
    	}
    	if(op2==14){ // Operación arco de la tangente
    		SHIFT = 0;
    		txtShift.setText("");
    		if(DRG == 0)
		 	 	vNumero = Math.atan(Math.toRadians(Double.parseDouble(resultado)));
			if(DRG == 1)
				vNumero = Math.atan(Double.parseDouble(resultado));
			if(DRG == 2){
				vNumero = Double.parseDouble(resultado)*360/400;
				vNumero = Math.atan(Math.toRadians(vNumero));
			}
    	}
    	if(op2==15){ // Operación arco del seno hiperbólico
    		hyp = 0;
    		txtHyp.setText("");
    		SHIFT = 0;
    		txtShift.setText("");
    		vNumero = Math.log(Double.parseDouble(resultado) + Math.sqrt(Double.parseDouble(resultado)*Double.parseDouble(resultado)+1));
    	}
    	if(op2==16){ // Operación arco del coseno hiperbólico 
    		hyp = 0;
    		txtHyp.setText("");
    		SHIFT = 0;
    		txtShift.setText("");
    		vNumero = Math.log(Double.parseDouble(resultado) + Math.sqrt(Double.parseDouble(resultado)*Double.parseDouble(resultado)-1));
    	}
    	if(op2==17){ // Operación arco de la tangente hiperbólica 
    		hyp = 0;
    		txtHyp.setText("");
    		SHIFT = 0;
    		txtShift.setText("");
    		vNumero = Math.log((1/Double.parseDouble(resultado)+1)/(1/Double.parseDouble(resultado)-1))/2;
    	}
    	if(op2==18){ // Operación de la raíz cúbica
    		SHIFT = 0;
    		txtShift.setText("");
    		vNumero = Math.cbrt(Double.parseDouble(resultado));
    	}
    	if(op2==19){ // Operación de la potencia cúbica
    		SHIFT = 0;
    		txtShift.setText("");
    		vNumero = Double.parseDouble(resultado)*Double.parseDouble(resultado)*Double.parseDouble(resultado);
    	}
    	if(op2==20){ // Operación inversión
    		SHIFT = 0;
    		txtShift.setText("");
    		vNumero = 1/Double.parseDouble(resultado);
    	}
    	if(op2==21){ // Operación número e^x
    		SHIFT = 0;
    		txtShift.setText("");
    		vNumero = Math.pow(Math.E, Double.parseDouble(resultado));
    	}
    	if(op2==22){ // Operación 10^x
    		SHIFT = 0;
    		txtShift.setText("");
    		vNumero = Math.pow(10, Double.parseDouble(resultado));
    	}
    	if(op2==23){ // Operación Randomize
    		SHIFT = 0;
    		txtShift.setText("");
    		vNumero = Math.random();
    		// TODO Acortar el random
    	}
    	if(op2==24){ // Operación PI
    		SHIFT = 0;
    		txtShift.setText("");
    		vNumero = Math.PI;
    	}
    	resultado = Double.toString(vNumero);
    	if(vNumero>0.99999999999999E99 || vNumero<-0.99999999999999E99 || 
    			Double.isInfinite(vNumero) || Double.isNaN(vNumero)){
    		E = 1;
    		txtError.setText("ERROR");
    		vNumero = 0.0;
    	}
    	if(resultado.endsWith(".0"))
    		txtFuncion.setText(Integer.toString((int) vNumero));
    	else
    		txtFuncion.setText(Double.toString(vNumero));
    	seop=1;
    	op2=0;
      }
      private void fIgual(){
      double vNumero = 0;
      String resultado;
      vValor02 = (String) txtFuncion.getText();
      if(op==0){
    	  vNumero = Double.parseDouble((String) txtFuncion.getText());
      }
      if(op==1){
    	  vNumero = Double.parseDouble(vValor01)+Double.parseDouble(vValor02);
      }
      if(op==2){
    	  vNumero = Double.parseDouble(vValor01)-Double.parseDouble(vValor02);
      }
      if(op==3){
    	  vNumero = Double.parseDouble(vValor01)*Double.parseDouble(vValor02);
      }
      if(op==4){
    	  vNumero = Double.parseDouble(vValor01)/Double.parseDouble(vValor02);
      }
      if(op==5){
    	  vNumero = Math.pow(Double.parseDouble(vValor01), Double.parseDouble(vValor02));
      }
      if(op==6){
    	  vNumero = Math.pow(Double.parseDouble(vValor01), 1/Double.parseDouble(vValor02));
      }
      resultado=Double.toString(vNumero);
      if(vNumero>0.99999999999999E99 || vNumero<-0.99999999999999E99 || 
  			Double.isInfinite(vNumero) || Double.isNaN(vNumero)){
  		E = 1;
  		txtError.setText("ERROR");
  		vNumero = 0.0;
  	}
      if(resultado.endsWith(".0"))
    	  txtFuncion.setText(Integer.toString((int) vNumero));
      else
    	  txtFuncion.setText(Double.toString(vNumero));
      seop=1;
    }//fin fIgual
    private void fBorrar(){
     txtFuncion.setText("0");
     vValor01="0";
     decimal=0;
     op = 0;
     seop = 0;
     cambio="1";
     EXP = 0;
     op2 = 0;
     longitudTexto = 0;
    }//fin fBorrar
    private void fBorrado(){
        txtFuncion.setText("0");
        decimal=0;
        op = 0;
        seop = 0;
        cambio="1";
        EXP = 0;
        op2 = 0;
        longitudTexto = 0;
    }//fin fBorrado
    private void fDRG(){
    	DRG++;
    	if(DRG == 1){ // TODO 0
    		if(SHIFT==1){ 
    			SHIFT = 0;
    			txtShift.setText("");
    			String res1 = (String) txtFuncion.getText();
    			Double res2 = Math.toRadians(Double.parseDouble(res1));
    			txtFuncion.setText(res2.toString());
    		}
    		txtDEG.setText("");
    		txtRAD.setText("RAD");
    	}
    	if(DRG == 2){ // TODO 1
    		if(SHIFT==1){
    			SHIFT = 0;
    			txtShift.setText("");
    			String res1 = (String) txtFuncion.getText();
    			Double res2 = Math.toDegrees(Double.parseDouble(res1)*400/360);
    			txtFuncion.setText(res2.toString());
    		}
    		txtRAD.setText("");
    		txtGRAD.setText("GRAD");
    	}
    	if(DRG == 3){
    		DRG = -1;
    		fDRG();
    	}
    	if(DRG == 0){ // TODO 2
    		if(SHIFT==1){
    			SHIFT = 0;
    			txtShift.setText("");
    			String res1 = (String) txtFuncion.getText();
    			Double res2 = Double.parseDouble(res1)*360/400;
    			txtFuncion.setText(res2.toString());
    		}
    		txtGRAD.setText("");
    		txtDEG.setText("DEG");
    	}
    }
    private void fMemoria(){
    	String resultado;
    	if(op3==1){ // MS: Memory Store guarda cualquier valor
    		memoria = Double.parseDouble((String) txtFuncion.getText());
    		if (memoria!=0){
    			M = 1;
    			txtMemoria.setText("M");
    		}
    		else{
    			M = 0;
    			txtMemoria.setText("");
    		}
    		seop = 1;
    	}
    	if(op3==2){ // MR: Memory Recall llama a la memoria
    		if(M==1){
    			resultado = Double.toString(memoria);
    			if(resultado.endsWith(".0"))
    		    	  txtFuncion.setText(Integer.toString((int) memoria));
    		    else
    		    	  txtFuncion.setText(Double.toString(memoria));
    		}
    		if(M==0)
    			txtFuncion.setText("0");
    		seop = 1;
    	}
    	if(op3==3){ // M+: Memory Add almacena el resultado de la suma del valor de la pantalla con la de la memoria
    		if(op==0)
    			memoria += Double.parseDouble((String)txtFuncion.getText());
    		if(op==1)
    			memoria = Double.parseDouble((String)txtFuncion.getText())*2;
    		if(op==2)
    			memoria = 0;
    		if(op==3)
    			memoria = Math.pow(Double.parseDouble((String)txtFuncion.getText()),2);
    		if(op==4)
    			memoria = Double.parseDouble((String)txtFuncion.getText())/Double.parseDouble((String)txtFuncion.getText());
    		if(op==5)
    			memoria = Math.pow(Double.parseDouble((String)txtFuncion.getText()), Double.parseDouble((String)txtFuncion.getText()));
    		if(memoria!=0){
    			M=1;
    			txtMemoria.setText("M");
    		}
    		else{
    			M=0;
    			txtMemoria.setText("");
    		}
    		resultado = Double.toString(memoria);
    		if(resultado=="Infinity" || resultado=="-Infinity" || resultado=="NaN"){
    	  		E = 1;
    	  		txtError.setText("ERROR");
    	  	}
			if(resultado.endsWith(".0"))
		    	  txtFuncion.setText(Integer.toString((int) memoria));
		    else
		    	  txtFuncion.setText(Double.toString(memoria));
    		seop = 1;
    	}
    }
}// fin Clase Calculator