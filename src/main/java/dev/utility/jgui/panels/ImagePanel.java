package dev.utility.jgui.panels;

import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import dev.utility.jgui.base.GUIConfigurations;



public class ImagePanel extends JButton {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
    
	public ImagePanel(BufferedImage img) {
		super();
		setVerticalAlignment(JButton.CENTER);
		setHorizontalAlignment(JButton.CENTER);
		//addActionListener(DynamicViewer.listener);
		setFocusable(false);
		setSize(img.getWidth(),img.getHeight());
	    setVerticalAlignment(JButton.CENTER);
		setHorizontalAlignment(JButton.CENTER);


	}
	
	public void updateImage(BufferedImage img )
	{
		setIcon(new ImageIcon(img));
		setSize(img.getWidth(),img.getHeight()); 	   
		setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor,6));

	}

}
