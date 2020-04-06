package dev.utility.jgui.base;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.utility.jgui.labels.LabelCreator;

public class CheckboxCreator extends JPanel{
	
	private static final long serialVersionUID = 6694868807509283522L;
	private JCheckBox checkbox; 
	private JLabel label; 
	
	
	public CheckboxCreator(String label)
	{
		super(); 
		
		LabelCreator labelCreator = new LabelCreator(label,16); 
		this.label = labelCreator.getLabel(); 
		this.checkbox = new JCheckBox(); 
		setLayout(new GridLayout(1,2));
		add(this.label);
		add(this.checkbox);
	}
	
	public JPanel getPanel()
	{
		return this;
	}
	 
	public JPanel getBorderPanel()
	{
		this.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor));
		return this; 
	}
	
	public JCheckBox getComboBox()
	{
		return this.checkbox; 
	}
	

	
}
