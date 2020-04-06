package dev.utility.jgui.base;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JTextArea;


public class JCTextArea extends JTextArea{
	

	private static final long serialVersionUID = -4675561353447049757L;
	
	public static final int READ_ONLY =0;
	public static final int WRITE_ONLY =1;
	
	private int width;
	private int height;
	private int isEditableFlag;
	
	
	public JCTextArea(int width, int height,int isEditableFlag)
	{
		super(width,height);
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) 
	{
		Paint paint = new GradientPaint(0, 0, GUIConfigurations.bkColor, 0, getHeight(), Color.DARK_GRAY,
				true);
		((Graphics2D) g).setPaint(paint);
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}




}
