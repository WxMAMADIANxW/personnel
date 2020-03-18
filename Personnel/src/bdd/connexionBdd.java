package bdd;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

public class connexionBdd {
    
    public static void main(String[] args) {
    	String BDD = "personnel";
    	String port = "3308";
        String url = "jdbc:mysql://localhost:"+ port + "/" + BDD + "?serverTimezone=UTC";
        String user = "root";
        String password = "";
        EventQueue.invokeLater(new Runnable() {
            public void run() {
      
                try {
                	Connection conn = DriverManager.getConnection(url, user, password);
                	System.out.println("T'es co bg");
                }
                catch (Exception e)
                {
                	e.printStackTrace();
                	System.out.println("Erreur");
                	System.exit(0);
                }
            }
        });
    }

}