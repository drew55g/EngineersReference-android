package com.worc.engineersreference;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class RelayNumbers extends Activity {
	private TextView relayText;
	private EditText editText1;
	private TextView relayDescription;
	protected AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relaynumbers);

		// Create the adView 
		AdView adView = new AdView(this, AdSize.BANNER, "a15160489d74c95");
		// Lookup your LinearLayout assuming it’s been given
		// the attribute android:id="@+id/mainLayout"
		LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
		// Add the adView to it
		layout.addView(adView);
		// Initiate a generic request to load it with an ad
		adView.loadAd(new AdRequest());

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);

		editText1 = (EditText) findViewById(R.id.editText1);
		relayText = (TextView) findViewById(R.id.textView1);
		relayDescription = (TextView) findViewById(R.id.TextView01);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);

				relayText.setVisibility(View.VISIBLE);
				relayDescription.setVisibility(View.VISIBLE);

				// Null check
				Editable e = editText1.getText();
				String et = "";
				if (e != null) {
					et = e.toString();
				}

				ScrollView scrollViewOne = (ScrollView) findViewById(R.id.scrollView1);
				scrollViewOne.scrollTo(0, 0);

				if (et.equals("")) {
					relayText.setText(relayNumber(1000));
					relayDescription.setText(relayNumberDescription((1000)));
				} else {
					relayText.setText(relayNumber(Integer.valueOf(et)));
					relayDescription.setText(relayNumberDescription(Integer
							.valueOf(et)));
				}

			}
		});
	}

	 @Override
	  public void onDestroy() {
	    if (adView != null) {
	      adView.destroy();
	    }
	    super.onDestroy();
	  }
	 
	// this class displays the associated function for a selected relay number
	// in a textview
	public String relayNumber(int relay) {
		switch (relay) {
		case 1:
			return "Master Element";
		case 2:
			return "Time Delay Starting or Closing Relay";
		case 3:
			return "Checking or Interlocking Relay";
		case 4:
			return "Master Contactor";
		case 5:
			return "Stopping Device";
		case 6:
			return "Starting Circuit Breaker";
		case 7:
			return "Rate of Change Relay";
		case 8:
			return "Control Power Disconnecting Device";
		case 9:
			return "Reversing Device";
		case 10:
			return "Unit Sequence Switch";
		case 11:
			return "Multifunction Device";
		case 12:
			return "Overspeed Device";
		case 13:
			return "Synchronous-speed Device";
		case 14:
			return "Underspeed Device";
		case 15:
			return "Speed or Frequency-Matching Device";
		case 16:
			return "Data Communications Device";
		case 17:
			return "Shunting or Discharge Switch";
		case 18:
			return "Accelerating or Decelerating Device";
		case 19:
			return "Starting to Running Transition Contactor";
		case 20:
			return "Electrically operated valve (solenoid valve)";
		case 21:
			return "Distance Relay";
		case 22:
			return "Equalizer circuit breaker";
		case 23:
			return "Temperature Control Device";
		case 24:
			return "Volts per Hertz Relay";
		case 25:
			return "Synchronizing or Synchronism-Check Device";
		case 26:
			return "Apparatus Thermal Device";
		case 27:
			return "Undervoltage Relay";
		case 28:
			return "Flame Detector";
		case 29:
			return "Isolating Contactor or Switch";
		case 30:
			return "Annunciator Relay";
		case 31:
			return "Separate Excitation Device";
		case 32:
			return "Directional Power Relay";
		case 33:
			return "Position Switch";
		case 34:
			return "Master Sequence Device";
		case 35:
			return "Brush-Operating or Slip-Ring Short-Circuiting Device";
		case 36:
			return "Polarity or Polarizing Voltage Devices";
		case 37:
			return "Undercurrent or Underpower Relay";
		case 38:
			return "Bearing Protective Device";
		case 39:
			return "Mechanical Conduction Monitor";
		case 40:
			return "Field (over/under excitation) Relay";
		case 41:
			return "Field Circuit Breaker";
		case 42:
			return "Running Circuit Breaker";
		case 43:
			return "Manual Transfer or Selector Device";
		case 44:
			return "Unit Sequence Starting Relay";
		case 45:
			return "Abnormal Atmospheric Condition Monitor";
		case 46:
			return "Reverse phase or Phase-Balance Current Relay";
		case 47:
			return "Phase-Sequence or Phase-Balanace Voltage Relay";
		case 48:
			return "Incomplete-Sequence Relay";
		case 49:
			return "Machine or Transformer Thermal Relay";
		case 50:
			return "Instantaneous Overcurrent";
		case 51:
			return "AC Time Overcurrent Relay";
		case 52:
			return "AC Circuit Breaker";
		case 53:
			return "Field Excitation Relay";
		case 54:
			return "Turning Gear Engaging Device";
		case 55:
			return "Power Factor Relay";
		case 56:
			return "Field Application Relay";
		case 57:
			return "Short-Circuiting or Grounding Device";
		case 58:
			return "Rectification Failure Relay";
		case 59:
			return "Overvoltage Relay";
		case 60:
			return "Voltage or Current Balance Relay";
		case 61:
			return "Density Switch or Sensor";
		case 62:
			return "Time-Delay Stopping or Opening Relay";
		case 63:
			return "Pressure Switch";
		case 64:
			return "Ground Detector Relay";
		case 65:
			return "Governor";
		case 66:
			return "Notching or jogging device";
		case 67:
			return "AC Directional Overcurrent Relay";
		case 68:
			return "AC Directional Overcurrent Relay";
		case 69:
			return "Permissive Control Device";
		case 70:
			return "Rheostat";
		case 71:
			return "Liquid Level Switch";
		case 72:
			return "DC Circuit Breaker";
		case 73:
			return "Load-Resistor Contactor";
		case 74:
			return "Alarm Relay";
		case 75:
			return "Position Changing Mechanism";
		case 76:
			return "DC Overcurrent Relay";
		case 77:
			return "Telemetering Device";
		case 78:
			return "Phase-Angle Measuring Relay";
		case 79:
			return "AC-Reclosing Relay";
		case 80:
			return "Flow Switch";
		case 81:
			return "Frequency Relay";
		case 82:
			return "DC Reclosing Relay";
		case 83:
			return "Automatic Selective Control or Transfer Relay";
		case 84:
			return "Operating Mechanism";
		case 85:
			return "Pilot Communications, Carrier or Pilot-Wire Relay";
		case 86:
			return "Lockout Relay";
		case 87:
			return "Differential Protective Relay";
		case 88:
			return "Auxiliary Motor or Motor";
		case 89:
			return "Line Switch";
		case 90:
			return "Regulating Device";
		case 91:
			return "Voltage Directional Relay";
		case 92:
			return "Voltage and Power Directional Relay";
		case 93:
			return "Field Changing Contactor";
		case 94:
			return "Tripping or Trip-Free Relay";

		}
		return "Not a valid relay number";
	}

	// this class displays the associated function for a selected relay number
	// in a scroll view
	public String relayNumberDescription(int relay) {

		switch (relay) {
		case 1:
			return "The initiating device, such as a control switch, etc., that serves, either directly or through such permissive devices as protective and time-delay relays, to place equipment in or out of operation. NOTE: This number is normally used for a hand-operated device, although it may also be used for an electrical or mechanical device for which no other function number is suitable.";
		case 2:
			return "A device that functions to give a desired amount of time delay before or after any point of operation in a switching sequence or protective relay system, except as specifically provided by device functions 48, 62, and 79";
		case 3:
			return "A relay that operates in response to the position of a number of other devices (or to a number of predetermined conditions) in equipment to allow an operating sequence to proceed, stop, or provide a check of the position of these devices or conditions for any purpose";
		case 4:
			return "A device, generally controlled by device function 1 or the equivalent and the required permissive and protective devices, that serves to make and break the necessary control circuits to place equipment into operation under the desired conditions and to take it out of operation under abnormal conditions";
		case 5:
			return "A control device used primarily to shut down equipment and hold it out of operation. (This device may be manually or electrically actuated, but it excludes the function of electrical lockout [see device function 86] on abnormal conditions.)";
		case 6:
			return "A device whose principal function is to connect a machine to its source of starting voltage";
		case 7:
			return "A relay that functions on an excessive rate-of-rise of current";
		case 8:
			return "A disconnecting device, such as a knife switch, circuit breaker, or pull-out fuse block, used for the purpose of respectively connecting and disconnecting the source of control power to and from the control bus or equipment. NOTE: Control power is considered to include auxiliary power that supplies such apparatus as small motors and heaters.";
		case 9:
			return "A device that is used for the purpose of reversing a machine field or for performing any other reversing functions";
		case 10:
			return "A switch that is used to change the sequence in which units may be placed in and out of service in multiple-unit equipment";
		case 11:
			return "A device that performs three or more comparatively important functions that could only be designated by combining several of these device function numbers. All of the functions performed by device 11 shall be defined in the drawing legend or device function definition list";
		case 12:
			return "Usually, a direct-connected speed switch that functions on machine overspeed";
		case 13:
			return "A device such as a centrifugal-speed switch, a slipfrequency relay, a voltage relay, an undercurrent relay, or any other type of device that operates at approximately the synchronous speed of a machine";
		case 14:
			return "A device that functions when the speed of a machine falls below a pre-determined value";
		case 15:
			return "A device that functions to match and hold the speed or frequency of a machine or a system equal to, or approximately equal to, that of another machine, source, or system";
		case 16:
			return "";
		case 17:
			return "A switch that serves to open or close a shunting circuit around any piece of apparatus (except a resistor), such as a machine field, a machine armature, a capacitor, or a reactor";
		case 18:
			return "A device that is used to close or cause the closing of circuits that are used to increase or decrease the speed of a machine";
		case 19:
			return "A device that operates to initiate or cause the automatic transfer of a machine from the starting to the running power connection";
		case 20:
			return "An electrically operated, controlled, or monitored valve used in a fluid, air, gas, or vacuum line";
		case 21:
			return "A relay that functions when the circuit admittance, impedance, or reactance increases or decreases beyond a predetermined value";
		case 22:
			return "A breaker that serves to control or make and break the equalizer or the current-balancing connections for a machine field, or for regulating equipment, in a multiple-unit installation";
		case 23:
			return "A device that functions to raise or lower the temperature of a machine or other apparatus, or of any medium, when its temperature falls below or rises above a predetermined value";
		case 24:
			return "A relay that functions when the ratio of voltage to frequency exceeds a preset value. The relay may have an instantaneous or a time characteristic";
		case 25:
			return "A device that operates when two ac circuits are within the desired limits of frequency, phase angle, and voltage to permit or cause the paralleling of these two circuits";
		case 26:
			return "A device that functions when the temperature of the protected apparatus (other than the loadcarrying windings of machines and transformers as covered by device function number 49) or of a liquid or other medium exceeds a predetermined value; or when the temperature of the protected apparatus or of any medium decreases below a predetermined value";
		case 27:
			return "A relay that operates when its input voltage is less than a predetermined value";
		case 28:
			return "A device that monitors the presence of the pilot or main flame in such apparatus as a gas turbine or a steam boiler";
		case 29:
			return "A device that is used expressly for disconnecting one circuit from another for the purposes of emergency operation, maintenance, or test";
		case 30:
			return "A nonautomatically reset device that gives a number of separate visual indications upon the functioning of protective devices and that may also be arranged to perform a lockout function";
		case 31:
			return "A device that connects a circuit, such as the shunt field of a synchronous converter, to a source of separate excitation during the starting sequence";
		case 32:
			return "A relay that operates on a predetermined value of power flow in a given direction or upon reverse power flow such as that resulting from the motoring of a generator upon loss of its prime mover";
		case 33:
			return "A switch that makes or breaks contact when the main device or piece of apparatus that has no device function number reaches a given position";
		case 34:
			return "A device such as a motor-operated multicontact switch, or the equivalent, or a programming device, such as a computer, that establishes or determines the operating sequence of the major devices in equipment during starting and stopping or during other sequential switching operations.";
		case 35:
			return "A device for raising, lowering, or shifting the brushes of a machine; short-circuiting its slip rings; or engaging or disengaging the contacts of a mechanical rectifier";
		case 36:
			return "A device that operates, or permits the operation of, another device on a predetermined polarity only or that verifies the presence of a polarizing voltage in equipment";
		case 37:
			return "A relay that functions when the current or power flow decreases below a predetermined value";
		case 38:
			return "A device that functions on excessive bearing temperature or on other abnormal mechanical conditions associated with the bearing, such as undue wear, which may eventually result in excessive bearing temperature or failure";
		case 39:
			return "A device that functions upon the occurrence of an abnormal mechanical condition (except that associated with bearings as covered under device function 38), such as exces sive vibration, eccentricity, expansion, shock, tilting, or seal failure";
		case 40:
			return "A relay that functions on a given or abnormally low value or failure of machine field current, or on an excessive value of the reactive component of armature current in an ac machine indicating abnormally low field excitation";
		case 41:
			return "A device that functions to apply or remove the field excitation of a machine";
		case 42:
			return "A device whose principal function is to connect a machine to its source of running or operating voltage. This function may also be used for a device, such as a contactor, that is used in series with a circuit breaker or other faultprotecting means, primarily for frequent opening and closing of the circuit";
		case 43:
			return "A manually operated device that transfers the control circuits in order to modify the plan of operation of the switching equipment or of some of the devices";
		case 44:
			return "A relay that functions to start the next available unit in multiple-unit equipment upon the failure or nonavailability of the normally preceding uni";
		case 45:
			return "A device that functions upon the occurrence of an abnormal atmospheric condition, such as damaging fumes, explosive mixtures, smoke, or fire";
		case 46:
			return "A relay that functions when the polyphase currents are of reverse-phase sequence or when the polyphase currents are unbalanced or contain negative phasesequence components above a given amount";
		case 47:
			return "A relay that functions upon a predetermined value of polyphase voltage in the desired phase sequence, when the polyphase voltages are unbalanced, or when the negative phase-sequence voltage exceeds a given amount";
		case 48:
			return "A relay that generally returns the equipment to the normal, or off, position and locks it out if the normal starting, operating, or stopping sequence is not properly completed within a predetermined time";
		case 49:
			return "A relay that functions when the temperature of a machine armature winding or other load-carrying winding or element of a machine or power transformer exceeds a predetermined value";
		case 50:
			return "A relay that functions instantaneously on an excessive value of current";
		case 51:
			return "A relay that functions when the ac input current exceeds a predetermined value, and in which the input current and operating time are inversely related through a substantial portion of the performance range";
		case 52:
			return "A device that is used to close and interrupt an ac power circuit under normal conditions or to interrupt this circuit under fault or emergency conditions";
		case 53:
			return "A relay that forces the dc machine field excitation to build up during starting or that functions when the machine voltage has built up to a given value";
		case 54:
			return "An electrically operated, controlled, or monitored device that functions to cause the turning gear to engage (or disengage) the machine shaft";
		case 55:
			return "A relay that operates when the power factor in an ac circuit rises above or falls below a predetermined value";
		case 56:
			return "A relay that automatically controls the application of the feld excitation to an ac motor at some predetermined point in the slip cycle";
		case 57:
			return "A primary circuit switching device that functions to short-circuit or ground a circuit in response to automatic or manual means";
		case 58:
			return "A device that functions if a power rectifier fails to conduct or block properly";
		case 59:
			return "A relay that operates when its input voltage is more than a predetermined valuey";
		case 60:
			return "A relay that operates on a given difference in voltage, or current input or output, of two circuits";
		case 61:
			return "A device that operates on a given value, or a given rate of change, of gas density";
		case 62:
			return "A time-delay relay that serves in conjunction with the device that initiates the shutdown, stopping, or opening operation in an automatic sequence or protective relay system";
		case 63:
			return "A switch that operates on given values, or on a given rate of change, of pressure.";
		case 64:
			return "A relay that operates upon failure of machine or other apparatus insulation to ground";
		case 65:
			return "The assembly of fluid, electrical, or mechanical control equipment used for regulating the flow of water, steam, or other media to the prime mover for such purposes as starting, holding speed or load, or stopping";
		case 66:
			return "A device that functions to allow only a specifed number of operations of a given device or equipment, or a specified number of successive operations within a given time of each other. It is also a device that functions to energize a circuit periodically or for fractions of specified time intervals, or that is used to permit intermittent acceleration or jogging of a machine at low speeds for mechanical positioning";
		case 67:
			return "A relay that functions on a desired value of ac overcurrent flowing in a predetermined direction";
		case 68:
			return "A relay that initiates a pilot signal for blocking of tripping on external faults in a transmission line or in other apparatus under predetermined conditions, or that cooperates with other devices to block tripping or to block reclosing on an out-of-step condition or on power swings";
		case 69:
			return "Generally, a two-position device that in one position permits the closing of a circuit breaker, or the placing of an equipment into operation, and in the other position prevents the circuit breaker or the equipment from being operated";
		case 70:
			return "A variable resistance device used in an electric circuit when the device is electrically operated or has other electrical accessories, such as auxiliary, position, or limit switches";
		case 71:
			return "A switch that operates on given values, or on a given rate of change, of level";
		case 72:
			return "A circuit breaker that is used to close and interrupt a dc power circuit under normal conditions or to interrupt this circuit under fault or emergency conditions";
		case 73:
			return "A contactor that is used to shunt or insert a step of load limiting, shifting, or indicating resistance in a power circuit; to switch a space heater in circuit; or to switch a light or regenerative load resistor of a power rectifier or other machine in and out of circuit";
		case 74:
			return "A relay other than an annunciator, as covered under device function 30, that is used to operate, or that operates in connection with, a visual or audible alarm.";
		case 75:
			return "A mechanism that is used for moving a main device from one position to another in equipment; for example, shifting a removable circuit breaker unit to and from the connected, disconnected, and test positions";
		case 76:
			return "A relay that functions when the current in a dc circuit exceeds a given value";
		case 77:
			return "A transmitter used to generate and transmit to a remote location an electrical signal representing a measured quantity, or a receiver used to receive the electrical signal from a remote transmitter and convert the signal to represent the original measured quantity";
		case 78:
			return "A relay that functions at a predetermined phase angle between two voltages, between two currents, or between voltage and current";
		case 79:
			return "A relay that functions at a predetermined phase angle between two voltages, between two currents, or between voltage and current";
		case 80:
			return "A switch that operates on given values, or on a given rate of change, of flow.";
		case 81:
			return "A relay that responds to the frequency of an electrical quantity, operating when the frequency or rate of change of frequency exceeds or is less than a predetermined value";
		case 82:
			return "A relay that controls the automatic closing and reclosing of a dc circuit interrupter, generally in response to load circuit conditions";
		case 83:
			return "A relay that operates to select automatically between certain sources or conditions in equipment or that performs a transfer operation automatically";
		case 84:
			return "The complete electrical mechanism or servo mechanism, including the operating motor, solenoids, position switches, etc., for a tap changer, induction regulator, or any similar piece of apparatus that otherwise has no device function numher.";
		case 85:
			return "A relay that is operated or restrained by a signal used in connection with carriercurrent or dc pilot-wire fault relaying";
		case 86:
			return "A hand or electrically reset auxiliary relay that is operated upon the occurrence of abnormal conditions to maintain associated equipment or devices inoperative until it is reset";
		case 87:
			return "A protective relay that functions on a percentage, phase angle, or other quantitative difference between two currents or some other electrical quantities";
		case 88:
			return "A device used for operating auxiliary equipment, such as pumps, blowers, exciters, rotating magnetic amplifiers, etc.";
		case 89:
			return "A switch used as a disconnecting, load-interrupter, or isolating switch in an ac or dc power circuit. (This device function number is normally not necessary unless the switch is electrically operated or has electrical accessories, such as an auxiliary switch, a magnetic lock, etc.)";
		case 90:
			return "A device that functions to regulate a quantity or quantities, such as voltage, current, power, speed, frequency, temperature, and load, at a certain value or between certain (generally close) limits for machines, tie lines, or other apparatus";
		case 91:
			return "A relay that operates when the voltage across an open circuit breaker or contactor exceeds a given value in a given direction";
		case 92:
			return "A relay that permits or causes the connection of two circuits when the voltage difference between them exceeds a given value in a predetermined direction and causes these two circuits to be disconnected from each other when the power flowing between them exceeds a given value in the opposite direction";
		case 93:
			return "A contactor that functions to increase or decrease, in one step, the value of field excitation on a machine.";
		case 94:
			return "A relay that functions to trip a circuit breaker, contactor, or equipment; to permit immediate tripping by other devices; or to prevent immediate reclosing of a circuit interrupter if it should open automatically, even though its closing circuit is maintained closed";

		}
		return "No description available";
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.relaynumbers, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		// Find which Menu Item has been selected
		switch (item.getItemId()) {
		// Check for each known Menu Item
		case (R.id.menu_settings): {
			Intent i = new Intent(this, Contents.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			return true;
		}
		// Return false if you have not handled the Menu Item
		default:
			return false;
		}
	}
}
