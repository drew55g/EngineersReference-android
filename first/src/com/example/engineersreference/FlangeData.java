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
			"20 in", "22 in", "24 in", "26 in", "30 in", "34 in", "36 in", "42 in" };

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
		actionBar.setDisplayShowHomeEnabled(false);

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
											+ boltCircleDiameter150(selectedPosition) + " inches");

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
									ODTextView.setText("  Flange OD = "
											+ flangeOD300(selectedPosition)
											+ " inches");

									IDTextView.setText(" Bolt Diameter = "
											+ boltCircleDiameter300(selectedPosition) + " inches");

									wallThicknessTextView
											.setText(" FlangHeight = "
													+ FlangeHeight300(selectedPosition)
													+ " inches");
									
									textViewSpace
									.setText(" Number of Bolts = "
											+ NoBolts300(selectedPosition));

									flangeTextView2.setText("You selected a "
											+ array[whichButton]
											+ " nominal flange ");


									// makes the text views visible after a
									// dialog button is selected
									flangeTextView2.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									wallThicknessTextView.setVisibility(View.VISIBLE);
									textViewSpace.setVisibility(View.VISIBLE);
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

									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

									// sets the text for the different variables
									ODTextView.setText("  Flange OD = "
											+ flangeOD400(selectedPosition)
											+ " inches");

									IDTextView.setText(" Bolt Diameter = "
											+ boltCircleDiameter400(selectedPosition) + " inches");

									wallThicknessTextView
											.setText(" FlangHeight = "
													+ FlangeHeight400(selectedPosition)
													+ " inches");
									
									textViewSpace
									.setText(" Number of Bolts = "
											+ NoBolts400(selectedPosition));

									flangeTextView2.setText("You selected a "
											+ array[whichButton]
											+ " nominal flange ");


									// makes the text views visible after a
									// dialog button is selected
									flangeTextView2.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									wallThicknessTextView.setVisibility(View.VISIBLE);
									textViewSpace.setVisibility(View.VISIBLE);
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

									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

									// sets the text for the different variables
									ODTextView.setText("  Flange OD = "
											+ flangeOD600(selectedPosition)
											+ " inches");

									IDTextView.setText(" Bolt Diameter = "
											+ boltCircleDiameter600(selectedPosition) + " inches");

									wallThicknessTextView
											.setText(" FlangHeight = "
													+ FlangeHeight600(selectedPosition)
													+ " inches");
									
									textViewSpace
									.setText(" Number of Bolts = "
											+ NoBolts600(selectedPosition));

									flangeTextView2.setText("You selected a "
											+ array[whichButton]
											+ " nominal flange ");


									// makes the text views visible after a
									// dialog button is selected
									flangeTextView2.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									wallThicknessTextView.setVisibility(View.VISIBLE);
									textViewSpace.setVisibility(View.VISIBLE);
								}
							}).create();

		}
		return null;

	}

