package dev.utility.jgui.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import dev.utility.jfile.JFileSorter;
import dev.utility.jfile.JFileTools;
import dev.utility.jgui.base.GUIConfigurations;
import dev.utility.jimage.JImage;
import dev.utility.jimage.transforms.JImageTransform;
import dev.utility.jimage.transforms.base.Combine2Transform;
import dev.utility.jimage.transforms.base.ScaleTransform;


public class ImageScroller {

	// --------------------------Configurable Constants-----------------------
	final String inputDirectory = "/home/r4770/Pictures/inputs/";
	final String outputDirectory = "/home/r4770/Pictures/outputs/";
	final int START = 0;

	// ----------------------GUI Component Variables--------------------------

	// 1 to 1 enties
	JFrame mainWindow;
	JPanel mainPanel;

	// left panel
	JScrollPane buttonScrollPane;
	JPanel buttonGridPanel;

	// right panel
	JPanel confirmPanel;
 
	// bottom right panel
	JPanel buttonOptionPanel;
	JButton submitButton;
	JButton saveButton;

	// upper right panel
	JPanel labelHolder;
	JLabel oldLabel;
	JLabel newLabel;
	// ------------------------------------------------------------------------

	// ---------------------------Instance variables --------------------------
	String prefix;
	ButtonListener buttonListener;
	Combine2Transform combiner;
	ScaleTransform scaler; 
	Map<Integer, DataElement> imageMap;
	boolean executePriorityFlag;

	public static void main(String[] args) throws IOException, InterruptedException {

		ImageScroller scroller = new ImageScroller("раздел");
		scroller.parseData();
		scroller.createMainWindow();

	}

	public ImageScroller(String prefix) throws IOException, InterruptedException {

		this.prefix = prefix;
		this.imageMap = new HashMap<Integer, DataElement>();
		this.buttonListener = new ButtonListener();
		this.executePriorityFlag = false; 
	}
	
	public void parseData() throws IOException, InterruptedException
	{
		
		System.out.println("\nBack end process directory set up initiated");
		
		String cmd = "rm -rf " + outputDirectory;
		Process p = Runtime.getRuntime().exec(cmd);
		p.waitFor();
		p.destroy();
		System.out.println("Removed old directories");
		
	    cmd = "mkdir " + outputDirectory;
		p = Runtime.getRuntime().exec(cmd);
		p.waitFor();
		p.destroy();
		System.out.println("Created new directories"); 
		System.out.println("Back end process directory set up terminated\n");
  

		System.out.println("\nBack end process fileParsing initiated"); 
		JFileSorter sorter = JFileTools.getFileSorter(inputDirectory, JFileSorter.SORT_FILES_ALPHANUMERIC);
		String[] fileNames =sorter.getFileNames();
		Integer index = START;
		for (String fileName : fileNames) {
			
			File file = new File(fileName);
			System.out.println("Attemping to parse  file: " + file.getAbsolutePath());
			JImage bufferedImage = new JImage( ImageIO.read(file.getAbsoluteFile()));
			JButton button = new JButton(prefix + index);
			button.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor, 3));
			button.setHorizontalTextPosition(JButton.CENTER);
			button.setVerticalTextPosition(JButton.TOP);
			button.addActionListener(buttonListener);
			button.setHorizontalAlignment(JButton.CENTER);
			DataElement imageData = new DataElement(file, bufferedImage, button);
			imageData.button.setIcon(imageData.iconImage.getImageIcon());
			
