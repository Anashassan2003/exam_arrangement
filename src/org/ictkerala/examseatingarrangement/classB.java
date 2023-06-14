package org.ictkerala.examseatingarrangement;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class classB extends JFrame {

	private JPanel contentPane;
	private JTable table;
	PreparedStatement pst;
    ResultSet rs;
    private JLabel lblNewLabel;
    private JPanel panel;
    private JPanel panel_1;
    private JLabel lblNewLabel_1;
	 public void table_load()
	    {
	    	try {
	    	pst=DB.mycon().prepareStatement("select * from admininserting where class=?");
	    	pst.setString(1, "B");
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
					classB frame = new classB();
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
	public classB() {
		setTitle("Details of Class B");
		
		setBounds(100, 100, 587, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 61, 513, 370);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String s="<HTML><u>CLASS B</u></HTML>";
		
		panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 429, 571, 61);
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 130, 180));
		panel_1.setBounds(0, 0, 571, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(212, 16, 117, 34);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setText(s);
		lblNewLabel.setFont(new Font("STZhongsong", Font.BOLD, 25));
		
		lblNewLabel_1 = new JLabel("Max Limit : 24");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(455, 36, 106, 14);
		panel_1.add(lblNewLabel_1);
		try {
			pst=DB.mycon().prepareStatement("Select * from admininserting where Class=? ");
			pst.setString(1, "B");
			rs=pst.executeQuery();
			if(!rs.next()) {
				
				JOptionPane.showMessageDialog(scrollPane, "Class B Is Empty");
				}
			else {
				setVisible(true);
				table_load();
			}
			
			
			
		}catch(Exception j) {
			
		}
	}

}
