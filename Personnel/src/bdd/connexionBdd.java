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

public class connexionBdd implements Passerelle{
	private static Connection myConn ;
	
    public static void main(String[] args) throws Exception{
    	
    	
    	myConn = null;
    	
    	try {
    		Properties props = new Properties();
            props.load(new FileInputStream("demo.properties"));
            
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            String dburl = props.getProperty("dburl");
            
            myConn = DriverManager.getConnection(dburl, user, password);
            
            System.out.println("Connecté à la BDD");	
    	}
    	 
         catch(SQLException e)
 		{
 			System.out.println(e);
 		}
        
    }

    
	@Override
	public GestionPersonnel getGestionPersonnel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		
	}

}