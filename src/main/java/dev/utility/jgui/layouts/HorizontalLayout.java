package dev.utility.jgui.layouts;


import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class HorizontalLayout extends JPanel {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9215455339906140131L;
	List<Component> components = new ArrayList<Component>();

	public HorizontalLayout()
	{
		super();
	}

	
	public void addPanel(JPanel component)
	{
		components.add(component);
	}
	
	public JPanel getPanel()
	{
		for(Component component: components)
		{
			this.add(component); 
		}
		return this; 
	}
}
