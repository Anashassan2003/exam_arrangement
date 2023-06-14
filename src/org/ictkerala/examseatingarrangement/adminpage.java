package org.ictkerala.examseatingarrangement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ScrollPaneConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
public class adminpage extends JFrame {
     
	private JPanel contentPane;
	private JTextField nameofthestudent;
	private JTextField registerno;
	private JTable table;
	private JComboBox classbox;
	private JTextField searchfield;
	private JComboBox branchbox;
    PreparedStatement pst;
    ResultSet rs;
    JLabel getadmintype;
    private JTextField snumber;
    private int mousex,mousey;
	JLabel getadminname;
    public void table_load()
    {
    	try {
    	pst=DB.mycon().prepareStatement("select * from admininserting");
    	rs=pst.executeQuery();
    	table.setModel(DbUtils.resultSetToTableModel(rs));
    	rs.close();
    }
    catch(Exception e) {
    	System.out.println(e);
    }
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpage frame = new adminpage();
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
	public adminpage() {
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
		setBounds(100, 100, 995, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(70, 130, 180));
		panel_2.setBounds(0, 0, 372, 691);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(10, 95, 350, 324);
		panel_2.add(panel);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DETAILS", TitledBorder.LEADING, TitledBorder.TOP, null,Color.black));
		panel.setLayout(null);
		
		nameofthestudent = new JTextField();
		nameofthestudent.setFont(nameofthestudent.getFont().deriveFont(nameofthestudent.getFont().getStyle() | Font.BOLD, nameofthestudent.getFont().getSize() + 2f));
		nameofthestudent.setBounds(154, 59, 186, 20);
		panel.add(nameofthestudent);
		nameofthestudent.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Register Number");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblNewLabel_2.setBounds(20, 115, 108, 14);
		panel.add(lblNewLabel_2);
		
		registerno = new JTextField();
		registerno.setFont(registerno.getFont().deriveFont(registerno.getFont().getStyle() | Font.BOLD, registerno.getFont().getSize() + 2f));
		registerno.setBounds(154, 112, 186, 20);
		panel.add(registerno);
		registerno.setColumns(10);
		
		 classbox = new JComboBox();
		 classbox.setFont(classbox.getFont().deriveFont(classbox.getFont().getStyle() | Font.BOLD, classbox.getFont().getSize() + 2f));
		classbox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
		classbox.setBounds(154, 216, 91, 22);
		panel.add(classbox);
		
		JLabel lblNewLabel_3 = new JLabel("Class");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblNewLabel_3.setBounds(20, 220, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Branch");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblNewLabel_4.setBounds(20, 166, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Seat Number");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_5.setBounds(20, 275, 97, 14);
		panel.add(lblNewLabel_5);
		
		snumber = new JTextField();
		snumber.setFont(snumber.getFont().deriveFont(snumber.getFont().getStyle() | Font.BOLD, snumber.getFont().getSize() + 2f));
		snumber.setBounds(154, 272, 186, 20);
		panel.add(snumber);
		snumber.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name Of The Student");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		lblNewLabel_1.setBounds(20, 51, 127, 35);
		panel.add(lblNewLabel_1);
		
		branchbox = new JComboBox();
		branchbox.setFont(branchbox.getFont().deriveFont(branchbox.getFont().getStyle() | Font.BOLD, branchbox.getFont().getSize() + 2f));
		branchbox.setModel(new DefaultComboBoxModel(new String[] {"CSE", "MEE", "EEE", "EC"}));
		branchbox.setBounds(154, 163, 91, 22);
		panel.add(branchbox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 506, 350, 112);
		panel_2.add(panel_1);
		panel_1.setBackground(new Color(70, 130, 180));
		panel_1.setBorder(new TitledBorder(null, "SEARCH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Register Number");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(22, 30, 108, 14);
		panel_1.add(lblNewLabel_2_1);
		
		searchfield = new JTextField();
		searchfield.setFont(searchfield.getFont().deriveFont(searchfield.getFont().getStyle() | Font.BOLD, searchfield.getFont().getSize() + 2f));
		searchfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
		});
		searchfield.setColumns(10);
		searchfield.setBounds(152, 27, 168, 20);
		panel_1.add(searchfield);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setIcon(new ImageIcon("images/searching-a-person (1).png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(187, 55, 108, 34);
		panel_1.add(btnNewButton_1);
		

	JButton btnNewButton = new JButton("Add");
	btnNewButton.setForeground(new Color(0, 0, 0));
	btnNewButton.setIcon(new ImageIcon("images/add-user (1).png"));
	btnNewButton.setBounds(65, 448, 111, 47);
	panel_2.add(btnNewButton);
	btnNewButton.setBackground(new Color(255, 255, 255));
	
	JButton btnNewButton_2 = new JButton("Clear");
	btnNewButton_2.setIcon(new ImageIcon("images/rubber.png"));
	btnNewButton_2.setBounds(217, 448, 111, 47);
	panel_2.add(btnNewButton_2);
	btnNewButton_2.setBackground(new Color(255, 255, 255));
	
	JLabel lblNewLabel_6 = new JLabel("Log Out");
	lblNewLabel_6.setIcon(new ImageIcon("images/home (1).png"));
	lblNewLabel_6.setAlignmentX(Component.RIGHT_ALIGNMENT);
	lblNewLabel_6.setAlignmentY(Component.TOP_ALIGNMENT);
	lblNewLabel_6.setPreferredSize(new Dimension(21, 14));
	lblNewLabel_6.setMaximumSize(new Dimension(33, 14));
	lblNewLabel_6.setBounds(28, 11, 99, 32);
	panel_2.add(lblNewLabel_6);
	lblNewLabel_6.setForeground(new Color(255, 255, 255));
	lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblNewLabel_6.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			firstwindow f=new firstwindow();
			f.setVisible(true);
			setVisible(false);
		}
	});
	lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
	
