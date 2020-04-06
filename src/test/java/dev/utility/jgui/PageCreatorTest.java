package dev.utility.jgui;

import java.io.IOException;

import dev.utility.jgui.pagegenerator.PageGenerator;
import dev.utility.jgui.pagegenerator.GradiantDesign;
import dev.utility.jgui.pagegenerator.GradiantOptions;
import dev.utility.jimage.JImage;

public class PageCreatorTest {
	public static void main(String [] args) throws IOException
	{
		GradiantOptions options=new GradiantOptions();
		
		GradiantDesign t1 = new GradiantDesign(options);
		t1.makeCoverpage();
		JImage result= t1.getResultPage();
		result.writeJImageAsPNG("/home/r4770/Desktop/image.png");
		
		
	}

}
