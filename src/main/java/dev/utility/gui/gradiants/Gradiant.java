package dev.utility.gui.gradiants;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dev.utility.jimage.DrawUtility;


public class Gradiant extends JPanel {
	

	private static final long serialVersionUID = -8332715418848438453L;


	protected Color[] colors;
	DrawUtility drawer; 
	
	
	protected float[] distributions = { 0.1f, 0.7f };
	private int Wwidth;
	private int height;


	public Gradiant(int width, int height, Color[] colors) {
		this.setWidth(width);
		this.setHeight(height);
		this.setColors(colors);
	}


	public int getWidth() {
		return this.Wwidth;
	}


	public void setWidth(int width) {
		this.Wwidth = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public Color[] getColors() {
		return colors;
	}


	public void setColors(Color[] colors) {
		this.colors = colors;
	}


	public float[] getDistributions() {
		return distributions;
	}


	public void setDistributions(float[] distributions) {
		this.distributions = distributions;
	}

	   public JPanel getPanel()
	   {
		   return this; 
	   }



}