			imageMap.put(index++, imageData);
			System.out.println("Sucessfully parsed file: " + file.getAbsolutePath());
		}
		System.out.println("Total files parsed: " + imageMap.size());
		System.out.println("Back end process fileParsing terminated\n"); 

	}


	public void createMainWindow() throws IOException {


		System.out.println("\nProcess creating user interfaced initiated");
		GUIConfigurations.setGrayConfigurations();

		buttonGridPanel = new JPanel();
		buttonGridPanel.setLayout(new GridLayout(imageMap.size(), 1));
		buttonGridPanel.setSize(300, 1000);
		
		for (int i = START; i < imageMap.size(); i++) {
			buttonGridPanel.add(imageMap.get(i).button);
			System.out.println("Embedded image on label : " + imageMap.get(i).file.getName());

		}
		buttonScrollPane = new JScrollPane(buttonGridPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		buttonScrollPane.setSize(300, 1000);
		buttonScrollPane.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor, 3));

		


		buttonOptionPanel = new JPanel(new BorderLayout());
		buttonOptionPanel.add(submitButton, BorderLayout.NORTH);
		buttonOptionPanel.add(saveButton, BorderLayout.CENTER);

		confirmPanel = new JPanel(new BorderLayout());
		confirmPanel.add(labelHolder, BorderLayout.CENTER);
		confirmPanel.add(buttonOptionPanel, BorderLayout.SOUTH);

		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(buttonScrollPane, BorderLayout.WEST);
		mainPanel.add(confirmPanel, BorderLayout.CENTER);

		mainWindow = new JFrame("File Prioritzer");
		mainWindow.add(mainPanel);
		mainWindow.setSize(1000, 1000);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
		
		System.out.println("Process creating user interfaced complete and running\n");


	}

	public class ButtonListener implements ActionListener {
		int oldLocation;
		int newLocation;
		
		public ButtonListener()
		{
			this.oldLocation = -1; 
			this.newLocation= -2; 
		}
		
		
		public void actionPerformed(ActionEvent e) {

			System.out.println("\nAction Event Detected");

			if (e.getSource() == submitButton) {
				System.out.println("Submit Button Selected");
				updateArray(oldLocation, newLocation);
			}
			if (e.getSource() == saveButton) {
				System.out.println("Save button Selected");
				saveData();
			}

			for (int i = START; i < imageMap.size(); i++) {

				if (e.getSource() == imageMap.get(i).button) {
					System.out.println("Image label selected: " +imageMap.get(i).file.getName()+","+ imageMap.get(i).location);
					setLabel(i);

	

				}

			}
			System.out.println("Action Event Completed\n");
		}

	}

	public void setLabel(int location)
	{
		System.out.println("Backup process set label initiated");
		if (!executePriorityFlag) {
			oldLabel.setIcon(imageMap.get(location).scaledImage.getImageIcon());
			buttonListener.oldLocation = location;
			executePriorityFlag = true;
			System.out.println("Set old location label");

		} else if (executePriorityFlag) {
			newLabel.setIcon(imageMap.get(location).scaledImage.getImageIcon());
			buttonListener.newLocation = location;
			executePriorityFlag = false;
			System.out.println("Set new location label");
		}
		System.out.println("Backup process set label terminated");

		
	}
	
	
	public void updateArray(int oldLocation, int newLocation)
	{
		//increasing pritory 
		if(oldLocation > newLocation)
		{
			int currentLocation= oldLocation; 
			int nextLocation= oldLocation-1;
			DataElement element = imageMap.get(oldLocation);
			for(int i = START; i <=  oldLocation - newLocation;i++)
			{
				swap(currentLocation, nextLocation);
				currentLocation = currentLocation -1; 
				nextLocation = nextLocation -1; 
			}
		}
		else if( newLocation > oldLocation)
		{
			int currentLocation = oldLocation;
			int nextLocation = oldLocation +1; 
			DataElement element = imageMap.get(oldLocation);
			for(int i = START; i <= newLocation - oldLocation ;i++)
			{
				swap(currentLocation, nextLocation);
				currentLocation = currentLocation +1; 
				nextLocation = nextLocation +1; 
			}
					
		}
	}
	public void swap(int oldLocation, int newLocation)  {
		
		System.out.println("Back End Swapping processing initiated");
		DataElement oldElement = imageMap.get(oldLocation);
		DataElement swapElement = imageMap.get(newLocation);
		oldElement.setLocation(newLocation);
		swapElement.setLocation(oldLocation); 
		imageMap.put(newLocation,oldElement);
		imageMap.put(oldLocation,swapElement);
		
		
		try 
		{
			mainWindow.setVisible(false);
		mainWindow.dispose();
		createMainWindow();
		
	
		}
		catch(IOException e)
		{
			System.out.println("Unable to create update GUI with new Data"); 
			System.exit(2);
		}
	}
	
	public void saveData()
	{
		System.out.println("Backend process saving image to disk initated");

		for (int i = START; i < imageMap.size(); i++) {

			try {
				JImage bufferedImage = imageMap.get(i).originalImage;
				ImageIO.write(bufferedImage.getBufferedImage(), "png", new File(outputDirectory + prefix + i + ".png"));
				System.out.println("Wrote image to disk: " + outputDirectory + prefix + i + ".png");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("Backend process saving image to disk terminated");
	}

	class DataElement {

		JImage originalImage;
		JImage iconImage;
		JImage scaledImage;

		File file;
		JButton button;
		private Integer location;

		public DataElement(File file, JImage originalImage, JButton button) throws IOException {

		

			this.file = file;
			this.originalImage = originalImage;
			            scaler= JImageTransform.getScaler(originalImage, ScaleTransform.SCALE_AUTO);
			this.iconImage = scaler.process(200, 200);

			if (this.originalImage.getWidth() > this.originalImage.getHeight())
				this.scaledImage = scaler.scaleByY( 400);
			else
				this.scaledImage = scaler.scaleByX(400);
			this.button = button;
			this.location = Integer.parseInt(file.getName().replaceAll("\\D+", ""));

		}

		public DataElement(DataElement copy) {
			this.file = copy.file;
			this.originalImage = copy.originalImage;
			this.button = copy.button;
			this.scaledImage = copy.scaledImage;
			this.location = copy.location;
		}

		public void setLocation(Integer newLocation) {
			String newFileName = this.file.getAbsolutePath();
			newFileName.replaceAll(location.toString(), newLocation.toString());
			this.file = new File(newFileName);
			this.location = newLocation;

		}

	}
}
