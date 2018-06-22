package deskApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
	public String url = "jdbc:mysql://localhost:3306/", db = "gfg",usuario = "root", password = "";
	Connection con;
	ResultSet myRs;
	
	public ResultSet query(String sentence) {
		try {
			con = DriverManager.getConnection(url+db,usuario,password);
			Statement mystmt = con.createStatement();
			myRs = mystmt.executeQuery(sentence);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return myRs;
	}
	
	public void update(String sentence) {
		try {
		con = DriverManager.getConnection(url+db,usuario,password);	
		Statement mystmt = con.createStatement();
		mystmt.executeUpdate(sentence);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
