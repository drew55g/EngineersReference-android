package com.example.engineersreference;

import java.util.Timer;
import java.util.TimerTask;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		MyTimerTask myTask = new MyTimerTask();
		Timer myTimer = new Timer();
		myTimer.schedule(myTask, 2000); // setup timer to limit onCreate task to
										// 2 seconds

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); // runs "splash screen" onCreate
												// first
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		//actionBar.hide();						// hides action bar
	}

	class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			// Timer task now runs second activity, which is set to display main
			// layout
			Intent i = new Intent(getApplicationContext(), Contents.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); 
			startActivity(i);
		}
	}

}
