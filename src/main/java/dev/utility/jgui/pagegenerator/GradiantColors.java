package dev.utility.jgui.pagegenerator;

import java.awt.Color;

import dev.utility.gui.gradiants.JColor;

public class GradiantColors extends JColor
{
	


	private Color[] gradiantColor; 
	private Color backgroundColor; 
	private Color innerBorderColor; 
	private Color outerBorderColor; 
	private Color textColor; 
	
	
	public Color[] getGradiantColor() {
		return gradiantColor;
	}
	public void setGradiantColor(Color[] gradiantColor) {
		this.gradiantColor = gradiantColor;
	}
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public Color getInnerBorderColor() {
		return innerBorderColor;
	}
	public void setInnerBorderColor(Color innerBorderColor) {
		this.innerBorderColor = innerBorderColor;
	}
	public Color getOuterBorderColor() {
		return outerBorderColor;
	}
	public void setOuterBorderColor(Color outerBorderColor) {
		this.outerBorderColor = outerBorderColor;
	}
	public Color getTextColor() {
		return textColor;
	}
	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}



	
	public GradiantColors(String user_choice)
	{
		if(user_choice .contentEquals(PURPLE_CHOICE))
		{
			this.gradiantColor=GradiantColors.PURPLES;
			this.backgroundColor=GradiantColors.PURPLE_BACKGROUND;
			this.innerBorderColor = GradiantColors.PURPLE_INNER_BORDER;
			this.outerBorderColor=GradiantColors.PURPLE_OUTER_BORDER;
			this.textColor=GradiantColors.PURPLE_TEXT_COLOR;
					
		}
		
		if(user_choice .contentEquals(BLUE_CHOICE))
		{
			this.gradiantColor=GradiantColors.BLUES;
			this.backgroundColor=GradiantColors.BLUE_BACKGROUND;
			this.innerBorderColor = GradiantColors.BLUE_INNER_BORDER;
			this.outerBorderColor=GradiantColors.BLUE_OUTER_BORDER;
			this.textColor=GradiantColors.BLUE_TEXT_COLOR;
					
		}
		
		if(user_choice .contentEquals(GREEN_CHOICE))
			
		{
			this.gradiantColor=GradiantColors.GREENS;
			this.backgroundColor=GradiantColors.GREEN_BACKGROUND;
			this.innerBorderColor = GradiantColors.GREEN_INNER_BORDER;
			this.outerBorderColor=GradiantColors.GREEN_OUTER_BORDER;
			this.textColor=GradiantColors.GREEN_TEXT_COLOR;
					
		}
		if(user_choice .contentEquals(GRAY_CHOICE))
		{
			this.gradiantColor=GradiantColors.GRAYS;
			this.backgroundColor=GradiantColors.GRAY_BACKGROUND;
			this.innerBorderColor = GradiantColors.GRAY_INNER_BORDER;
			this.outerBorderColor=GradiantColors.GRAY_OUTER_BORDER;
			this.textColor=GradiantColors.GRAY_TEXT_COLOR;
					
		}
		if(user_choice .contentEquals(RED_CHOICE))
		{
			this.gradiantColor=GradiantColors.REDS;
			this.backgroundColor=GradiantColors.RED_BACKGROUND;
			this.innerBorderColor = GradiantColors.RED_INNER_BORDER;
			this.outerBorderColor=GradiantColors.RED_OUTER_BORDER;
			this.textColor=GradiantColors.RED_TEXT_COLOR;
					
		}
		if(user_choice .contentEquals(GOLD_CHOICE))
		{
			this.gradiantColor=GradiantColors.GOLDS;
			this.backgroundColor=GradiantColors.GOLD_BACKGROUND_LIGHT;
			this.innerBorderColor = GradiantColors.GOLD_INNER_BORDER;
			this.outerBorderColor=GradiantColors.GOLD_OUTER_BORDER;
			this.textColor=GradiantColors.GOLD_TEXT_COLOR;
					
		}
		
	}



	

	


	 
}
