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
	private static final int sleepTime = 5;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Surface s = new Surface();
		s.setTitle("Circle");
		s.setSize(500, 500);
		s.setVisible(true);

	}
	
	// Draw the infinite symbol with Octants
	public ArrayList<Point> calculateInfiniteSymbolPoints() {
		ArrayList<Point> infinitePoints = new ArrayList<Point>();
		
		Circle circleE = new Circle();
		circleE.midPointCircle(150, 250, 50);
		
		Circle circleD = new Circle();
		circleD.midPointCircle(250, 250, 50);
		
		infinitePoints.addAll(circleE.getOctant(1, -1));
		infinitePoints.addAll(circleE.getOctant(5, 1));
		
		infinitePoints.addAll(circleD.getOctant(6, -1));
		infinitePoints.addAll(circleD.getOctant(2, 1));
		infinitePoints.addAll(circleD.getOctant(0, -1));
		infinitePoints.addAll(circleD.getOctant(4, 1));
		infinitePoints.addAll(circleD.getOctant(5, -1));
		infinitePoints.addAll(circleD.getOctant(1, 1));
		infinitePoints.addAll(circleD.getOctant(3, -1));
		infinitePoints.addAll(circleD.getOctant(7, 1));
		
		infinitePoints.addAll(circleE.getOctant(4, -1));
		infinitePoints.addAll(circleE.getOctant(0, 1));
		infinitePoints.addAll(circleE.getOctant(2, -1));
		infinitePoints.addAll(circleE.getOctant(6, 1));
		infinitePoints.addAll(circleE.getOctant(7, -1));
		infinitePoints.addAll(circleE.getOctant(3, 1));
		
		return infinitePoints;
		
	}
	
	
	public void paint(Graphics g) {
		
		ArrayList<Point> infPoints = this.calculateInfiniteSymbolPoints();
		
		Graphics2D g2d = (Graphics2D) g;
		
		for(int i=0; i < infPoints.size(); i++)
		{
			Point point = infPoints.get(i);
			g2d.drawLine(point.x, point.y, point.x, point.y);
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				System.out.printf("Erro no Sleep.");
				e.printStackTrace();
			}
		}
		
	}

}
