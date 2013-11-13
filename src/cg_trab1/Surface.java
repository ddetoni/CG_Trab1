package cg_trab1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Surface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int sleepTime = 20;
	private static final int step = 60;
	private static final int size = 50;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Surface s = new Surface();
		s.setTitle("Circle");
		s.setSize(900, 600);
		s.setVisible(true);

	}
	
	// Draw the infinite symbol with Octants
	public ArrayList<Point> calculateInfiniteSymbolPoints() {
		ArrayList<Point> infinitePoints = new ArrayList<Point>();
		
		Circle circleE = new Circle();
		circleE.midPointCircle(250, 280, 200);
		
		Circle circleD = new Circle();
		circleD.midPointCircle(650, 280, 200);
		
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
		int j = 0;
		int count = 0;
		boolean aux = false;
		while(j<infPoints.size()&&!aux){
			for(int i=0; i < infPoints.size(); i++)
			{
				Point point = infPoints.get(i);
				g2d.drawLine(point.x, point.y, point.x, point.y);
				/*
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					System.out.printf("Erro no Sleep.");
					e.printStackTrace();
				}*/
			}
			int auxStep = step;
			Point point;
			if(j*step>infPoints.size()){
				point = infPoints.get(infPoints.size()-1);
				aux = true;
			}else{
				point = infPoints.get(j*step);
			}
			
			Shape rec ;
			AffineTransform affine = new AffineTransform();
			if(count==0){
				rec = new Rectangle(point.x-((size-15)/2),point.y-((size-15)/2),size-15,size-15);
				affine.setToRotation(45,point.x,point.y);
				affine.rotate(45,point.x,point.y);
				count++;
			}else{
				rec = new Rectangle(point.x-(size/2),point.y-(size/2),size,size);
				affine.setToRotation(-45,point.x,point.y);
				affine.rotate(-45,point.x,point.y);
				count--;
			}
			if(j==0){
				g2d.draw(rec);
			}else{
				rec =  affine.createTransformedShape(rec);
				g2d.draw(rec);
			}
			
			try {
				Thread.sleep(sleepTime+100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j++;
			clearWindow(g2d);
		}
	}