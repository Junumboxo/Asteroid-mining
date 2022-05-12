package views;

import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.MainWindow;

public class AsteroidView {

	private String imageAddr;
	private Image img;
	private JLabel label;
	private MainWindow mainFrame;
	
	public AsteroidView(MainWindow frame, JPanel panel, int X, int Y) {
		 mainFrame = frame;
		 label = new JLabel();
		 GridBagConstraints gbc_label = new GridBagConstraints();
		 gbc_label.gridx = X;
		 gbc_label.gridy = Y;
		 imageAddr = "/asteroid.png";
		 img = new ImageIcon(this.getClass().getResource(imageAddr)).getImage();
		 label.setIcon(new ImageIcon(img));
		 mainFrame.getContentPane().invalidate();
		 mainFrame.getContentPane().validate();
		 mainFrame.getContentPane().repaint();
		 //doesnt work because we add it via copy, not via reference
		 panel.add(label, gbc_label);
	}
	
	public void update(boolean c) {
		if (c)
			imageAddr = "/asteroid_current.png";
		else 
			imageAddr = "/asteroid.png";
		render();
	}
	
	public void render()
	{
		img = new ImageIcon(this.getClass().getResource(imageAddr)).getImage();
		label.setIcon(new ImageIcon(img));
		//refresh main frame
		mainFrame.getContentPane().invalidate();
		mainFrame.getContentPane().validate();
		mainFrame.getContentPane().repaint();
	}
}
