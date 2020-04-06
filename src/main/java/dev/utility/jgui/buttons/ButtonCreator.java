package dev.utility.jgui.buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import dev.utility.jgui.base.GUIConfigurations;




public  class ButtonCreator extends JButton{
  
	private static final long serialVersionUID = 7819516031940193383L;
	
	Color color1 = Color.GRAY; 
	Color color2 = Color.black; 
	JPanel buttonPanel; 
	ImageIcon icon;
	
	
	public void createRollOver()
	{



	
	}
	public  ButtonCreator(String text){
        
		super(text); 
		createRollOver();
         setHorizontalAlignment(JButton.CENTER);
         setVerticalAlignment(JButton.CENTER);
         setHorizontalTextPosition(JButton.CENTER);
         setVerticalTextPosition(JButton.CENTER);
         setForeground(Color.black);
         setPreferredSize(new Dimension(300,30));
         setContentAreaFilled(false);
         setFocusPainted(false);
         setRolloverEnabled(true);
         setBorder(BorderFactory.createLineBorder(Color.black));
      
        buttonPanel = new JPanel(); 
        buttonPanel.add(this); 
         repaint();
        
        
    }
	
	public  ButtonCreator(String text, Color color){
        
		super(text); 
		color1=color;
		createRollOver();
         setHorizontalAlignment(JButton.CENTER);
         setVerticalAlignment(JButton.CENTER);
         setHorizontalTextPosition(JButton.CENTER);
         setVerticalTextPosition(JButton.CENTER);
         setForeground(Color.black);
         setFocusPainted(false);
         setBorderPainted(false);
         setContentAreaFilled(false);
         setFocusPainted(false) ;
         setPreferredSize(new Dimension(300,30));
         setPreferredSize(new Dimension(300,30));


         setContentAreaFilled(false);
         setBorder(BorderFactory.createLineBorder(Color.black));
      
         buttonPanel = new JPanel(); 
        buttonPanel.add(this); 
         repaint();
        
        
    }
	
	

	
	public ButtonCreator(ImageIcon image)
	{
		super(image);
		color1 = Color.DARK_GRAY;

		setSize(100, 100);
		setOpaque(false);
		setContentAreaFilled(false);
		setHorizontalAlignment(JButton.CENTER);
	    setVerticalAlignment(JButton.CENTER);
	    setHorizontalTextPosition(JButton.CENTER);
	    setVerticalTextPosition(JButton.CENTER);
		setBorderPainted(false);
	    setFocusPainted(false);
		setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor));
	    buttonPanel = new JPanel(); 
		buttonPanel.add(this); 
		buttonPanel.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor));
		
		
	}
	

    public JButton getButton() 
    {
    	return this; 
    }
	public JPanel getPanel()
	{
		return buttonPanel; 
	}
	
      
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setPaint(new GradientPaint(
                new Point(0, 0), 
                color2, 
                new Point(0, getHeight()/3), 
                color1));
        g2.fillRect(0, 0, getWidth(), getHeight()/3);
        g2.setPaint(new GradientPaint(
                new Point(0, getHeight()/3), 
                color1, 
                new Point(0, getHeight()), 
                color2));
        g2.fillRect(0, getHeight()/3, getWidth(), getHeight());
        g2.dispose();

        super.paintComponent(g);
    }
}