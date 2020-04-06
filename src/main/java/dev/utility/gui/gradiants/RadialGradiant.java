package dev.utility.gui.gradiants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RadialGradiant extends Gradiant 
{

	private static final long serialVersionUID = -6011769092315779312L;
	private float radius; 
	private Point2D center;


    private RadialGradientPaint gradiant; 
    
	
	public RadialGradiant(int width, int height, Color[] colors )
	{
		super(width,height,colors);
	     this.center = new Point2D.Float(width/2, height/2);
	     this.radius = (width+height)/2;

	} 
	
	
		   @Override
		   protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        
		        Graphics2D g2d = (Graphics2D) g;
		        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		        gradiant =
		           new RadialGradientPaint(this.center, this.radius,distributions , this.colors);

		        g2d.setPaint(gradiant);
		        g2d.fillRect(0, 0, getWidth(), getHeight());
		        g2d.dispose();
		       
		    }


		
	}
	

