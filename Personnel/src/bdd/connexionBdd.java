package bdd;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

public class connexionBdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
		
		Connection conn = null;
                String BDD = "personnel";
                String url = "jdbc:mysql://localhost:8888/" + BDD;
                String user = "root";
                String password = "root";
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(url, user, password);
                    System.out.println("Connecter");
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Erreur");
                    System.exit(0);
                }
    	}

}