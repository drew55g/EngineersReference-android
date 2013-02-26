package com.example.engineersreference;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;



public class Contents extends Activity {
	
	ContentsListAdapter cla;
	Activity a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents);

		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		cla = new ContentsListAdapter();
		ListView contentsListView = (ListView) findViewById(R.id.listView1);
		

		contentsListView.setAdapter(cla);
		cla.setContext(this);

		
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
							SafeHighVoltageClearances.class));
					break;
				case 4:
					startActivity(new Intent(getApplicationContext(),
							Conversions.class));
					break;
				case 5:
					startActivity(new Intent(getApplicationContext(),
							PumpMotorData.class));
					break;
				}
			}
		});
		
	
	}
}
