package com.example.engineersreference;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PumpMotorData extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pump_motor_data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_pump_motor_data, menu);
		return true;
	}

}
