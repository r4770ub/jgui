package dev.utility.jgui.labels;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.utility.jgui.base.GUIConfigurations;
import dev.utility.jimage.JImage;



public class LabelCreator extends JLabel {
 
	/**
	 * 
	 */ 
	private static final long serialVersionUID = -2493566510332034403L;
	public static boolean ADD_BORDER = false; 
	public static final int EFFECT_PLAIN = 0;
	  public static final int EFFECT_GRADIENT = 1;
	  protected int effectIndex = EFFECT_PLAIN;
	  protected double shearFactor = 0.0;
	  protected Color outlineColor;
	  ImageLabel imageLabel;
	  boolean isImage = false; 
	  protected Stroke stroke;
	  protected GradientPaint gradient;
	  protected Image foregroundImage;
  JPanel titleHolder; 



  Font font = new Font("Padauk", Font.BOLD, 36);
  public LabelCreator(String text)
  {
      super(text);
  

 
    }
public LabelCreator(String text, int size)
{
    super(text);
	
    setFont(new Font("Padauk", Font.BOLD, size));
    setOutlineColor(Color.black);
    setEffectIndex(LabelCreator.EFFECT_GRADIENT);
    GradientPaint gp = new GradientPaint(0, 0, Color.gray, 100, 50,GUIConfigurations.fontColor, true);
    setGradient(gp);
    initialize();




  }
public LabelCreator(String text, int size,Color color1,Color color2)
{
    super(text);

    setFont(new Font("Padauk", Font.BOLD, size));
    setOutlineColor(Color.black);
    setEffectIndex(LabelCreator.EFFECT_GRADIENT);
    GradientPaint gp = new GradientPaint(0, 0, color1, 100, 50,color2, true);
    setGradient(gp);
    initialize();
	
	
}

public LabelCreator(String text, int size, Color color1)
{
    super(text);
    setFont(new Font("Padauk", Font.BOLD, size));
    setOutlineColor(Color.black);
    setForeground(color1);
    initialize();

	
   
	
}

public LabelCreator(JImage jImage)
{
	imageLabel = new ImageLabel(jImage.getImageIcon()); 
	isImage = true;  
}
private void initialize()
{
	setHorizontalAlignment(JLabel.CENTER);
	setHorizontalTextPosition(JLabel.CENTER);
	setVerticalAlignment(JLabel.CENTER);
	setVerticalTextPosition(JLabel.CENTER);
    titleHolder = new JPanel(); 
    titleHolder.setLayout(new GridLayout(1,1));
    titleHolder.add(this); 
}




  public JPanel getPanel()
  {
	  if(ADD_BORDER)
		  titleHolder.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor));
	  
	  if(!isImage)
		   return titleHolder; 
	   else
		   return imageLabel.getPanel(); 
  }

  public JLabel getLabel()
  {
	  if(ADD_BORDER)
		  setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor));

	  if(!isImage)
		  return this; 
	  else
		  return imageLabel.getLabel(); 
  }
  public void setEffectIndex(int e) {
    effectIndex = e;
    repaint();
  }

  public int getEffectIndex() {
    return effectIndex;
  }

  public void setShearFactor(double s) {
    shearFactor = s;
    repaint();
  }

  public double getShearFactor() {
    return shearFactor;
  }

  public void setOutlineColor(Color c) {
    outlineColor = c;
    repaint();
  }

  public Color getOutlineColor() {
    return outlineColor;
  }

  public void setStroke(Stroke s) {
    stroke = s;
    repaint();
  }

  public Stroke getStroke() {
    return stroke;
  }


  public void setGradient(GradientPaint g) {
    gradient = g;
    repaint();
  }

  public GradientPaint getGradient() {
    return gradient;
  }

  public void setForegroundImage(Image img) {
    foregroundImage = img;
    repaint();
  }

  public Image getForegroundImage() {
    return foregroundImage;
  }


  public void paintComponent(Graphics g) {
    Dimension d = getSize();
    Insets ins = getInsets();
    int x = ins.left;
    int y = ins.top;
    int w = d.width - ins.left - ins.right;
    int h = d.height - ins.top - ins.bottom;

    if (isOpaque()) {
      g.setColor(getBackground());
      g.fillRect(0, 0, d.width, d.height);
    }
    paintBorder(g);

    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);

    FontRenderContext frc = g2.getFontRenderContext();
    TextLayout tl = new TextLayout(getText(), getFont(), frc);

    AffineTransform shear = AffineTransform.getShearInstance(shearFactor,
        0.0);
    Shape src = tl.getOutline(shear);
    Rectangle rText = src.getBounds();

    float xText = x - rText.x;
    switch (getHorizontalAlignment()) {
    case CENTER:
      xText = x + (w - rText.width) / 2;
      break;
    case RIGHT:
      xText = x + (w - rText.width);
      break;
    }
    float yText = y + h / 2 + tl.getAscent() / 4;

    AffineTransform shift = AffineTransform.getTranslateInstance(xText,
        yText);
    Shape shp = shift.createTransformedShape(src);

    if (outlineColor != null) {
      g2.setColor(outlineColor);
      if (stroke != null)
        g2.setStroke(stroke);
      g2.draw(shp);
    }

    switch (effectIndex) {
    case EFFECT_GRADIENT:
      if (gradient == null)
        break;
      g2.setPaint(gradient);
      g2.fill(shp);
      break;

    default:
      g2.setColor(getForeground());
      g2.fill(shp);
      break;
    }
  }
  
  public class ParagraphLabel extends JLabel
  {
	  public ParagraphLabel() 
	  {
		  
	  }
  }
  
  public class ImageLabel extends JLabel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -356214645483149764L;
		JPanel panel; 
		public ImageLabel(ImageIcon imageIcon)
		{
			super(imageIcon);
			this.setOpaque(true);
			this.setVerticalAlignment(JLabel.CENTER);
			this.setHorizontalAlignment(JLabel.CENTER);
			this.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
			panel = new JPanel(); 
			panel.add(this);
			
			
		}
		
		public JPanel getPanel()
		{
			return panel; 
		}
		
		public JLabel getLabel()
		{
			return this; 
		}


	}
    

  }