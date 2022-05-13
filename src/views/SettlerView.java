package views;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SettlerView {
	private String imageAddr;
	private Image img;
	private JLabel label;

	
	public SettlerView(JLabel label) {
		this.label = label;
		imageAddr = "/settler_alive.png";
		img = new ImageIcon(this.getClass().getResource(imageAddr)).getImage();
		this.label.setIcon(new ImageIcon(img));
		
	}

	public void update(boolean selected) {
		if (selected)
			imageAddr = "/settler_current.png";
		else 
			imageAddr = "/settler_alive.png";
		img = new ImageIcon(this.getClass().getResource(imageAddr)).getImage();
		label.setIcon(new ImageIcon(img));
	}
}
