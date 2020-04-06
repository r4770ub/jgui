package dev.utility.jgui.panels;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.utility.jgui.base.GUIConfigurations;
import dev.utility.jgui.labels.LabelCreator;



public class DataPanel extends JPanel
{
	
	private static final long serialVersionUID = 1L;

	JLabel timeDisplay; 
	JLabel frozenLabel; 
	JLabel delayLabel; 
	JLabel reverseLabel; 
	JLabel processingLabel; 
	JPanel processPanel;
	JPanel infoPanel;
	Boolean freeze=false; 
	long delay=0; 
	boolean reverse=false; 
	LabelCreator lc; 

	 
	static final String idleProcess = "No external Processes Running";
	static final String saveProcess = "External Process Executing: Saving images";
	static final String reprocessProcess = "External Process Executing: Reprocess Image Sizes ";
	static final String autoCrop = "Auto cropping and recombing image.... ";
	static final String manualCrop = "Manual cropping and  auto recombing image.... ";

	public DataPanel()
	{
	
	lc = new LabelCreator("Time: ",18);
	timeDisplay = lc.getLabel(); 
	
	lc = new LabelCreator("Pause: " +freeze,18);
	frozenLabel = lc.getLabel(); 
	
	
	lc = new LabelCreator("Delay: " +delay/1000 +"sec",18);
	delayLabel = lc.getLabel(); 
	
	lc = new LabelCreator("Reversed: "+ reverse,18);
	reverseLabel = lc.getLabel(); 
	
	lc = new LabelCreator(idleProcess,18);
	processingLabel = lc.getLabel(); 
	
	infoPanel = new JPanel();
	infoPanel.add(timeDisplay);
	infoPanel.add(Box.createHorizontalStrut(10));
	infoPanel.add(delayLabel);
	infoPanel.add(Box.createHorizontalStrut(10));
	infoPanel.add(frozenLabel);
	infoPanel.add(Box.createHorizontalStrut(10));
	infoPanel.add(reverseLabel);
	infoPanel.add(Box.createHorizontalStrut(10));
	infoPanel.add(processingLabel);

	infoPanel.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor));
	
	setLayout(new BorderLayout());
	add(infoPanel, BorderLayout.CENTER);
	
	
	}
	
}