package dev.utility.jgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.utility.gui.gradiants.Gradiant;
import dev.utility.gui.gradiants.RadialGradiant;
import dev.utility.jimage.DrawUtility;
import dev.utility.jimage.JImage;
import dev.utility.gui.gradiants.LinearGradiant;
import dev.utility.gui.gradiants.JColor;



public class DocumentGenerator {
	
	
	public static final int LINEAR_RED = 0;
	public static final int LINEAR_BLUE = 1;
	public static final int LINEAR_GREEN = 2;
	public static final int LINEAR_PURPLE = 3;
	public static final int LINEAR_YELLOW = 4;
	public static final int LINEAR_ORANGE = 5;
	public static final int LINEAR_GRAY = 6;
	
	public static final int RADIAL_RED = 7;
	public static final int RADIAL_BLUE = 8;
	public static final int RADIAL_GREEN = 9;
	public static final int RADIAL_PURPLE = 10;
	public static final int RADIAL_YELLOW = 11;
	public static final int RADIAL_ORANGE = 12;
	public static final int RADIAL_GRAY = 13;

	public static String outputDirectory ="/home/r4770/Desktop/outputs/"; 

	public static int counter =0; 
	private int width;
	private int height;
	private int scheme;
	private String titleText;
	private int titleSize;
	private String dataText;
	private int dataSize;
	
	Gradiant panelGradiant;
	JPanel panel;
	JLabel titleLabel;
	JLabel dataLabel;
	JLabel imagePanel;
	
	JFrame frame;
	
	public DocumentGenerator(int width, int height,int scheme)
	{
		this.width = width;
		this.height = height; 
		this.scheme = scheme;
	}
	
	public JImage processImage(String titleText, String text) throws IOException
	{

		
		if(scheme == LINEAR_RED)
			panelGradiant = new LinearGradiant(width, height, JColor.REDS, LinearGradiant.HORIZONTAL_OPTION);
		else if(scheme == LINEAR_GREEN)
			panelGradiant = new LinearGradiant(width, height, JColor.GREENS,LinearGradiant.HORIZONTAL_OPTION);
		else if(scheme == LINEAR_BLUE)
			panelGradiant = new LinearGradiant(width, height, JColor.BLUES, LinearGradiant.HORIZONTAL_OPTION);
		else if(scheme == LINEAR_PURPLE)
			panelGradiant = new LinearGradiant(width, height, JColor.PURPLES, LinearGradiant.HORIZONTAL_OPTION);
		
		else if(scheme == LINEAR_GRAY)
			panelGradiant = new LinearGradiant(width, height, JColor.GRAYS, LinearGradiant.HORIZONTAL_OPTION);
		
		else if(scheme == RADIAL_RED)
			panelGradiant = new RadialGradiant(width, height, JColor.REDS);
		else if(scheme == RADIAL_GREEN)
			panelGradiant = new RadialGradiant(width, height, JColor.GREENS);
		else if(scheme == RADIAL_BLUE)
			panelGradiant = new RadialGradiant(width, height, JColor.BLUES);
		else if(scheme == RADIAL_PURPLE)
			panelGradiant = new RadialGradiant(width, height, JColor.PURPLES);

		else if(scheme == RADIAL_GRAY)
			panelGradiant = new RadialGradiant(width, height, JColor.GRAYS);
		else 
			throw new IOException("Incorect scheme painter selected....");
		
		panel =panelGradiant.getPanel();
		
		 titleText = "<html> Journey Towards Faith </html>";
		
		 text = "<html>I am guilty Ashamed of what I’ve done what Ive become These hands are dirty I dare not lift them up to the holy one He pleads my causeHe right my wrongs you break my chains you overcomeYou gave  your life To give me mineYou say I am free </html>";
		
	  
	    JFrame frame = new JFrame(); 
	    frame.add(panel);
	    frame.setVisible(true); 
	    frame.setResizable(false);
	    frame.setSize(width,height);

		
		DrawUtility drawer = new DrawUtility(panel); 
		drawer.drawRectangle(new Rectangle(0,0,width,height), 25, JColor.RED_INNER_BORDER);
		drawer.drawRectangle(new Rectangle(0,0,width,height), 8, JColor.RED_OUTER_BORDER);
		drawer.drawCenterText(text, new Font("Palock", Font.PLAIN, 26),Color.red);
		JImage image = drawer.getResultImage();
		image.displayImage();
		image.writeJImageAsPNG(outputDirectory + "img"+counter+++".png");
		return image; 
	
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getScheme() {
		return scheme;
	}

	public void setScheme(int scheme) {
		this.scheme = scheme;
	}

	public String getTitleText() {
		return titleText;
	}

	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	public int getTitleSize() {
		return titleSize;
	}

	public void setTitleSize(int titleSize) {
		this.titleSize = titleSize;
	}

	public String getDataText() {
		return dataText;
	}

	public void setDataText(String dataText) {
		this.dataText = dataText;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}

}
