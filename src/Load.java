import java.awt.Color;
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Load
{
	private Polygon polygonObj;
	private Color objectsColor;
	private static Circle circleObj;
	private Rectangle rectangleObj;


	public ArrayList<Shape> loadFile()
	{
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<Shape> loadShapes = null;
		System.out.println("Just called loadFile()");
		Path source = Paths.get("/Users/Tim/Desktop/output.txt");
		Charset charset = Charset.forName("US-ASCII");
		lines = new ArrayList<>();
		
		try (BufferedReader reader = Files.newBufferedReader(source, charset))
		{
			String line = null;
			
			while ((line = reader.readLine()) != null)
			{
				lines.add(line);
				System.out.println( "line ="  + line);
				//circleObj = new Circle("circle", shapeID, getObjectsColor(), 10, x, y);
			}
			reader.close();
			System.out.println("Finished calling loadFile()");
			loadShapes = processData(lines);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return loadShapes;
	}// end loadFile()
	
	
	//start process data
	public ArrayList<Shape> processData(ArrayList<String> lines)
	{
		ArrayList<Shape> loadShapes  = new ArrayList<Shape>();
		//while  lines.get(1) == "circle"
		for ( int i = 0; i < lines.size(); i++ )
		{
			if ( lines.get(i).equals("circle") )
			{
				int x = Integer.parseInt( lines.get(i + 1).split(" ")[0]) ;
				int y = Integer.parseInt( lines.get(i + 1).split(" ")[1]) ;
				int radius = Integer.parseInt( lines.get(i + 2));				
				int shapeID = 0; //not required for project
				Color color = Color.black;
				circleObj = new Circle( lines.get(i), shapeID, color, radius, x, y );
				loadShapes.add(circleObj);
			}
			else if (lines.get(i).equals("rectangle") )
			{
				int x = Integer.parseInt( lines.get(i + 1).split(" ")[0]) ;
				int y = Integer.parseInt( lines.get(i + 1).split(" ")[1]) ;
				int radius = Integer.parseInt( lines.get(i + 2));				
				int shapeID = 0; //not required for project
				Color color = Color.black;
				rectangleObj = new Rectangle( lines.get(i), shapeID, color, radius, x, y );
				loadShapes.add(rectangleObj);
			}
			else
			{
					int x = Integer.parseInt( lines.get(i + 1).split(" ")[0]) ;
					int y = Integer.parseInt( lines.get(i + 1).split(" ")[1]) ;
					int radius = Integer.parseInt( lines.get(i + 2));				
					int shapeID = 0; //not required for project
					Color color = Color.black;
					rectangleObj = new Rectangle( lines.get(i), shapeID, color, radius, x, y );
					loadShapes.add(rectangleObj);
				}
			}
				
//				color = ( 	((Object) color).setRed( Integer.parseInt(lines.get(i + 1).split(" ")[0] ) ) +
//							color.setGreen( Integer.parseInt(lines.get(i + 1).split(" ")[0] ) ) +
//							color.setBlue( Integer.parseInt(lines.get(i + 1).split(" ")[0] ) ) );
//				
				
				//(color.getRed() + " " + color.getGreen() + " " + color.getBlue() +
						
				
				
				// given data
				// ("circle", color,  x y, radius)
				// reformat data to
				// circleObj = new Circle("circle", shapeID, getObjectsColor(), radius, x, y);
		
		return loadShapes;		
	}	
}
