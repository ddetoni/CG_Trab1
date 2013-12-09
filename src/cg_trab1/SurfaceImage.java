package cg_trab1;

import java.awt.Color;
import java.awt.Shape;

public class SurfaceImage extends Surface {

	private static final long serialVersionUID = 1L;
	private static final int size = 100;
	Shape RectA, RectB = null;
	private static int radius = 0;
	private static int step = 0;
	private static int segmentation = 0;
	boolean decreasing = true;
	boolean last = false;
	
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
		
		SurfaceImage s = new SurfaceImage();
		s.setTitle("Circle");
		s.setBackground(Color.white);
		s.setSize(1200, 700);
		s.setVisible(true);

	}

}
