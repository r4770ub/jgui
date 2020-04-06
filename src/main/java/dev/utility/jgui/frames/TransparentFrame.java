package dev.utility.jgui.frames;

import java.awt.Color;

import javax.swing.JFrame;

public class TransparentFrame extends JFrame {
	
	
	public TransparentFrame()
	{
		setUndecorated(true);
		setBackground(new Color(1.0f,1.0f,1.0f,0.5f));

		setFocusable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    setVisible(true);
	    
	    setSize(1000,1800);
	}


}
