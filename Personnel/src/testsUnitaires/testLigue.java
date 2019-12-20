package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	@Test
	void testCreateLigue() 
	{	
		Ligue ligue = new Ligue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

	@Test
	void testAddEmploye() 
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	@Test
	void testSetNom()
	{
		Ligue ligue = new Ligue("Fortnite");
		String nom = "Aouar";
		Employe employe = ligue.addEmploye(nom, "Houssem", "aouar@gmail.com", "aouar");
		assertTrue(employe.getNom().contains(nom));
	}
	@Test
	void  testGetAdministrateur()
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = GestionPersonnel.getGestionPersonnel().getRoot();
		ligue.setAdministrateur(employe);
		assertEquals(employe, ligue.getAdministrateur());
	}
	@Test
	void testRemove()
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "GÃ©rard", "g.bouchard@gmail.com", "azerty");
		employe.remove();
		assertFalse(ligue.getEmployes().contains(employe));
	}
	
	@Test
	void testCompareTo()
	{
		Ligue ligue = new Ligue("Fléchettes");
		Ligue ligue2 = new Ligue("Fortnite");
		ligue.getNom().compareTo(ligue2.getNom());
		assertNotEquals(ligue.getNom(), ligue2.getNom());
	}
	
	@Test
	void testToString()
	{
		Ligue ligue = new Ligue("Fortnite");
		String nom = "Fortnite";
		ligue.setNom(nom);
		assertTrue(ligue.toString().contains("Fortnite"));
	}
	
	void testGetEmployes()
	{
		Ligue ligue = new Ligue("Fortnite");
		Employe employe = ligue.addEmploye("Aouar", "Houssem", "aouar@gmail.com", "aouar");
		assertTrue(ligue.getEmployes().contains(employe));
	}
	
}
