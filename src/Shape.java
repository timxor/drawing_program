//********************************************************************
//	Shape.java				Author: Tim C. Siwula
//
//	Demonstrates polymorphism via inheritance. Shape children inherit
//	shape instance variables and methods. i.e. circle, rectangle, polygon
//********************************************************************

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape 
{
	//----------------------------------------------------------------
	//	Class variables for all shape objects.
	//----------------------------------------------------------------
    protected Color color;
    protected int radius, x, y, shapeID;
    protected String type;
    
    public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	//----------------------------------------------------------------
    //	Constructor: Sets up this circle with the specified values.
  	//----------------------------------------------------------------
    public Shape(String type, int shapeID, Color objectsColor, int radius, int x, int y)
	{
    	this.type = type;
    	this.shapeID = shapeID;
    	this.radius = radius;
    	this.color = objectsColor;
    	this.x = x;
    	this.y = y;
	}
    
    //----------------------------------------------------------------
    //	Set the radius of an object.
  	//----------------------------------------------------------------
    public void setRadius (int rad)
    {
    	radius = rad;
    }
    
    //----------------------------------------------------------------
    //	Returns the objects radius size in type int.
  	//----------------------------------------------------------------
    public int getRadius()
    {
    	return radius;
    }
    
    //----------------------------------------------------------------
    //	Returns the objects color in type Color.
  	//----------------------------------------------------------------
    public Color getColor ()
    {
    	return color;
    }
    
    //----------------------------------------------------------------
    //	Set the shapes color.
  	//----------------------------------------------------------------
    public void setColor ( Color color)
    {
    	this.color = color;
    }
    
    //----------------------------------------------------------------
    //	Returns x.
  	//----------------------------------------------------------------
    public int getX()
    {
    	return x;
    }
    
    //----------------------------------------------------------------
    //	Returns y.
  	//----------------------------------------------------------------
    public int getY ()
    {
    	return y;
    }
    
    //----------------------------------------------------------------
    //	Sets x.
  	//----------------------------------------------------------------
    public void setX (int setX)
    {
    	x = setX;
    }
    
    //----------------------------------------------------------------
    //	Sets y.
  	//----------------------------------------------------------------
    public void setY (int setY)
    {
    	y = setY;
    }
    
    //----------------------------------------------------------------
    //	Abstract methods for each shape to draw its own style.
  	//----------------------------------------------------------------
    public abstract void draw( Graphics page );
}
