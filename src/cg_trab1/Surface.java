package cg_trab1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Surface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Surface s = new Surface();
		s.setTitle("Circle");
		s.setSize(500, 500);
		s.setVisible(true);

	}
	
	public void paint(Graphics g) {
		
		Circle circle = new Circle();
		circle.midPointCircle(100, 100, 30);
		
		ArrayList<Point> cPoints = circle.getCirclePoints();
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i=0; i < cPoints.size(); i++)
		{
			Point point = cPoints.get(i);
			g2d.drawLine(point.x, point.y, point.x, point.y);
		}
		
	}

}
