package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import personnel.*;


public class JDBC implements Passerelle {

		Connection connection;

		public JDBC()
		{
			try
			{
				Class.forName(Credentials.getDriverClassName());
				connection = DriverManager.getConnection(Credentials.getUrl(), Credentials.getUser(), Credentials.getPassword()); 
				
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
		

		@Override
		public GestionPersonnel getGestionPersonnel() 
		{
			GestionPersonnel gestionPersonnel = new GestionPersonnel();
			try 
			{
				String requete = "select * from ligue";
				Statement instruction = connection.createStatement();
				ResultSet ligues = instruction.executeQuery(requete);
				while (ligues.next())
					gestionPersonnel.addLigue(ligues.getInt(1), ligues.getString(2));
			}
			catch (SQLException e)
			{
				System.out.println(e);
			}
			return gestionPersonnel;
		}
		

		@Override
		public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible 
		{
			close();
		}

		
		public void close() throws SauvegardeImpossible
		{
			try
			{
				if (connection != null)
					connection.close();
			}
			catch (SQLException e)
			{
				throw new SauvegardeImpossible(e);
			}
		}

		
		@Override
		public int insert(Ligue ligue) throws SauvegardeImpossible 
		{
			try 
			{
				PreparedStatement instruction;
				instruction = connection.prepareStatement("insert into ligue (nomLig) values(?)", Statement.RETURN_GENERATED_KEYS);
				instruction.setString(1, ligue.getNom());		
				instruction.executeUpdate();
				ResultSet id = instruction.getGeneratedKeys();
				id.next();
				return id.getInt(1);
				
			} 
			catch (SQLException exception) 
			{
				exception.printStackTrace();
				throw new SauvegardeImpossible(exception);
			}		
		}


			


		@Override
		
			public void removeLigue(Ligue ligue) throws SQLException {
				Statement myStmt = null;
				String requete = "DELETE FROM `ligue` WHERE `ligue`.`nomLig` = \""+ligue.getNom()+"\" AND `ligue`.`idLig`="+ligue.getId();
				try {
					try {
						
						PreparedStatement instruction;
						instruction = connection.prepareStatement(requete);
						instruction.executeUpdate();
					}
					
					catch(SQLException e){
						throw new SauvegardeImpossible(e);
					}
					
					finally {
						
						close(myStmt);
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GestionPersonnel.getGestionPersonnel();
			}
			
			private static void close( Statement myStmt)
				throws SQLException {

			

			if (myStmt != null) {
				myStmt.close();
			}
		}


		@Override
		public void changerNomLigue(Ligue ligue,String nouveauNom) throws SQLException {
			Statement myStmt = null;
			String requete = "UPDATE ligue Set nomLig = \""+nouveauNom+"\" WHERE IdLig ="+ligue.getId();
			
			try {
				PreparedStatement instruction;
				instruction = connection.prepareStatement(requete);
				instruction.executeUpdate();
			}
			catch(SQLException e){
				e.printStackTrace();	
			}
			finally {
				
				close(myStmt);
				
			}
			
		}


		
		
			
	}
		
      

	
