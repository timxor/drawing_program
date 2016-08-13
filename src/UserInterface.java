//********************************************************************
//	Driver.java				Author: Tim C. Siwula
//
//	Starts the GUI for the and calls the ButtonPanel.
//********************************************************************
import javax.swing.JFrame;
public class UserInterface extends JFrame 
{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Simple Paint App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawingPanel paintPanel = new DrawingPanel();
		ButtonPanel mainPanel = new ButtonPanel(paintPanel);
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
		frame.pack();
	}	
}
