package com.example.engineersreference;

//import com.example.android.apis.R;
//import com.example.android.apis.app.AlertDialogSamples;

import java.text.DecimalFormat;

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

public class Pipesizedata extends Activity {
	CharSequence[] arraySTD = { "1/8 in", "1/4 in", "3/8 in", "1/2 in",
			"3/4 in", "1 in", "1 1/4 in", "1 1/2 in", "2 in", "2 1/2 in",
			"3 in", "3 1/2 in", "4 in", "5 in", "6 in", "8 in", "10 in",
			"12 in", "14 O.D.", "16 O.D.", "18 O.D.", "20 O.D.", "22 O.D.",
			"24 O.D.", "26 O.D.", "28 O.D.", "30 O.D.", "32 O.D.", "34 O.D.",
			"36 O.D.", "42 O.D." };

	CharSequence[] array40 = { "1/8 in", "1/4 in", "3/8 in", "1/2 in",
			"3/4 in", "1 in", "1 1/4 in", "1 1/2 in", "2 in", "2 1/2 in",
			"3 in", "3 1/2 in", "4 in", "5 in", "6 in", "8 in", "10 in",
			"12 in", "14 O.D.", "16 O.D.", "18 O.D.", "20 O.D.", "24 O.D.",
			"32 O.D.", "34 O.D.", "36 O.D." };

	CharSequence[] array80 = { "1/8 in", "1/4 in", "3/8 in", "1/2 in",
			"3/4 in", "1 in", "1 1/4 in", "1 1/2 in", "2 in", "2 1/2 in",
			"3 in", "3 1/2 in", "4 in", "5 in", "6 in", "8 in", "10 in",
			"12 in", "14 O.D.", "16 O.D.", "18 O.D.", "20 O.D.", "22 O.D.",
			"24 O.D." };
	
	CharSequence[] arrayXS = { "1/8 in", "1/4 in", "3/8 in", "1/2 in",
			"3/4 in", "1 in", "1 1/4 in", "1 1/2 in", "2 in", "2 1/2 in",
			"3 in", "3 1/2 in", "4 in", "5 in", "6 in", "8 in", "10 in",
			"12 in", "14 O.D.", "16 O.D.", "18 O.D.", "20 O.D.", "22 O.D.",
			"24 O.D.", "26 O.D.", "28 O.D.", "30 O.D.", "32 O.D.", "34 O.D.",
			"36 O.D.", "42 O.D." };

	int selectedPosition;

