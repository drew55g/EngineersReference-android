package com.example.engineersreference;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class FlashSteamCalculator extends Activity {
	
	private EditText condhigh;
	private EditText steamtotal;
	private EditText condlow;
	private TextView FlashSteamPercent;
	Float percentFLash;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flash_steam_calculator);
		
		condhigh = (EditText) findViewById(R.id.editText2);
		condlow = (EditText) findViewById(R.id.editText1);
		steamtotal = (EditText) findViewById(R.id.editText3);
		FlashSteamPercent = (TextView) findViewById(R.id.textView2);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(condhigh.getWindowToken(), 0);
				imm.hideSoftInputFromWindow(condlow.getWindowToken(), 0);
				imm.hideSoftInputFromWindow(steamtotal.getWindowToken(), 0);

				FlashSteamPercent.setVisibility(View.VISIBLE);

				// Null check
				Editable h = condhigh.getText();
				Editable t = steamtotal.getText();
				Editable l = condlow.getText();
				String CL = "";
				String CH = "";
				String Tot = "";
				
				if (l != null) {CL = l.toString();}
				if (h != null) {CH = h.toString();}
				if (t != null) {Tot = t.toString();}
				
				//Tot.equals("")

				if (CH.equals("") || CL.equals("") ||Tot.equals("") ) 
					   {
					FlashSteamPercent.setText("Enter valid information from steam tables for all inputs");
				} else {
					percentFLash = (((Float.valueOf(CH)-Float.valueOf(CL))*100)/Float.valueOf(Tot));
					String formattedValue = new DecimalFormat("#.#").format(percentFLash);
					FlashSteamPercent.setText(formattedValue + " Percent of condensate volume will flash to steam");
				}
			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_flash_steam_calculator, menu);
		return true;
	}

}
