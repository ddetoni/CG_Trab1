package cg_trab1;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Graphics2D;

//Class that implements Circle methods.

public class Circle {
	
	private ArrayList<Point> circlePoints;
	
	public Circle(){
		this.circlePoints = new ArrayList<Point>();	
	}
	
	// Baseado daqui: http://rosettacode.org/wiki/Bitmap/Midpoint_circle_algorithm#Java
	public void midPointCircle(int centerX, int centerY, int radius) {
		
		int d = (5 - radius*4)/4;
		int x = 0;
		int y = radius;
		
		do {
			
			this.circlePoints.add(new Point(centerX + x, centerY + y));
			this.circlePoints.add(new Point(centerX + x, centerY - y));
			this.circlePoints.add(new Point(centerX - x, centerY + y));
			this.circlePoints.add(new Point(centerX - x, centerY - y));
			
			this.circlePoints.add(new Point(centerX + y, centerY + x));
			this.circlePoints.add(new Point(centerX + y, centerY - x));
			this.circlePoints.add(new Point(centerX - y, centerY + x));
			this.circlePoints.add(new Point(centerX - y, centerY - x));
			
			if (d<0) {
				d += 2*x + 1;
			} else {
				d += 2 * (x-y) + 1;
				y--;
			}
			x++;
			
		} while( x <= y);
		//System.out.printf(this.circlePoints.toString());
	}
	
	public ArrayList<Point> getCirclePoints() {
		
		return this.circlePoints;
		
	}
	
	
	/*
	public void drawnCircle(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i=0; i<this.circlePoints.size(); i++)
		{
			Point point = this.circlePoints.get(i);
			g2d.drawLine(point.x, point.y, point.x, point.y);
		}
	}
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i=0; i<this.circlePoints.size(); i++)
		{
			Point point = this.circlePoints.get(i);
			g2d.drawLine(point.x, point.y, point.x, point.y);
		}
		
	}
	*/
	
}
