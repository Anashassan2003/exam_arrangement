package org.ictkerala.examseatingarrangement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Loading extends JFrame  {

	private JPanel contentPane;
    private JProgressBar pbar;
	private JLabel perc ;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_4;
	
	public static void main(String[] args) {
		
				try {
					
					Loading a = new Loading();
					a.setVisible(true);
					a.setLocationRelativeTo(null);
                      try {
					  for(int i=1;i<=100;i++) {
						  a.pbar.setValue(i);
						  Thread.sleep(60);
						
						 a.perc.setText(String.valueOf(i)+"%");
					      if(i==100) {
					    	 a.setVisible(false);
					    	  
					      }
					  
					  }
					 
					} catch (Exception e) {
					e.printStackTrace();
				}
                      firstwindow f=new firstwindow();
 					 f.setVisible(true);
 					 f.setLocationRelativeTo(null);
			}catch(Exception h) {
				
			}
			;
		   
			
		
	}

	



	public Loading() {
		setUndecorated(true);
		setTitle("EDUSOFT");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 438, 728, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		perc = new JLabel("0%");
		perc.setForeground(new Color(255, 255, 255));
		perc.setBounds(326, 87, 53, 14);
		panel.add(perc);
		perc.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		 pbar = new JProgressBar();
		 pbar.setBounds(47, 54, 629, 22);
		 panel.add(pbar);
		 
		 lblNewLabel_2 = new JLabel("LOADING...");
		 lblNewLabel_2.setForeground(new Color(255, 255, 255));
		 lblNewLabel_2.setBounds(295, 11, 118, 32);
		 panel.add(lblNewLabel_2);
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		 
		 panel_1 = new JPanel();
		 panel_1.setBackground(new Color(255, 255, 255));
		 panel_1.setBounds(0, 0, 728, 438);
		 contentPane.add(panel_1);
		 panel_1.setLayout(null);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setBounds(220, 55, 266, 271);
		 panel_1.add(lblNewLabel);
		 lblNewLabel.setIcon(new ImageIcon("images/books (2).png"));
		 
		 lblNewLabel_3 = new JLabel("TO THE EDUSOFT");
		 lblNewLabel_3.setBounds(275, 363, 161, 14);
		 panel_1.add(lblNewLabel_3);
		 lblNewLabel_3.setFont(new Font("STZhongsong", Font.BOLD, 15));
		 
		 lblNewLabel_1 = new JLabel("WELCOME");
		 lblNewLabel_1.setBounds(276, 332, 186, 32);
		 panel_1.add(lblNewLabel_1);
		 lblNewLabel_1.setFont(new Font("STZhongsong", Font.BOLD, 25));
		 
		 lblNewLabel_4 = new JLabel("");
		 lblNewLabel_4.setToolTipText("exit");
		 lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 lblNewLabel_4.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		System.exit(0);
		 	}
		 });
		 lblNewLabel_4.setIcon(new ImageIcon("images/delete.png"));
		 lblNewLabel_4.setBounds(679, 11, 26, 38);
		 panel_1.add(lblNewLabel_4);
	
		
		 
		
		
		
		
	}
}
