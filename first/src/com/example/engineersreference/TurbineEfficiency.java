package com.example.engineersreference;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;

public class TurbineEfficiency extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_turbine_efficiency);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
	}

}
