package bdd;

import java.util.*;
import java.io.*;
import java.sql.*;

import personnel.Ligue;

public class LigueDAO {
	private Connection conn;
	
	
	public void EmployeeDAO() throws Exception{
		Properties props = new Properties();
		props.load(new FileInputStream("infoBdd.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");;
		String url = props.getProperty("url");;
		
		// connect to database
        conn = DriverManager.getConnection(url, user, password);
		
		System.out.println("DB connection successful to: " + url);	
	}
	
	public List<Ligue> getLigues() throws Exception {
		List<Ligue> liste = new ArrayList<Ligue>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		ResultSetMetaData rsMeta = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("select * from ligue");
			rsMeta = myRs.getMetaData();
			
			for(int i = 1; i <= rsMeta.getColumnCount(); i++)
	         {
	             System.out.println(" " + rsMeta.getColumnName(i).toUpperCase() + " ");
	         }
			 while(myRs.next()) 
	         {
	             for (int i = 1; i <= rsMeta.getColumnCount(); i++)
	             {
	                 System.out.println("         " + myRs.getObject(i).toString() + "    ");
	             }
	         }
			 myRs.close();
			 myStmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
            System.out.println(e);
            System.exit(0);
		}
		 
		 
		return liste;
		
	}

	

}
