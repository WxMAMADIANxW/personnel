package personnel;

import java.sql.SQLException;

public interface Passerelle 
{
	public GestionPersonnel getGestionPersonnel();
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel)  throws SauvegardeImpossible;
	public int insert(Ligue ligue) throws SauvegardeImpossible;
	public void insert(Employe employe) throws SauvegardeImpossible;
	void removeLigue(Ligue ligue) throws SQLException;
	void updateLigue(Ligue ligue) throws SQLException;
}
