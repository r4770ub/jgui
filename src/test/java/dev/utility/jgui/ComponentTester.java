package dev.utility.jgui;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.utility.jgui.base.TextAreaCreator;
import dev.utility.jgui.base.TextFieldCreator;
import dev.utility.jgui.buttons.ButtonCreator;
import dev.utility.jgui.labels.LabelCreator;
import dev.utility.jgui.base.GUIConfigurations;
import dev.utility.jgui.layouts.RelativeLayout;


public class ComponentTester {

	
	JFrame window; 
	JButton submitButton; 
	JLabel aLabel; 
	JPanel textFieldInput; 
	JPanel textArea; 
	public static void main(String [] args) throws IOException
	{
		GUIConfigurations.setGrayConfigurations();
		new ComponentTester(); 
	}
	
	public ComponentTester() throws IOException
	{

		testButton(); 
	   testLabel();
		testTextFieldCreator(); 
		testTextAreaCreator() ;
		
		 
	}
	
	public void testButton()
	{
		ButtonCreator createButton = new ButtonCreator("Example Button" ,Color.gray); 
		JPanel submitPanel = createButton.getPanel(); 
		RelativeLayout relativeLayout = new RelativeLayout(); 
		relativeLayout.setCenter(submitPanel);
		display(relativeLayout.getPanel(),"button test"); 
	}
	
	public void testLabel() 
	{
		LabelCreator labelCreator =  new LabelCreator("Testing label creator", 36); 
		aLabel = labelCreator.getLabel();
		RelativeLayout relativeLayout = new RelativeLayout(); 
		relativeLayout.setCenter(aLabel);
		display(relativeLayout.getPanel(),"label test"); 
		
		
		
		
	}
	
	public void testTextFieldCreator()
	{
		TextFieldCreator textFieldCreator = new TextFieldCreator("vertical Text Box",18,34); 
		RelativeLayout absoluteLayput = new RelativeLayout(); 

		textFieldInput = textFieldCreator.getPanel(); 
		 
		absoluteLayput.setNorth(textFieldInput);

		 display(absoluteLayput.getPanel(),"text Field  test"); 
		
		
		
	
	}
	
	public void testTextAreaCreator() throws IOException 
	{
		
		TextAreaCreator textAreaCreator = new TextAreaCreator("A Text Area",16, ">",20,20,true); 
		textArea = textAreaCreator.getPanel();
		display(textArea,"text area"); 
		
		
		
	}
	public void display(JPanel panel, String message)
	{
		
	    window = new JFrame(message); 
		window.setSize(500,200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel); 
		window.setVisible(true); 
		
		
	}
}
