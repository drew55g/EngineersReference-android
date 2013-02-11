package com.example.engineersreference;

//import com.example.android.apis.R;
//import com.example.android.apis.app.AlertDialogSamples;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;

public class FlangeData extends Activity {
	CharSequence[] array = { "1/8 in", "1/4 in", "3/8 in", "1/2 in", "3/4 in",
			"1 in", "1 1/4 in", "1 1/2 in", "2 in", "2 1/4 in", "2 1/2 in",
			"3 in", "3 1/2 in", "4 in", "5 in", "6 in", "8 in", "10 in",
			"12 in", "14 O.D.", "16 O.D.", "18 O.D.", "20 O.D.", "22 O.D.",
			"24 O.D.", "26 O.D.", "28 O.D.", "30 O.D.", "32 O.D.", "34 O.D.",
			"36 O.D.", "42 O.D." };
	boolean[] itemsChecked = new boolean[array.length];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flange_data);
	}

	public void onClick(View v) {
		showDialog(0);
	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {

		case 0:
			return new AlertDialog.Builder(FlangeData.this)
					.setIcon(R.drawable.ic_launcher)
					.setTitle("Flange size")
					.setSingleChoiceItems(array, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {

									/*
									 * User clicked on a radio button do some
									 * stuff
									 */
								}
							})
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {

									/* User clicked Yes so do some stuff */
								} 
							})
					.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {

									/* User clicked No so do some stuff */
								}
							}).create();
		}
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_flange_data, menu);
		return true;
	}

}
