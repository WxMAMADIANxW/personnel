package bdd;

import java.util.*;
import java.io.*;
import java.sql.*;

import personnel.Ligue;

public class LigueDAO {
	private Connection myConn;
	
	
	public LigueDAO() throws Exception{
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");;
		String dburl = props.getProperty("dburl");;
		
		// connect to database
        myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("DB connection successful to: " + dburl);	
	}
	
	public List<Ligue> getLigues() throws Exception {
		List<Ligue> liste = new ArrayList<Ligue>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		ResultSetMetaData rsMeta = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from ligue");
			rsMeta = myRs.getMetaData();
			
			for(int i = 1; i <= rsMeta.getColumnCount(); i++)
	         {
	             System.out.print("" + rsMeta.getColumnName(i).toUpperCase() + "	|");
	         }
			
			System.out.println();
			 while(myRs.next()) 
	         {
	             for (int i = 1; i <= rsMeta.getColumnCount(); i++)
	             {
	                 System.out.print("" + myRs.getObject(i).toString() + "	|");
	             }
	         }
			
		}
		catch(SQLException e){
			e.printStackTrace();
            System.out.println(e);
            System.exit(0);
		}
		finally {
			close(myStmt, myRs);
		}
		
		 
		return liste;
		
	}
	
	private static void close( Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
	}
	
	public static void main(String[] args) throws Exception {
			LigueDAO dao = new LigueDAO();
			System.out.println(dao.getLigues());
	}
	
}
