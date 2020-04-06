package dev.utility.jgui.base;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dev.utility.jgui.labels.LabelCreator;

public class TextFieldCreator  extends JTextField{
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -3820076511073159656L;
		LabelCreator label; 
		JTextField textField; 
		JPanel panel; 
		JPanel horizntalFieldPanel;
		
		public TextFieldCreator(String labelText,int size,int columns)
		{
			super(labelText);
			label = new LabelCreator(labelText,size); 
	 
			
	
		
		   add(label);
			add(Box.createHorizontalStrut(10));
			add(textField);
			
			
			
			
			
		}
		
		public JPanel getPanel()
		{
			return panel; 
		}
		

		
	
	}


