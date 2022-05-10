package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Toolkit;

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
	Image image = new ImageIcon(this.getClass().getResource("/background.png")).getImage();

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
		contentPane = new JPanel() {
		         @Override
		         public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            g.drawImage(image, 0, 0, null);
		         }
		      };
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 528);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Border border = BorderFactory.createLineBorder(Color.BLACK);

		Image img;
		/*
		 * JLabel lblNewLabel_1 = new JLabel("Sample"); Image img = new
		 * ImageIcon(this.getClass().getResource("/background.png")).getImage();
		 * lblNewLabel_1.setIcon(new ImageIcon(img)); lblNewLabel_1.setBounds(100, 100,
		 * 656, 380); contentPane.add(lblNewLabel_1);
		 */

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,0,0));
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JButton btnNewButton = new JButton(" Travel");
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 10));
		btnNewButton.setBackground(Color.magenta);
		btnNewButton.setFocusPainted(false);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton(" Drill ");
		btnNewButton_1.setFont(new Font("Consolas", Font.BOLD, 10));
		btnNewButton_1.setBackground(Color.magenta);
		btnNewButton_1.setFocusPainted(false);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(" Mine  ");
		btnNewButton_2.setFont(new Font("Consolas", Font.BOLD, 10));
		btnNewButton_2.setBackground(Color.magenta);
		btnNewButton_2.setFocusPainted(false);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton(" Drop  ");
		btnNewButton_3.setFont(new Font("Consolas", Font.BOLD, 10));
		btnNewButton_3.setBackground(Color.magenta);
		btnNewButton_3.setFocusPainted(false);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Pick up");
		btnNewButton_4.setFont(new Font("Consolas", Font.BOLD, 10));
		btnNewButton_4.setBackground(Color.magenta);
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setPreferredSize(new Dimension(100, 10));
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton(" Build ");
		btnNewButton_5.setFont(new Font("Consolas", Font.BOLD, 10));
		btnNewButton_5.setBackground(Color.magenta);
		btnNewButton_5.setFocusPainted(false);
		panel_1.add(btnNewButton_5);
		
		//dont need hide according to requirements
		
		JLabel lblNewLabel = new JLabel("Settlers:");
		lblNewLabel.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel);
		
		 JLabel lblNewLabel_2 = new JLabel();
		 lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		 img = new ImageIcon(this.getClass().getResource("/settler_alive.png")).getImage();
		 
		 JLabel lblNewLabel_7 = new JLabel("Settler 1");
		 lblNewLabel_7.setForeground(Color.WHITE);
		 panel_1.add(lblNewLabel_7);
		 lblNewLabel_2.setIcon(new ImageIcon(img));
		 panel_1.add(lblNewLabel_2);
		 
		 JLabel lblNewLabel_3 = new JLabel();
		 lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		 img = new ImageIcon(this.getClass().getResource("/settler_alive.png")).getImage();
		 
		 JLabel lblNewLabel_6 = new JLabel("Settler 2");
		 lblNewLabel_6.setForeground(Color.WHITE);
		 panel_1.add(lblNewLabel_6);
		 lblNewLabel_3.setIcon(new ImageIcon(img));
		 panel_1.add(lblNewLabel_3);
		 
		 JLabel lblNewLabel_4 = new JLabel();
		 lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		 img = new ImageIcon(this.getClass().getResource("/settler_alive.png")).getImage();
		 
		 JLabel lblNewLabel_8 = new JLabel("Settler 3");
		 lblNewLabel_8.setForeground(Color.WHITE);
		 panel_1.add(lblNewLabel_8);
		 lblNewLabel_4.setIcon(new ImageIcon(img));
		 panel_1.add(lblNewLabel_4);
			
		 JLabel lblNewLabel_5 = new JLabel();
		 lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		 img = new ImageIcon(this.getClass().getResource("/settler_alive.png")).getImage();
		 
		 JLabel lblNewLabel_9 = new JLabel("Settler 4");
		 lblNewLabel_9.setForeground(Color.WHITE);
		 panel_1.add(lblNewLabel_9);
		 lblNewLabel_5.setIcon(new ImageIcon(img));
		 panel_1.add(lblNewLabel_5);
			
	}

}
