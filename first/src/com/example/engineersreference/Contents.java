package com.example.engineersreference;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;



public class Contents extends Activity {

	String[] contents = { "Relay Device Numbers", "Pipe Dimensions",
			"Flange Dimensions", "High Voltage Clearances",
			"Conversions", "Pump/Motor Data", "Electrical Terminology",
			"Valve Data", "Steam Trap Selection", "Percent Flash Steam",
			"Turbine Efficiency" };
	
	 static final String KEY_SONG = "song"; // parent node 
	    static final String KEY_ID = "id"; 
	    static final String KEY_TITLE = "title"; 
	    static final String KEY_ARTIST = "artist"; 
	    static final String KEY_DURATION = "duration"; 
	    static final String KEY_THUMB_URL = "thumb_url"; 

	ArrayAdapter<String> aa;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents);

		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		aa = (new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, contents));

		ListView contentsListView = (ListView) findViewById(R.id.listView1);

		contentsListView.setAdapter(aa);

		ContentsListAdapter adapter; 
		
		contentsListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					startActivity(new Intent(getApplicationContext(),
							RelayNumbers.class));
					break;
				case 1:
					startActivity(new Intent(getApplicationContext(),
							Pipesizedata.class));
					break;
				case 2:
					startActivity(new Intent(getApplicationContext(),
							FlangeData.class));
					break;
				case 3:
					startActivity(new Intent(getApplicationContext(),
							PumpMotorData.class));
					break;
				case 4:
					startActivity(new Intent(getApplicationContext(),
							SafeHighVoltageClearances.class));
					break;
				}
				{
					Toast.makeText(getApplicationContext(),
							"you have selected " + contents[position],
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		// public View getView(int position, View convertView, ViewGroup parent) {}
	}
}
