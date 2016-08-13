//********************************************************************
//	DrawingPanel.java				Author: Tim C. Siwula
//
//	Paints to screen.
//********************************************************************
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel
{
	private int mode, x, y;
	public int numberOfShapes = 0;
	public int numberOfCircles = 0;
	public int numberOfRectangles = 0;
	public int numberOfPolygons = 0;
	public int shapeID = 0;
	private Polygon polygonObj = new Polygon("polygon", shapeID, getObjectsColor(), 10, x, y);
	private Color objectsColor;
	private Circle circleObj;
	private Rectangle rectangleObj;
	private JLabel statusBar1;
	// private Point[] points = new Point[10000];
	public int redValue, greenValue, blueValue;

	public int getBlueValue()
	{
		return blueValue;
	}

	public void setBlueValue(int blueValue)
	{
		this.blueValue = blueValue;
	}

	public int getGreenValue()
	{
		return greenValue;
	}

	public void setGreenValue(int greenValue)
	{
		this.greenValue = greenValue;
	}

	public int getRedValue()
	{
		return redValue;
	}

	public void setRedValue(int redValue)
	{
		this.redValue = redValue;
	}

	// ----------------------------------------------------------------
	// Constructor: Sets up the paint panel as a yellow background.
	// ----------------------------------------------------------------
	public DrawingPanel()
	{
		shapes = new ArrayList<Shape>();
		MouseHandler listener = new MouseHandler();
		addMouseMotionListener(listener);
		addMouseListener(listener);
		setPreferredSize(new Dimension(750, 600));
		statusBar1 = new JLabel("Mouse outside the panel");
		add(statusBar1, BorderLayout.NORTH);
		
	}

	private static final long serialVersionUID = 1L;
	private static ArrayList<Shape> shapes;

	// getter for shapes
	public static ArrayList<Shape> getShapes()
	{
		return shapes;
	}

	// setter for shapes
	public void setShapes(ArrayList<Shape> shapes)
	{
		DrawingPanel.shapes = shapes;
	}

	// -----------------------------------------------------------------
	// Draws all of the dots stored in the list.
	// -----------------------------------------------------------------
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		 page.setColor( new Color( getRedValue(), getBlueValue(), getGreenValue() ) );
		for (Shape s : shapes)
		{
			s.draw(page);
		}
	}

	// ----------------------------------------------------------------
	// Method call to update the mode via button listeners in
	// ButtonPanel.java
	// ----------------------------------------------------------------
	public void setMode(int i)
	{
		this.mode = i;

		if (i == 4)
		{
			shapes = new ArrayList<Shape>();
			repaint();
		} 
		else if (i == 5)
		{
			Load load = new Load();
			shapes = load.loadFile();
			System.out.println("shapes = " + shapes);
			repaint();

		} 
		else if (i == 6)
		{
			Save.saveFile();
//			shapes = new ArrayList<Shape>();
			repaint();
		}
	}

	// **************************************************************************************************************************
	// Now starting MouseListener event handlers
	//
	// handle event when mouse released immediately after press
	// **************************************************************************************************************************
	class MouseHandler implements MouseListener, MouseMotionListener
	{
		// --------------------------------------------------------------
		// Now starting MouseListener event handlers
		// handle event when mouse released immediately after press.
		// -------------------------------------------------------------
		public void mouseClicked(MouseEvent event)
		{
			// int xPos = event.getX();
			// int yPos = event.getY();

			// details = String.format("Clicked %d times",
			// event.getClickCount());
//			
//			event.isShiftDown()
//			
//			if (event.isMetaDown() ) // right mouse click
//			// details += " with right mouse button";
//			 else if (event.isAltDown() ) //middle mouse click
//			// details += " with center mouse button";
//			else //left mouse click
//			// details += " with left mouse button at " + xPos;
			//
			// statusBar1.setText( details + " @ [" + xPos + "] & [" + yPos +
			// "]." );
			//
			
			x = event.getPoint().x;
			y = event.getPoint().y;
			Point pointForPolygon = event.getPoint();
			
			
			
			
			if (mode == 0)
			{
				//circleObj = new Circle("circle", shapeID, getObjectsColor(), 10, x, y);
				circleObj = new Circle("circle", shapeID, Color.black, 20, x, y);

				shapes.add(circleObj);
				repaint();
				numberOfCircles++;
				shapeID++;

				// Debugging
				System.out.println("Mode # " + mode);
				System.out.println("Click # " + (numberOfShapes));
				System.out.println("Circle # " + (numberOfCircles));
			}

			else if (mode == 1)
			{
				rectangleObj = new Rectangle("rectangle", shapeID, getObjectsColor(), 30, x, y);
				shapes.add(rectangleObj);
				repaint();
				numberOfRectangles++;
				shapeID++;

				// Debugging
				System.out.println("Mode # " + mode);
				System.out.println("Click # " + (numberOfShapes));
				System.out.println("ShapeID # " + shapeID);
				System.out.println("Rectangle # " + (numberOfRectangles));
			}

			else if (mode == 2)
			{
				
				polygonObj.addPoint(pointForPolygon);
				//polygonObj = new Polygon("polygon", shapeID, getObjectsColor(), 10, x, y);
				shapes.add(polygonObj);
				repaint();
				//numberOfPolygons++;
				shapeID++;

				// Debugging
				System.out.println("Mode # " + mode);
				System.out.println("Point # " + (polygonObj.getPoints() ));
				System.out.println("ShapeID # " + shapeID);
				//System.out.println("Lines # " + (numberOfPolygons));
			}
			if (mode == 3)
			{
				// free draw
				repaint();

			}

			else if (mode == 4)
			{

				
			}

			else if (mode == 5)
			{
				// open
				//Load.loadFile();

			}

			else if (mode == 6)
			{
				// save

			}
		}

		public void mouseMoved(MouseEvent event)
		{
			statusBar1.setText( String.format( "Pressed at [%5d, %5d]", event.getX(), event.getY() ) );	
//			int xPos = event.getX();
//			 int yPos = event.getY();
//			if ( event.isShiftDown() ) // shift click
//			{
//				for (Shape s : shapes)
//				{
//					s.setX(xPos);
//					s.setY(yPos);
//				}
//				repaint();
//
//			}
		}

		public void mousePressed(MouseEvent event)
		{

			 int xPos = event.getX();
			 int yPos = event.getY();
			 String details;
			 details = String.format("Clicked %d times",event.getClickCount());

			//	details += " with right mouse button";
//			 else if (event.isAltDown() ) //middle mouse click
//			// details += " with center mouse button";
//			else //left mouse click
//			// details += " with left mouse button at " + xPos;
			//
			 statusBar1.setText( details + " @ [" + xPos + "] & [" + yPos + "]." );
			repaint();
			//
			// TODO Auto-generated method stub
		}

		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent e)
		{
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent e)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDragged(MouseEvent event)
		{
			statusBar1.setText( String.format( "Pressed at [%5d, %5d]", event.getX(), event.getY() ) );	
			int xPos = event.getX();
			 int yPos = event.getY();
			if ( event.isShiftDown() ) // shift click
			{
				for (Shape s : shapes)
				{
					int thisX = s.getX();
					int thisY = s.getY();
					int thisRadius = s.getRadius();
					
					if ( s.getType() == "circle" && (Math.sqrt( Math.pow( xPos - thisX, 2 ) + Math.pow( yPos - thisY, 2) ) ) < ( thisRadius  ) )
					{
						s.setX(xPos);
						s.setY(yPos);
						statusBar1.setText( String.format( "Pressed at [%5d, %5d]", event.getX(), event.getY() ) );	
					}
					
					else if ( s.getType() == "rectangle" && (Math.sqrt( Math.pow( xPos - thisX, 2 ) + Math.pow( yPos - thisY, 2) ) ) < ( thisRadius  ) )
					{
						s.setX(xPos);
						s.setY(yPos);
					}
					else if ( s.getType() == "polygon" && (Math.sqrt( Math.pow( xPos - thisX, 2 ) + Math.pow( yPos - thisY, 2) ) ) < ( thisRadius  ) )
					{
						s.setX(xPos);
						s.setY(yPos);
					}
					repaint();
				}
			}
		}
	}

	public int getShapeID()
	{
		return shapeID;
	}

	public void setShapeID(int shapeID)
	{
		this.shapeID = shapeID;
	}

	public void mouseReleased(MouseEvent event)
	{
		// statusBar1.setText(String.format( "Clicked at [%d, %d]",
		// event.getX(), event.getY() ) );
	}

	public void mouseEntered(MouseEvent event)
	{
		// statusBar1.setText(String.format( "Mouse entered at [%d, %d]",
		// event.getX(), event.getY() ) );
	}

	public void mouseExited(MouseEvent event)
	{
		// statusBar1.setText( String.format( "Mouse outside JPanel") );
	}

	public void mousePressed(MouseEvent event)
	{
		// statusBar1.setText( String.format( "Pressed at [5d, 5d]",
		// event.getX(), event.getY() ) );
	}

	public void setColor(Color col)
	{
		setObjectsColor(col);
	}

	public Color getObjectsColor()
	{
		return objectsColor;
	}

	public void setObjectsColor(Color objectsColor)
	{
		this.objectsColor = objectsColor;
	}
}
