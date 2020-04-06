package dev.utility.jgui.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import dev.utility.jgui.labels.LabelCreator;


public class TextAreaCreator extends JPanel {

	private static final long serialVersionUID = 8489771508367191306L;
	LabelCreator label;
	protected JTextArea textArea;
	JPanel areaPanel;
	JScrollPane textAreaScroller;
	PrintStream consoleStream;

	Boolean divertOutput;

	private String labelName;
	private int labelSize;
	private String description;
	private int x;
	private int y;
	private boolean readOnly;

	public TextAreaCreator(String labelName, String description, int x, int y, boolean readOnly) throws IOException {
		super(new BorderLayout());
		this.labelName = labelName;
		this.description = description;
		this.x = x;
		this.y = y;
		this.labelSize = 20;
		this.readOnly = readOnly;
		initialize();
		;

	}

	public TextAreaCreator(String labelName, int labelSize, String description, int x, int y, boolean readOnly)
			throws IOException {
		super(new BorderLayout());
		this.labelName = labelName;
		this.description = description;
		this.x = x;
		this.y = y;
		this.labelSize = labelSize;
		initialize();
		;

	}

	public void initialize() throws IOException {

		label = new LabelCreator(labelName, labelSize);

		textArea = new JTextArea(x, y) {

		
			@Override
			protected void paintComponent(Graphics g) {
				Paint paint = new GradientPaint(0, 0, GUIConfigurations.bkColor, 0, getHeight(), Color.DARK_GRAY,
						true); 
				((Graphics2D) g).setPaint(paint);
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};

		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		textArea.setSize(x, y);
		textArea.setOpaque(false);
		textArea.setText(description);
		textArea.setEditable(readOnly);
		textArea.setForeground(GUIConfigurations.fontColor);
		if (readOnly)
			textArea.setEnabled(false);
		else
			textArea.setEnabled(true);

		textArea.setBorder(BorderFactory.createLineBorder(GUIConfigurations.borderColor, 2));
		textAreaScroller = new JScrollPane(textArea);
		textAreaScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textAreaScroller.setBackground(Color.darkGray);
		textAreaScroller.setSize(x, y);

		new BorderLayout();
		add(label, BorderLayout.NORTH);
		add(textAreaScroller, BorderLayout.CENTER);

	}

	public JPanel getPanel() {
		return this;
	}

}
