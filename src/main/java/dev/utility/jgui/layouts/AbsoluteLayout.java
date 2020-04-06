package dev.utility.jgui.layouts;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class AbsoluteLayout extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4266640699894436924L;
    private List<Component> components;
	
	public AbsoluteLayout(int x, int y)
	{
    	components = new ArrayList<Component>(); 
		setLayout(new  GridLayout(x,y));
		
	}
	
	public void addPanel(Component component)
	{
		components.add(component); 
	}
	
	public JPanel getPanel()
	{
		
		for(Component component: components)
		{
			
			add(component); 
		}
		return this;
	}
	public void forget()
	{
		removeAll();
		components= null;

	}

}
