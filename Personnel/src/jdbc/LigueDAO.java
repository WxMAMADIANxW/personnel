package jdbc;

import java.util.*; 
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import personnel.*;


public class LigueDAO {
	private Connection myConn;
	
	
	public LigueDAO() throws Exception{
		try
		{
			Class.forName(Credentials.getDriverClassName());
			myConn = DriverManager.getConnection(Credentials.getUrl(), Credentials.getUser(), Credentials.getPassword()); 
			
	        System.out.println("Vous êtes bien connecté à la BDD");

		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Pilote JDBC non installé.");
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}

	
	public void removeLigue(int idLig,String nomLig) throws SQLException {
		Statement myStmt = null;
		@SuppressWarnings("null")
		int myRs = 0;
		int rsMeta = 0;
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeUpdate("DELETE FROM `ligue` WHERE `ligue`.`nomLig` = \""+nomLig+"\" AND `ligue`.`idLig`="+idLig);
			rsMeta = myRs;	
		}
		
		catch(SQLException e){
			e.printStackTrace();
            System.out.println(e);
            System.exit(0);
		}
		
		finally {
			
			close(myStmt);
			
		}
	}
	private void close(Statement myStmt) throws SQLException {
		// TODO Auto-generated method stub


			if (myStmt != null) {
				myStmt.close();
			}
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
		
		Ligue tempLigue =  GestionPersonnel.getGestionPersonnel().addLigue(idLig,nomLig);	
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
