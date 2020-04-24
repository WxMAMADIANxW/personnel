package serialisation;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import personnel.Employe;
import java.sql.SQLException;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;

public class Serialization implements personnel.Passerelle
{
	private static final String FILE_NAME = "GestionPersonnel.srz";
	GestionPersonnel gestionPersonnel;
		
	@Override
	public GestionPersonnel getGestionPersonnel()
	{
		ObjectInputStream ois = null;
		try
		{
			FileInputStream fis = new FileInputStream(FILE_NAME);
			ois = new ObjectInputStream(fis);
			return (GestionPersonnel)(ois.readObject());
		}
		catch (IOException | ClassNotFoundException e)
		{
			return null;
		}
		finally
		{
				try
				{
					if (ois != null)
						ois.close();
				} 
				catch (IOException e){}
		}	
	}
	
	/**
	 * Sauvegarde le gestionnaire pour qu'il soit ouvert automatiquement 
	 * lors d'une exécution ultérieure du programme.
	 * @throws SauvegardeImpossible Si le support de sauvegarde est inaccessible.
	 */
	
	@Override
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible
	{
		ObjectOutputStream oos = null;
		try
		{
			FileOutputStream fis = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fis);
			oos.writeObject(this);
		}
		catch (IOException e)
		{
			throw new SauvegardeImpossible(e);
		}
		finally
		{
			try
			{
				if (oos != null)
					oos.close();
			} 
			catch (IOException e){}
		}
		
	}
	

	@Override
	public int insertLigue(Ligue ligue) throws SauvegardeImpossible
	{
		return -1;
	}

	@Override
	public void insertEmploye(Employe employe) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
	}
	

	@Override
	public void removeLigue(Ligue ligue) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLigue(Ligue ligue) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEmploye(Employe employe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmlpoye(Employe employe) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	
}
