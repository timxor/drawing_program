//********************************************************************
//	Rectangle.java				Author: Tim C. Siwula
//
//	Represents that draws a rectangle.
//********************************************************************
import java.awt.Color;
import java.awt.Graphics;
public class Rectangle extends Shape
{	
	public Rectangle(String type, int shapeID, Color objectsColor, int radius, int x, int y)
	{
        super(type, shapeID, objectsColor, radius, x, y);
	}

	public void draw(Graphics page)
	{
		page.fillRect ( x-radius/2, y-radius/2, radius, radius);
	}
}
