package cg_trab1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class SurfaceImage extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int size = 100;
	Shape RectA, RectB = null;
	private static int radius = 0;
	private static int step = 0;
	boolean decreasing = true;
	boolean last = false;
	
	public static void main(String[] args) {
		
		try
		{
			step = Integer.parseInt(args[0]);
			radius = Integer.parseInt(args[1]);
			if(radius>200){
				radius=200;
			}
			if(step<=0){
				step= 1;
			}
		} catch(NumberFormatException nfe)
		{
			System.out.printf("Arguments is not a number.");
			System.exit(1);
		}
		
		SurfaceImage s = new SurfaceImage();
		s.setTitle("SurfaceImage");
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
			
		}
	}
	
	private BufferedImage loadImage(String filePath) {
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Não da pra carregar imagem.");
		}
		return image;
	}
	
	public void paint(Graphics g) {
		
		ArrayList<Point> points = this.calculateInfiniteSymbolPoints();
		Graphics2D g2d = (Graphics2D) g;
		
		String[] imgPaths = {"./images/1982_alemanha_breitner.jpg", "./images/1982_alemanha_rummenigge.jpg",
				"./images/1982_argentina_ardiles1.jpg", "./images/1982_argentina_maradona.jpg",
				"./images/1982_argentina_passarella.jpg", "./images/1982_austria_obermayer.jpg",
				"./images/1982_brasil_eder.jpg", "./images/1982_brasil_falcao.jpg", "./images/1982_brasil_junior.jpg",
				"./images/1982_brasil_leandro.jpg", "./images/1982_brasil_oscar.jpg", "./images/1982_brasil_socrates.jpg",
				"./images/1982_brasil_t-cerezo.jpg", "./images/1982_brasil_zico.jpg", "./images/1982_espanha_juanito.jpg",
				"./images/1982_franca_giresse.jpg"};
		
		//drawInfinity(g2d, points, true);
		int cImg = 0;
		BufferedImage image = loadImage(imgPaths[cImg]);
		
		int countStep = step;
		int octant = points.size()/16;
		Point last = new Point(0,0);
		int changeImg = octant;
		for(int i=0; i < points.size(); i++)
		{
			if(i == countStep)
			{
				clearWindow(g2d);
				g2d.drawImage(image, null, points.get(i).x, points.get(i).y);
				countStep += step;
				last.x = points.get(i).x;
				last.y = points.get(i).y;
			}
			
			if(i == changeImg)
			{
				image = loadImage(imgPaths[++cImg]);
				changeImg += octant ;
			}
			
			sustain(10);
		}
		
	}
	
	private void sustain(int time){
        if (time>0) {
            long t = System.currentTimeMillis();
            while (System.currentTimeMillis()-t<time);
        }
	}
	
	public static void clearWindow(Graphics2D g)
	{
	    g.setPaint(Color.white);
	    g.fill(new Rectangle(0,0,1200,700));
	    g.setPaint(Color.black);
	}

}
