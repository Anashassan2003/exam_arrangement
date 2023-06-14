package org.ictkerala.examseatingarrangement;
import java.sql.*;
public class DB {
 public static Connection mycon()
 { 
	  Connection obj=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 obj = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exam","root","anashassan71");
	}catch(Exception e) {
		System.out.println(e);
	}
	return obj;
 }
}
