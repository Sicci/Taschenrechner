package com.example.taschenrechner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText display;
	
	private double a = 0,b = 0;
	
	private enum OPERATOR {PLUS, MINUS, MUL, DIV};
	
	private OPERATOR operation = null;
	private OPERATOR lastOperation = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		display = (EditText) findViewById(R.id.display);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onButtonClick1(View view) {
		addToDisplay("1");
	}
	
	public void onButtonClick2(View view) {
		addToDisplay("2");
	}
	
	public void onButtonClick3(View view) {
		addToDisplay("3");
	}
	
	public void onButtonClick4(View view) {
		addToDisplay("4");
	}
	
	public void onButtonClick5(View view) {
		addToDisplay("5");
	}
	
	public void onButtonClick6(View view) {
		addToDisplay("6");
	}
	
	public void onButtonClick7(View view) {
		addToDisplay("7");
	}
	
	public void onButtonClick8(View view) {
		addToDisplay("8");
	}
	
	public void onButtonClick9(View view) {
		addToDisplay("9");
	}
	
	public void onButtonClick0(View view) {
		addToDisplay("0");
	}
	
	public void onButtonClickPlus(View view) {	
		if (lastOperation != null)
			foo();
		operation = OPERATOR.PLUS;
		
	}
	
	public void onButtonClickMinus(View view) {
		if (lastOperation != null)
			foo();
		operation = OPERATOR.MINUS;
	}
	
	public void onButtonClickMul(View view) {
		if (lastOperation != null)
			foo();
		operation = OPERATOR.MUL;
	}
	
	public void onButtonClickDiv(View view) {
		if (lastOperation != null)
			foo();
		operation = OPERATOR.DIV;
	}
	
	public void onButtonClickClear(View view) {
		display.setText("");
		operation = null;
		lastOperation = null;
		a = 0;
		b = 0;
	}
	
	public void onButtonClickResult(View view) {
		foo();
	}
	
	private void addToDisplay(String text) {
		if (operation == null) 
			display.append(text);
		else {
			b = a;
			display.setText(text);
			lastOperation = operation;
			operation = null;
		}
		
		a = Double.valueOf(display.getText().toString());
		
	}
	
	private void foo() {
		if (lastOperation != null) 
			switch(lastOperation) {
				case PLUS: a = MathLogic.sum(a, b); System.out.println("Sum is "+a); break;
				case MINUS: a = MathLogic.sub(b, a); break;
				case MUL: a = MathLogic.mul(a, b); break;
				case DIV: a = MathLogic.div(b, a); break;
			}
		
		display.setText(""+a);
		lastOperation = null;
	}

}
