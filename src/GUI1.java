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
public class GUI1 extends ConvexHull {
	final int TOTAL_POINTS = 10; //points both inside and outside of convex hull
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI1();
			}
		});
	}
	
	GUI1(){
		super();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		Point[] points = generatePoints(TOTAL_POINTS);
		showPoints(points, g);
		
		//calculate vertices that make the convex hull
		ArrayList<Point> vertices = makeConvexHull(points);
		
		//show convex hull
		showConvexHull(vertices, g);
		
		//fill the convex hull
		fillConvexHull(vertices, g);
		
		System.exit(0);
	}
	
	//midpoint = ratio*x1 + (1-ratio)*x2
	private Point getPointBetween(Point start, Point end, float ratio) {
		return Point.add(Point.mul(start, ratio), Point.mul(end, 1-ratio));
	}
	
	private void fillConvexHull(ArrayList<Point> vertices, Graphics g) {
		g.setColor(Color.CYAN);
		Point driver = vertices.get(0);
		for(int i=1;i<vertices.size()-2;i++){ //for every side
			Point start = vertices.get(i);
			Point end = vertices.get(i+1);
			for(float ratio=0.1f;ratio<1;ratio+=0.1){ //for every point in the side	
				Point wallpoint = getPointBetween(start, end, ratio);
				for(float walk=0.01f;walk<1;walk+=0.01){
					Point point = getPointBetween(driver, wallpoint, walk);
					g.setColor(Color.getHSBColor(ratio, 1, 1));
					g.fillOval(point.x, point.y, 5, 5);
					wait(5);
				}
			}
		}
		
	}
	
}
