package dev.utility.jgui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import dev.utility.jgui.base.GUIConfigurations;
import dev.utility.jgui.buttons.ButtonCreator;
import dev.utility.jgui.labels.LabelCreator;
import dev.utility.jimage.JImage;;


public class ImageCombinerPanel {

	// --------------------------Configurable Constants-----------------------
	final String inputDirectory = "/home/r4770/Desktop/inputs/";
	final String outputDirectory = "/home/r4770/Desktop/outputs/";
	final int START = 0;

	public static int counter =1; 
	// ----------------------GUI Component Variables--------------------------

	// 1 to 1 entities
	JFrame mainWindow;
	JPanel mainPanel;

	static int index = 0; 
	// left panel
	JScrollPane buttonScrollPane;
	JPanel buttonGridPanel;
 
	// right panel
	JPanel confirmPanel;

	// bottom right panel
	JPanel buttonOptionPanel;
	JButton submitButton;
	JButton saveButton;
	JImage imageH;
	JImage imageV;
	
	JLabel scrollLabel;
	JPanel scrollPanel;

	// upper right panel
	JPanel labelHolder;
	JLabel leftLabel;
	JLabel rightLabel;
	JPanel rightPanel; 
	JLabel rightImage; 
	JPanel leftPanel;
	JLabel leftImage; 
	JPanel imagePanel;

	
	
	
	public ImageCombinerPanel()throws IOException {


		System.out.println("\nProcess creating user interfaced initiated");
		GUIConfigurations.setGrayConfigurations();

		buttonGridPanel = new JPanel();
		//buttonGridPanel.setLayout(new GridLayout(imageMap.size(), 1));
		buttonGridPanel.setSize(300, 1000);
		
		//for (int i = START; i < imageMap.size(); i++) {
		//	buttonGridPanel.add(imageMap.get(i).button);
		//	System.out.println("Embedded image on label : " + imageMap.get(i).file.getName());

		//}
		
		
		LabelCreator lc = new LabelCreator("Image Options",19);
		 scrollLabel = lc.getLabel(); 
		
		 lc = new LabelCreator("Image Concatinator - x and y directions",25,Color.DARK_GRAY,Color.white); 
		 JPanel title = lc.getPanel(); 
		
		
		 
		buttonScrollPane = new JScrollPane(buttonGridPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		buttonScrollPane.setSize(300, 1000);
		buttonScrollPane.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor, 3));

		scrollPanel = new JPanel(new BorderLayout()); 
		scrollPanel.add(scrollLabel, BorderLayout.NORTH);
		scrollPanel.add(buttonScrollPane, BorderLayout.CENTER);
		
		 lc = new LabelCreator("Image One",19);
		leftLabel = lc.getLabel(); 
		leftLabel.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor, 3));
		
	    lc = new LabelCreator("Image Two",19);
		rightLabel = lc.getLabel(); 
		rightLabel.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor, 3));
		

		leftImage = new JLabel(); 
		leftImage.setIcon(new ImageIcon( new BufferedImage(400,400,BufferedImage.TYPE_INT_ARGB)));
		leftImage.setHorizontalAlignment(JLabel.CENTER);
		leftImage.setHorizontalTextPosition(JLabel.CENTER);
		leftImage.setVerticalAlignment(JLabel.CENTER);
		leftImage.setVerticalTextPosition(JLabel.CENTER);
		
		leftPanel = new JPanel(new BorderLayout()); 
		leftPanel.add(leftLabel,BorderLayout.NORTH);
		leftPanel.add(leftImage,BorderLayout.CENTER);
	
		
	    rightImage = new JLabel(); 
		rightImage.setIcon(new ImageIcon( new BufferedImage(400,400,BufferedImage.TYPE_INT_ARGB)));
		rightImage.setHorizontalAlignment(JLabel.CENTER);
		rightImage.setHorizontalTextPosition(JLabel.CENTER);
		rightImage.setVerticalAlignment(JLabel.CENTER);
		rightImage.setVerticalTextPosition(JLabel.CENTER);
		
		rightPanel = new JPanel(new BorderLayout()); 
		rightPanel.add(rightLabel,BorderLayout.NORTH);
		rightPanel.add(rightImage,BorderLayout.CENTER);
	
		ButtonCreator bc = new ButtonCreator("Combine Files");
		submitButton = bc.getButton();
	//	submitButton.addActionListener(buttonListener);
		
		 bc = new ButtonCreator("Save to disk");
		saveButton = bc.getButton();
	//	saveButton.addActionListener(buttonListener);

		buttonOptionPanel = new JPanel(new BorderLayout());
		buttonOptionPanel.add(submitButton, BorderLayout.NORTH);
		buttonOptionPanel.add(saveButton, BorderLayout.CENTER);

		confirmPanel = new JPanel(new BorderLayout());
		confirmPanel.add(buttonOptionPanel, BorderLayout.SOUTH);

		imagePanel = new JPanel();
		imagePanel.setLayout(new BoxLayout(imagePanel,BoxLayout.X_AXIS));
		imagePanel.add(leftPanel);
		imagePanel.add(scrollPanel);
		imagePanel.add(rightPanel);
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(imagePanel,BorderLayout.CENTER);
		mainPanel.add(confirmPanel, BorderLayout.SOUTH);
		mainPanel.add(title,BorderLayout.NORTH);
		mainWindow = new JFrame("Image Combiner ");
		mainWindow.add(mainPanel);
		mainWindow.setSize(1000, 1800);
		mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
		
		System.out.println("Process creating user interfaced complete and running\n");


	}

}
