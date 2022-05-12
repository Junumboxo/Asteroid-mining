package views;

import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AsteroidView {

	private String imageAddr;
	private Image img;
	private JLabel label;
	
	public AsteroidView(JLabel label) {
		 this.label = label;
		 imageAddr = "/asteroid.png";
		 img = new ImageIcon(this.getClass().getResource(imageAddr)).getImage();
		 this.label.setIcon(new ImageIcon(img));
	}

	public void update(boolean selected) {
		if (selected)
			imageAddr = "/asteroid_current.png";
		else 
			imageAddr = "/asteroid.png";
		img = new ImageIcon(this.getClass().getResource(imageAddr)).getImage();
		label.setIcon(new ImageIcon(img));
		label.paintImmediately(label.getVisibleRect());
	}
}
