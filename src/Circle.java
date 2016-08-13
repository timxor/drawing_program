//********************************************************************
//	Circle.java				Author: Tim C. Siwula
//
//	Represents a class that draws circle.
//********************************************************************
import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape
{	
       
	
	
	//----------------------------------------------------------------
	//	Constructor: Sets up this stroke type using the specified
	//	information.
	//----------------------------------------------------------------
	public Circle(String type, int shapeID, Color objectsColor, int radius, int x, int y)
    {
        super(type, shapeID, objectsColor, radius, x, y);
        
    }

	//----------------------------------------------------------------
    //	Draws the circle in the specified graphics context.
  	//----------------------------------------------------------------
    public void draw(Graphics page)
    {
    	page.setColor(Color.BLACK);
		page.fillOval ( x-radius, y-radius, 2*radius, 2*radius);
    }
}