	private TextView pipeTextView2;
	private TextView ODTextView;
	private TextView IDTextView;
	private TextView WallThicknessTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);

		setContentView(R.layout.activity_pipesizedata);

		
		pipeTextView2 = (TextView) findViewById(R.id.textViewSTD);
		ODTextView = (TextView) findViewById(R.id.textView2);
		IDTextView = (TextView) findViewById(R.id.TextView01);
		WallThicknessTextView = (TextView) findViewById(R.id.TextView02);

		
		Button button1 = (Button) findViewById(R.id.btn_standard);
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(0);
			}
		});

		Button button2 = (Button) findViewById(R.id.btn_40);
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(1);
			}
		});

		Button button3 = (Button) findViewById(R.id.btn_80);
		button3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(2);
			}
		});
		
		Button button4 = (Button) findViewById(R.id.btn_XS);
		button4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(3);
			}
		});

	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {

		case 0:
			return new AlertDialog.Builder(Pipesizedata.this)
					.setIcon(R.drawable.ic_launcher)
					.setTitle("pipe size")
					.setSingleChoiceItems(arraySTD, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();

									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

									// sets the text for the different variables
									ODTextView.setText(" OD = "
											+ PipeOD(selectedPosition)
											+ " inches");

									Float value = ((Float
											.valueOf(PipeOD(selectedPosition))) - 2 * Float
											.valueOf(WallThickness(selectedPosition)));

									String formattedValue = new DecimalFormat(
											"#.###").format(value);
									IDTextView.setText(" ID = "
											+ formattedValue + " inches");

									WallThicknessTextView
											.setText(" WallThickness = "
													+ WallThickness(selectedPosition)
													+ " inches");

									pipeTextView2.setText("You selected a "
											+ arraySTD[whichButton]
											+ " nominal STD Sch pipe");

									// makes the text views visible after a
									// dialog button is selected
									pipeTextView2.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									WallThicknessTextView
											.setVisibility(View.VISIBLE);
								}
							}).create();

		case 1:
			return new AlertDialog.Builder(Pipesizedata.this)
					.setIcon(R.drawable.ic_launcher)
					.setTitle("pipe size")
					.setSingleChoiceItems(array40, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();

									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

									// sets the text for the different variables
									ODTextView.setText(" OD = "
											+ PipeOD(selectedPosition)
											+ " inches");

									Float value = ((Float
											.valueOf(PipeOD(selectedPosition))) - 2 * Float
											.valueOf(Sch40Thickness(selectedPosition)));

									String formattedValue = new DecimalFormat(
											"#.###").format(value);
									IDTextView.setText(" ID = "
											+ formattedValue + " inches");

									WallThicknessTextView
											.setText(" WallThickness = "
													+ Sch40Thickness(selectedPosition)
													+ " inches");

									// gets the position of the dialog button
									pipeTextView2.setText("You selected a "
											+ array40[whichButton]
											+ " nominal schedule 40 pipe ");

									// makes the text views visible after a
									// dialog button is selected
									pipeTextView2.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									WallThicknessTextView
											.setVisibility(View.VISIBLE);
								}
							}).create();

		case 2:
			return new AlertDialog.Builder(Pipesizedata.this)
					.setIcon(R.drawable.ic_launcher)
					.setTitle("pipe size")
					.setSingleChoiceItems(array80, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();

									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

									if (selectedPosition == 31) {

										ODTextView.setText(" OD = "
												+ " undefined: does not exist");

										IDTextView.setText(" ID = "
												+ " undefined: does not exist");

										WallThicknessTextView
												.setText(" WallThickness = "
														+ " undefined: does not exist");

										// gets the position of the dialog
										// button
										pipeTextView2.setText("You selected a "
												+ array80[whichButton]
												+ " nominal schedule 80 pipe");

									} else {
										// sets the text for the different
										// variables
										ODTextView.setText(" OD = "
												+ PipeOD(selectedPosition)
												+ " inches");

										Float value = ((Float
												.valueOf(PipeOD(selectedPosition))) - 2 * Float
												.valueOf(Sch80Thickness(selectedPosition)));

										String formattedValue = new DecimalFormat(
												"#.###").format(value);
										IDTextView.setText(" ID = "
												+ formattedValue + " inches");

										WallThicknessTextView
												.setText(" WallThickness = "
														+ Sch80Thickness(selectedPosition)
														+ " inches");

										// gets the position of the dialog
										// button
										pipeTextView2.setText("You selected a "
												+ array80[whichButton]
												+ " nominal schedule 80 pipe");
									}
									// makes the text views visible after a
									// dialog button is selected
									pipeTextView2.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									WallThicknessTextView
											.setVisibility(View.VISIBLE);
								}
							}).create();
			
		case 3:
			return new AlertDialog.Builder(Pipesizedata.this)
					.setIcon(R.drawable.ic_launcher)
					.setTitle("pipe size")
					.setSingleChoiceItems(arrayXS, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();

									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

									// sets the text for the different variables
									ODTextView.setText(" OD = "
											+ PipeOD(selectedPosition)
											+ " inches");

									Float value = ((Float
											.valueOf(PipeOD(selectedPosition))) - 2 * Float
											.valueOf(SchXSThickness(selectedPosition)));

									String formattedValue = new DecimalFormat(
											"#.###").format(value);
									IDTextView.setText(" ID = "
											+ formattedValue + " inches");

									WallThicknessTextView
											.setText(" WallThickness = "
													+ SchXSThickness(selectedPosition)
													+ " inches");

									pipeTextView2.setText("You selected a "
											+ arrayXS[whichButton]
											+ " nominal Sch extra strong pipe");

									// makes the text views visible after a
									// dialog button is selected
									pipeTextView2.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									WallThicknessTextView
											.setVisibility(View.VISIBLE);
								}
							}).create();

		}
		return null;

	}

	// List of OD for all selected pipe sizes
	public String PipeOD(int selectedPosition) {
		switch (selectedPosition) {
		case 0:
			return ".405";
		case 1:
			return ".540";
		case 2:
			return ".675";
		case 3:
			return ".840";
		case 4:
			return "1.050";
		case 5:
			return "1.315";
		case 6:
			return "1.660";
		case 7:
			return "1.900";
		case 8:
			return "2.375";
		case 9:
			return "2.875";
		case 10:
			return "3.5";
		case 11:
			return "4.0";
		case 12:
			return "4.5";
		case 13:
			return "5.563";
		case 14:
			return "6.625";
		case 15:
			return "8.625";
		case 16:
			return "10.75";
		case 17:
			return "12.75";
		case 18:
			return "14.0";
		case 19:
			return "16.0";
		case 20:
			return "18.0";
		case 21:
			return "20.0";
		case 22:
			return "22.0";
		case 23:
			return "24.0";
		case 24:
			return "26.0";
		case 25:
			return "28.0";
		case 26:
			return "30.0";
		case 27:
			return "32.0";
		case 28:
			return "34.0";
		case 29:
			return "36.0";
		case 30:
			return "42.0";
		}
		return "Not a valid pipe size";
	}
	
	// List of schedule XS wall thickness for a selected pipe size
		public String SchXSThickness(int selectedPosition) {
			switch (selectedPosition) {
			case 0:
				return ".095";
			case 1:
				return ".119";
			case 2:
				return ".126";
			case 3:
				return ".147";
			case 4:
				return ".154";
			case 5:
				return ".179";
			case 6:
				return ".191";
			case 7:
				return ".200";
			case 8:
				return ".218";
			case 9:
				return ".276";
			case 10:
				return ".300";
			case 11:
				return ".318";
			case 12:
				return ".337";
			case 13:
				return ".375";
			case 14:
				return ".432";
			case 15:
				return ".500";
			case 16:
				return ".500";
			case 17:
				return ".500";
			case 18:
				return ".500";
			case 19:
				return ".500";
			case 20:
				return ".500";
			case 21:
				return ".500";
			case 22:
				return ".500";
			case 23:
				return ".500";
			case 24:
				return ".500";
			case 25:
				return ".500";
			case 26:
				return ".500";
			case 27:
				return ".500";
			case 28:
				return ".500";
			case 29:
				return ".500";
			case 30:
				return ".500";
			case 31:
				return ".500";
			}
			return "Not a valid pipe size";
		}

	// List of schedule 80 wall thickness for a selected pipe size
	public String Sch80Thickness(int selectedPosition) {
		switch (selectedPosition) {
		case 0:
			return ".095";
		case 1:
			return ".119";
		case 2:
			return ".126";
		case 3:
			return ".147";
		case 4:
			return ".154";
		case 5:
			return ".179";
		case 6:
			return ".191";
		case 7:
			return ".200";
		case 8:
			return ".218";
		case 9:
			return ".276";
		case 10:
			return ".300";
		case 11:
			return ".318";
		case 12:
			return ".337";
		case 13:
			return ".375";
		case 14:
			return ".432";
		case 15:
			return ".500";
		case 16:
			return ".594";
		case 17:
			return ".688";
		case 18:
			return ".750";
		case 19:
			return ".844";
		case 20:
			return ".938";
		case 21:
			return "1.031";
		case 22:
			return "1.125";
		case 23:
			return "1.218";
		}
		return "Not a valid pipe size";
	}

	// List of schedule standard WallThickness for a selected pipe size
	public String WallThickness(int selectedPosition) {
		switch (selectedPosition) {
		case 0:
			return ".068";
		case 1:
			return ".088";
		case 2:
			return ".091";
		case 3:
			return ".109";
		case 4:
			return ".113";
		case 5:
			return ".133";
		case 6:
			return ".140";
		case 7:
			return ".145";
		case 8:
			return ".154";
		case 9:
			return ".203";
		case 10:
			return ".216";
		case 11:
			return ".226";
		case 12:
			return ".237";
		case 13:
			return ".258";
		case 14:
			return ".280";
		case 15:
			return ".322";
		case 16:
			return ".365";
		case 17:
			return ".375";
		case 18:
			return ".375";
		case 19:
			return ".375";
		case 20:
			return ".375";
		case 21:
			return ".375";
		case 22:
			return ".375";
		case 23:
			return ".375";
		case 24:
			return ".375";
		case 25:
			return ".375";
		case 26:
			return ".375";
		case 27:
			return ".375";
		case 28:
			return ".375";
		case 29:
			return ".375";
		case 30:
			return ".375";
		}
		return "Not a valid pipe size";
	}

	// List of schedule 40 wall thickness for a selected pipe size
	public String Sch40Thickness(int selectedPosition) {
		switch (selectedPosition) {
		case 0:
			return ".068";
		case 1:
			return ".088";
		case 2:
			return ".091";
		case 3:
			return ".109";
		case 4:
			return ".113";
		case 5:
			return ".133";
		case 6:
			return ".140";
		case 7:
			return ".145";
		case 8:
			return ".154";
		case 9:
			return ".203";
		case 10:
			return ".216";
		case 11:
			return ".226";
		case 12:
			return ".237";
		case 13:
			return ".258";
		case 14:
			return ".280";
		case 15:
			return ".322";
		case 16:
			return ".365";
		case 17:
			return ".406";
		case 18:
			return ".438";
		case 19:
			return ".500";
		case 20:
			return ".562";
		case 21:
			return ".594";
		case 22:
			return ".688";
		case 23:
			return ".688";
		case 24:
			return ".688";
		case 25:
			return ".750";
		}
		return "Not a valid pipe size";
	}
}