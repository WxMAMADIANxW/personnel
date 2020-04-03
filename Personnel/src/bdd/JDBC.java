package bdd;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import personnel.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import personnel.*;
import java.util.*; 
public class JDBC implements Passerelle {

		private Connection myConn;
	
		public JDBC() throws FileNotFoundException, IOException
		{
			Properties props = new Properties();
			props.load(new FileInputStream("demo.properties"));
			String user = props.getProperty("user");
			String password = props.getProperty("password");;
			String dburl = props.getProperty("dburl");;
			String driverClassName = props.getProperty("driverClassName");
			try
			{
				Class.forName(driverClassName);
				myConn= DriverManager.getConnection( dburl, user, password); 
				
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
				Statement instruction = myConn.createStatement();
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
				if (myConn != null)
					myConn.close();
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
				instruction = myConn.prepareStatement("insert into ligue (nomLig) values(?)", Statement.RETURN_GENERATED_KEYS);
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
		
		
		
	}

