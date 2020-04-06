package dev.utility.jgui.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dev.utility.jgui.base.TextAreaCreator;
import dev.utility.jgui.labels.LabelCreator;
import dev.utility.jgui.layouts.DefaultLayout;
import dev.utility.jgui.layouts.RelativeLayout;



public class MetadataPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3848271928769316530L;
	LabelCreator lc;
	JPanel labelPanel; 
	JPanel codePanel; 
	JPanel datePanel; 
	JPanel locationPanel; 
	JPanel commentPanel; 
	JPanel infoPanel;
	
	private String label; 
	private String code;
	private String date;
	private String location; 
	private String comment; 
	 
	 
	public MetadataPanel() throws IOException
	{
		super();

		label ="<data>";
		code = "<code>";
		date = "<date>";
		location = "<location>";
		comment = "<comment>";
		
		DefaultLayout dl = new DefaultLayout(false);
		lc = new LabelCreator("Name: ", 12); 
		dl.add(lc.getLabel());
		lc = new LabelCreator(label, 12); 
		dl.add(lc.getLabel());
		labelPanel = dl.getPanel();
		
		
		 dl = new DefaultLayout(false);
		lc = new LabelCreator("Code: ", 12); 
		dl.add(lc.getLabel());
		lc = new LabelCreator(code, 12); 
		dl.add(lc.getLabel());
		codePanel = dl.getPanel(); 
		
		
		 dl = new DefaultLayout(false);
		lc = new LabelCreator("Location: ", 12); 
		dl.add(lc.getLabel());
		lc = new LabelCreator(location, 12); 
		dl.add(lc.getLabel());
		datePanel = dl.getPanel(); 
		
		
		 dl = new DefaultLayout(false);
		lc = new LabelCreator("Date: ", 12); 
		dl.add(lc.getLabel());
		lc = new LabelCreator(date, 12); 
		dl.add(lc.getLabel());
		locationPanel = dl.getPanel(); 

		dl = new DefaultLayout(true);
		dl.add(labelPanel);
		dl.add(codePanel); 
		dl.add(locationPanel); 
		dl.add(datePanel); 
		 infoPanel = dl.getPanel();

             
		 
		 TextAreaCreator tac = new TextAreaCreator("Description",12, comment,10,10,false);
		 tac.enableInputMethods(false);
		 tac.setEnabled(false);
		  commentPanel = tac.getPanel(); 
		  commentPanel.setEnabled(false);
		 
		 RelativeLayout rl = new RelativeLayout();
		 
		 this.setLayout(new BorderLayout());
		add(infoPanel,BorderLayout.NORTH);
		add(commentPanel,BorderLayout.CENTER); 
		setEnabled(false);
		setFocusable(false);
		
		
	}
}

