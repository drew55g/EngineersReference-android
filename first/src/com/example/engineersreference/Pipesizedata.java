package com.example.engineersreference;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;



public class Pipesizedata extends Activity {
	CharSequence[] items ={"1","1 1/4","1 1/2","2","2 1/4","2 1/2","3","3 1/2","4"};
	boolean[] itemsChecked = new boolean [items.length];
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pipesizedata);
	}

	public void onClick(View v) {
		showDialog(0);
	}
	
	protected Dialog onCreateDialog(int id) {
		switch(id) {
		
		case 0:
			return new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("Choose a pipe size")
			.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton)
				{
					Toast.makeText(getBaseContext(), "OK clicked", Toast.LENGTH_SHORT).show();
				}
			}
	)
	.setNegativeButton("Cancel", 
			new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int whichButton)
		{
			Toast.makeText(getBaseContext(),
					"Cancel clicked", Toast.LENGTH_SHORT).show();
		}
	}
)

	.setMultiChoiceItems(items, itemsChecked,
			new DialogInterface.OnMultiChoiceClickListener() {
		public void onClick(DialogInterface dialog, 
				int which, boolean isChecked) {
			Toast.makeText(getBaseContext(),
					items[which] + (isChecked ? "checked":" unchecked"),
					Toast.LENGTH_SHORT).show();
		}	
	}
	).create();
			
		}
		return null;
	}
}