package org.ictkerala.examseatingarrangement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Label;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.sql.*;
import java.awt.event.MouseMotionAdapter;
public class studentpage extends JFrame {

	private JPanel contentPane;
	private JTextField searchfield;
	public JLabel getstudentname;
	JLabel typefield;
	firstwindow f = new firstwindow();
	private JTable table;
    ResultSet rs;
    PreparedStatement pst;
    public String search;
    private int mousex,mousey;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentpage frame = new studentpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void table_load()
	{ 
		try {
	   search= searchfield.getText();
		pst=DB.mycon().prepareStatement("select * from admininserting WHERE RegisterNO=?");
		pst.setString(1, search);
		rs=pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception j) {
			
		}
	}
	

	
	public studentpage() {
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
		setBounds(100, 100, 787, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 317, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User :");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 350, 46, 23);
		panel.add(lblNewLabel);
		
	    getstudentname = new JLabel();
	    getstudentname.setForeground(new Color(0, 0, 0));
	    getstudentname.setFont(new Font("Tahoma", Font.BOLD, 14));
	    getstudentname.setText("user");
	   	getstudentname.setBounds(50, 354, 46, 14);
		panel.add(getstudentname);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 255));
		panel_2.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 131, 284, 140);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		Label label = new Label(" REGISTER NUMBER");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 15));
		label.setBounds(56, 25, 184, 22);
		panel_2.add(label);
		
		searchfield = new JTextField();
		searchfield.setBounds(30, 58, 231, 20);
		panel_2.add(searchfield);
		searchfield.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					 search= searchfield.getText();
					pst=DB.mycon().prepareStatement("select * from admininserting WHERE RegisterNO=?");
					pst.setString(1, search);
					rs=pst.executeQuery();
				
				  if(rs.next())
				{
					table_load();
				}
				  else {
					  JOptionPane.showMessageDialog(btnNewButton, "Seating is not dont for the corresponding Register Number","student not found",JOptionPane.WARNING_MESSAGE);
				  }
				
			}catch(Exception h)
				{
				
				}
		}});
		
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(92, 89, 89, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Type :");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 378, 46, 14);
		panel.add(lblNewLabel_1);
		
		 typefield = new JLabel("type");
		 typefield.setForeground(new Color(0, 0, 0));
		 typefield.setFont(new Font("Tahoma", Font.BOLD, 14));
		typefield.setBounds(50, 378, 85, 14);
		panel.add(typefield);
		
		JLabel lblNewLabel_6 = new JLabel("HOME");
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				firstwindow f=new firstwindow();
				f.setVisible(true);
				setVisible(false);
				
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon("images/home (2).png"));
		lblNewLabel_6.setPreferredSize(new Dimension(21, 14));
		lblNewLabel_6.setMaximumSize(new Dimension(33, 14));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setAlignmentY(0.0f);
		lblNewLabel_6.setAlignmentX(1.0f);
		lblNewLabel_6.setBounds(10, 11, 99, 32);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				
				
			}
		});
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				mousex=e.getX();
				mousey=e.getY();
				
				
				
			}
		});
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(316, 0, 471, 403);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_2.setIcon(new ImageIcon("images/delete.png"));
		lblNewLabel_2_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2_2.setToolTipText("close");
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 42));
		lblNewLabel_2_2.setBounds(438, 11, 23, 23);
		panel_1.add(lblNewLabel_2_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 451, 39);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}
}
