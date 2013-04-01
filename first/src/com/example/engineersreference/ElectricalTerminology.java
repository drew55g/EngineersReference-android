package com.example.engineersreference;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ActionBar;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ElectricalTerminology extends ListActivity {
	String[] voltages = { "Ampacity", "Megger", "High Pot", "Arc",
			"Arc Suppresion", "Feeder", "Flash Over", "Field", "Equalization",
			"Eddy Current", "Degauss", "Commutator", "Bus",
			"Bonding Conductor", "Brush", "Excitation", "Ground Fault" };

	String message;
	String title;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, voltages));

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		switch (position) {
		case 0:
			message = "The current, in amperes that a conductor can carry continuously under the conditions of use without exceeding its temperature rating. "
					+ " Also known as current carrying capacity";
			title = "Ampacity ";
			break;
		case 1:
			message = "Megger is a company that manufactures electrical test and measurement equipment. "
					+ "Although the use of the term often implies an insulation resistance test";
			title = "Megger ";
			break;
		case 2:
			message = "A high pot or high potential test requires a high voltage to stress an insulation system and thereby "
					+ "verify its integrity ";
			title = "High Pot ";
			break;
		case 3:
			message = "An electric arc is a visible plasma discharge between two electrodes that is caused by electrical current ionizing gasses in the air ";
			title = "Arc ";
			break;
		case 4:
			message = "Arc Suppresion is the method used to prevent unitended electrical arcing, "
					+ " this includes circuit breakers utilizing SF6 gas, oil, air blast and vacuum";
			title = "Arc Suppression ";
			break;
		case 5:
			message = "A conductor which carries or feeds power from the service supply to branch lines or circuit ";
			title = "Feeder ";
			break;
		case 6:
			message = "The temperature point at which the heat in an area or region is high enough to ignite all flammable material simultaneously ";
			title = "Flash Over ";
			break;
		case 7:
			message = "A Field is defined as the magnetic component of a generator or motor. A generator requires excitation to produce the neccesary magnetic field while motor fields are induced from the grid";
			title = "Field ";
			break;
		case 8:
			message = " Equalizing temporarily elevates the charging voltage of the entire battery string above the normal float voltage. The elevated charging voltage allows all cells, including the weak ones, to accept more current from the charger than they would at float voltage. A consequence of the elevated equalize voltage is that all cells in the battery are overcharged ";
			title = "Equalization ";
			break;
		case 9:
			message = "An electric current induced within the body of a conductor when that conductor either moves through a nonuniform magnetic field or is in a region where there is a change in magnetic flux. It is sometimes called Foucault current ";
			title = "Eddy Current ";
			break;
		case 10:
			message = "To neutralize or rebalance the magnetic field of a magnetized object, such as a computer monitor or the read/write head of a disk drive or tape recorder. ";
			title = "Degauss ";
			break;
		case 11:
			message = "A commutator is a rotary electrical switch in certain types of electric motors or electrical generators that periodically reverses the current direction between the rotor and the external circuit ";
			title = "Commutator ";
			break;
		case 12:
			message = "An electrical conductor, maintained at a specific voltage and capable of carrying a high current, usually used to make a common connection between several circuits in a system ";
			title = "Bus ";
			break;
		case 13:
			message = "A bare or insulated conductor used to ensure the required electrical conductivity between metal parts required to be electrically connected. Frequently used from a bonding bushing to the service equipment enclosure to provide a path around concentric knockouts in an enclosure wall: also used to bond one raceway to another ";
			title = "Bonding Conductor ";
			break;
		case 14:
			message = "A small block of carbon used to convey current between the stationary and moving parts of an electric generator/motor ";
			title = "Brush ";
			break;
		case 15:
			message = "The current in a field coil of a generator used to produce AC power ";
			title = "Excitation ";
			break;
		case 16:
			message = "The unitentional grounding of a conductor, such as an insulation fault between a conductor and the ground or the frame of a device ";
			title = "Ground Fault ";
			break;
		}
		AlertDialog.Builder adb = new AlertDialog.Builder(
				ElectricalTerminology.this);
		adb.setTitle(title + "Definition ");
		adb.setMessage(message);
		adb.setPositiveButton("OK", null);
		adb.show();
	}
}