import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class GUI2 extends ConvexHull {
	final int TOTAL_POINTS = 10; //points both inside and outside of convex hull
	ArrayList<Point> vertices;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI2();
			}
		});
	}
	
	GUI2(){
		super();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		Point[] points = generatePoints(TOTAL_POINTS);
		showPoints(points, g);
		
		//calculate vertices that make the convex hull
		vertices = makeConvexHull(points);
		
		//show convex hull
		showConvexHull(vertices, g);
		
		//fill the convex hull
		g.setColor(Color.CYAN);
		for(float ratio=0;ratio<=1;ratio+=0.05f){	
			F(vertices.size() - 1, ratio, g);
		}
		
		System.exit(0);
	}
	
	// F(n) = L*F(n-1) - (1-L)*Xn
	private Point F(int n, float ratio, Graphics g) {
		if(n == 0) {
			return vertices.get(0);
		}else{
			Point xn = vertices.get(n);
			Point point = Point.add(Point.mul(F(--n, ratio, g), ratio), Point.mul(xn, 1- ratio));
			g.setColor(Color.getHSBColor(ratio, 1, 1));
			g.fillOval(point.x, point.y, 10, 10);
			wait(50);				
			return point;
		}
		
	}
	
}
