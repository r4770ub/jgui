package dev.utility.jgui.layouts;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JPanel;

public class DefaultLayout extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DefaultLayout(boolean border)
	{
		super();
	}
	public void addComponent(Component component)
	{
		add(component);
	}
	
	public void addSpace(int space)
	{
		add(Box.createHorizontalStrut(space));
	}
	public JPanel getPanel()
	{
		return this;
	}

} 
