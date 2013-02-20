package com.example.engineersreference;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

 

public class ContentsListAdapter extends BaseAdapter {

	String[] contents = { "Relay Device Numbers", "Pipe Dimensional Data",
			"Flange Dimensional Data", "High Voltage Clearances",
			"Conversions", "Pum/Motor Data", "Electrical Terminology",
			"Valve Data", "Steam Trap Selection", "Percent Flash Steam",
			"Turbine Efficiency" };
	
	Integer[] images = { 
			R.drawable.electromagnetic_relay,
			R.drawable.pipe,
			R.drawable.flanges2,
			R.drawable.ic_launcher,
			R.drawable.flanges1
						 };

	String[] contentsSubItems = { "Descriptive", "informational",
			"informational", "informational",
			"Calcs", "Calcs", "Calcs",
			"Calcs", "Calcs", "Calcs",
			"Calcs" };

	private Activity activity;
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
	        LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	        View vi=convertView;
	        if(convertView==null)
	            vi = inflater.inflate(R.layout.list_row, null);

	        TextView title = (TextView)vi.findViewById(R.id.title); // title
	        TextView artist = (TextView)vi.findViewById(R.id.artist); // artist name
	        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
	        
	     
	       
	        
	        // Setting all values in listview
	        title.setText(contents[position]);
	        artist.setText(contentsSubItems[position]);
	     //   imageLoader.DisplayImage(song.get(CustomizedListView.KEY_THUMB_URL), thumb_image);
	        return vi;
	    }

}
