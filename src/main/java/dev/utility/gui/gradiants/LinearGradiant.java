package dev.utility.gui.gradiants;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;

public class LinearGradiant extends Gradiant {

	public static final int HORIZONTAL_OPTION = 0;
	public static final int VERTICAL_OPTION = 1;
	private static final long serialVersionUID = -7873101039499823988L;

	private GradientPaint painter;
	private int optionType = 0;

	public LinearGradiant(int width, int height, Color[] colors, int OPTION) {
		super(width, height, colors);
		this.optionType = OPTION;
		setSize(width, height);

	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g.create();
		Point startPoint;
		Point endPoint;

		if (optionType == HORIZONTAL_OPTION) {
			startPoint = new Point(0, 0);
			endPoint = new Point(0, getHeight() / 2);
			painter = new GradientPaint(startPoint, Color.BLACK, endPoint, colors[0]);
			g2.setPaint(painter);
			g2.fillRect(0, 0, getWidth(), getHeight() / 2);

			startPoint = endPoint;
			endPoint = new Point(0, getHeight());
			painter = new GradientPaint(startPoint, colors[0], endPoint, Color.black);
			g2.setPaint(painter);
			g2.fillRect(0, getHeight() / 2, getWidth(), getHeight());
		} else if (optionType == VERTICAL_OPTION) {

			startPoint = new Point(0, 0);
			endPoint = new Point(getWidth() / 2, 0);
			painter = new GradientPaint(startPoint, Color.BLACK, endPoint, colors[0]);
			g2.setPaint(painter);
			g2.fillRect(0, 0, getWidth() / 2, getHeight());

			startPoint = endPoint;
			endPoint = new Point(getWidth(), 0);
			painter = new GradientPaint(startPoint, colors[0], endPoint, Color.black);
			g2.setPaint(painter);
			g2.fillRect(getWidth() / 2, 0, getWidth(), getHeight());

			g2.dispose();
		} else {
			try {
				throw new IOException("Invalid gradiant type");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public GradientPaint getPainter() {
		return painter;
	}

	public void setPainter(GradientPaint painter) {
		this.painter = painter;
	}

}