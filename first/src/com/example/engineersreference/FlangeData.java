package com.example.engineersreference;

//import com.example.android.apis.R;
//import com.example.android.apis.app.AlertDialogSamples;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FlangeData extends Activity {
	CharSequence[] array = { "1/2 in", "3/4 in", "1 in", "1 1/4 in",
			"1 1/2 in", "2 in", "2 1/2 in", "3 in", "3 1/2 in", "4 in", "5 in",
			"6 in", "8 in", "10 in", "12 in", "14 in", "16 in", "18 in",
			"20 in", "22 in", "24 in", "26 in", "28 in", "30 in",
			"32 in", "34 in", "36 in", "42 in" };

	int selectedPosition;

	private TextView flangeTextView2;
	private TextView flangeTextView40;

	private TextView ODTextView;
	private TextView IDTextView;
	private TextView wallThicknessTextView;
	private TextView textViewSpace;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActionBar actionBar = getActionBar();
		actionBar.hide();

		setContentView(R.layout.activity_flange_data);

	
		flangeTextView2 = (TextView) findViewById(R.id.textViewSTD);
		ODTextView = (TextView) findViewById(R.id.textView2);
		IDTextView = (TextView) findViewById(R.id.TextView01);
		wallThicknessTextView = (TextView) findViewById(R.id.TextView02);
		textViewSpace = (TextView) findViewById(R.id.textViewSpace);

		Button button1 = (Button) findViewById(R.id.btn_150lb);
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(0);
			}
		});

		Button button2 = (Button) findViewById(R.id.btn_300lb);
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(1);
			}
		});

		Button button3 = (Button) findViewById(R.id.btn_400lb);
		button3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(2);
			}
		});
		
		Button button4 = (Button) findViewById(R.id.btn_600lb);
		button4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(3);
			}
		});

	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {

		case 0:
			return new AlertDialog.Builder(FlangeData.this)
					.setIcon(R.drawable.ic_launcher)
					.setTitle("flange size")
					.setSingleChoiceItems(array, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();

									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

									// sets the text for the different variables
									ODTextView.setText("  Flange OD = "
											+ flangeOD150(selectedPosition)
											+ " inches");

									IDTextView.setText(" Bolt Diameter = "
											+ boltCircleDiameter(selectedPosition) + " inches");

									wallThicknessTextView
											.setText(" FlangHeight = "
													+ FlangeHeight150(selectedPosition)
													+ " inches");
									
									textViewSpace
									.setText(" Number of Bolts = "
											+ NoBolts150(selectedPosition));

									flangeTextView2.setText("You selected a "
											+ array[whichButton]
											+ " nominal flange ");

									{
										Toast.makeText(getBaseContext(),
												selectedPosition + " checked",
												Toast.LENGTH_SHORT).show();
									}

									// makes the text views visible after a
									// dialog button is selected
									flangeTextView2.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									wallThicknessTextView.setVisibility(View.VISIBLE);
									textViewSpace.setVisibility(View.VISIBLE);
								}
							}).create();

		case 1:
			return new AlertDialog.Builder(FlangeData.this)
					.setIcon(R.drawable.ic_launcher)
					.setTitle("flange size")
					.setSingleChoiceItems(array, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();

									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

									// sets the text for the different variables
									ODTextView.setText(" OD = "
											+ flangeOD150(selectedPosition)
											+ " inches");

									IDTextView.setText(" ID = "
											+ boltCircleDiameter(selectedPosition) + " inches");

									wallThicknessTextView
											.setText(" wallThickness = "
													+ FlangeHeight150(selectedPosition)
													+ " inches");

									// gets the position of the dialog button
									flangeTextView2.setText("You selected a "
											+ array[whichButton]
											+ " nominal flange ");

									flangeTextView40.setText(array[whichButton]
											+ " Schedule (40) " + "flange data");

									ActionBar actionBar = getActionBar();
									actionBar.hide();

									{
										Toast.makeText(getBaseContext(),
												selectedPosition + " checked",
												Toast.LENGTH_SHORT).show();
									}

									// makes the text views visible after a
									// dialog button is selected
									flangeTextView2.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									wallThicknessTextView
											.setVisibility(View.VISIBLE);
								}
							}).create();

		case 2:
			return new AlertDialog.Builder(FlangeData.this)
					.setIcon(R.drawable.ic_launcher)
					.setTitle("flange size")
					.setSingleChoiceItems(array, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();

									/*
									 * double a = Float
									 * .valueOf(flangeOD(selectedPosition));
									 * double b = Float
									 * .valueOf(wallThickness(selectedPosition
									 * )); double c = a - (2 * b);
									 */

									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

									// sets the text for the different variables
									ODTextView.setText(" OD = "
											+ FlangeHeight150(selectedPosition)
											+ " inches");

									IDTextView.setText(" ID = "
											+ FlangeHeight150(selectedPosition) + " inches");

									wallThicknessTextView
											.setText(" wallThickness = "
													+ FlangeHeight150(selectedPosition)
													+ " inches");

									// gets the position of the dialog button
									flangeTextView2.setText("You selected a "
											+ array[whichButton]
											+ " nominal flange size");

									{
										Toast.makeText(getBaseContext(),
												selectedPosition + " checked",
												Toast.LENGTH_SHORT).show();
									}

									// makes the text views visible after a
									// dialog button is selected
									flangeTextView2.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									wallThicknessTextView
											.setVisibility(View.VISIBLE);
								}
							}).create();
			
		case 3:
			return new AlertDialog.Builder(FlangeData.this)
					.setIcon(R.drawable.ic_launcher)
					.setTitle("flange size")
					.setSingleChoiceItems(array, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();

									/*
									 * double a = Float
									 * .valueOf(flangeOD(selectedPosition));
									 * double b = Float
									 * .valueOf(wallThickness(selectedPosition
									 * )); double c = a - (2 * b);
									 */

									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

									// sets the text for the different variables
									ODTextView.setText(" OD = "
											+ flangeOD150(selectedPosition)
											+ " inches");

									IDTextView.setText(" ID = "
											+ flangeOD150(selectedPosition) + " inches");

									wallThicknessTextView
											.setText(" wallThickness = "
													+ flangeOD150(selectedPosition)
													+ " inches");

									flangeTextView2.setText("You selected a "
											+ array[whichButton]
											+ " nominal flange ");

									// flangeTextView40
									// .setText(array[whichButton]+
									// " Schedule (40) " +"flange data" );

									{
										Toast.makeText(getBaseContext(),
												selectedPosition + " checked",
												Toast.LENGTH_SHORT).show();
									}

									// makes the text views visible after a
									// dialog button is selected
									flangeTextView2.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									wallThicknessTextView
											.setVisibility(View.VISIBLE);
								}
							}).create();

		}
		return null;

	}

	// List of OD for a selected flange size
	public String flangeOD150(int selectedPosition) {
		switch (selectedPosition) {
		case 0:
			return "3.5";
		case 1:
			return "3.875";
		case 2:
			return "4.25";
		case 3:
			return "4.625";
		case 4:
			return "5";
		case 5:
			return "6";
		case 6:
			return "7";
		case 7:
			return "7.5";
		case 8:
			return "8.5";
		case 9:
			return "9";
		case 10:
			return "10";
		case 11:
			return "11";
		case 12:
			return "13.5";
		case 13:
			return "16";
		case 14:
			return "19";
		case 15:
			return "21";
		case 16:
			return "23.5";
		case 17:
			return "25";
		case 18:
			return "27.5";
		case 19:
			return "29.5";
		case 20:
			return "32";
		case 21:
			return "34.25";
		case 22:
			return "38.75";
		case 23:
			return "43.75";
		case 24:
			return "46";
		case 25:
			return "53";
		}
		return "Not a valid flange size";
	}

	// List of schedule 80 wall thickness for a selected flange size
	public String FlangeHeight150(int selectedPosition) {
		switch (selectedPosition) {
		case 0:
			return "1.875";
		case 1:
			return "2.0625";
		case 2:
			return "2.1875";
		case 3:
			return "2.25";
		case 4:
			return "2.4375";
		case 5:
			return "2.5";
		case 6:
			return "2.75";
		case 7:
			return "2.75";
		case 8:
			return "2.8125";
		case 9:
			return "3";
		case 10:
			return "3.5";
		case 11:
			return "3.5";
		case 12:
			return "4";
		case 13:
			return "4";
		case 14:
			return "4.5";
		case 15:
			return "5";
		case 16:
			return "5";
		case 17:
			return "5.5";
		case 18:
			return "5.6875";
		case 19:
			return "5.875";
		case 20:
			return "6";
		case 21:
			return "5";
		case 22:
			return "5.125";
		case 23:
			return "5.3125";
		case 24:
			return "5.375";
		case 25:
			return "5.375";		
		}
		return "Not a valid flange size";
	}

	// List of schedule standard wallThickness for a selected flange size
	public String boltCircleDiameter(int selectedPosition) {
		switch (selectedPosition) {
		case 0:
			return "2.375";
		case 1:
			return "2.75";
		case 2:
			return "3.125";
		case 3:
			return "3.5";
		case 4:
			return "3.875";
		case 5:
			return "4.75";
		case 6:
			return "5.5";
		case 7:
			return "6";
		case 8:
			return "7";
		case 9:
			return "7.5";
		case 10:
			return "8.5";
		case 11:
			return "9.5";
		case 12:
			return "11.75";
		case 13:
			return "14.25";
		case 14:
			return "17";
		case 15:
			return "18.75";
		case 16:
			return "21.25";
		case 17:
			return "22.75";
		case 18:
			return "25";
		case 19:
			return "27.25";
		case 20:
			return "29.5";
		case 21:
			return "31.75";
		case 22:
			return "36";
		case 23:
			return "40.5";
		case 24:
			return "42.75";
		case 25:
			return "49.5";
		}
		return "Not a valid flange size";
	}

	// List of schedule 40 wall thickness for a selected flange size
	public String NoBolts150(int selectedPosition) {
		switch (selectedPosition) {
		case 0:
			return "4";
		case 1:
			return "4";
		case 2:
			return "4";
		case 3:
			return "4";
		case 4:
			return "4";
		case 5:
			return "4";
		case 6:
			return "4";
		case 7:
			return "4";
		case 8:
			return "8";
		case 9:
			return "8";
		case 10:
			return "8";
		case 11:
			return "8";
		case 12:
			return "8";
		case 13:
			return "12";
		case 14:
			return "12";
		case 15:
			return "12";
		case 16:
			return "16";
		case 17:
			return "16";
		case 18:
			return "20";
		case 19:
			return "20";
		case 20:
			return "20";
		case 21:
			return "24";
		case 22:
			return "28";
		case 23:
			return "32";
		case 24:
			return "32";
		case 25:
			return "36";
		}
		return "Not a valid flange size";
	}
}