////////////////////////////////////////////////////////////START 150lb////////////////////////////////////////////////////////////////
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

	
	public String boltCircleDiameter150(int selectedPosition) {
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
	/////////////////////////////////////////////////////////START 300lb/////////////////////////////////////////////////////
	// List of OD for a selected flange size
		public String flangeOD300(int selectedPosition) {
			switch (selectedPosition) {
			case 0:
				return "3.75";
			case 1:
				return "4.625";
			case 2:
				return "4.875";
			case 3:
				return "5.25";
			case 4:
				return "6.125";
			case 5:
				return "6.5";
			case 6:
				return "7.5";
			case 7:
				return "8.25";
			case 8:
				return "9";
			case 9:
				return "10";
			case 10:
				return "11";
			case 11:
				return "12.5";
			case 12:
				return "15";
			case 13:
				return "17.5";
			case 14:
				return "20.5";
			case 15:
				return "23";
			case 16:
				return "25.5";
			case 17:
				return "28";
			case 18:
				return "30.5";
			case 19:
				return "33";
			case 20:
				return "36";
			case 21:
				return "38.25";
			case 22:
				return "43";
			case 23:
				return "47.5";
			case 24:
				return "50";
			case 25:
				return "57";
			}
			return "Not a valid flange size";
		}

		
		public String FlangeHeight300(int selectedPosition) {
			switch (selectedPosition) {
			case 0:
				return "2.0625";
			case 1:
				return "2.25";
			case 2:
				return "2.4375";
			case 3:
				return "2.5625";
			case 4:
				return "2.6875";
			case 5:
				return "2.75";
			case 6:
				return "3";
			case 7:
				return "3.125";
			case 8:
				return "3.1875";
			case 9:
				return "3.375";
			case 10:
				return "3.875";
			case 11:
				return "3.875";
			case 12:
				return "4.375";
			case 13:
				return "4.625";
			case 14:
				return "5.125";
			case 15:
				return "5.625";
			case 16:
				return "5.75";
			case 17:
				return "6.25";
			case 18:
				return "6.375";
			case 19:
				return "6.5";
			case 20:
				return "6.625";
			case 21:
				return "7.25";
			case 22:
				return "8.25";
			case 23:
				return "9.125";
			case 24:
				return "9.5";
			case 25:
				return "10.875";		
			}
			return "Not a valid flange size";
		}

		
		public String boltCircleDiameter300(int selectedPosition) {
			switch (selectedPosition) {
			case 0:
				return "2.625";
			case 1:
				return "3.25";
			case 2:
				return "3.5";
			case 3:
				return "3.875";
			case 4:
				return "4.5";
			case 5:
				return "5";
			case 6:
				return "5.875";
			case 7:
				return "6.625";
			case 8:
				return "7.25";
			case 9:
				return "7.875";
			case 10:
				return "9.25";
			case 11:
				return "10.625";
			case 12:
				return "13";
			case 13:
				return "15.25";
			case 14:
				return "17.75";
			case 15:
				return "20.25";
			case 16:
				return "22.5";
			case 17:
				return "24.75";
			case 18:
				return "27";
			case 19:
				return "29.25";
			case 20:
				return "32";
			case 21:
				return "34.5";
			case 22:
				return "39.25";
			case 23:
				return "43.5";
			case 24:
				return "46";
			case 25:
				return "52.75";
			}
			return "Not a valid flange size";
		}


		public String NoBolts300(int selectedPosition) {
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
				return "8";
			case 6:
				return "8";
			case 7:
				return "8";
			case 8:
				return "8";
			case 9:
				return "8";
			case 10:
				return "8";
			case 11:
				return "12";
			case 12:
				return "12";
			case 13:
				return "16";
			case 14:
				return "16";
			case 15:
				return "20";
			case 16:
				return "20";
			case 17:
				return "24";
			case 18:
				return "24";
			case 19:
				return "24";
			case 20:
				return "24";
			case 21:
				return "28";
			case 22:
				return "28";
			case 23:
				return "28";
			case 24:
				return "32";
			case 25:
				return "36";
			}
			return "Not a valid flange size";
		}	
///////////////////////////////////////////////////////////////////START 400lb//////////////////////////////////////////////////////	
		public String flangeOD400(int selectedPosition) {
			switch (selectedPosition) {
			case 0:
				return "3.75";
			case 1:
				return "4.625";
			case 2:
				return "4.875";
			case 3:
				return "5.25";
			case 4:
				return "6.125";
			case 5:
				return "6.5";
			case 6:
				return "7.5";
			case 7:
				return "8.25";
			case 8:
				return "9";
			case 9:
				return "10";
			case 10:
				return "11";
			case 11:
				return "12.5";
			case 12:
				return "15";
			case 13:
				return "17.5";
			case 14:
				return "20.5";
			case 15:
				return "23";
			case 16:
				return "25.5";
			case 17:
				return "28";
			case 18:
				return "30.5";
			case 19:
				return "33";
			case 20:
				return "36";
			case 21:
				return "38.25";
			case 22:
				return "43";
			case 23:
				return "47.5";
			case 24:
				return "50";
			case 25:
				return "57";
			}
			return "Not a valid flange size";
		}

		
		public String FlangeHeight400(int selectedPosition) {
			switch (selectedPosition) {
			case 0:
				return "2.0625";
			case 1:
				return "2.25";
			case 2:
				return "2.4375";
			case 3:
				return "2.625";
			case 4:
				return "2.75";
			case 5:
				return "2.875";
			case 6:
				return "3.125";
			case 7:
				return "3.25";
			case 8:
				return "3.375";
			case 9:
				return "3.5";
			case 10:
				return "4";
			case 11:
				return "4.0625";
			case 12:
				return "4.625";
			case 13:
				return "4.875";
			case 14:
				return "5.375";
			case 15:
				return "5.875";
			case 16:
				return "6";
			case 17:
				return "6.5";
			case 18:
				return "6.625";
			case 19:
				return "6.75";
			case 20:
				return "6.875";
			case 21:
				return "7.625";
			case 22:
				return "8.625";
			case 23:
				return "9.5";
			case 24:
				return "9.875";
			case 25:
				return "11.375";		
			}
			return "Not a valid flange size";
		}

		
		public String boltCircleDiameter400(int selectedPosition) {
			switch (selectedPosition) {
			case 0:
				return "2.625";
			case 1:
				return "3.25";
			case 2:
				return "3.5";
			case 3:
				return "3.875";
			case 4:
				return "4.5";
			case 5:
				return "5";
			case 6:
				return "5.875";
			case 7:
				return "6.625";
			case 8:
				return "7.25";
			case 9:
				return "7.875";
			case 10:
				return "9.25";
			case 11:
				return "10.625";
			case 12:
				return "13";
			case 13:
				return "15.25";
			case 14:
				return "17.75";
			case 15:
				return "20.25";
			case 16:
				return "22.5";
			case 17:
				return "24.75";
			case 18:
				return "27";
			case 19:
				return "29.25";
			case 20:
				return "32";
			case 21:
				return "34.5";
			case 22:
				return "39.25";
			case 23:
				return "43.5";
			case 24:
				return "46";
			case 25:
				return "52.75";
			}
			return "Not a valid flange size";
		}


		public String NoBolts400(int selectedPosition) {
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
				return "8";
			case 6:
				return "8";
			case 7:
				return "8";
			case 8:
				return "8";
			case 9:
				return "8";
			case 10:
				return "8";
			case 11:
				return "12";
			case 12:
				return "12";
			case 13:
				return "16";
			case 14:
				return "16";
			case 15:
				return "20";
			case 16:
				return "20";
			case 17:
				return "24";
			case 18:
				return "24";
			case 19:
				return "24";
			case 20:
				return "24";
			case 21:
				return "28";
			case 22:
				return "28";
			case 23:
				return "28";
			case 24:
				return "32";
			case 25:
				return "32";
			}
			return "Not a valid flange size";
		}
