
public class Point {
	int x,y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Point other){
		return x == other.x && y == other.y;
	}
	
	public static Point add(Point p1, Point p2){
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}
	
	public static Point sub(Point p1, Point p2){
		return new Point(p1.x - p2.x, p1.y - p2.y);
	}
	
	public static Point mul(Point p, float scale){
		return new Point((int)(p.x * scale), (int)(p.y * scale));
	}
	
	public Point copy(){
		return new Point(x,y);
	}
	
	public String toString(){
		return " ("+x+","+y+") ";
	}
	
}
