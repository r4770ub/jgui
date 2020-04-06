package dev.utility.jgui.pagegenerator;

import java.awt.Image;
import java.io.IOException;

import dev.utility.jbase.JHelper;
import dev.utility.jbase.constants.JConstants;
import dev.utility.jimage.JImage;

public class GradiantElement {
	public final static int TITLE_INDEX = 0;
	public final static int SUBTITLE_INDEX = 1;
	public final static int DESC1_INDEX = 2;
	public final static int DESC2_INDEX = 3;
	public final static int DESC3_INDEX = 4;

	String[] dataElements = new String[5];
	GradiantColors colors;
	boolean hasImage;
	boolean toStamp;
	JImage overlayImage;
	float alpha;
	String GradiantOption;
	String fontName;

	public GradiantElement(GradiantOptions options) throws IOException {
		this.dataElements[TITLE_INDEX] = options.TITLE;
		this.dataElements[SUBTITLE_INDEX] = options.SUBTITLE;
		this.dataElements[DESC1_INDEX] = options.DESC1;
		this.dataElements[DESC2_INDEX] = options.DESC2;
		this.dataElements[DESC3_INDEX] = options.DESC3;
		this.colors = new GradiantColors(options.colorChoice);
		this.toStamp=options.toStamp;
		this.fontName = options.fontname;
		this.hasImage=options.hasImage;


		if (hasImage) {
			try {
				this.overlayImage = (new JImage(JHelper.getImageURL(options.overLayImageURL)));
				this.alpha = alpha;
			} catch (NullPointerException e) {
				System.err.println("Error in reading overlay image");
				GradiantDesign.valid_image = false;
			}
		}

	}

}