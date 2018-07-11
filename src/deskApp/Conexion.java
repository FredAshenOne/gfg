package deskApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
	public String url = "jdbc:mysql://localhost:3306/", db = "gfg",usuario = "root", password = "";
	
	
	public ResultSet query(String sentence) {
		Connection con;
		ResultSet myRs = null;
		try {
			con = DriverManager.getConnection(url+db,usuario,password);
			Statement mystmt = con.createStatement();
			myRs = mystmt.executeQuery(sentence);
			if(myRs.wasNull()) {
				con.close();
			}
		}catch(Exception ex) {
}
		
		return myRs;
	}
	
	public void update(String sentence) {
		Connection con;
		try {
		con = DriverManager.getConnection(url+db,usuario,password);	
		Statement mystmt = con.createStatement();
		mystmt.executeUpdate(sentence);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
}
