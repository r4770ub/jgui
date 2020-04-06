package dev.utility.gui.gradiants;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;

import javax.swing.JPanel;

import dev.utility.jimage.DrawUtility;
import dev.utility.jimage.JImage;
import dev.utility.jimage.filters.JImageFilter;
import dev.utility.jimage.filters.OverlayFilter;

public class SquareGradiant extends Gradiant {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2658945226813993895L;
	private GradientPaint painter;
	JPanel horizontalPanel; 
	JPanel verticalPanel; 
	JPanel finalPanel; 
	JImage finalJImage; 

	public SquareGradiant(int width, int height, Color[] colors) throws IOException {
		super(width, height, colors);
		setSize(width,height);
		Gradiant gradiant = new LinearGradiant(width,height,colors,LinearGradiant.HORIZONTAL_OPTION);
		horizontalPanel = gradiant.getPanel(); 
		
	    gradiant = new LinearGradiant(width,height,colors,LinearGradiant.VERTICAL_OPTION);
		verticalPanel = gradiant.getPanel(); 
		
		DrawUtility drawer = new DrawUtility(horizontalPanel); 
		JImage image1 = drawer.getSourceImage();
		image1.displayImage("horizontal image");
		
	    drawer = new DrawUtility(verticalPanel); 
		JImage image2 = drawer.getSourceImage();
		image2.displayImage("vertical image");
	
		
		OverlayFilter overlayFilter = JImageFilter.getOverlayFilter(image1,0f, image2, .5f);
		 JImage resultImage = overlayFilter.getResultImage();
		 
		 drawer = new DrawUtility(resultImage); 
		this.finalPanel =drawer.getSourcePanel();
		

	}
	
	public JPanel getPanel()
	{
		return this.finalPanel; 
	}
	
	public JImage getJImage()
	{
		return this.finalJImage;
	}




}
