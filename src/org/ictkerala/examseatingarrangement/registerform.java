package org.ictkerala.examseatingarrangement;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.awt.Window.Type;

public class registerform extends JFrame {

	private JPanel contentPane;
	private JTextField rname;
	private JPasswordField rpass;
	private JPasswordField rconfirm;
	private int mousex,mousey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerform frame = new registerform();
					frame.setLocationRelativeTo(null);
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
	public registerform() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX()+e.getX() - mousex,getY()+e.getY() - mousey);
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousex=e.getX();
				mousey=e.getY();
			}
		});
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 534, 587);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images/undraw_building_websites_i78t.png"));
		lblNewLabel_1.setBounds(-61, 0, 607, 661);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = 
				new JPanel();
		panel_1.setBackground(new Color(70, 130, 180));
		panel_1.setBounds(522, 0, 487, 587);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRegister = new JLabel("Create Account");
		lblRegister.setBounds(118, 61, 275, 34);
		lblRegister.setForeground(new Color(255, 255, 255));
		panel_1.add(lblRegister);
		lblRegister.setFont(lblRegister.getFont().deriveFont(lblRegister.getFont().getStyle() | Font.BOLD, lblRegister.getFont().getSize() + 17f));
		
		JLabel lblUserType = new JLabel("USER TYPE");
		lblUserType.setForeground(new Color(255, 255, 255));
		lblUserType.setBounds(77, 377, 98, 20);
		panel_1.add(lblUserType);
		lblUserType.setFont(new Font("STZhongsong", Font.BOLD, 14));
		
		rname = new JTextField();
		rname.setFont(new Font("Tahoma", Font.BOLD, 13));
		rname.setBounds(74, 159, 319, 28);
		panel_1.add(rname);
		rname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(75, 138, 227, 20);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("STZhongsong", Font.BOLD, 14));
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(75, 209, 227, 20);
		panel_1.add(lblPassword);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("STZhongsong", Font.BOLD, 14));
		
		rpass = new JPasswordField();
		rpass.setFont(new Font("Tahoma", Font.BOLD, 13));
		rpass.setBounds(74, 229, 319, 28);
		panel_1.add(rpass);
		
		JCheckBox box1 = new JCheckBox("show password");
		box1.setFont(new Font("Tahoma", Font.BOLD, 11));
		box1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		box1.setForeground(new Color(255, 255, 255));
		box1.setBackground(new Color(70, 130, 180));
		box1.setBounds(84, 332, 128, 20);
		panel_1.add(box1);
		
		JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
		lblConfirmPassword.setForeground(new Color(255, 255, 255));
		lblConfirmPassword.setBounds(73, 280, 164, 20);
		panel_1.add(lblConfirmPassword);
		lblConfirmPassword.setFont(new Font("STZhongsong", Font.BOLD, 14));
		
		rconfirm = new JPasswordField();
		rconfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		rconfirm.setBounds(74, 299, 319, 28);
		panel_1.add(rconfirm);
		
		JComboBox rcomboBox = new JComboBox();
		rcomboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rcomboBox.setBounds(205, 375, 86, 24);
		panel_1.add(rcomboBox);
		rcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Student"}));
		rcomboBox.setToolTipText("");
		rcomboBox.setFont(new Font("STZhongsong", Font.BOLD, 14));
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setBounds(77, 438, 326, 41);
		panel_1.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rename=rname.getText();
				String repass=rpass.getText();
				String reconfirm=rconfirm.getText();
				String reoption=rcomboBox.getSelectedItem().toString();
				try {
					if(rename.equals("")||repass.equals("")||reconfirm.equals(""))
					{
						JOptionPane.showMessageDialog(btnRegister, "please fill the fields");
					}else
					{
						if(repass.equals(reconfirm)) {
							Statement s=DB.mycon().createStatement();
							
							s.executeUpdate("insert into user(password,username,usertype)"+"VALUES('"+repass+"','"+rename+"','"+reoption+"')");
						
							JOptionPane.showMessageDialog(btnRegister, "your account has been created");
							rname.setText("");
							rpass.setText("");
							rconfirm.setText("");
							firstwindow f=new firstwindow();
							setVisible(false);
							f.setVisible(true);
							f.setLocationRelativeTo(null);
						}else {
							JOptionPane.showMessageDialog(btnRegister, "password mismatched");
						}
			
					}
				
			}catch(Exception g) {
				System.out.println(g);
			}
			}});
		btnRegister.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JLabel lblAlreadyHaveAccountlogin = new JLabel("Already Have  Account? Login");
		lblAlreadyHaveAccountlogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAlreadyHaveAccountlogin.setBounds(129, 510, 247, 20);
		panel_1.add(lblAlreadyHaveAccountlogin);
		lblAlreadyHaveAccountlogin.setForeground(new Color(255, 255, 255));
		lblAlreadyHaveAccountlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				firstwindow f=new firstwindow();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		lblAlreadyHaveAccountlogin.setFont(new Font("Verdana", Font.BOLD, 14));
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("images/delete.png"));
		lblNewLabel_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2_1.setToolTipText("close");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 42));
		lblNewLabel_2_1.setBounds(433, 22, 31, 23);
		panel_1.add(lblNewLabel_2_1);
		box1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(box1.isSelected())
				{
					rpass.setEchoChar((char)0);
					rconfirm.setEchoChar((char)0);
				}else {
					rpass.setEchoChar('*');
					rconfirm.setEchoChar('*');
				}
			}
		});
	}

}
