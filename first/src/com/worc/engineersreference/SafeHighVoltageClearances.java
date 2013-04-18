package com.worc.engineersreference;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SafeHighVoltageClearances extends Activity {

	String message;
	private ListView lv;
	private String listview_array[] = { "2.1 --> 15 Kv", "15.1 --> 35 Kv",
			"35.1 --> 46 Kv", "46.1 --> 72 Kv", "72.6 --> 121 Kv",
			"138 --> 145 Kv", "161 --> 169 Kv", "230 --> 242 Kv",
			"345 --> 362 Kv", "500 --> 552 Kv", "700 --> 765 Kv" };

	public void onCreate(Bundle icicle) {

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);

		super.onCreate(icicle);
		setContentView(R.layout.activity_safe_high_voltage_clearances);
		lv = (ListView) findViewById(R.id.listview);
		lv.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listview_array));
		lv.setTextFilterEnabled(true);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long id) {
				switch (position) {
				case 0:
					message = "2 feet";
					break;
				case 1:
					message = "2 feet - 4 inches";
					break;
				case 2:
					message = "2 feet - 6 inches";
					break;
				case 3:
					message = "3 feet";
					break;
				case 4:
					message = "3 feet - 4 inches";
					break;
				case 5:
					message = "3 feet - 6 inches";
					break;
				case 6:
					message = "3 feet - 8 inches";
					break;
				case 7:
					message = "5 feet";
					break;
				case 8:
					message = "7 feet";
					break;
				case 9:
					message = "11 feet";
					break;
				case 10:
					message = "15 feet";
					break;
				}
				AlertDialog.Builder adb = new AlertDialog.Builder(
						SafeHighVoltageClearances.this);
				adb.setTitle(" OSHA Minimum Distance");
				adb.setMessage(message);
				adb.setPositiveButton("OK", null);
				adb.show();

			}
		});
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_safe_high_voltage_clearances,
				menu);
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