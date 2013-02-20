package com.example.engineersreference;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class ImageLoader {
	
	Integer[] data = { 
			R.drawable.electromagnetic_relay,
			R.drawable.pipe,
			R.drawable.flanges2,
			R.drawable.ic_launcher,
			R.drawable.flanges1
						 };
	
	  final int stub_id = R.drawable.ic_launcher; 
	    public void DisplayImage(ImageView imageView) 
	    {  
	        if(data!=null) 
	            imageView.setImageResource(data.length); 
	        else
	        { 
	            imageView.setImageResource(stub_id); 
	        } 
	    } 
	  
	   

}
