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

public class TurbineEfficiency extends Activity {
	private EditText editText1;
	private TextView efficiency;
	Float eff;
	protected AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_turbine_efficiency);
	
		// Create the adView
		AdView adView = new AdView(this, AdSize.BANNER, "a151606ea53e58f");
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
		efficiency = (TextView) findViewById(R.id.textView2);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);

				efficiency.setVisibility(View.VISIBLE);

				// Null check
				Editable e = editText1.getText();
				String et = "";

				if (e != null) {
					et = e.toString();
				}

				if (et.equals("")) {
					efficiency.setText("Enter a valid number for heat rate");
				} else {
					eff = ((3412 / (Float.valueOf(et))) * 100);
					String formattedValue = new DecimalFormat("#.#")
							.format(eff);
					efficiency.setText(formattedValue
							+ "% of fuel converted to power");
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
