package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	@Test
	void createLigue() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

	@Test
	void addEmploye() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	@Test
	void  getAdministrateur()
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = GestionPersonnel.getGestionPersonnel().getRoot();
		assertEquals(employe, ligue.getAdministrateur());
	}
	@Test
	void remove()
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		employe.remove();
		assertFalse(ligue.getEmployes().contains(employe));
	}
	
	@Test
	void compareTo()
	{
		Ligue ligue = new Ligue("Fléchettes");
		Ligue ligue2 = new Ligue("Fortnite");
		ligue.getNom().compareTo(ligue2.getNom());
		assertNotEquals(ligue.getNom(), ligue2.getNom());
	}
	
}
