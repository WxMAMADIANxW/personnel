package bdd;


import java.util.*;



import java.sql.*;
import java.sql.Date;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.Passerelle;
import personnel.SauvegardeImpossible;


public class EmployeDAO{
	private Connection myConn ;
	
	public EmployeDAO() throws Exception{
		Properties props = new Properties();
        props.load(new FileInputStream("demo.properties"));
        
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String dburl = props.getProperty("dburl");
        
        // Connexion à la base de données.
        
        myConn = DriverManager.getConnection(dburl, user, password);
        
        System.out.println("Connecté à la BDD");
	}
	
	 public List<Employe> getEmploye() throws Exception {
	    	List<Employe> liste = new ArrayList<Employe>();
	    	
	    	Statement myStmt = null;
	    	ResultSet myRs = null;
	    	ResultSetMetaData rsMeta = null;
	    	
	    	try {
	    		myStmt = myConn.createStatement();
	    		myRs = myStmt.executeQuery("SELECT nomEmp, preEmp, mail, dateArrive FROM employe");
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
		             System.out.println("\n");
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
	 
	 public void setEmploye() throws Exception {
		 Statement myStmt = null;
		 int nb;
		 
		 myStmt = myConn.createStatement();
		 nb = myStmt.executeUpdate("INSERT INTO employe"
		 		+ " VALUES ('5', '1', 'Lopes', 'Anthony', 'aLopes@ol.com', 'lopes' , '0' , '2020-03-17', null)");
		 
		 System.out.println("nb lignes modifs : " +nb);
		 
		 myStmt.close();
	 }
	 /*
	public void delete() throws Exception{
		Statement myStmt = null;
		int nb;
		
		myStmt = myConn.createStatement("DELETE FROM employe WHERE idEmp = '4'");
	}
	*/
    private static void close( Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
	}
    
    public static void main(String[] args) throws Exception{
    	EmployeDAO dao = new EmployeDAO();
    	System.out.println(dao.getEmploye());
    	dao.setEmploye();
    	System.out.println(dao.getEmploye());
        
    }


}