package dev.utility.jgui.base;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;


public class GUIConfigurations 
{

 

   	

	public static  Color fontColor = new Color(0,208,201);
	public static  Color bkColor =   new Color(20,20,20); 
	public static  Color borderColor = new Color(175,219,252);
	public static final boolean DEBUG_MODE = false;
	public static final int TITLE_SIZE = 12;
	public static final int REGULAR_SIZE =36;
	public static String fontName ="Paduak"; 
	  
 
	public static final Font PLAIN_SMALL_FONT  = new Font(fontName, Font.PLAIN, 12);
	public static final Font PLAIN_MEDIUM_FONT = new Font(fontName, Font.PLAIN, 16);
	public static final Font PLAIN_LARGE_FONT  = new Font(fontName, Font.PLAIN, 36);
	
	public static final Font BOLD_SMALL_FONT  = new Font(fontName, Font.BOLD, 12);
	public static final Font BOLD_MEDIUM_FONT = new Font(fontName, Font.BOLD, 16);
	public static final Font BOLD_LARGE_FONT  = new Font(fontName, Font.BOLD, 36);
	
	public static final Font ITALIC_SMALL_FONT  = new Font(fontName, Font.ITALIC, 12);
	public static final Font ITALIC_MEDIUM_FONT = new Font(fontName, Font.ITALIC, 16);
	public static final Font ITALIC_LARGE_FONT  = new Font(fontName, Font.ITALIC, 36);
	


   
	public static void setGrayConfigurations()
	{
		fontColor = Color.white;
		bkColor = Color.black;
		borderColor=Color.LIGHT_GRAY;
		setGUIConfiguations();
		
		
	}
	
	public static void setFontConfigurations()
	{
	
		
		
	}
	private static void setGUIConfiguations() 
	{
		    UIManager.put("Button.background",bkColor);
		    //UIManager.put("Button.darkShadow",null);
			UIManager.put("Button.disabledText",Color.DARK_GRAY);
			UIManager.put("Button.foreground",fontColor);
			UIManager.put("Button.highlight",Color.DARK_GRAY);
		//	UIManager.put("Button.light",null);
		UIManager.put("Button.select",Color.DARK_GRAY);
		//	UIManager.put("Button.shadow",null);
		   
			UIManager.put("CheckBox.background",bkColor);
			UIManager.put("CheckBox.border",borderColor);
			//UIManager.put("CheckBox.disabledText",null);
		   // UIManager.put("CheckBox.focusInputMap",null);
			//UIManager.put("CheckBox.font",null);
			UIManager.put("CheckBox.foreground",fontColor);
			//UIManager.put("CheckBox.icon",null);
			//UIManager.put("CheckBox.margin",null);
		 //   UIManager.put("CheckBox.select",null);
			//UIManager.put("CheckBox.textIconGap",null);
		//	UIManager.put("CheckBox.textShiftOffset",null);
					
		    UIManager.put("ComboBox.background",bkColor);
			UIManager.put("ComboBox.buttonBackground",bkColor);
			//UIManager.put("ComboBox.buttonDarkShadow",null);
			UIManager.put("ComboBox.buttonHighlight",borderColor);
			UIManager.put("ComboBox.buttonShadow",borderColor);
			//UIManager.put("ComboBox.disabledBackground",null);
			//UIManager.put("ComboBox.disabledForeground",null);
		    UIManager.put("ComboBox.foreground",fontColor);
		    UIManager.put("ComboBox.selectionBackground",bkColor);
		    UIManager.put("ComboBox.selectionForeground",borderColor);

			UIManager.put("Label.background",bkColor);
//			UIManager.put("Label.disabledForeground",null);
//			UIManager.put("Label.disabledShadow",null);
			UIManager.put("Label.foreground",fontColor);
		

			
			UIManager.put("OptionPane.background",bkColor);
			UIManager.put("OptionPane.foreground",fontColor);
			//UIManager.put("OptionPane.messageForeground",null);
			
			UIManager.put("Panel.background",bkColor);
			UIManager.put("Panel.foreground",fontColor);


			UIManager.put("ScrollBar.background",bkColor);
			UIManager.put("ScrollBar.foreground",fontColor);
			//UIManager.put("ScrollBar.thumb",null);
			//UIManager.put("ScrollBar.thumbDarkShadow",null);
			//UIManager.put("ScrollBar.thumbHighlight",null);
		   // UIManager.put("ScrollBar.thumbShadow",null);
		   // UIManager.put("ScrollBar.track",null);
			//UIManager.put("ScrollBar.trackHighlight",null);
			UIManager.put("ScrollPane.background",bkColor);
		    UIManager.put("ScrollPane.foreground",fontColor);
			

			UIManager.put("TextArea.background",bkColor);
			//UIManager.put("TextArea.caretForeground",null);
			UIManager.put("TextArea.foreground",fontColor);
			//UIManager.put("TextArea.inactiveBackground",null);
			//UIManager.put("TextArea.inactiveForeground",null);
			//UIManager.put("TextArea.selectionBackground",null);
			//UIManager.put("TextArea.selectionForeground",null);
			
			UIManager.put("TextField.background",bkColor);
			//UIManager.put("TextField.caretForeground",null);
			//UIManager.put("TextField.darkShadow",null);
			UIManager.put("TextField.foreground",fontColor);
			//UIManager.put("TextField.highlight",null);
			//UIManager.put("TextField.inactiveBackground",null);
			//UIManager.put("TextField.inactiveForeground",null);
			//UIManager.put("TextField.light",null);
			//UIManager.put("TextField.selectionBackground",null);
			//UIManager.put("TextField.selectionForeground",null);
			//UIManager.put("TextField.shadow",null);
			
			UIManager.put("TextPane.background",bkColor);
			//UIManager.put("TextPane.caretForeground",null);
			UIManager.put("TextPane.foreground",fontColor);
			//UIManager.put("TextPane.inactiveBackground",null);
			//UIManager.put("TextPane.inactiveForeground",null);
			//UIManager.put("TextPane.selectionBackground",null);
			UIManager.put("scrollbar",Color.GRAY);
		

		

	}

}