package dev.utility.jgui.pagegenerator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import dev.utility.gui.gradiants.Gradiant;
import dev.utility.gui.gradiants.RadialGradiant;
import dev.utility.jbase.JHelper;
import dev.utility.jbase.constants.JConstants;
import dev.utility.jimage.DrawUtility;
import dev.utility.jimage.JImage;

public class GradiantDesign 
{
	
	
	
	//Page dimensions 
	public static boolean valid_image = true; 
	private static final int PAGE_WIDTH=850;
	private static final int PAGE_HEIGHT=1100; 

	//Font Constants
	private static final int TITLE_SIZE =70;  
	private static final int  SUBTITLE_SIZE=33; 
	private static final int DESC_SIZE=25; 
	private static  int STAMP_SIZE=10; 

	private static  Font STAMP_FONT;
	private static  Font DESC_FONT;
	private static  Font TITLE_FONT;
	private static  Font SUBTITLE_FONT;

	//y location for text 
	private static final int TITLE_LOCY=100; 
	private static final int SUBTITLE_LOCY=150;
	private static final int DESC1_LOC_Y=900;
	private static final int DESC2_LOC_Y=950;
	private static final int DESC3_LOC_Y=1000;
	private static final int DESC4_LOC_Y=1050;


	//border information
	private static final int INNERBORDER_THICKNESS=40; 
	private static final int OUTERBORDER_THICKNESS=10; 
	
	String OS_System = System.getProperty("os.name") +"   " +System.getProperty("os.arch");
	
	private JImage resultImage ;
	private JImage resultCoverImage; 
	public GradiantElement element; 
	boolean toStamp=true; 
	boolean hasImage;

   

    
    	
	public GradiantDesign(GradiantOptions options) throws IOException
	{
	     element= new GradiantElement(options); 
	     
		 toStamp= options.toStamp;
		
	
	}	
	public void  makeCoverpage() throws IOException
	{
		 DrawUtility drawer; 
		 JImage image = 		element.overlayImage;
		 GradiantColors colors =element.colors;;
	     DESC_FONT     = new Font(element.fontName, Font.PLAIN, DESC_SIZE);
		 TITLE_FONT     = new Font(element.fontName, Font.PLAIN, TITLE_SIZE);
		 SUBTITLE_FONT     = new Font(element.fontName, Font.ITALIC, SUBTITLE_SIZE);
		 STAMP_FONT     = new Font(element.fontName, Font.PLAIN, STAMP_SIZE);

		//create gradiant 
		 Gradiant radialImage= new RadialGradiant(PAGE_WIDTH,PAGE_HEIGHT, element.colors.getGradiantColor());
		 drawer=new DrawUtility(radialImage.getPanel());
		 //create overlay
		if(hasImage)
		{
		 if(valid_image)
			 drawer.drawOverlayImage(image,element.alpha);
		}
		 //draw borders 
		 Rectangle rect = new Rectangle(0,0,PAGE_WIDTH,PAGE_HEIGHT);
		 drawer.drawRectangle(rect,INNERBORDER_THICKNESS,  colors.getInnerBorderColor());
		 drawer.drawRectangle(rect,OUTERBORDER_THICKNESS,  colors.getOuterBorderColor());
		 drawer.drawCenterText(element.dataElements[0], TITLE_FONT, colors.getTextColor(), TITLE_LOCY);
		 drawer.drawCenterText(element.dataElements[1], SUBTITLE_FONT, colors.getTextColor(),SUBTITLE_LOCY);
		 drawer.drawCenterText(element.dataElements[2], DESC_FONT, colors.getTextColor(),DESC1_LOC_Y);
		 drawer.drawCenterText(element.dataElements[3], DESC_FONT, colors.getTextColor(),DESC2_LOC_Y);
	     drawer.drawCenterText(element.dataElements[4], DESC_FONT, colors.getTextColor(),DESC3_LOC_Y);
		 if(toStamp)
			 drawer.drawText(GradiantOptions.stamp_text, STAMP_FONT, Color.white,50,DESC4_LOC_Y);
		 resultCoverImage=drawer.getResultImage();
	}

	public JImage getResultPage ()
	{
		return resultCoverImage;
	}
	
	
	
	


}
