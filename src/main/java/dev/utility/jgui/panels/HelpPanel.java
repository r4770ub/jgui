package dev.utility.jgui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import dev.utility.jgui.base.GUIConfigurations;
import dev.utility.jgui.labels.LabelCreator;



public class HelpPanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	LabelCreator lc;
	String[][] options; 
	

	public void addData(Map<String,String> itemMap)
	{
		options = new String[itemMap.size()+1][2];
		int count = 0; 
		for(Map.Entry<String,String> entry : itemMap.entrySet())
		{
			String key = entry.getKey(); 
			String value = entry.getValue(); 
			options[count++][0] = key; 
			options[count++][1] =value; 
			setup(); 
	 
		}
	}
	public void addData(String[][] options)
	{
		this.options = options; 
		setup(); 
	}
	public  HelpPanel()
	{

	}
	
	public void setup()
	{
//		JLabel[][] labels = new JLabel[options.length][2];
//
//		lc = new LabelCreator("Program Options", 16); 
//		JLabel top = lc.getLabel(); 
//		top.setHorizontalAlignment(JLabel.CENTER);
//		top.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor));
//		top.setFont(new Font("Serif", Font.BOLD, 18));
//
//		
//
//		JPanel helpGrid = new JPanel(new GridLayout(options.length, 2));
//		for (int i = 0; i < options.length; i++) {
//			for (int j = 0; j < 2; j++) {
//				
//				lc = new LabelCreator(options[i][j],12);
//				
//				JLabel label = lc.getLabel();
//				label.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor));
//				label.setOpaque(true);
//				helpGrid.add(label);
//
//			}
//
//		}
//		JScrollPane buttonScroller = new JScrollPane(helpGrid);
//		buttonScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		setLayout(new BorderLayout());
//		add(top, BorderLayout.PAGE_START);
//		add(buttonScroller, BorderLayout.CENTER);
//		//setSize(300,DynamicViewer.imagePanel.getHeight());
	}
}

