package personnel;

import java.sql.SQLException;

public interface Passerelle 
{
	public GestionPersonnel getGestionPersonnel();
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel)  throws SauvegardeImpossible;
	public int insertLigue(Ligue ligue) throws SauvegardeImpossible;
	public void insertEmploye(Employe employe) throws SauvegardeImpossible;
	void removeLigue(Ligue ligue) throws SQLException;
	void updateLigue(Ligue ligue) throws SQLException;
	void removeEmploye(Employe employe);
	void updateEmlpoye(Employe employe) throws SQLException;
}
