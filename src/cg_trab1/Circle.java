package cg_trab1;

import java.awt.Point;
import java.util.ArrayList;

//Class that implements Circle methods.
public class Circle {
	
	private ArrayList<Point> circlePoints;
	
	public Circle(){
		this.circlePoints = new ArrayList<Point>();	
	}
	
	// Based: http://rosettacode.org/wiki/Bitmap/Midpoint_circle_algorithm#Java
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
	
	// Return the selected octant.
	// Way means: 1=normal-way, -1=inverted-way
	// Normal-way means: Way used by de Middle Point Circle Algorithm
	public ArrayList<Point> getOctant(int numOctant, int way){
		
		ArrayList<Point> octant = new ArrayList<Point>();
		
		
		if ( way == 1) {
			
			int index = this.circlePoints.size()-(8 - numOctant);
			
			for(int i=0; i < (this.circlePoints.size()/8); i++)
			{
				octant.add(this.circlePoints.get(index));
				index -= 8 ;
			}
			
		} else {
			int index = numOctant;
			
			for(int i=0; i < (this.circlePoints.size()/8); i++)
			{
				octant.add(this.circlePoints.get(index));
				index += 8 ;
			}
			
		}
		
		return octant;
	}	
}
