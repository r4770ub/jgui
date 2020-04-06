package dev.utility.jgui.base;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.utility.jgui.labels.LabelCreator;


public class ComboBoxCreator extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6694868807509283522L;
	private JComboBox optionBox; 
	private JLabel label; 
	
	@SuppressWarnings("unchecked")
	public ComboBoxCreator(String label,String [] optionStrings)
	{
		super(); 
		
		LabelCreator labelCreator = new LabelCreator(label,16); 
		this.label = labelCreator.getLabel(); 
		this.optionBox = new JComboBox<String>(optionStrings); 
		setLayout(new GridLayout(1,2));
		add(this.label);
		add(optionBox);
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
	
	public JComboBox getComboBox()
	{
		return optionBox; 
	}

}
