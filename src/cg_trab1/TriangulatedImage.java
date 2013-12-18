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
                //1st doctor
                _2dpoints[4] = new Point2D.Double(70, 55);
                _2dpoints[5] = new Point2D.Double(90, 55);
                _2dpoints[7] = new Point2D.Double(81, 68);
                _2dpoints[8] = new Point2D.Double(70, 80);
                _2dpoints[9] = new Point2D.Double(90, 80);
                /*
                _2dpoints[4] = new Point2D.Double(70, 52);
                _2dpoints[5] = new Point2D.Double(90, 55);
                _2dpoints[7] = new Point2D.Double(81, 68);
                _2dpoints[8] = new Point2D.Double(70, 80);
                _2dpoints[9] = new Point2D.Double(90, 80);
                */
                break;
            case 1:
                //2nd doctor
                _2dpoints[4] = new Point2D.Double(60, 50);
                _2dpoints[5] = new Point2D.Double(80, 50);
                _2dpoints[7] = new Point2D.Double(70, 65);
                _2dpoints[8] = new Point2D.Double(60, 70);
                _2dpoints[9] = new Point2D.Double(80, 70);
                
                /*
                _2dpoints[4] = new Point2D.Double(58, 89);
                _2dpoints[5] = new Point2D.Double(98, 92);
                _2dpoints[7] = new Point2D.Double(75, 124);
                _2dpoints[8] = new Point2D.Double(55, 148);
                _2dpoints[9] = new Point2D.Double(97, 143);
                */
                break;
            case 2:
                //3rd doctor
                _2dpoints[4] = new Point2D.Double(85, 35);
                _2dpoints[5] = new Point2D.Double(90, 35);
                _2dpoints[7] = new Point2D.Double(80, 45);
                _2dpoints[8] = new Point2D.Double(75, 55);
                _2dpoints[9] = new Point2D.Double(85, 55);
                /*
                _2dpoints[4] = new Point2D.Double(46, 84);
                _2dpoints[5] = new Point2D.Double(81, 83);
                _2dpoints[7] = new Point2D.Double(55, 111);
                _2dpoints[8] = new Point2D.Double(45, 128);
                _2dpoints[9] = new Point2D.Double(81, 128);
                */
                break;
            case 3:
                //4th doctor
                _2dpoints[4] = new Point2D.Double(65, 55);
                _2dpoints[5] = new Point2D.Double(90, 55);
                _2dpoints[7] = new Point2D.Double(85, 65);
                _2dpoints[8] = new Point2D.Double(75, 65);
                _2dpoints[9] = new Point2D.Double(85, 65);
                /*
                _2dpoints[4] = new Point2D.Double(56, 90);
                _2dpoints[5] = new Point2D.Double(101, 88);
                _2dpoints[7] = new Point2D.Double(83, 113);
                _2dpoints[8] = new Point2D.Double(58, 136);
                _2dpoints[9] = new Point2D.Double(102, 133);
                */
                break;
            case 4:
                //5th doctor
                _2dpoints[4] = new Point2D.Double(50, 60);
                _2dpoints[5] = new Point2D.Double(80, 60);
                _2dpoints[7] = new Point2D.Double(70, 70);
                _2dpoints[8] = new Point2D.Double(60, 80);
                _2dpoints[9] = new Point2D.Double(75, 80);
                break;
            case 5:
                //6th doctor
                _2dpoints[4] = new Point2D.Double(60, 50);
                _2dpoints[5] = new Point2D.Double(80, 50);
                _2dpoints[7] = new Point2D.Double(70, 62);
                _2dpoints[8] = new Point2D.Double(60, 72);
                _2dpoints[9] = new Point2D.Double(80, 72);
                break;
            case 6:
                //7th doctor
                _2dpoints[4] = new Point2D.Double(60, 70);
                _2dpoints[5] = new Point2D.Double(100, 70);
                _2dpoints[7] = new Point2D.Double(80, 90);
                _2dpoints[8] = new Point2D.Double(65, 110);
                _2dpoints[9] = new Point2D.Double(90, 110);
                break;
            case 7:
                //8th doctor
                _2dpoints[4] = new Point2D.Double(92, 45);
                _2dpoints[5] = new Point2D.Double(110, 47);
                _2dpoints[7] = new Point2D.Double(103, 57);
                _2dpoints[8] = new Point2D.Double(86, 75);
                _2dpoints[9] = new Point2D.Double(110, 75); 
                break;
            case 8:
                //9th doctor
                _2dpoints[4] = new Point2D.Double(87, 89);
                _2dpoints[5] = new Point2D.Double(119, 84);
                _2dpoints[7] = new Point2D.Double(104, 109);
                _2dpoints[8] = new Point2D.Double(88, 123);
                _2dpoints[9] = new Point2D.Double(115, 119);
                break;
            case 9:
                //10th doctor
                _2dpoints[4] = new Point2D.Double(54, 63);
                _2dpoints[5] = new Point2D.Double(83, 58);
                _2dpoints[7] = new Point2D.Double(68, 72);
                _2dpoints[8] = new Point2D.Double(61, 82);
                _2dpoints[9] = new Point2D.Double(83, 80);
                break;
            case 10:
                //11th doctor
                _2dpoints[4] = new Point2D.Double(55, 56);
                _2dpoints[5] = new Point2D.Double(85, 57);
                _2dpoints[7] = new Point2D.Double(71, 72);
                _2dpoints[8] = new Point2D.Double(58, 83);
                _2dpoints[9] = new Point2D.Double(79, 83);
                break;
            case 11:
                //amy pond
            	_2dpoints[4] = new Point2D.Double(99, 77);
                _2dpoints[5] = new Point2D.Double(99, 80);
                _2dpoints[7] = new Point2D.Double(118, 94);
                _2dpoints[8] = new Point2D.Double(95, 99);
                _2dpoints[9] = new Point2D.Double(110, 99);
                break;
            case 12:
                //clara oswald
                _2dpoints[4] = new Point2D.Double(59, 45);
                _2dpoints[5] = new Point2D.Double(87, 43);
                _2dpoints[7] = new Point2D.Double(76, 59);
                _2dpoints[8] = new Point2D.Double(64, 71);
                _2dpoints[9] = new Point2D.Double(81, 69);
                break;
            case 13:
                //river song
                _2dpoints[4] = new Point2D.Double(59, 68);
                _2dpoints[5] = new Point2D.Double(85, 66);
                _2dpoints[7] = new Point2D.Double(76, 81);
                _2dpoints[8] = new Point2D.Double(60, 88);
                _2dpoints[9] = new Point2D.Double(86, 88);
                break;
            case 14:
                //rory pond
                _2dpoints[4] = new Point2D.Double(64, 53);
                _2dpoints[5] = new Point2D.Double(87, 49);
                _2dpoints[7] = new Point2D.Double(79, 68);
                _2dpoints[8] = new Point2D.Double(70, 71);
                _2dpoints[9] = new Point2D.Double(87, 70);
                break;
            case 15:
                //rory's dad
                _2dpoints[4] = new Point2D.Double(88, 57);
                _2dpoints[5] = new Point2D.Double(116, 55);
                _2dpoints[7] = new Point2D.Double(103, 73);
                _2dpoints[8] = new Point2D.Double(95, 80);
                _2dpoints[9] = new Point2D.Double(112, 80);
                break;
        }
        return _2dpoints;
    }

  public static double[] triangleCoordinates(Point2D v, Point2D[] triangle)
  {
	
    //The array for the three coefficients.
  	double[] result = new double[3];

  	//Some values that are needed to solve the system of linear equations for
  	//determining the coefficients.
    double d13x = triangle[0].getX() - triangle[2].getX();
    double d23x = triangle[1].getX() - triangle[2].getX();
    double dx3 =  v.getX()           - triangle[2].getX();
    double d13y = triangle[0].getY() - triangle[2].getY();
    double d23y = triangle[1].getY() - triangle[2].getY();
    double dy3 =  v.getY()           - triangle[2].getY();

    double delta = d13x*d23y - d23x*d13y;

    //When the three points are (almost) collinear, division by zero is avoided and
    //coefficients are returned which at least do not represent a convex combinaion.
    //Otherwise the coefficients cannot be computed.
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

  public static boolean isConvexCombination(double[] t)
  {
    boolean result;
    double sum;
    //According to round-off errors, the coefficients will almost never sum up to 1 exactly.
    //The following value specifies how much deviation from the exact value 1 is still considered
    //as a convex combination.
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

  public BufferedImage mixWith(TriangulatedImage ti, double alpha)
  {
    TriangulatedImage mix = new TriangulatedImage();

    //Here the interpolated image will be stored.
    mix.bi = new BufferedImage(this.bi.getWidth(),this.bi.getHeight(),
                                            BufferedImage.TYPE_INT_RGB);

    
    //Define the points for the triangulation points in the interpolated image as 
    //convex combinations of the corresponding points in the images to be  
    //interpolated.
    mix.tPoints = new Point2D[this.tPoints.length];
    for (int i=0; i<mix.tPoints.length; i++)
    {
      mix.tPoints[i] = new Point2D.Double((1-alpha)*this.tPoints[i].getX()
                                          + alpha*ti.tPoints[i].getX(),
                                          (1-alpha)*this.tPoints[i].getY()
                                          + alpha*ti.tPoints[i].getY());
    }

    //The triangles for the triangulation must be defined using the same points (indices) 
    //as in the original images.
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

    
    //Determine for each pixel in the interpolated image the colour as a 
    //convex combination of the RGB-values of the corresponding pixels in the
    //two images to be interpolated.
    for (int i=0; i<mix.bi.getWidth(); i++)
    {
      for (int j=0; j<mix.bi.getHeight(); j++)
      {
        //For this pixel the colour must be determined.
        pixel.setLocation(i,j);

        //tNo is used to compute the index of the triangle in which the 
        //considered pixel lies.
        tNo = 0;

        //When the triangle has been found, notFound changes to false.
        notFound = true;
        while(tNo<mix.triangles.length && notFound)
        {
        	
          //Determine the three points of the triangle no. tNo.
          for(int k=0; k<3; k++)
          {
            threePoints[k] = mix.tPoints[mix.triangles[tNo][k]];
          }

          //Determine the coordinates of the pixels w.r.t. to the triangle no. tNo.
          t = triangleCoordinates(pixel,threePoints);

          //Check whether the pixel lies inside the triangle.
          if (isConvexCombination(t))
          {
            notFound = false;
          }
          else
          {
            tNo++;
          }
        }//endWhile
        //The while-loop terminates when an index tNo of a triangle containing the
        //pixel has been found or when no triangle containing the pixel has been found.
        
        
        //If a triangle containing the pixel has been found, the colour for the pixel
        //can be computed.
        if (!notFound)
        {
          //Determine the x-coordinate of the pixel in the first image (this) as 
          //a convex combination of the vertices of the corresponding triangle.
          aux = 0;
          for (int k=0; k<3; k++)
          {
            aux = aux + t[k]*this.tPoints[this.triangles[tNo][k]].getX();
          }
          xInt = (int) Math.round(aux);
          
          //We have to make sure that round-off errors will not lead to a pixel
          //outside the image.
          xInt = Math.max(0,xInt);
          xInt = Math.min(this.bi.getWidth()-1,xInt);


          //The same for the y-coordinate.
          aux = 0;
          for (int k=0; k<3; k++)
          {
            aux = aux + t[k]*this.tPoints[this.triangles[tNo][k]].getY();
          }
          yInt = (int) Math.round(aux);
          yInt = Math.max(0,yInt);
          yInt = Math.min(this.bi.getHeight()-1,yInt);


          //Determine the colour of the pixel in the first image.
          rgbValueThis = this.bi.getRGB(xInt,yInt);
          thisColour = new Color(rgbValueThis);



          //Do the same as above for the second image ti.
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



          //Now that we have the two colours, we can compute their
          //convex combimation for the R-,G- and B-value.
          //Problems caused by round-off errors are quite unlikely here.
          rMix = (int) Math.round((1-alpha)*thisColour.getRed()+
                                        alpha*tiColour.getRed());

          gMix = (int) Math.round((1-alpha)*thisColour.getGreen()+
                                        alpha*tiColour.getGreen());

          bMix = (int) Math.round((1-alpha)*thisColour.getBlue()+
                                        alpha*tiColour.getBlue());


          //Generate the interpolated colour as a convex combination.
          pixelColour = new Color(rMix, gMix, bMix);

          //Use the interpolated colour to draw the pixel in the interpolated image
          mix.bi.setRGB(i,j,pixelColour.getRGB());

        }//endif (!notFound)

      }//endfor j
    }//endfor i

    return(mix.bi);
  }
}

