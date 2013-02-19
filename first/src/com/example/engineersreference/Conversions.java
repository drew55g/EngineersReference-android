package com.example.engineersreference;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Conversions extends ListActivity {
	String[] presidents = { "Dwight D. Eisenhower", "John F. Kennedy",
			"Lyndon B. Johnson", "Richard Nixon", "Gerald Ford",
			"Jimmy Carter", "Ronald Reagan", "George H. W. Bush",
			"Bill Clinton", "George W. Bush", "Barack Obama" };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ---no need to call this---
		// setContentView(R.layout.main);
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, presidents));
	}

	public void onListItemClick(ListView parent, View v, int position, long id) 
	 {
	    switch( position )
	    {
	       case 0:  startActivity(new Intent(getApplicationContext(),
					RelayNumbers.class));
	                break;
	       case 1:  startActivity(new Intent(getApplicationContext(),
					Pipesizedata.class));
	                break;
	       case 2:  startActivity(new Intent(getApplicationContext(),
					FlangeData.class));
	                break;
	       case 3:  startActivity(new Intent(getApplicationContext(),
					PumpMotorData.class));
	                break;
	       case 4:  startActivity(new Intent(getApplicationContext(),
					SafeHighVoltageClearances.class));
	                break;
	    }
	    {
		Toast.makeText(this, "You have selected " + presidents[position],
				Toast.LENGTH_SHORT).show();
	}
	}
	
}