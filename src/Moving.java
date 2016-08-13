import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Moving extends JPanel implements ActionListener
{

	int x, y;
	Timer timer;
	
	Moving() 
	{
		x = 0;
		y = 0;
		timer = new Timer(20, this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		x += 1;
		y += 1;
		repaint();
	}
	
	public void paintComponent( Graphics g )
	{
		super.paintComponent(g);
		g.fillOval(x, y, 10, 10);
	}
}
