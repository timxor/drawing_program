import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Polygon extends Shape
{
	private ArrayList<Point> points;

	Polygon(String type, int shapeID, Color objectsColor, int radius, int x, int y)
	{
		super(type, shapeID, objectsColor, radius, x, y); // calling the constructor of the Shape class
		points = new ArrayList<Point>();
	}

	public void addPoint(Point p)
	{
		points.add(p);
	}

	public ArrayList<Point> getPoints()
	{
		return points;
	}

	public void draw(Graphics g)
	{
		// draw polygon vertices
		Graphics2D g2 = (Graphics2D) g;
		
		g.setColor(this.getColor());
		
		g2.setStroke(new BasicStroke(3));
		
		Point prev = points.get(0);
		
		for (int i = 1; i < points.size(); i++)
		{
			Point curr = points.get(i);
			g2.drawLine(prev.x, prev.y, curr.x, curr.y);
			prev = curr;
		}
		// connect last and first
		g2.drawLine(prev.x, prev.y, points.get(0).x, points.get(0).y);
	}

}