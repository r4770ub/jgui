package dev.utility.jgui.pagegenerator;

import java.io.IOException;

import javax.imageio.ImageIO;

import dev.utility.jimage.JImage;

public class PageGenerator 
{

	JImage resultImage; 
	
	public static void main(String [] args) throws IOException
	{
		GradiantOptions options = new GradiantOptions();
		PageGenerator page  = new PageGenerator(options);
		JImage result= page.getResultImage();
		result.displayImage();
	}
	
	public PageGenerator(GradiantOptions options) throws IOException
	{
		GradiantDesign templete1= new GradiantDesign(options); 
		templete1.makeCoverpage();
		this.resultImage = templete1.getResultPage();
	
	} 
	
	public JImage getResultImage()
	{
		return resultImage;
	}
	
	
	
	
	
}
