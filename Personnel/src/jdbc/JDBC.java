package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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
				Statement instruction2 = connection.createStatement();
				ResultSet ligues = instruction.executeQuery(requete);
				while (ligues.next()) {
					gestionPersonnel.addLigue(ligues.getInt(1), ligues.getString(2));
					Ligue ligue = gestionPersonnel.addLigue(ligues.getInt(1), ligues.getString(2));
					ResultSet employes = instruction2.executeQuery("Select * from employe where employe.IdLig ="+ligues.getInt(1));
					
					while(employes.next()) {
					LocalDate dateArrive = LocalDate.parse(employes.getString(8)); 
					ligue.addEmploye(employes.getInt(1), employes.getString(3), employes.getString(4), employes.getString(5),employes.getString(6), dateArrive);
						
					}
				}
			}
			catch (SQLException e)
			{
				System.out.println(e);
				e.printStackTrace();
				
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
		public int insertLigue(Ligue ligue) throws SauvegardeImpossible 
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
		public void updateLigue(Ligue ligue) throws SQLException {
			PreparedStatement myStmt = null;
			String requete = "UPDATE ligue Set nomLig = \""+ligue.getNom()+"\" ,  IdAdmin="+ligue.getAdministrateur().getId()
					+" WHERE ligue.IdLig ="+ligue.getId();
			
			
			try {
			//	PreparedStatement instructionNomLigue, instructionAdministrateur;
				myStmt = connection.prepareStatement(requete);
				myStmt.executeUpdate();
				//instructionAdministrateur = connection.prepareStatement(requeteAdministrateur);
				//instructionAdministrateur.executeUpdate();
			}
			catch(SQLException e){
				e.printStackTrace();	
			}
			finally {
				
				close(myStmt);
				
			}
			
		}
		
		
		@Override
		public void insertEmploye(Employe employe) throws SauvegardeImpossible 
		{
			try 
			{
				PreparedStatement instruction;
				instruction = connection.prepareStatement("insert into employe (nomEmp, preEmp, mail, Password, dateArrive, dateDepart) values(?)", Statement.RETURN_GENERATED_KEYS);
				instruction.executeUpdate();
			
			} 
			catch (SQLException exception) 
			{
				exception.printStackTrace();
				throw new SauvegardeImpossible(exception);
			}		
		}
		
		
		@Override 	
		public void removeEmploye(Employe employe) {
			Statement myStmt = null;
			String requete = "DELETE FROM `employe` WHERE `employe`.`nomEmp` = \""+employe.getNom()+"\" AND `employe`.`idEmp`="+employe.getId();
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

		
		
		@Override
		public void updateEmlpoye(Employe employe) throws SQLException {
			PreparedStatement myStmt = null;
			String requete = "UPDATE ligue Set nomEmp = \""+employe.getNom()+"\" preEmp"+employe.getPrenom() +"\" mail" +employe.getMail() + 
					"\" dateArrive"+employe.getDateArrive() +"\" dateDepart" +employe.getDateDepart() 
					+ " WHERE employe.IdEmp ="+employe.getId();
			
			
			try {
				myStmt = connection.prepareStatement(requete);
				myStmt.executeUpdate();
			}
			catch(SQLException e){
				e.printStackTrace();	
			}
			finally {
				
				close(myStmt);
				
			}
			
		}
	
	}
		
      

	