	JLabel lblNewLabel_7 = new JLabel("User :");
	lblNewLabel_7.setForeground(new Color(0, 0, 0));
	lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNewLabel_7.setBounds(20, 638, 46, 23);
	panel_2.add(lblNewLabel_7);
	
	getadminname = new JLabel();
	getadminname.setText("user");
	getadminname.setForeground(new Color(0, 0, 0));
	getadminname.setFont(new Font("Tahoma", Font.BOLD, 14));
	getadminname.setBounds(65, 641, 46, 14);
	panel_2.add(getadminname);
	
	JLabel lblNewLabel_1_1 = new JLabel("Type :");
	lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNewLabel_1_1.setBounds(20, 667, 46, 14);
	panel_2.add(lblNewLabel_1_1);
	
	getadmintype = new JLabel("type");
	getadmintype.setForeground(new Color(0, 0, 0));
	getadmintype.setFont(new Font("Tahoma", Font.BOLD, 14));
	getadmintype.setBounds(65, 667, 85, 14);
	panel_2.add(getadmintype);
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nameofthestudent.setText("");
			registerno.setText("");
			snumber.setText("");
			searchfield.setText("");
			nameofthestudent.requestFocus();
			
		}
	});
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String studname=nameofthestudent.getText();
			String regnumber=registerno.getText();
			String cbox=classbox.getSelectedItem().toString();
			String br=branchbox.getSelectedItem().toString();
			String sno=snumber.getText();
			Integer snum=Integer.parseInt(sno)-1;
			
			if(studname.equals("")||regnumber.equals("")||br.equals("")||sno.equals(""))
			{
				JOptionPane.showMessageDialog(btnNewButton, "please fill the fields");
			}
			else
			{
				try {
			    Integer s=Integer.parseInt(sno);
			    if(s>25) {
			    	JOptionPane.showMessageDialog(lblNewLabel_1_1, "class has reached maximum seating capacity");
			    }
			    else {
			    pst=DB.mycon().prepareStatement("select * from admininserting WHERE Class=? and SeatNO=?");
			    pst.setString(1, cbox);
				pst.setString(2, sno);
				rs=pst.executeQuery();
				if(!rs.next()) {
					pst=DB.mycon().prepareStatement("select * from admininserting WHERE Class=? and SeatNO=? and Branch=?");
					pst.setString(1, cbox);
					pst.setString(2, snum.toString());
					pst.setString(3, br);	
					rs=pst.executeQuery();
					
					if(!rs.next()) {
						
					    
						pst=DB.mycon().prepareStatement("insert into admininserting(Username,RegisterNO,Branch,Class,SeatNO)VALUES(?,?,?,?,?)");
						pst.setString(1, studname);
						pst.setString(2, regnumber);
						pst.setString(3, br);
						pst.setString(4, cbox);
						pst.setString(5, sno);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(btnNewButton, "Record added successfully");
						pst=DB.mycon().prepareStatement("select * from admininserting ORDER BY RegisterNO ASC");
						pst.executeQuery();
						table_load();
						nameofthestudent.setText("");
						registerno.setText("");
						snumber.setText("");
						nameofthestudent.requestFocus();
					
					}
					
						
					
					
					else {
						JOptionPane.showMessageDialog(btnNewButton, "cant allocate adjecently");
					}
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "seat number already allocated");
				}
			    }
				
			}catch(Exception h) {
				System.out.print(h);
			}
			
			
			
		}
	}});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 String number=searchfield.getText();
					 
					 pst=DB.mycon().prepareStatement("select * from admininserting WHERE RegisterNO=?");
					 pst.setString(1,number);
					 rs=pst.executeQuery();
				     if(number.equals(""))
				     {
				    	 JOptionPane.showMessageDialog(searchfield, "Please enter the valid register number to search");
				     }
				     else {
					 if(rs.next()) {
						 String name=rs.getString(1);
						 String rno=rs.getString(2);
						 String b=rs.getString(3);
						 String cla=rs.getString(4);
						 String seat=rs.getString(5);
						 nameofthestudent.setText(name);
						 registerno.setText(rno);
						 branchbox.setSelectedItem(b);
						 classbox.setSelectedItem(cla);
						 snumber.setText(seat);
					 }
					 else {
						 JOptionPane.showMessageDialog(searchfield, "No Such Register number is Found");
						 searchfield.setText("");
						 nameofthestudent.setText("");
						 registerno.setText("");
						 branchbox.setSelectedItem("");
						 classbox.setSelectedItem("");
						 snumber.setText("");
						 nameofthestudent.requestFocus();
						 
						 
						 
					 }
				     }
				}catch(Exception t)
					{
					  System.out.println(t);
					}
				
				
				
		}});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(372, 0, 636, 691);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setIcon(new ImageIcon("images/update.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studname=nameofthestudent.getText();
				String regnumber=registerno.getText();
				String cbox=classbox.getSelectedItem().toString();
				String br=branchbox.getSelectedItem().toString();
				String sno=snumber.getText();
				String up=searchfield.getText();
				Integer snum=Integer.parseInt(sno)-1;
				if(studname.equals("")||regnumber.equals("")||sno.equals(""))
				{
					JOptionPane.showMessageDialog(btnNewButton, "please fill the fields");
				}
				else
				{
					try {
				    pst=DB.mycon().prepareStatement("select * from admininserting WHERE Class=? and SeatNO=?");
				    pst.setString(1, cbox);
					pst.setString(2, sno);
					rs=pst.executeQuery();
					if(!rs.next()) {
						pst=DB.mycon().prepareStatement("select * from admininserting WHERE Class=? and SeatNO=? and Branch=?");
						pst.setString(1, cbox);
						pst.setString(2, snum.toString());
						pst.setString(3, br);	
						rs=pst.executeQuery();
						if(!rs.next()) {
							pst=DB.mycon().prepareStatement("update admininserting set Username=?,RegisterNO=?,Branch=?,Class=?,SeatNO=? WHERE RegisterNO=? ");
							pst.setString(1, studname);
							pst.setString(2, regnumber);
							pst.setString(3, br);
							pst.setString(4, cbox);
							pst.setString(5, sno);
							pst.setString(6, up);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(btnNewButton, "Record Updated successfully");
							table_load();
							nameofthestudent.setText("");
							registerno.setText("");
							snumber.setText("");
							searchfield.setText("");
							nameofthestudent.requestFocus();
							rs.close();
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton, "cant allocate adjecently");
						}
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "seat number already allocated");
					}
					
				}catch(Exception h) {
					System.out.print(h);
				}
				
				
			}
			}});
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(171, 522, 115, 48);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.setIcon(new ImageIcon("images/delete-account.png"));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(347, 522, 115, 48);
		panel_3.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("EXAM SEATING ARRANGEMENT");
		lblNewLabel.setIcon(new ImageIcon("images/spectator (3).png"));
		lblNewLabel.setBounds(108, 10, 401, 72);
		panel_3.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 27));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}});
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 10));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 93, 596, 418);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row=table.getSelectedRow();
				String tc=table.getModel().getValueAt(row,1).toString();
				try {
					pst=DB.mycon().prepareStatement("select * from admininserting where RegisterNO="+tc+"");
					rs=pst.executeQuery();
					if(rs.next())
					{
						
						String selectedname=rs.getString("Username");
						String selectedreg=rs.getString("RegisterNO");
						String selectedbranch=rs.getString("Branch");
						String selectedclass=rs.getString("Class");
						String selectedseat=rs.getString("SeatNO");
						String searchedregno=rs.getString("RegisterNO");
						
						nameofthestudent.setText(selectedname);
						registerno.setText(selectedreg);
						branchbox.setSelectedItem(selectedbranch);
						classbox.setSelectedItem(selectedclass);
						snumber.setText(selectedseat);
						searchfield.setText(searchedregno);
						
						
					}
				}catch(Exception h) {
					
					JOptionPane.showMessageDialog(null, h);
					
				}
			}
			}
		);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBorder(new TitledBorder(null, "DETAILS OF CLASSES", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 581, 596, 96);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JButton classabutton = new JButton("CLASS A");
		classabutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classA window=new classA();
				
				
			
			}
		});
		classabutton.setBackground(Color.WHITE);
		classabutton.setBounds(10, 35, 164, 36);
		panel_4.add(classabutton);
		
		JButton classbbutton = new JButton("CLASS B");
		classbbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				classB b=new classB();
				
				
			}
		});
		classbbutton.setBackground(Color.WHITE);
		classbbutton.setBounds(215, 35, 164, 36);
		panel_4.add(classbbutton);
		
		JButton classcbutton = new JButton("CLASS C");
		classcbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classC c=new classC();
			}
		});
		classcbutton.setBackground(Color.WHITE);
		classcbutton.setBounds(422, 35, 164, 36);
		panel_4.add(classcbutton);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon("images/delete.png"));
		lblNewLabel_2_2.setBounds(590, 11, 23, 23);
		panel_3.add(lblNewLabel_2_2);
		lblNewLabel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_2.setToolTipText("close");
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 42));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String del=searchfield.getText();
				try {
				pst=DB.mycon().prepareStatement("delete from admininserting  WHERE RegisterNO=? ");
				pst.setString(1, del);
  				int s=JOptionPane.showConfirmDialog(lblNewLabel_2_2, "do you really want to delete the record?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(s==JOptionPane.YES_OPTION)
				{
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(scrollPane, "record deleted successfully");
				table_load();
				nameofthestudent.setText("");
				registerno.setText("");
				snumber.setText("");
				nameofthestudent.requestFocus();
				searchfield.setText("");
				}
			}catch(Exception f)
				{
				  System.out.println(f);
			}
		}
	});
	}
	}

