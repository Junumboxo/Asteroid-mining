package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Border border = BorderFactory.createLineBorder(Color.BLACK);

		
		 JLabel lblNewLabel_1 = new JLabel("Sample"); Image img = new
		 ImageIcon(this.getClass().getResource("/background.png")).getImage();
		 lblNewLabel_1.setIcon(new ImageIcon(img)); lblNewLabel_1.setBounds(100, 100,
		 656, 380); contentPane.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setBackground(Color.magenta);
		btnNewButton.setFocusPainted(false);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_1.setBackground(Color.magenta);
		btnNewButton_1.setFocusPainted(false);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_2.setBackground(Color.magenta);
		btnNewButton_2.setFocusPainted(false);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_3.setBackground(Color.magenta);
		btnNewButton_3.setFocusPainted(false);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_4.setBackground(Color.magenta);
		btnNewButton_4.setFocusPainted(false);
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_5.setBackground(Color.magenta);
		btnNewButton_5.setFocusPainted(false);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_6.setBackground(Color.magenta);
		btnNewButton_6.setFocusPainted(false);
		panel_1.add(btnNewButton_6);

	}

}
