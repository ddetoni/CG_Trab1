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
	private static final int sleepTime = 20;
	
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
		
		Circle circleE = new Circle();
		circleE.midPointCircle(150, 250, 50);
		
		ArrayList<Point> cPoints = circleE.getCirclePoints();
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i=0; i < cPoints.size(); i++)
		{
			Point point = cPoints.get(i);
			g2d.drawLine(point.x, point.y, point.x, point.y);
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Circle circleD = new Circle();
		circleD.midPointCircle(250, 250, 50);
		
		cPoints = circleD.getCirclePoints();
		
		for(int i=0; i < cPoints.size(); i++)
		{
			Point point = cPoints.get(i);
			g2d.drawLine(point.x, point.y, point.x, point.y);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
