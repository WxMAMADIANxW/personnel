package bdd;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

import personnel.GestionPersonnel;
import personnel.Passerelle;
import personnel.SauvegardeImpossible;

public class connexionBdd implements Passerelle{
    
    public static void main(String[] args) {
    	String BDD = "personnel";
    	String port = "3308";
        String url = "jdbc:mysql://localhost:"+ port + "/" + BDD + "?serverTimezone=UTC";
        String user = "root";
        String password = "";
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Connection conn = null;
            	
                try {
                	conn = DriverManager.getConnection(url, user, password);
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