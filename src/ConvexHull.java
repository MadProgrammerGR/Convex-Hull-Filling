import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ConvexHull extends JFrame{
	
	ConvexHull(){
		setTitle("Convex Hull filling pattern");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);
	}
	
	protected Point[] generatePoints(int n){
		Random random = new Random();
		Point[] points = new Point[n];
		for(int i=0;i<points.length;i++){
			points[i] = new Point(random.nextInt(getWidth()), random.nextInt(getHeight()));
		}
		return points;
	}
	
	protected void showPoints(Point[] points, Graphics g){
		for(int i=0;i<points.length;i++){
			g.fillOval(points[i].x, points[i].y, 10,10);
		}
	}
	
	protected ArrayList<Point> makeConvexHull(Point[] vertices) {
		ArrayList<Point> sorted_vertices = new ArrayList<>();

		int left = 0;
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i].x < vertices[left].x) {
				left = i;
			}
		}
		
		int current = left, q;
		do {
			sorted_vertices.add(vertices[current]);
			q = (current + 1) % vertices.length;
			for (int i = 0; i < vertices.length; i++) {
				if (isRight(vertices[current], vertices[i], vertices[q])) q = i;
			}
			current = q;
		} while (current != left);
		sorted_vertices.add(sorted_vertices.get(0));
		
		return sorted_vertices;
	}
	
	private boolean isRight(Point p, Point q, Point r) {
		    return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y) < 0;
	}
	
	protected void showConvexHull(ArrayList<Point> vertices, Graphics g) {
		g.setColor(Color.GREEN);
		for(int i=0;i<vertices.size()-1;i++){
			Point start = vertices.get(i);
			Point end = vertices.get(i+1);
			g.fillOval(start.x, start.y, 10 ,10);
			g.fillOval(end.x, end.y, 10 ,10);
			g.drawLine(start.x+5, start.y+5, end.x+5, end.y+5);
			wait(500);
		}
	}
	
	public void wait(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
