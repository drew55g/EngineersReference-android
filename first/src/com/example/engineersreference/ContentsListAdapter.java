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
			"Electrical Terminology", "Pump/Motor Data", "Electrical Terminology",
			"Valve Data", "Steam Trap Selection", "Percent Flash Steam",
			"Turbine Efficiency" };
	
	Integer[] images = { 
			R.drawable.electromagnetic_relay,
			R.drawable.pipe2,
			R.drawable.flanges1,
			R.drawable.lightning_bolt_md,
			R.drawable.flanges1,
			R.drawable.pipe
						 };

	String[] contentsSubItems = { "Descriptive", "informational",
			"informational", "informational",
			"Calcs", "Calcs", "Calcs",
			"Calcs", "Calcs", "Calcs",
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
