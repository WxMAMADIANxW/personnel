package bdd;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import personnel.*;

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
	
//	public Employe addEmploye(String nom, String prenom, String mail, String password,LocalDate dateArrive) throws Exception{
//		Employe employe = new Employe( nom, prenom, mail, password, dateArrive);
//		
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		ResultSetMetaData rsMeta = null;
//		try {
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("insert into employe(IdLig) values (1)");
//			rsMeta = myRs.getMetaData();
//			
//			for(int i = 1; i <= rsMeta.getColumnCount(); i++)
//	         {
//	             System.out.print("" + rsMeta.getColumnName(i).toUpperCase() + "	|");
//	         }
//			
//			System.out.println();
//			 while(myRs.next()) 
//	         {
//	             for (int i = 1; i <= rsMeta.getColumnCount(); i++)
//	             {
//	                 System.out.print("" + myRs.getObject(i).toString() + "	|");
//	             }
//	             return employe;
//	         }
//		}
//		finally {
//			close(myStmt,myRs);
//		}
//	}
	
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
	             System.out.print("" + rsMeta.getColumnName(i).toUpperCase() + " |");
	         }
			
			System.out.println();
			 while(myRs.next()) 
	         {
				 Ligue tempLigue = convertRowToLigue(myRs);
	             liste.add(tempLigue);
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
	
	
private Ligue convertRowToLigue(ResultSet myRs) throws SQLException {
		
		int idLig = myRs.getInt("IdLig");
		String nomLig = myRs.getString("nomLig");
		
		Ligue tempLigue = GestionPersonnel.addLigue(idLig, nomLig);		
		return tempLigue;
	}
	
	
	
	private static void close( Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
			LigueDAO dao = new LigueDAO();
			System.out.println(dao.getLigues());
	}
	
}
