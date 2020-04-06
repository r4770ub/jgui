package dev.utility.jgui.layouts;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class VerticalLayout extends JPanel {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 6220081014293837067L;
	private List<Component> components;

	public VerticalLayout()
	{
		super();
			this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			components = new ArrayList<Component>();
	}
	
	public void addPanel(Component p)
	{
		components.add(p);
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
