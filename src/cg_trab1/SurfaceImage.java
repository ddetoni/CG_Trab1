package cg_trab1;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SurfaceImage {

	private static final long serialVersionUID = 1L;
	private BufferedImageDrawer buffid;
	private TriangulatedImage t[] = new TriangulatedImage[16];
    private BufferedImage cleaner;
    private ArrayList<Point> points;
    private int width=1000;
    private int height=1000;
	
	private static final int size = 50;
	private static int radius = 200;
	private static int steps = 5;
	
	public static void main(String[] args) {
		
		SurfaceImage surImage = new SurfaceImage();
		surImage.getAllOctantPoints();
		surImage.loadAllImages();
		surImage.run();
		
	}
	
	public SurfaceImage() {
		
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        this.buffid = new BufferedImageDrawer(bi, width,height);
        this.buffid.setTitle("Trab 2");
        
        this.points = new ArrayList<Point>();
		
	}
	
	public void getAllOctantPoints() {
		int centerX = radius + size;
		int centerY = radius + size;
		
		Circle circleE = new Circle();
		circleE.midPointCircle(centerX, centerY, radius);
		
		centerX = centerX + radius*2;
		
		Circle circleD = new Circle();
		circleD.midPointCircle(centerX, centerY, radius);
		
		this.points.add(circleE.getOctant(1, -1).get(0));
		this.points.add(circleE.getOctant(5, 1).get(0));
		
		this.points.add(circleD.getOctant(6, -1).get(0));
		this.points.add(circleD.getOctant(2, 1).get(0));
		this.points.add(circleD.getOctant(0, -1).get(0));
		this.points.add(circleD.getOctant(4, 1).get(0));
		this.points.add(circleD.getOctant(5, -1).get(0));
		this.points.add(circleD.getOctant(1, 1).get(0));
		this.points.add(circleD.getOctant(3, -1).get(0));
		this.points.add(circleD.getOctant(7, 1).get(0));
		
		this.points.add(circleE.getOctant(4, -1).get(0));
		this.points.add(circleE.getOctant(0, 1).get(0));
		this.points.add(circleE.getOctant(2, -1).get(0));
		this.points.add(circleE.getOctant(6, 1).get(0));
		this.points.add(circleE.getOctant(7, -1).get(0));
		this.points.add(circleE.getOctant(3, 1).get(0));
		
	}
	
	private void loadAllImages() {
		String[] imgPaths = {"./images/1982_alemanha_breitner.jpg", "./images/1982_alemanha_rummenigge.jpg",
				"./images/1982_argentina_ardiles1.jpg", "./images/1982_argentina_maradona.jpg",
				"./images/1982_argentina_passarella.jpg", "./images/1982_austria_obermayer.jpg",
				"./images/1982_brasil_eder.jpg", "./images/1982_brasil_falcao.jpg", "./images/1982_brasil_junior.jpg",
				"./images/1982_brasil_leandro.jpg", "./images/1982_brasil_oscar.jpg", "./images/1982_brasil_socrates.jpg",
				"./images/1982_brasil_t-cerezo.jpg", "./images/1982_brasil_zico.jpg", "./images/1982_espanha_juanito.jpg",
				"./images/1982_franca_giresse.jpg"};
		
		TriangulatedImage.triangles = this.trianglePoints();
		
		for(int i=0; i< imgPaths.length; i++)
		{
			t[i] = new TriangulatedImage(width, height, imgPaths[i], i);
		}

        this.cleaner = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	}
	
	private int[][] trianglePoints() {
        int[][] tri = new int[16][3];

        tri[0][0] = 0;
        tri[0][1] = 4;
        tri[0][2] = 3;

        tri[1][0] = 0;
        tri[1][1] = 1;
        tri[1][2] = 4;

        tri[2][0] = 1;
        tri[2][1] = 2;
        tri[2][2] = 5;

        tri[3][0] = 2;
        tri[3][1] = 5;
        tri[3][2] = 6;

        tri[4][0] = 6;
        tri[4][1] = 9;
        tri[4][2] = 12;

        tri[5][0] = 11;
        tri[5][1] = 9;
        tri[5][2] = 12;

        tri[6][0] = 8;
        tri[6][1] = 10;
        tri[6][2] = 11;

        tri[7][0] = 3;
        tri[7][1] = 8;
        tri[7][2] = 10;

        tri[8][0] = 3;
        tri[8][1] = 7;
        tri[8][2] = 8;

        tri[9][0] = 3;
        tri[9][1] = 4;
        tri[9][2] = 7;

        tri[10][0] = 1;
        tri[10][1] = 4;
        tri[10][2] = 7;

        tri[11][0] = 1;
        tri[11][1] = 5;
        tri[11][2] = 7;

        tri[12][0] = 5;
        tri[12][1] = 6;
        tri[12][2] = 7;

        tri[13][0] = 9;
        tri[13][1] = 6;
        tri[13][2] = 7;

        tri[14][0] = 7;
        tri[14][1] = 9;
        tri[14][2] = 11;

        tri[15][0] = 7;
        tri[15][1] = 8;
        tri[15][2] = 11;

        return tri;
    }
	
	public void run() {
		
		Point pointA, pointB;
        
        for(int i=0; i<t.length-1; i++)
        {
        	pointA = this.points.get(i);
        	pointB = this.points.get(i+1); 	
        	
        	for (int j = 0; j < steps; j++) 
        	{
                double alpha = (double) j / steps;

                int pointX = (int) ((1 - alpha) * pointA.x + alpha * pointB.x);
                int pointY = (int) ((1 - alpha) * pointA.y + alpha * pointB.y);
                
                buffid.g2dbi.drawImage(t[i].mixWith(t[i+1], alpha), pointX, pointY, null);
                buffid.repaint();
                
        	}
        }	
	}
}
