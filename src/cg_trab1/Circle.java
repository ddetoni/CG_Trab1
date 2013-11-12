package cg_trab1;

import java.awt.Point;
import java.util.ArrayList;

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
	}
	
	public ArrayList<Point> getCirclePoints() {
		
		ArrayList<Point> sortedPoints = new ArrayList<Point>();
		int count = 0;
		int iterator = -8;
		int startIterator = 0;
		
		do {
			
			if (iterator >= this.circlePoints.size()-8)
			{
				iterator = startIterator++;
				count++;
			} else {
				iterator += 8;
			}
			
			sortedPoints.add(this.circlePoints.get(iterator));
			
		} while (count <= 8);
		
		return sortedPoints;
		
	}
	
}
