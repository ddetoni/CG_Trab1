package cg_trab1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class TriangulatedImage
{
	BufferedImage bi;
	Point2D[] tPoints;
	static int[][] triangles;
	
	public TriangulatedImage(int width, int height, String filePath, int index) {
		
		this.bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dt0 = this.bi.createGraphics();
        g2dt0.drawImage(new javax.swing.ImageIcon(filePath).getImage(), 0, 0, null);
        this.tPoints = this.imagePoints(index);
	}
	
	public TriangulatedImage(){}
	
	private Point2D[] imagePoints(int image) {
		Point2D[] _2dpoints = new Point2D[13];
        //posicoes do array
        _2dpoints[0] = new Point2D.Double(0, 0);//[0]canto superior esquerdo
        _2dpoints[1] = new Point2D.Double(75, 0);//[1]meio superior
        _2dpoints[2] = new Point2D.Double(150, 0);//[2]canto supedior direito
        _2dpoints[3] = new Point2D.Double(0, 100);//[3]meio esquerdo
        //[4]olho esquerdo
        //[5]olho direito
        _2dpoints[6] = new Point2D.Double(150, 100);//[6]meio direito
        //[7]nariz
        //[8]boca canto esquerdo
        //[9]boca canto direito
        _2dpoints[10] = new Point2D.Double(0, 200);//[10]canto inferior esquerdo
        _2dpoints[11] = new Point2D.Double(75, 200);//[11]meio inferior
        _2dpoints[12] = new Point2D.Double(150, 200);//[12]canto inferior direito
        
        switch (image) {
            case 0:
                _2dpoints[4] = new Point2D.Double(70, 55);
                _2dpoints[5] = new Point2D.Double(90, 55);
                _2dpoints[7] = new Point2D.Double(81, 68);
                _2dpoints[8] = new Point2D.Double(70, 80);
                _2dpoints[9] = new Point2D.Double(90, 80);
                break;
            case 1:
                _2dpoints[4] = new Point2D.Double(60, 50);
                _2dpoints[5] = new Point2D.Double(80, 50);
                _2dpoints[7] = new Point2D.Double(70, 65);
                _2dpoints[8] = new Point2D.Double(60, 70);
                _2dpoints[9] = new Point2D.Double(80, 70);
                break;
            case 2:
                _2dpoints[4] = new Point2D.Double(85, 35);
                _2dpoints[5] = new Point2D.Double(90, 35);
                _2dpoints[7] = new Point2D.Double(80, 45);
                _2dpoints[8] = new Point2D.Double(75, 55);
                _2dpoints[9] = new Point2D.Double(85, 55);
                break;
            case 3:
                _2dpoints[4] = new Point2D.Double(65, 55);
                _2dpoints[5] = new Point2D.Double(90, 55);
                _2dpoints[7] = new Point2D.Double(85, 65);
                _2dpoints[8] = new Point2D.Double(75, 65);
                _2dpoints[9] = new Point2D.Double(85, 65);
                break;
            case 4:
                _2dpoints[4] = new Point2D.Double(49, 63);
                _2dpoints[5] = new Point2D.Double(79, 58);
                _2dpoints[7] = new Point2D.Double(69, 70);
                _2dpoints[8] = new Point2D.Double(56, 78);
                _2dpoints[9] = new Point2D.Double(78, 75);
                break;
            case 5:
                _2dpoints[4] = new Point2D.Double(60, 50);
                _2dpoints[5] = new Point2D.Double(80, 50);
                _2dpoints[7] = new Point2D.Double(70, 62);
                _2dpoints[8] = new Point2D.Double(60, 72);
                _2dpoints[9] = new Point2D.Double(80, 72);
                break;
            case 6:
                _2dpoints[4] = new Point2D.Double(60, 70);
                _2dpoints[5] = new Point2D.Double(100, 70);
                _2dpoints[7] = new Point2D.Double(80, 90);
                _2dpoints[8] = new Point2D.Double(65, 110);
                _2dpoints[9] = new Point2D.Double(90, 110);
                break;
            case 7:
                _2dpoints[4] = new Point2D.Double(92, 45);
                _2dpoints[5] = new Point2D.Double(110, 47);
                _2dpoints[7] = new Point2D.Double(103, 57);
                _2dpoints[8] = new Point2D.Double(86, 75);
                _2dpoints[9] = new Point2D.Double(110, 75); 
                break;
            case 8:
                _2dpoints[4] = new Point2D.Double(87, 89);
                _2dpoints[5] = new Point2D.Double(119, 84);
                _2dpoints[7] = new Point2D.Double(104, 109);
                _2dpoints[8] = new Point2D.Double(88, 123);
                _2dpoints[9] = new Point2D.Double(115, 119);
                break;
            case 9:
                _2dpoints[4] = new Point2D.Double(54, 63);
                _2dpoints[5] = new Point2D.Double(83, 58);
                _2dpoints[7] = new Point2D.Double(68, 72);
                _2dpoints[8] = new Point2D.Double(61, 82);
                _2dpoints[9] = new Point2D.Double(83, 80);
                break;
            case 10:
                _2dpoints[4] = new Point2D.Double(55, 56);
                _2dpoints[5] = new Point2D.Double(85, 57);
                _2dpoints[7] = new Point2D.Double(71, 72);
                _2dpoints[8] = new Point2D.Double(58, 83);
                _2dpoints[9] = new Point2D.Double(79, 83);
                break;
            case 11:
            	_2dpoints[4] = new Point2D.Double(99, 77);
                _2dpoints[5] = new Point2D.Double(99, 80);
                _2dpoints[7] = new Point2D.Double(118, 94);
                _2dpoints[8] = new Point2D.Double(95, 99);
                _2dpoints[9] = new Point2D.Double(110, 99);
                break;
            case 12:
                _2dpoints[4] = new Point2D.Double(59, 45);
                _2dpoints[5] = new Point2D.Double(87, 43);
                _2dpoints[7] = new Point2D.Double(76, 59);
                _2dpoints[8] = new Point2D.Double(64, 71);
                _2dpoints[9] = new Point2D.Double(81, 69);
                break;
            case 13:
                _2dpoints[4] = new Point2D.Double(59, 68);
                _2dpoints[5] = new Point2D.Double(85, 66);
                _2dpoints[7] = new Point2D.Double(76, 81);
                _2dpoints[8] = new Point2D.Double(60, 88);
                _2dpoints[9] = new Point2D.Double(86, 88);
                break;
            case 14:
                _2dpoints[4] = new Point2D.Double(64, 53);
                _2dpoints[5] = new Point2D.Double(87, 49);
                _2dpoints[7] = new Point2D.Double(79, 68);
                _2dpoints[8] = new Point2D.Double(70, 71);
                _2dpoints[9] = new Point2D.Double(87, 70);
                break;
            case 15:
                _2dpoints[4] = new Point2D.Double(88, 57);
                _2dpoints[5] = new Point2D.Double(116, 55);
                _2dpoints[7] = new Point2D.Double(103, 73);
                _2dpoints[8] = new Point2D.Double(95, 80);
                _2dpoints[9] = new Point2D.Double(112, 80);
                break;
        }
        return _2dpoints;
    }

	public static double[] triangleCoordinates(Point2D v, Point2D[] triangle) {
		double[] result = new double[3];

	    double d13x = triangle[0].getX() - triangle[2].getX();
	    double d23x = triangle[1].getX() - triangle[2].getX();
	    double dx3 =  v.getX()           - triangle[2].getX();
	    double d13y = triangle[0].getY() - triangle[2].getY();
	    double d23y = triangle[1].getY() - triangle[2].getY();
	    double dy3 =  v.getY()           - triangle[2].getY();
	
	    double delta = d13x*d23y - d23x*d13y;

	    if (Math.abs(delta)<0.00000001)
	    {
	      result[0] = 10;
	    }
	    else
	    {
	      result[0] = (dx3*d23y - d23x*dy3)/delta;
	      result[1] = (d13x*dy3 - dx3*d13y)/delta;
	    }
	
	
	    result[2] = 1 - result[0] - result[1];
	
	    return(result);
	}

	public static boolean isConvexCombination(double[] t){
    
		boolean result;
		double sum;

		double tolerance = 0.000001;

		result = true;
		sum = 0;
		for (int i=0; i<t.length; i++)
		{
			if (t[i]<0 || t[i]>1) {result = false;}
			sum = sum + t[i];
		}
    
		if (Math.abs(sum-1)>tolerance) {result = false;}
    
		return(result);
	}

	public BufferedImage mixWith(TriangulatedImage ti, double alpha){
		TriangulatedImage mix = new TriangulatedImage();

		mix.bi = new BufferedImage(this.bi.getWidth(),this.bi.getHeight(),
                                            BufferedImage.TYPE_INT_RGB);

		mix.tPoints = new Point2D[this.tPoints.length];
		for (int i=0; i<mix.tPoints.length; i++)
		{
			mix.tPoints[i] = new Point2D.Double((1-alpha)*this.tPoints[i].getX()
                                          + alpha*ti.tPoints[i].getX(),
                                          (1-alpha)*this.tPoints[i].getY()
                                          + alpha*ti.tPoints[i].getY());
		}

		mix.triangles = this.triangles;

	    int rgbValueThis;
	    int rgbValueTi;
	    Color thisColour;
	    Color tiColour;
	    Color pixelColour;
	    int rMix;
	    int gMix;
	    int bMix;
	    int xInt;
	    int yInt;
	    double[] t = new double[3];
	    double aux;
	    Point2D[] threePoints = new Point2D[3];;
	    Point2D.Double pixel = new Point2D.Double();
	    int tNo;
	    boolean notFound;

	    for (int i=0; i<mix.bi.getWidth(); i++)
	    {
	    	for (int j=0; j<mix.bi.getHeight(); j++)
	    	{

	    		pixel.setLocation(i,j);

	    		tNo = 0;

	    		notFound = true;
	    		while(tNo<mix.triangles.length && notFound)
	    		{
	        	
	    			for(int k=0; k<3; k++)
	    			{
	    				threePoints[k] = mix.tPoints[mix.triangles[tNo][k]];
	    			}

	    			t = triangleCoordinates(pixel,threePoints);

	    			if (isConvexCombination(t))
	    			{
	    				notFound = false;
	    			}
	    			else
	    			{
	    				tNo++;
	    			}
	    		}
	        
	    		if (!notFound)
	    		{
	         
	    			aux = 0;
	    			for (int k=0; k<3; k++)
	    			{
	    				aux = aux + t[k]*this.tPoints[this.triangles[tNo][k]].getX();
	    			}
	    			xInt = (int) Math.round(aux);
	          
	    			xInt = Math.max(0,xInt);
	    			xInt = Math.min(this.bi.getWidth()-1,xInt);

	    			aux = 0;
	    			for (int k=0; k<3; k++)
	    			{
	    				aux = aux + t[k]*this.tPoints[this.triangles[tNo][k]].getY();
	    			}
	    			yInt = (int) Math.round(aux);
	    			yInt = Math.max(0,yInt);
	    			yInt = Math.min(this.bi.getHeight()-1,yInt);

	    			rgbValueThis = this.bi.getRGB(xInt,yInt);
	    			thisColour = new Color(rgbValueThis);

	    			aux = 0;
	    			for (int k=0; k<3; k++)
	    			{
	    				aux = aux + t[k]*ti.tPoints[ti.triangles[tNo][k]].getX();
	    			}
	    			xInt = (int) Math.round(aux);
	
	    			aux = 0;
	    			for (int k=0; k<3; k++)
	    			{
	    				aux = aux + t[k]*ti.tPoints[ti.triangles[tNo][k]].getY();
	    			}
	    			yInt = (int) Math.round(aux);
	
	    			rgbValueTi = ti.bi.getRGB(xInt,yInt);
	    			tiColour = new Color(rgbValueTi);

	    			rMix = (int) Math.round((1-alpha)*thisColour.getRed()+
	                                        alpha*tiColour.getRed());
	
	    			gMix = (int) Math.round((1-alpha)*thisColour.getGreen()+
	                                        alpha*tiColour.getGreen());
	
	    			bMix = (int) Math.round((1-alpha)*thisColour.getBlue()+
	                                        alpha*tiColour.getBlue());

	    			pixelColour = new Color(rMix, gMix, bMix);

	    			mix.bi.setRGB(i,j,pixelColour.getRGB());
	    		}
	    	}
	    }

	    return(mix.bi);
	}
}