////////////////////////////////////////////////////////////////START 600lb//////////////////////////////////////////////////
		public String flangeOD600(int selectedPosition) {
			switch (selectedPosition) {
			case 0:
				return "3.75";
			case 1:
				return "4.625";
			case 2:
				return "4.875";
			case 3:
				return "5.25";
			case 4:
				return "6.125";
			case 5:
				return "6.5";
			case 6:
				return "7.5";
			case 7:
				return "8.25";
			case 8:
				return "9";
			case 9:
				return "10.75";
			case 10:
				return "13";
			case 11:
				return "14";
			case 12:
				return "16.5";
			case 13:
				return "20";
			case 14:
				return "22";
			case 15:
				return "23.75";
			case 16:
				return "27";
			case 17:
				return "29.25";
			case 18:
				return "32";
			case 19:
				return "34.25";
			case 20:
				return "37";
			case 21:
				return "40";
			case 22:
				return "44.5";
			case 23:
				return "49";
			case 24:
				return "51.75";
			case 25:
				return "58.75";
			}
			return "Not a valid flange size";
		}

		
		public String FlangeHeight600(int selectedPosition) {
			switch (selectedPosition) {
			case 0:
				return "2.0625";
			case 1:
				return "2.25";
			case 2:
				return "2.4375";
			case 3:
				return "2.625";
			case 4:
				return "2.75";
			case 5:
				return "2.875";
			case 6:
				return "3.125";
			case 7:
				return "3.25";
			case 8:
				return "3.375";
			case 9:
				return "4";
			case 10:
				return "4.5";
			case 11:
				return "4.625";
			case 12:
				return "5.25";
			case 13:
				return "6";
			case 14:
				return "6.125";
			case 15:
				return "6.5";
			case 16:
				return "7";
			case 17:
				return "7.25";
			case 18:
				return "7.5";
			case 19:
				return "7.75";
			case 20:
				return "8";
			case 21:
				return "8.75";
			case 22:
				return "9.75";
			case 23:
				return "10.625";
			case 24:
				return "11.125";
			case 25:
				return "12.75";	
			}
			return "Not a valid flange size";
		}

		
		public String boltCircleDiameter600(int selectedPosition) {
			switch (selectedPosition) {
			case 0:
				return "2.625";
			case 1:
				return "3.25";
			case 2:
				return "3.5";
			case 3:
				return "3.875";
			case 4:
				return "4.5";
			case 5:
				return "5";
			case 6:
				return "5.875";
			case 7:
				return "6.625";
			case 8:
				return "7.25";
			case 9:
				return "8.5";
			case 10:
				return "10.5";
			case 11:
				return "11.5";
			case 12:
				return "13.75";
			case 13:
				return "17";
			case 14:
				return "19.25";
			case 15:
				return "20.75";
			case 16:
				return "23.75";
			case 17:
				return "25.75";
			case 18:
				return "28.5";
			case 19:
				return "30.625";
			case 20:
				return "33";
			case 21:
				return "36";
			case 22:
				return "40.25";
			case 23:
				return "44.5";
			case 24:
				return "47";
			case 25:
				return "53.75";
			}
			return "Not a valid flange size";
		}


		public String NoBolts600(int selectedPosition) {
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
				return "8";
			case 6:
				return "8";
			case 7:
				return "8";
			case 8:
				return "8";
			case 9:
				return "8";
			case 10:
				return "8";
			case 11:
				return "12";
			case 12:
				return "12";
			case 13:
				return "16";
			case 14:
				return "20";
			case 15:
				return "20";
			case 16:
				return "20";
			case 17:
				return "20";
			case 18:
				return "24";
			case 19:
				return "24";
			case 20:
				return "24";
			case 21:
				return "28";
			case 22:
				return "28";
			case 23:
				return "28";
			case 24:
				return "28";
			case 25:
				return "28";
			}
			return "Not a valid flange size";
		}	
}