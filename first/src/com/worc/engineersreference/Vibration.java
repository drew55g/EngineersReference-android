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

public class Vibration extends Activity {

	private EditText editText1;
	private EditText editText2;
	private TextView vibrationText;
	Float mils;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vibration);

		// Create the adView
		AdView adView = new AdView(this, AdSize.BANNER, "a15160a4625ac24");
		// Lookup your LinearLayout assuming it’s been given
		// the attribute android:id="@+id/mainLayout"
		LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
		// Add the adView to it
		layout.addView(adView);
		// Initiate a generic request to load it with an ad
		adView.loadAd(new AdRequest());

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);

		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		vibrationText = (TextView) findViewById(R.id.textView2);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);
				imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);

				vibrationText.setVisibility(View.VISIBLE);

				// Null check
				Editable e = editText1.getText();
				Editable r = editText2.getText();
				String et = "";
				String rpm = "";

				if (e != null) {
					et = e.toString();
				}

				if (r != null) {
					rpm = r.toString();
				}

				if (rpm.equals("") || et.equals("")) {
					vibrationText
							.setText("Enter a valid number for vibration and rpm");
				} else {
					mils = ((Float.valueOf(et) * 19100) / Float.valueOf(rpm));
					String formattedValue = new DecimalFormat("#.#")
							.format(mils);
					vibrationText.setText(formattedValue + " mils");
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_vibration, menu);
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
