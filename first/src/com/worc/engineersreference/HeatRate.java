package com.worc.engineersreference;

import java.text.DecimalFormat;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class HeatRate extends Activity {
	private EditText editText1;
	private EditText editText2;
	private TextView HeatRate;
	Float rate;
	int selectedPosition;
	protected AdView adView;

	CharSequence[] flowunits = { "lb/hr", "lb/min", "lb/sec" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_heat_rate);
	
		// Create the adView
		AdView adView = new AdView(this, AdSize.BANNER, "a1515fb32f76daf");
		// Lookup your LinearLayout assuming it’s been given
		// the attribute android:id="@+id/mainLayout"
		LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
		// Add the adView to it
		layout.addView(adView);
		// Initiate a generic request to load it with an ad
		adView.loadAd(new AdRequest());
	

		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		HeatRate = (TextView) findViewById(R.id.textView2);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);
				imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);

				HeatRate.setVisibility(View.VISIBLE);

				// Null check
				Editable e = editText1.getText();
				Editable r = editText2.getText();
				String Q = "";
				String MW = "";

				if (e != null) {
					Q = e.toString();
				}

				if (r != null) {
					MW = r.toString();
				}

				if (MW.equals("") || Q.equals("")) {
					HeatRate.setText("Enter a valid number for fuel flow and power");
				} else {
					rate = ((Float.valueOf(Q)
							* Float.valueOf(units(selectedPosition)) * 23000) / (Float
							.valueOf(MW) * 1000));
					String formattedValue = new DecimalFormat("#.#")
							.format(rate);
					HeatRate.setText(formattedValue + " Btu/kWh");
				}
			}
		});

		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(0);
				editText1.setEnabled(true);
				editText2.setEnabled(true);
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
	
	protected Dialog onCreateDialog(int id) {
		switch (id) {

		case 0:
			return new AlertDialog.Builder(HeatRate.this)
					.setTitle("fuel units")
					.setSingleChoiceItems(flowunits, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();

									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

								}
							}).create();
		}
		return null;
	}

	// Switches units for heat rate calculation
	public String units(int selectedPosition) {
		switch (selectedPosition) {
		case 0:
			return "1";
		case 1:
			return "60";
		case 2:
			return "3600";
		}
		return "no heat rate";
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_heat_rate, menu);
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
