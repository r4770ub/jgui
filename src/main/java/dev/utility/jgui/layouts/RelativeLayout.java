package dev.utility.jgui.layouts;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

public class RelativeLayout extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4651539607895069232L;
	Component northPanel; 
	Component centerPanel; 
	Component southPanel;
	Component westPanel; 
	Component eastPanel; 
	
	JPanel resultPanel; 
	 
	
	
	
	public RelativeLayout() 
	{
		setLayout(new BorderLayout());
	}
	
	public void setNorth(Component component)
	{
		northPanel = component; 

	}
	public void setSouth(Component component)
	{
		southPanel = component; 

	}
	public void setCenter(Component component)
	{
		centerPanel = component; 

	}
	public void setEast(Component component)
	{
		eastPanel = component; 

	}
	public void setWest(Component component)
	{
		westPanel = component; 

	}
	public JPanel getPanel()
	{
		if(northPanel!=null)
			add(northPanel,BorderLayout.NORTH);
		
		if(southPanel!=null)
		add(southPanel,BorderLayout.SOUTH);
	
		if(eastPanel!=null)
			add(eastPanel,BorderLayout.EAST);
		
		if(westPanel!=null)
			add(westPanel,BorderLayout.WEST);
		
		if(centerPanel!=null)
			add(centerPanel,BorderLayout.CENTER);
		
		return this; 
	}

	public void forget()
	{
		eastPanel = null; 
		westPanel = null; 
		southPanel = null;
		centerPanel = null; 
		northPanel = null; 
	
	}


}
