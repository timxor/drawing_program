import java.awt.Color;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Save
{
	public static void saveFile()
	{
		System.out.println("Just called saveFile()");
		Path target = Paths.get("/Users/Tim/Desktop/output.txt");
		Charset charset = Charset.forName("US-ASCII");

		try (BufferedWriter writer = Files.newBufferedWriter(target, charset))
		{
			

				writer.append(DrawingPanel.getShapes().size() + "\n");
				
				for (Shape s : DrawingPanel.getShapes())
				{
					//Color color = s.getColor();

					if (s.getType() == "circle")
					{
						writer.append("\n");
						writer.append(s.getType() + "\n");
						//writer.append(color.getRed() + " " + color.getGreen() + " " + color.getBlue() + "\n");
						writer.append(s.getX() + " " + s.getY() + "\n");
						writer.append(s.getRadius() + "");
						writer.append("\n");
					} else if (s.getType() == "rectangle")
					{
						writer.append("\n");
						writer.append(s.getType() + "\n");
						//writer.append(color.getRed() + " " + color.getGreen() + " " + color.getBlue() + "\n");
						writer.append(s.getX() + " " + s.getY() + "\n");
						writer.append(s.getRadius() + "\n");
						writer.append("\n");
					} else
					{
						writer.append("\n");
						writer.append(s.getType() + "\n");
						//writer.append(color.getRed() + " " + color.getGreen() + " "
						//		+ color.getBlue() + "\n");
						writer.append(s.getX() + " " + s.getY() + "\n");
						writer.append(s.getRadius() + "\n");
						writer.append("\n");
					}
				}
			
			writer.flush();
			writer.close();
			System.out.println("Finished calling saveFile()");
			System.out.println("Saved " + DrawingPanel.getShapes().size() + " shapes.");

		} catch (Exception e)
		{
			

			System.out.println(e.getMessage());
		}
	}
}
