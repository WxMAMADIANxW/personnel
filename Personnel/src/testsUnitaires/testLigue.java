package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	@Test
	void testCreateLigue() 
	{
		Ligue ligue = new Ligue("Fl�chettes");
		assertEquals("Fl�chettes", ligue.getNom());
	}

	@Test
	void testAddEmploye() 
	{
		Ligue ligue = new Ligue("Fl�chettes");
		Employe employe = ligue.addEmploye("Bouchard", "G�rard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	@Test
	void  testGetAdministrateur()
	{
		Ligue ligue = new Ligue("Fl�chettes");
		Employe employe = GestionPersonnel.getGestionPersonnel().getRoot();
		assertEquals(employe, ligue.getAdministrateur());
	}
	@Test
	void testRemove()
	{
		Ligue ligue = new Ligue("Fl�chettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty");
		employe.remove();
		assertFalse(ligue.getEmployes().contains(employe));
	}
	
	@Test
	void testCompareTo()
	{
		Ligue ligue = new Ligue("Fl�chettes");
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
	
}
