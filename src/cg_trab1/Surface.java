package cg_trab1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Surface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int size = 100;
	Shape RectA, RectB = null;
	private static int radius = 0;
	private static int step = 0;
	private static int segmentation = 0;
	boolean decreasing = true;
	boolean last = false;
	
	Surface(){
		addWindowListener(new MyFinishWindow());
	}
	
	/**
	 * params: step segmentation radius
	 */
	public static void main(String[] args) {
		
		try
		{
			step = Integer.parseInt(args[0]);
			segmentation = Integer.parseInt(args[1]);
			radius = Integer.parseInt(args[2]);
			if(radius>200){
				radius=200;
			}
			if(step<=0){
				step= 1;
			}
			if(segmentation<=0){
				segmentation=1;
			}
		} catch(NumberFormatException nfe)
		{
			System.out.printf("Arguments is not a number.");
			System.exit(1);
		}
		
		Surface s = new Surface();
		s.setTitle("Circle");
		s.setBackground(Color.white);
		s.setSize(1200, 700);
		s.setVisible(true);

	}
	
	// Draw the infinite symbol with Octants
	public ArrayList<Point> calculateInfiniteSymbolPoints() {
		ArrayList<Point> infinitePoints = new ArrayList<Point>();
		
		int centerX = radius + size;
		int centerY = radius + size;
		
		Circle circleE = new Circle();
		circleE.midPointCircle(centerX, centerY, radius);
		
		centerX = centerX + radius*2;
		
		Circle circleD = new Circle();
		circleD.midPointCircle(centerX, centerY, radius);
		
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
	
	public void drawInfinity(Graphics2D g2d,ArrayList<Point>points,boolean firstTime){
		for(int i=0; i < points.size(); i++)
		{
			Point point = points.get(i);
			g2d.drawLine(point.x, point.y, point.x, point.y);
			if(firstTime){
				sustain(1);
			}
			
		}
	}
	public void paint(Graphics g) {
		
		ArrayList<Point> points = this.calculateInfiniteSymbolPoints();
		
		Graphics2D g2d = (Graphics2D) g;
		
		//drawInfinity(g2d, points,true);
			
		Rectangle2D.Double smallRectangle = new Rectangle2D.Double(0, 0, 30, 30);
        Rectangle2D.Double bigRectangle = new Rectangle2D.Double(0, 0, 50, 50);
        AffineTransform trans;
        for (int i = 0; i < points.size(); i += points.size()/segmentation) {
            Point point = points.get(i);
            Point nextPoint;
            if (i + points.size()/segmentation >= points.size()) {
                nextPoint = points.get(0);
                last = true;
            } else {
                nextPoint = points.get(i + points.size()/segmentation);
            }
            double[] initialMatrix = matrixID();
            double[] finalMatrix = new double[6];
            Shape lastShape;
            if (decreasing&&!last) {
                bigRectangle.x = point.x - bigRectangle.height / 2.0;
                bigRectangle.y = point.y - bigRectangle.height / 2.0;
                trans = new AffineTransform();
                trans.translate(nextPoint.x - bigRectangle.x - bigRectangle.height / 2.0, nextPoint.y - bigRectangle.y - bigRectangle.height / 2.0);
                trans.concatenate(this.scalingWRTXY(bigRectangle.x + bigRectangle.height / 2.0, bigRectangle.y + bigRectangle.height / 2.0, 3.0 / 5.0, 3.0 / 5.0));
                trans.rotate(Math.toRadians(45), bigRectangle.x + bigRectangle.height / 2.0, bigRectangle.y + bigRectangle.height / 2.0);
                trans.getMatrix(finalMatrix);
                RectA = bigRectangle;
                RectB = trans.createTransformedShape(bigRectangle);
                smallRectangle = (Double) RectB.getBounds2D();
                lastShape = smallRectangle;
            } else {
            	 double smallMidx = smallRectangle.x + smallRectangle.height / 2.0;
                 double smallMidy = smallRectangle.y + smallRectangle.height / 2.0;
                 trans = new AffineTransform();
                 trans.translate(nextPoint.x - smallMidx, nextPoint.y - smallMidy);
                 trans.rotate(Math.toRadians(-45), smallMidx, smallMidy);
                 trans.concatenate(this.scalingWRTXY(smallMidx, smallMidy, 5.0 / 3.0, 5.0 / 3.0));
                 RectA = RectB;
                 RectB = trans.createTransformedShape(RectB).getBounds2D();
                 trans.getMatrix(finalMatrix);
                 lastShape = RectB;
            }
 
            for (int k = 0; k < step; k++) {
                AffineTransform intermediateTransform = new AffineTransform(convexCombination(initialMatrix, finalMatrix, k / (double) step));
                Shape inter = intermediateTransform.createTransformedShape(RectA);                
                
                //drawInfinity(g2d, points,false);
                clearWindow(g2d);
                g2d.fill(inter);
                
                sustain(20);
            }
            
            decreasing = !decreasing;
        }
        
        System.exit(0);
	}
	 private double[] matrixID() {
	        double[] matrix = new double[6];
	        matrix[0] = 1.0;
	        matrix[1] = 0.0;
	        matrix[2] = 0.0;
	        matrix[3] = 1.0;
	        matrix[4] = 0.0;
	        matrix[5] = 0.0;
	        return matrix;
	 }
	 private void sustain(int time){
	        if (time>0) {
	            long t = System.currentTimeMillis();
	            while (System.currentTimeMillis()-t<time);
	        }
	 }
	  
	  private AffineTransform scalingWRTXY(double x, double y, double xs, double ys) {
	        AffineTransform at = new AffineTransform();
	        at.translate(x, y);
	        at.scale(xs, ys);
	        at.translate(-x, -y);
	        return at;
	  }
	  
	  public static void clearWindow(Graphics2D g)
	  {
	    g.setPaint(Color.white);
	    g.fill(new Rectangle(0,0,1200,600));
	    g.setPaint(Color.black);
	  }
	  
	  private static double[] convexCombination(double[] a, double[] b, double alpha) {
	        double[] result = new double[6];

	        result[0] = (1 - alpha) * a[0] + alpha * b[0];
	        result[1] = (1 - alpha) * a[1] + alpha * b[1];
	        result[2] = (1 - alpha) * a[2] + alpha * b[2];
	        result[3] = (1 - alpha) * a[3] + alpha * b[3];
	        result[4] = (1 - alpha) * a[4] + alpha * b[4];
	        result[5] = (1 - alpha) * a[5] + alpha * b[5];

	        return result;
	  }
}