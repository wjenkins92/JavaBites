package project;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class UserInterface implements ComponentListener
{
	private static JFrame mainFrame = new JFrame("Character Explorer");
	private static GridLayout gridLayout = new GridLayout(0, 10);

	public UserInterface()
	{
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel mainPane = new JPanel(gridLayout);
		JScrollPane scrollPane = new JScrollPane(mainPane);

		for (int i = 1; i <= 500; i++)
		{
			JPanel bigPanel = new JPanel();
			bigPanel.setPreferredSize(new Dimension(50, 50));
			bigPanel.add(new JLabel(i + ""));

			mainPane.add(bigPanel);
		}

		mainFrame.getContentPane().add(scrollPane);
	}

	public void display()
	{
		mainFrame.setSize(500, 250);
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.addComponentListener(this);
	}

	public void componentResized(ComponentEvent e)
	{
		if (e.getSource() == mainFrame)
		{
			gridLayout.setColumns(mainFrame.getWidth() / 60);
		}
	}
	
	public void componentMoved(ComponentEvent e) {}
	public void componentShown(ComponentEvent e) {}
	public void componentHidden(ComponentEvent e) {}
}
