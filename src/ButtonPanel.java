//********************************************************************
//  ButtonPanel.java       Authors: Tim C. Siwula
//
//  Demonstrates a graphical user interface and an event listener.
//********************************************************************

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.ArrayList;

public class ButtonPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JPanel buttons, sliders;
	private JButton circle, rectangle, polygon, freedraw, eraseall, open, save;
	private JSlider sliderR, sliderG, sliderB;
	private Color col;

	DrawingPanel canvasPanel = new DrawingPanel();

	// -----------------------------------------------------------------
	// Constructor: Sets up the GUI.
	// -----------------------------------------------------------------
	public ButtonPanel(DrawingPanel paintPanel)
	{
		// set layout
		canvasPanel = paintPanel;
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(750, 600));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		new ArrayList<Point>();

		// create sliders
		sliderR = new JSlider(0, 255);
		sliderG = new JSlider(0, 255);
		sliderB = new JSlider(0, 255);

		// add listeners to sliders
		sliderR.addChangeListener(new SliderListener());
		sliderG.addChangeListener(new SliderListener());
		sliderB.addChangeListener(new SliderListener());

		// add sliders to panel
		sliders = new JPanel();
		sliders.setLayout(new BoxLayout(sliders, BoxLayout.Y_AXIS));
		sliders.add(sliderR);
		sliders.add(sliderG);
		sliders.add(sliderB);

		// create buttons
		circle = new JButton("Circle");
		rectangle = new JButton("Rectangle");
		polygon = new JButton("Polygon");
		freedraw = new JButton("Free Draw");
		eraseall = new JButton("Erase");
		open = new JButton("Load");
		save = new JButton("Save");

		// add listeners to buttons
		ButtonListener listener = new ButtonListener();
		circle.addActionListener(listener);
		rectangle.addActionListener(listener);
		polygon.addActionListener(listener);
		freedraw.addActionListener(listener);
		eraseall.addActionListener(listener);
		save.addActionListener(listener);
		open.addActionListener(listener);

		buttons = new JPanel();
		buttons.setLayout(new GridLayout(2, 4));
		buttons.add(circle);
		buttons.add(rectangle);
		buttons.add(polygon);
		buttons.add(freedraw);
		buttons.add(sliders);
		buttons.add(eraseall);
		buttons.add(open);
		buttons.add(save);

		// add buttons panel
		this.add(buttons);
		// add paintPanel to buttonPanel
		this.add(paintPanel);
	}

	public void changeColor(JSlider source)
	{
		col = new Color(sliderR.getValue(), sliderG.getValue(), sliderB.getValue());
		canvasPanel.setColor(col);
	}

	// *****************************************************************
	// Represents a listener for button push (action) events.
	// *****************************************************************
	private class ButtonListener implements ActionListener
	{
		// --------------------------------------------------------------
		// Updates the mode and label when the button is pushed.
		// --------------------------------------------------------------
		public void actionPerformed(ActionEvent event)
		{
			// identify event source
			// assign variable mode to source
			if (event.getSource() == circle)
			{
				canvasPanel.setMode(0);
			} else if (event.getSource() == rectangle)
			{
				canvasPanel.setMode(1);
			} else if (event.getSource() == polygon)
			{
				canvasPanel.setMode(2);
			} else if (event.getSource() == freedraw)
			{
				canvasPanel.setMode(3);
			} else if (event.getSource() == eraseall)
			{
				canvasPanel.setMode(4);
			} else if (event.getSource() == open)
			{
				canvasPanel.setMode(5);
			} else if (event.getSource() == save)
			{
				canvasPanel.setMode(6);
			}
		} // end
	} // end private listener

	// Inner class, listener for sliders:
	class SliderListener implements ChangeListener
	{

		public void stateChanged(ChangeEvent e)
		{
			JSlider source = (JSlider) e.getSource();
			int col = (int) source.getValue();
			changeColor(source);
		}
	} // end main class
}