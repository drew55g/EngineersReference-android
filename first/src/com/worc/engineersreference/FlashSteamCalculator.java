package com.worc.engineersreference;

import java.text.DecimalFormat;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class FlashSteamCalculator extends Activity {

	private EditText condhigh;
	private EditText steamtotal;
	private EditText condlow;
	private TextView FlashSteamPercent;
	Float percentFLash;
	protected AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flash_steam_calculator);

		// Create the adView
		AdView adView = new AdView(this, AdSize.BANNER, "a15160818fd6a92");
		// Lookup your LinearLayout assuming it’s been given
		// the attribute android:id="@+id/mainLayout"
		LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
		// Add the adView to it
		layout.addView(adView);
		// Initiate a generic request to load it with an ad
		adView.loadAd(new AdRequest());

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);

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

				if (l != null) {
					CL = l.toString();
				}
				if (h != null) {
					CH = h.toString();
				}
				if (t != null) {
					Tot = t.toString();
				}

				// Tot.equals("")

				if (CH.equals("") || CL.equals("") || Tot.equals("")) {
					FlashSteamPercent
							.setText("Enter valid information from steam tables for all inputs");
				} else {
					percentFLash = (((Float.valueOf(CH) - Float.valueOf(CL)) * 100) / Float
							.valueOf(Tot));
					String formattedValue = new DecimalFormat("#.#")
							.format(percentFLash);
					FlashSteamPercent.setText(formattedValue
							+ "% of condensate volume will flash to steam");
				}
			}
		});
	}

	 @Override
	  public void onDestroy() {
	    if (adView != null) {
	      adView.destroy();
	    }
	    super.onDestroy();
	  }
	 
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_flash_steam_calculator, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		// Find which Menu Item has been selected
		switch (item.getItemId()) {
		// Check for each known Menu Item
		case (R.id.menu_settings): {
			Intent i = new Intent(this, Contents.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			return true;
		}
		// Return false if you have not handled the Menu Item
		default:
			return false;
		}
	}
}
