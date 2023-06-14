package org.ictkerala.examseatingarrangement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.UIManager;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
public class firstwindow extends JFrame {
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField upass;
	private int mousex,mousey;
	public String name;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstwindow frame = new firstwindow();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public firstwindow() {
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
		setForeground(new Color(30, 144, 255));
		setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		setTitle("PORTAL");
		setBackground(new Color(70, 130, 180));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 529, 587);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images\\undraw_building_websites_i78t.png"));
		lblNewLabel_1.setBounds(-70, -40, 599, 772);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 130, 180));
		panel_1.setBounds(420, 0, 736, 988);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBounds(195, 121, 100, 23);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("STZhongsong", Font.BOLD, 14));
		
		uname = new JTextField();
		uname.setForeground(new Color(255, 255, 255));
		uname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		uname.setFont(uname.getFont().deriveFont(uname.getFont().getStyle() | Font.BOLD, uname.getFont().getSize() + 2f));
		uname.setBounds(195, 142, 312, 32);
		panel_1.add(uname);
		uname.setBackground(new Color(70, 130, 180));
		uname.setColumns(10);
		
		upass = new JPasswordField();
		upass.setForeground(new Color(255, 255, 255));
		upass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		upass.setFont(new Font("Tahoma", Font.BOLD, 13));
		upass.setBounds(195, 209, 312, 32);
		panel_1.add(upass);
		upass.setBackground(new Color(70, 130, 180));
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(194, 191, 164, 19);
		panel_1.add(lblPassword);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("STZhongsong", Font.BOLD, 15));
		
		JCheckBox showpassword = new JCheckBox("show password");
		showpassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		showpassword.setForeground(new Color(255, 255, 255));
		showpassword.setBounds(187, 248, 135, 13);
		showpassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_1.add(showpassword);
		showpassword.setBackground(new Color(70, 130, 180));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(368, 302, 86, 23);
		comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_1.add(comboBox);
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("STZhongsong", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Student"}));
		comboBox.setToolTipText("");
		
		JLabel lblSelectUserType = new JLabel("SELECT USER TYPE");
		lblSelectUserType.setBounds(195, 287, 163, 53);
		panel_1.add(lblSelectUserType);
		lblSelectUserType.setForeground(new Color(255, 255, 255));
		lblSelectUserType.setFont(new Font("STZhongsong", Font.BOLD, 14));
		
		JButton lbutton = new JButton("Login");
		lbutton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lbutton.setToolTipText("Login");
		lbutton.setBounds(196, 387, 312, 43);
		lbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_1.add(lbutton);
		lbutton.setForeground(SystemColor.desktop);
		lbutton.setBackground(new Color(255, 255, 255));
		
		
		lbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=uname.getText();
				String pass=upass.getText();
				String option=comboBox.getSelectedItem().toString();
				if(name.equals("")||pass.equals(""))
				{
					JOptionPane.showMessageDialog(lbutton, "some fields are empty","error",1);
				}
				else {
					try {   
						     con=DB.mycon();
						    
						    
						     ps=con.prepareStatement("select * from user WHERE username=? and password=?");
						     ps.setString(1, name);
						     ps.setString(2, pass);
						     
						     rs=ps.executeQuery();
						     
						        	if(rs.next()) {
						        		String s1 = rs.getString("usertype");
						        		if(option.equalsIgnoreCase("ADMIN")&&s1.equalsIgnoreCase("admin"))
						        		{
						        			adminpage ad=new adminpage();
			                                ad.getadminname.setText(name);
			                                ad.getadmintype.setText(option);
						        			ad.setVisible(true);
						        			ad.table_load();
						        			setVisible(false);
								
						        		}
						        		else if(option.equalsIgnoreCase("STUDENT")&&s1.equalsIgnoreCase("student"))
								{
									studentpage st=new studentpage();
			
									st.setVisible(true);
									st.getstudentname.setText(name);
									st.typefield.setText(option);
									setVisible(false);
								
								}else {
									JOptionPane.showMessageDialog(lbutton, "invalid login credentials","Error",JOptionPane.ERROR_MESSAGE);
								}
								
						      				}else {
						      					JOptionPane.showMessageDialog(lbutton, "invalid login credentials","Error",JOptionPane.ERROR_MESSAGE);
						      				}
						        	
					
					
					}
					catch(Exception g)
					{
						System. out.println(g);
					}
				}
			}
		});
		lbutton.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		JLabel create = new JLabel("Dont't have a account? create new");
		create.setBackground(new Color(255, 255, 255));
		create.setBounds(211, 459, 318, 13);
		create.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_1.add(create);
		create.setForeground(new Color(255, 255, 255));
		create.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registerform r =new registerform();
				r.setVisible(true);
				r.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		create.setFont(new Font("Verdana", Font.BOLD, 14));
		
		JLabel login = new JLabel("LOGIN");
		login.setBounds(288, 35, 119, 64);
		panel_1.add(login);
		login.setForeground(new Color(255, 255, 255));
		login.setBackground(new Color(255, 255, 255));
		login.setFont(login.getFont().deriveFont(login.getFont().getStyle() | Font.BOLD, login.getFont().getSize() + 17f));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\javaprojects\\exam_arrangement\\images\\delete.png"));
		lblNewLabel_2.setToolTipText("exit");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 42));
		lblNewLabel_2.setBounds(552, 11, 24, 23);
		lblNewLabel_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("images\\user.png"));
		lblNewLabel_3.setBounds(166, 142, 24, 32);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("images\\forgot-password (1).png"));
		lblNewLabel_4.setBounds(166, 209, 24, 43);
		panel_1.add(lblNewLabel_4);
		showpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showpassword.isSelected())
				{
					upass.setEchoChar((char)0);
				}else
				{
					upass.setEchoChar('•');
				}
			}
		});
		
	}
}
