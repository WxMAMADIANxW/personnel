package bdd;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

public class connexionBdd {
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                String BDD = "personnel";
                String url = "jdbc:mysql://localhost:3308/" + BDD + "?serverTimezone=UTC";
                String user = "root";
                String password = "";
                
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