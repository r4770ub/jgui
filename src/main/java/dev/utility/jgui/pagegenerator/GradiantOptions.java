package dev.utility.jgui.pagegenerator;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dev.utility.jbase.constants.JConstants;



public class GradiantOptions  {

	public static final String GERMAN_EAGLE_URL="https://live.staticflickr.com/65535/49402079987_5e0547def4_o_d.png";
	
	
	public String fontname;
	public String colorChoice;
	public boolean hasImage;
	public String overLayImageURL;
	public float alpha; 

	public String TITLE;
	public String SUBTITLE;
	public String DESC1;
	public String DESC2;
	public String DESC3;
	public boolean toStamp;
	public static String stamp_text;
	
	public GradiantOptions() {

		fontname = "padauk";
		colorChoice = "red";
		hasImage=true;
		overLayImageURL = this.GERMAN_EAGLE_URL;
		alpha=.5f;
		TITLE = "Title Message ";
		SUBTITLE = "Subtitle Message ";
		DESC1 = "Description Line1";
		DESC2 = "Description Line 2 ";
		DESC3 = " Description Line 3";
	    toStamp = true;
	    stamp_text= System.getProperty("os.name") +" " +System.getProperty("os.arch")+ "  | JAVA "+
				System.getProperty("java.runtime.version") + "  |  "+ " Loc: 43.4195° N, 83.9508° W  |  TS" + JConstants.getEpochTimeStamp();

	}
	
	public  void appendStamp(String text)
	{
		stamp_text = stamp_text + "  |  " +text;
	}

}
