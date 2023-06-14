package org.ictkerala.examseatingarrangement;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class classC extends JFrame {

	private JPanel contentPane;
	private JTable table;
	PreparedStatement pst;
    ResultSet rs;
	 public void table_load()
	    {
	    	try {
	    	pst=DB.mycon().prepareStatement("select * from admininserting where class=?");
	    	pst.setString(1, "C");
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
					classC frame = new classC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public classC() {
		setTitle("Details of Class C");
		
		setBounds(100, 100, 587, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(70, 130, 180));
		scrollPane.setBounds(27, 52, 518, 378);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String s="<HTML><u>CLASS C</u></HTML>";
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 0, 571, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(201, 11, 138, 41);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setText(s);
		lblNewLabel.setFont(new Font("STZhongsong", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("Max Limit : 24");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(455, 31, 106, 14);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(70, 130, 180));
		panel_1.setBounds(0, 517, 805, 69);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(70, 130, 180));
		panel_2.setBounds(0, 430, 571, 61);
		contentPane.add(panel_2);
		try {
			pst=DB.mycon().prepareStatement("Select * from admininserting where Class=? ");
			pst.setString(1, "C");
			rs=pst.executeQuery();
			if(!rs.next()) {
				
				JOptionPane.showMessageDialog(scrollPane, "Class C Is Empty");
				}
			else {
				setVisible(true);
				table_load();
			}
			
			
			
		}catch(Exception j) {
			
		}
	}
}
