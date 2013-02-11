package com.example.engineersreference;

//import com.example.android.apis.R;
//import com.example.android.apis.app.AlertDialogSamples;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Pipesizedata extends Activity {
	CharSequence[] array = { "1/8 in", "1/4 in", "3/8 in", "1/2 in", "3/4 in",
			"1 in", "1 1/4 in", "1 1/2 in", "2 in", "2 1/4 in", "2 1/2 in",
			"3 in", "3 1/2 in", "4 in", "5 in", "6 in", "8 in", "10 in",
			"12 in", "14 O.D.", "16 O.D.", "18 O.D.", "20 O.D.", "22 O.D.",
			"24 O.D.", "26 O.D.", "28 O.D.", "30 O.D.", "32 O.D.", "34 O.D.",
			"36 O.D.", "42 O.D." };

	boolean[] itemsChecked = new boolean[array.length];

	int selectedPosition;

	String c;

	private TextView pipeTextView;
	private TextView ODTextView;
	private TextView IDTextView;
	private TextView wallThicknessTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pipesizedata);

		pipeTextView = (TextView) findViewById(R.id.textView1);
		ODTextView = (TextView) findViewById(R.id.textView2);
		IDTextView = (TextView) findViewById(R.id.TextView01);
		wallThicknessTextView = (TextView) findViewById(R.id.TextView02);
	}

	public void onClick(View v) {
		showDialog(0);

	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {

		case 0:
			return new AlertDialog.Builder(Pipesizedata.this)
					.setIcon(R.drawable.ic_launcher)
					.setTitle("pipe size")
					.setSingleChoiceItems(array, 0,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();

									// gets the position of the dialog button
									// selected
									selectedPosition = ((AlertDialog) dialog)
											.getListView()
											.getCheckedItemPosition();

									// sets the text for the different variables
									ODTextView.setText(" OD = "
											+ PipeOD(selectedPosition) );

									IDTextView.setText(" ID = " + PipeID(selectedPosition));
									wallThicknessTextView
											.setText(" wallThickness = "
													+ wallThickness(selectedPosition));
									pipeTextView
											.setText("The selected pipe is "
													+ array[whichButton]);

									ListView lw = ((AlertDialog) dialog)
											.getListView();
									Object checkedItem = lw
											.getAdapter()
											.getItem(
													lw.getCheckedItemPosition());
									/*
									 * User clicked on a radio button do some
									 * stuff
									 */
								
									ActionBar actionBar = getActionBar();
									actionBar.hide();

									{
										Toast.makeText(getBaseContext(),
												selectedPosition + " checked",
												Toast.LENGTH_SHORT).show();
									}

									// makes the text views visible after a
									// dialog button is selected
									pipeTextView.setVisibility(View.VISIBLE);
									ODTextView.setVisibility(View.VISIBLE);
									IDTextView.setVisibility(View.VISIBLE);
									wallThicknessTextView
											.setVisibility(View.VISIBLE);
								}

							}).create();
		}
		return null;

	}

	// List of OD for a selected pipe size
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

	// List of ID for a selected pipe size
	
	  public String PipeID(int selectedPosition) { switch (selectedPosition) {
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
	  return "Not a valid relay number"; }
	 
	// List of wallThickness for a selected pipe size
	public String wallThickness(int selectedPosition) {
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
		return "Not a valid relay number";
	}

}