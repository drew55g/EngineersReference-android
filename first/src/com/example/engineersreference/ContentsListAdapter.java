package com.example.engineersreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

 

public class ContentsListAdapter extends BaseAdapter {

	String[] contents = { "Relay Device Numbers", "Pipe Dimensions",
			"Flange Dimensions", "Safe High Voltage Clearances",
			"Electrical Terminology", "Vibration Calculator", "Flash Steam Calculator",
			"Turbine Efficiency"};
	
	Integer[] images = { 
			R.drawable.electromagnetic_relay,
			R.drawable.pipe2,
			R.drawable.flanges1,
			R.drawable.lightning_bolt_md,
			R.drawable.bulb,
			R.drawable.vibrations,
			R.drawable.steam,
			R.drawable.turbine
						 };

	String[] contentsSubItems = { "ANSI Descriptions", "Commercial pipe sizes in inches",
			"Welding Neck Flanges in inches", "OSHA safety guidelines",
			"Common terms used in utility industry", "Velocity to displacement conversion",
			"Percentage volume of water flashing to steam", "Gas Turbine and Steam turbine efficiency", "",
			"Calcs" };

	Context a;

	
	public void setContext(Context c) {
		a = c;
	}
	

	    public int getCount() {
	        return images.length;
	    }

	    public Object getItem(int position) {
	        return position;
	    }

	    public long getItemId(int position) {
	        return position;
	    }
	    
	    public View getView(int position, View convertView, ViewGroup parent) {
	        LayoutInflater inflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	        View vi=convertView;
	        if(convertView==null)
	            vi = inflater.inflate(R.layout.list_row, null);

	        TextView title = (TextView)vi.findViewById(R.id.title); // title
	        TextView artist = (TextView)vi.findViewById(R.id.artist); // artist name
	        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
	        
	     
	       
	        
	        // Setting all values in listview
	        title.setText(contents[position]);
	        artist.setText(contentsSubItems[position]);
	        thumb_image.setImageResource(images[position]);
	        return vi;
	    }

}
